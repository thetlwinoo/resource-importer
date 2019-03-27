package bieebox.resource.importer.web.rest;

import bieebox.resource.importer.ImporterApp;

import bieebox.resource.importer.domain.ProductModel;
import bieebox.resource.importer.repository.ProductModelRepository;
import bieebox.resource.importer.service.ProductModelService;
import bieebox.resource.importer.service.dto.ProductModelDTO;
import bieebox.resource.importer.service.mapper.ProductModelMapper;
import bieebox.resource.importer.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.util.List;


import static bieebox.resource.importer.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the ProductModelResource REST controller.
 *
 * @see ProductModelResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ImporterApp.class)
public class ProductModelResourceIntTest {

    private static final String DEFAULT_PRODUCT_MODEL_NAME = "AAAAAAAAAA";
    private static final String UPDATED_PRODUCT_MODEL_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_CALALOG_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_CALALOG_DESCRIPTION = "BBBBBBBBBB";

    private static final String DEFAULT_INSTRUCTIONS = "AAAAAAAAAA";
    private static final String UPDATED_INSTRUCTIONS = "BBBBBBBBBB";

    @Autowired
    private ProductModelRepository productModelRepository;

    @Autowired
    private ProductModelMapper productModelMapper;

    @Autowired
    private ProductModelService productModelService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    @Autowired
    private Validator validator;

    private MockMvc restProductModelMockMvc;

    private ProductModel productModel;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ProductModelResource productModelResource = new ProductModelResource(productModelService);
        this.restProductModelMockMvc = MockMvcBuilders.standaloneSetup(productModelResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ProductModel createEntity(EntityManager em) {
        ProductModel productModel = new ProductModel()
            .productModelName(DEFAULT_PRODUCT_MODEL_NAME)
            .calalogDescription(DEFAULT_CALALOG_DESCRIPTION)
            .instructions(DEFAULT_INSTRUCTIONS);
        return productModel;
    }

    @Before
    public void initTest() {
        productModel = createEntity(em);
    }

    @Test
    @Transactional
    public void createProductModel() throws Exception {
        int databaseSizeBeforeCreate = productModelRepository.findAll().size();

        // Create the ProductModel
        ProductModelDTO productModelDTO = productModelMapper.toDto(productModel);
        restProductModelMockMvc.perform(post("/api/product-models")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productModelDTO)))
            .andExpect(status().isCreated());

        // Validate the ProductModel in the database
        List<ProductModel> productModelList = productModelRepository.findAll();
        assertThat(productModelList).hasSize(databaseSizeBeforeCreate + 1);
        ProductModel testProductModel = productModelList.get(productModelList.size() - 1);
        assertThat(testProductModel.getProductModelName()).isEqualTo(DEFAULT_PRODUCT_MODEL_NAME);
        assertThat(testProductModel.getCalalogDescription()).isEqualTo(DEFAULT_CALALOG_DESCRIPTION);
        assertThat(testProductModel.getInstructions()).isEqualTo(DEFAULT_INSTRUCTIONS);
    }

    @Test
    @Transactional
    public void createProductModelWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = productModelRepository.findAll().size();

        // Create the ProductModel with an existing ID
        productModel.setId(1L);
        ProductModelDTO productModelDTO = productModelMapper.toDto(productModel);

        // An entity with an existing ID cannot be created, so this API call must fail
        restProductModelMockMvc.perform(post("/api/product-models")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productModelDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ProductModel in the database
        List<ProductModel> productModelList = productModelRepository.findAll();
        assertThat(productModelList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkProductModelNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = productModelRepository.findAll().size();
        // set the field null
        productModel.setProductModelName(null);

        // Create the ProductModel, which fails.
        ProductModelDTO productModelDTO = productModelMapper.toDto(productModel);

        restProductModelMockMvc.perform(post("/api/product-models")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productModelDTO)))
            .andExpect(status().isBadRequest());

        List<ProductModel> productModelList = productModelRepository.findAll();
        assertThat(productModelList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllProductModels() throws Exception {
        // Initialize the database
        productModelRepository.saveAndFlush(productModel);

        // Get all the productModelList
        restProductModelMockMvc.perform(get("/api/product-models?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(productModel.getId().intValue())))
            .andExpect(jsonPath("$.[*].productModelName").value(hasItem(DEFAULT_PRODUCT_MODEL_NAME.toString())))
            .andExpect(jsonPath("$.[*].calalogDescription").value(hasItem(DEFAULT_CALALOG_DESCRIPTION.toString())))
            .andExpect(jsonPath("$.[*].instructions").value(hasItem(DEFAULT_INSTRUCTIONS.toString())));
    }
    
    @Test
    @Transactional
    public void getProductModel() throws Exception {
        // Initialize the database
        productModelRepository.saveAndFlush(productModel);

        // Get the productModel
        restProductModelMockMvc.perform(get("/api/product-models/{id}", productModel.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(productModel.getId().intValue()))
            .andExpect(jsonPath("$.productModelName").value(DEFAULT_PRODUCT_MODEL_NAME.toString()))
            .andExpect(jsonPath("$.calalogDescription").value(DEFAULT_CALALOG_DESCRIPTION.toString()))
            .andExpect(jsonPath("$.instructions").value(DEFAULT_INSTRUCTIONS.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingProductModel() throws Exception {
        // Get the productModel
        restProductModelMockMvc.perform(get("/api/product-models/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateProductModel() throws Exception {
        // Initialize the database
        productModelRepository.saveAndFlush(productModel);

        int databaseSizeBeforeUpdate = productModelRepository.findAll().size();

        // Update the productModel
        ProductModel updatedProductModel = productModelRepository.findById(productModel.getId()).get();
        // Disconnect from session so that the updates on updatedProductModel are not directly saved in db
        em.detach(updatedProductModel);
        updatedProductModel
            .productModelName(UPDATED_PRODUCT_MODEL_NAME)
            .calalogDescription(UPDATED_CALALOG_DESCRIPTION)
            .instructions(UPDATED_INSTRUCTIONS);
        ProductModelDTO productModelDTO = productModelMapper.toDto(updatedProductModel);

        restProductModelMockMvc.perform(put("/api/product-models")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productModelDTO)))
            .andExpect(status().isOk());

        // Validate the ProductModel in the database
        List<ProductModel> productModelList = productModelRepository.findAll();
        assertThat(productModelList).hasSize(databaseSizeBeforeUpdate);
        ProductModel testProductModel = productModelList.get(productModelList.size() - 1);
        assertThat(testProductModel.getProductModelName()).isEqualTo(UPDATED_PRODUCT_MODEL_NAME);
        assertThat(testProductModel.getCalalogDescription()).isEqualTo(UPDATED_CALALOG_DESCRIPTION);
        assertThat(testProductModel.getInstructions()).isEqualTo(UPDATED_INSTRUCTIONS);
    }

    @Test
    @Transactional
    public void updateNonExistingProductModel() throws Exception {
        int databaseSizeBeforeUpdate = productModelRepository.findAll().size();

        // Create the ProductModel
        ProductModelDTO productModelDTO = productModelMapper.toDto(productModel);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restProductModelMockMvc.perform(put("/api/product-models")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productModelDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ProductModel in the database
        List<ProductModel> productModelList = productModelRepository.findAll();
        assertThat(productModelList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteProductModel() throws Exception {
        // Initialize the database
        productModelRepository.saveAndFlush(productModel);

        int databaseSizeBeforeDelete = productModelRepository.findAll().size();

        // Delete the productModel
        restProductModelMockMvc.perform(delete("/api/product-models/{id}", productModel.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<ProductModel> productModelList = productModelRepository.findAll();
        assertThat(productModelList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ProductModel.class);
        ProductModel productModel1 = new ProductModel();
        productModel1.setId(1L);
        ProductModel productModel2 = new ProductModel();
        productModel2.setId(productModel1.getId());
        assertThat(productModel1).isEqualTo(productModel2);
        productModel2.setId(2L);
        assertThat(productModel1).isNotEqualTo(productModel2);
        productModel1.setId(null);
        assertThat(productModel1).isNotEqualTo(productModel2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ProductModelDTO.class);
        ProductModelDTO productModelDTO1 = new ProductModelDTO();
        productModelDTO1.setId(1L);
        ProductModelDTO productModelDTO2 = new ProductModelDTO();
        assertThat(productModelDTO1).isNotEqualTo(productModelDTO2);
        productModelDTO2.setId(productModelDTO1.getId());
        assertThat(productModelDTO1).isEqualTo(productModelDTO2);
        productModelDTO2.setId(2L);
        assertThat(productModelDTO1).isNotEqualTo(productModelDTO2);
        productModelDTO1.setId(null);
        assertThat(productModelDTO1).isNotEqualTo(productModelDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(productModelMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(productModelMapper.fromId(null)).isNull();
    }
}
