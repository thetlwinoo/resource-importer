package bieebox.resource.importer.web.rest;

import bieebox.resource.importer.ImporterApp;

import bieebox.resource.importer.domain.ProductSubCategory;
import bieebox.resource.importer.repository.ProductSubCategoryRepository;
import bieebox.resource.importer.service.ProductSubCategoryService;
import bieebox.resource.importer.service.dto.ProductSubCategoryDTO;
import bieebox.resource.importer.service.mapper.ProductSubCategoryMapper;
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
 * Test class for the ProductSubCategoryResource REST controller.
 *
 * @see ProductSubCategoryResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ImporterApp.class)
public class ProductSubCategoryResourceIntTest {

    private static final String DEFAULT_PRODUCT_SUB_CATEGORY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_PRODUCT_SUB_CATEGORY_NAME = "BBBBBBBBBB";

    @Autowired
    private ProductSubCategoryRepository productSubCategoryRepository;

    @Autowired
    private ProductSubCategoryMapper productSubCategoryMapper;

    @Autowired
    private ProductSubCategoryService productSubCategoryService;

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

    private MockMvc restProductSubCategoryMockMvc;

    private ProductSubCategory productSubCategory;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ProductSubCategoryResource productSubCategoryResource = new ProductSubCategoryResource(productSubCategoryService);
        this.restProductSubCategoryMockMvc = MockMvcBuilders.standaloneSetup(productSubCategoryResource)
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
    public static ProductSubCategory createEntity(EntityManager em) {
        ProductSubCategory productSubCategory = new ProductSubCategory()
            .productSubCategoryName(DEFAULT_PRODUCT_SUB_CATEGORY_NAME);
        return productSubCategory;
    }

    @Before
    public void initTest() {
        productSubCategory = createEntity(em);
    }

    @Test
    @Transactional
    public void createProductSubCategory() throws Exception {
        int databaseSizeBeforeCreate = productSubCategoryRepository.findAll().size();

        // Create the ProductSubCategory
        ProductSubCategoryDTO productSubCategoryDTO = productSubCategoryMapper.toDto(productSubCategory);
        restProductSubCategoryMockMvc.perform(post("/api/product-sub-categories")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productSubCategoryDTO)))
            .andExpect(status().isCreated());

        // Validate the ProductSubCategory in the database
        List<ProductSubCategory> productSubCategoryList = productSubCategoryRepository.findAll();
        assertThat(productSubCategoryList).hasSize(databaseSizeBeforeCreate + 1);
        ProductSubCategory testProductSubCategory = productSubCategoryList.get(productSubCategoryList.size() - 1);
        assertThat(testProductSubCategory.getProductSubCategoryName()).isEqualTo(DEFAULT_PRODUCT_SUB_CATEGORY_NAME);
    }

    @Test
    @Transactional
    public void createProductSubCategoryWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = productSubCategoryRepository.findAll().size();

        // Create the ProductSubCategory with an existing ID
        productSubCategory.setId(1L);
        ProductSubCategoryDTO productSubCategoryDTO = productSubCategoryMapper.toDto(productSubCategory);

        // An entity with an existing ID cannot be created, so this API call must fail
        restProductSubCategoryMockMvc.perform(post("/api/product-sub-categories")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productSubCategoryDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ProductSubCategory in the database
        List<ProductSubCategory> productSubCategoryList = productSubCategoryRepository.findAll();
        assertThat(productSubCategoryList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkProductSubCategoryNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = productSubCategoryRepository.findAll().size();
        // set the field null
        productSubCategory.setProductSubCategoryName(null);

        // Create the ProductSubCategory, which fails.
        ProductSubCategoryDTO productSubCategoryDTO = productSubCategoryMapper.toDto(productSubCategory);

        restProductSubCategoryMockMvc.perform(post("/api/product-sub-categories")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productSubCategoryDTO)))
            .andExpect(status().isBadRequest());

        List<ProductSubCategory> productSubCategoryList = productSubCategoryRepository.findAll();
        assertThat(productSubCategoryList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllProductSubCategories() throws Exception {
        // Initialize the database
        productSubCategoryRepository.saveAndFlush(productSubCategory);

        // Get all the productSubCategoryList
        restProductSubCategoryMockMvc.perform(get("/api/product-sub-categories?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(productSubCategory.getId().intValue())))
            .andExpect(jsonPath("$.[*].productSubCategoryName").value(hasItem(DEFAULT_PRODUCT_SUB_CATEGORY_NAME.toString())));
    }
    
    @Test
    @Transactional
    public void getProductSubCategory() throws Exception {
        // Initialize the database
        productSubCategoryRepository.saveAndFlush(productSubCategory);

        // Get the productSubCategory
        restProductSubCategoryMockMvc.perform(get("/api/product-sub-categories/{id}", productSubCategory.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(productSubCategory.getId().intValue()))
            .andExpect(jsonPath("$.productSubCategoryName").value(DEFAULT_PRODUCT_SUB_CATEGORY_NAME.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingProductSubCategory() throws Exception {
        // Get the productSubCategory
        restProductSubCategoryMockMvc.perform(get("/api/product-sub-categories/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateProductSubCategory() throws Exception {
        // Initialize the database
        productSubCategoryRepository.saveAndFlush(productSubCategory);

        int databaseSizeBeforeUpdate = productSubCategoryRepository.findAll().size();

        // Update the productSubCategory
        ProductSubCategory updatedProductSubCategory = productSubCategoryRepository.findById(productSubCategory.getId()).get();
        // Disconnect from session so that the updates on updatedProductSubCategory are not directly saved in db
        em.detach(updatedProductSubCategory);
        updatedProductSubCategory
            .productSubCategoryName(UPDATED_PRODUCT_SUB_CATEGORY_NAME);
        ProductSubCategoryDTO productSubCategoryDTO = productSubCategoryMapper.toDto(updatedProductSubCategory);

        restProductSubCategoryMockMvc.perform(put("/api/product-sub-categories")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productSubCategoryDTO)))
            .andExpect(status().isOk());

        // Validate the ProductSubCategory in the database
        List<ProductSubCategory> productSubCategoryList = productSubCategoryRepository.findAll();
        assertThat(productSubCategoryList).hasSize(databaseSizeBeforeUpdate);
        ProductSubCategory testProductSubCategory = productSubCategoryList.get(productSubCategoryList.size() - 1);
        assertThat(testProductSubCategory.getProductSubCategoryName()).isEqualTo(UPDATED_PRODUCT_SUB_CATEGORY_NAME);
    }

    @Test
    @Transactional
    public void updateNonExistingProductSubCategory() throws Exception {
        int databaseSizeBeforeUpdate = productSubCategoryRepository.findAll().size();

        // Create the ProductSubCategory
        ProductSubCategoryDTO productSubCategoryDTO = productSubCategoryMapper.toDto(productSubCategory);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restProductSubCategoryMockMvc.perform(put("/api/product-sub-categories")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productSubCategoryDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ProductSubCategory in the database
        List<ProductSubCategory> productSubCategoryList = productSubCategoryRepository.findAll();
        assertThat(productSubCategoryList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteProductSubCategory() throws Exception {
        // Initialize the database
        productSubCategoryRepository.saveAndFlush(productSubCategory);

        int databaseSizeBeforeDelete = productSubCategoryRepository.findAll().size();

        // Delete the productSubCategory
        restProductSubCategoryMockMvc.perform(delete("/api/product-sub-categories/{id}", productSubCategory.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<ProductSubCategory> productSubCategoryList = productSubCategoryRepository.findAll();
        assertThat(productSubCategoryList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ProductSubCategory.class);
        ProductSubCategory productSubCategory1 = new ProductSubCategory();
        productSubCategory1.setId(1L);
        ProductSubCategory productSubCategory2 = new ProductSubCategory();
        productSubCategory2.setId(productSubCategory1.getId());
        assertThat(productSubCategory1).isEqualTo(productSubCategory2);
        productSubCategory2.setId(2L);
        assertThat(productSubCategory1).isNotEqualTo(productSubCategory2);
        productSubCategory1.setId(null);
        assertThat(productSubCategory1).isNotEqualTo(productSubCategory2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ProductSubCategoryDTO.class);
        ProductSubCategoryDTO productSubCategoryDTO1 = new ProductSubCategoryDTO();
        productSubCategoryDTO1.setId(1L);
        ProductSubCategoryDTO productSubCategoryDTO2 = new ProductSubCategoryDTO();
        assertThat(productSubCategoryDTO1).isNotEqualTo(productSubCategoryDTO2);
        productSubCategoryDTO2.setId(productSubCategoryDTO1.getId());
        assertThat(productSubCategoryDTO1).isEqualTo(productSubCategoryDTO2);
        productSubCategoryDTO2.setId(2L);
        assertThat(productSubCategoryDTO1).isNotEqualTo(productSubCategoryDTO2);
        productSubCategoryDTO1.setId(null);
        assertThat(productSubCategoryDTO1).isNotEqualTo(productSubCategoryDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(productSubCategoryMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(productSubCategoryMapper.fromId(null)).isNull();
    }
}
