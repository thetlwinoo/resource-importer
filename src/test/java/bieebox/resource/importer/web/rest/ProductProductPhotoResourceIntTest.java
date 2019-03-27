package bieebox.resource.importer.web.rest;

import bieebox.resource.importer.ImporterApp;

import bieebox.resource.importer.domain.ProductProductPhoto;
import bieebox.resource.importer.repository.ProductProductPhotoRepository;
import bieebox.resource.importer.service.ProductProductPhotoService;
import bieebox.resource.importer.service.dto.ProductProductPhotoDTO;
import bieebox.resource.importer.service.mapper.ProductProductPhotoMapper;
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
 * Test class for the ProductProductPhotoResource REST controller.
 *
 * @see ProductProductPhotoResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ImporterApp.class)
public class ProductProductPhotoResourceIntTest {

    private static final Boolean DEFAULT_FIRST_PRIORITY = false;
    private static final Boolean UPDATED_FIRST_PRIORITY = true;

    private static final Boolean DEFAULT_SECOND_PRIORITY = false;
    private static final Boolean UPDATED_SECOND_PRIORITY = true;

    private static final Boolean DEFAULT_THIRD_PRIORITY = false;
    private static final Boolean UPDATED_THIRD_PRIORITY = true;

    private static final Boolean DEFAULT_FOURTH_PRIORITY = false;
    private static final Boolean UPDATED_FOURTH_PRIORITY = true;

    private static final Boolean DEFAULT_FIXTH_PRIORITY = false;
    private static final Boolean UPDATED_FIXTH_PRIORITY = true;

    private static final Boolean DEFAULT_SIXTH_PRIORITY = false;
    private static final Boolean UPDATED_SIXTH_PRIORITY = true;

    @Autowired
    private ProductProductPhotoRepository productProductPhotoRepository;

    @Autowired
    private ProductProductPhotoMapper productProductPhotoMapper;

    @Autowired
    private ProductProductPhotoService productProductPhotoService;

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

    private MockMvc restProductProductPhotoMockMvc;

    private ProductProductPhoto productProductPhoto;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ProductProductPhotoResource productProductPhotoResource = new ProductProductPhotoResource(productProductPhotoService);
        this.restProductProductPhotoMockMvc = MockMvcBuilders.standaloneSetup(productProductPhotoResource)
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
    public static ProductProductPhoto createEntity(EntityManager em) {
        ProductProductPhoto productProductPhoto = new ProductProductPhoto()
            .firstPriority(DEFAULT_FIRST_PRIORITY)
            .secondPriority(DEFAULT_SECOND_PRIORITY)
            .thirdPriority(DEFAULT_THIRD_PRIORITY)
            .fourthPriority(DEFAULT_FOURTH_PRIORITY)
            .fixthPriority(DEFAULT_FIXTH_PRIORITY)
            .sixthPriority(DEFAULT_SIXTH_PRIORITY);
        return productProductPhoto;
    }

    @Before
    public void initTest() {
        productProductPhoto = createEntity(em);
    }

    @Test
    @Transactional
    public void createProductProductPhoto() throws Exception {
        int databaseSizeBeforeCreate = productProductPhotoRepository.findAll().size();

        // Create the ProductProductPhoto
        ProductProductPhotoDTO productProductPhotoDTO = productProductPhotoMapper.toDto(productProductPhoto);
        restProductProductPhotoMockMvc.perform(post("/api/product-product-photos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productProductPhotoDTO)))
            .andExpect(status().isCreated());

        // Validate the ProductProductPhoto in the database
        List<ProductProductPhoto> productProductPhotoList = productProductPhotoRepository.findAll();
        assertThat(productProductPhotoList).hasSize(databaseSizeBeforeCreate + 1);
        ProductProductPhoto testProductProductPhoto = productProductPhotoList.get(productProductPhotoList.size() - 1);
        assertThat(testProductProductPhoto.isFirstPriority()).isEqualTo(DEFAULT_FIRST_PRIORITY);
        assertThat(testProductProductPhoto.isSecondPriority()).isEqualTo(DEFAULT_SECOND_PRIORITY);
        assertThat(testProductProductPhoto.isThirdPriority()).isEqualTo(DEFAULT_THIRD_PRIORITY);
        assertThat(testProductProductPhoto.isFourthPriority()).isEqualTo(DEFAULT_FOURTH_PRIORITY);
        assertThat(testProductProductPhoto.isFixthPriority()).isEqualTo(DEFAULT_FIXTH_PRIORITY);
        assertThat(testProductProductPhoto.isSixthPriority()).isEqualTo(DEFAULT_SIXTH_PRIORITY);
    }

    @Test
    @Transactional
    public void createProductProductPhotoWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = productProductPhotoRepository.findAll().size();

        // Create the ProductProductPhoto with an existing ID
        productProductPhoto.setId(1L);
        ProductProductPhotoDTO productProductPhotoDTO = productProductPhotoMapper.toDto(productProductPhoto);

        // An entity with an existing ID cannot be created, so this API call must fail
        restProductProductPhotoMockMvc.perform(post("/api/product-product-photos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productProductPhotoDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ProductProductPhoto in the database
        List<ProductProductPhoto> productProductPhotoList = productProductPhotoRepository.findAll();
        assertThat(productProductPhotoList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkFirstPriorityIsRequired() throws Exception {
        int databaseSizeBeforeTest = productProductPhotoRepository.findAll().size();
        // set the field null
        productProductPhoto.setFirstPriority(null);

        // Create the ProductProductPhoto, which fails.
        ProductProductPhotoDTO productProductPhotoDTO = productProductPhotoMapper.toDto(productProductPhoto);

        restProductProductPhotoMockMvc.perform(post("/api/product-product-photos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productProductPhotoDTO)))
            .andExpect(status().isBadRequest());

        List<ProductProductPhoto> productProductPhotoList = productProductPhotoRepository.findAll();
        assertThat(productProductPhotoList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkSecondPriorityIsRequired() throws Exception {
        int databaseSizeBeforeTest = productProductPhotoRepository.findAll().size();
        // set the field null
        productProductPhoto.setSecondPriority(null);

        // Create the ProductProductPhoto, which fails.
        ProductProductPhotoDTO productProductPhotoDTO = productProductPhotoMapper.toDto(productProductPhoto);

        restProductProductPhotoMockMvc.perform(post("/api/product-product-photos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productProductPhotoDTO)))
            .andExpect(status().isBadRequest());

        List<ProductProductPhoto> productProductPhotoList = productProductPhotoRepository.findAll();
        assertThat(productProductPhotoList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkThirdPriorityIsRequired() throws Exception {
        int databaseSizeBeforeTest = productProductPhotoRepository.findAll().size();
        // set the field null
        productProductPhoto.setThirdPriority(null);

        // Create the ProductProductPhoto, which fails.
        ProductProductPhotoDTO productProductPhotoDTO = productProductPhotoMapper.toDto(productProductPhoto);

        restProductProductPhotoMockMvc.perform(post("/api/product-product-photos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productProductPhotoDTO)))
            .andExpect(status().isBadRequest());

        List<ProductProductPhoto> productProductPhotoList = productProductPhotoRepository.findAll();
        assertThat(productProductPhotoList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkFourthPriorityIsRequired() throws Exception {
        int databaseSizeBeforeTest = productProductPhotoRepository.findAll().size();
        // set the field null
        productProductPhoto.setFourthPriority(null);

        // Create the ProductProductPhoto, which fails.
        ProductProductPhotoDTO productProductPhotoDTO = productProductPhotoMapper.toDto(productProductPhoto);

        restProductProductPhotoMockMvc.perform(post("/api/product-product-photos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productProductPhotoDTO)))
            .andExpect(status().isBadRequest());

        List<ProductProductPhoto> productProductPhotoList = productProductPhotoRepository.findAll();
        assertThat(productProductPhotoList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkFixthPriorityIsRequired() throws Exception {
        int databaseSizeBeforeTest = productProductPhotoRepository.findAll().size();
        // set the field null
        productProductPhoto.setFixthPriority(null);

        // Create the ProductProductPhoto, which fails.
        ProductProductPhotoDTO productProductPhotoDTO = productProductPhotoMapper.toDto(productProductPhoto);

        restProductProductPhotoMockMvc.perform(post("/api/product-product-photos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productProductPhotoDTO)))
            .andExpect(status().isBadRequest());

        List<ProductProductPhoto> productProductPhotoList = productProductPhotoRepository.findAll();
        assertThat(productProductPhotoList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkSixthPriorityIsRequired() throws Exception {
        int databaseSizeBeforeTest = productProductPhotoRepository.findAll().size();
        // set the field null
        productProductPhoto.setSixthPriority(null);

        // Create the ProductProductPhoto, which fails.
        ProductProductPhotoDTO productProductPhotoDTO = productProductPhotoMapper.toDto(productProductPhoto);

        restProductProductPhotoMockMvc.perform(post("/api/product-product-photos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productProductPhotoDTO)))
            .andExpect(status().isBadRequest());

        List<ProductProductPhoto> productProductPhotoList = productProductPhotoRepository.findAll();
        assertThat(productProductPhotoList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllProductProductPhotos() throws Exception {
        // Initialize the database
        productProductPhotoRepository.saveAndFlush(productProductPhoto);

        // Get all the productProductPhotoList
        restProductProductPhotoMockMvc.perform(get("/api/product-product-photos?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(productProductPhoto.getId().intValue())))
            .andExpect(jsonPath("$.[*].firstPriority").value(hasItem(DEFAULT_FIRST_PRIORITY.booleanValue())))
            .andExpect(jsonPath("$.[*].secondPriority").value(hasItem(DEFAULT_SECOND_PRIORITY.booleanValue())))
            .andExpect(jsonPath("$.[*].thirdPriority").value(hasItem(DEFAULT_THIRD_PRIORITY.booleanValue())))
            .andExpect(jsonPath("$.[*].fourthPriority").value(hasItem(DEFAULT_FOURTH_PRIORITY.booleanValue())))
            .andExpect(jsonPath("$.[*].fixthPriority").value(hasItem(DEFAULT_FIXTH_PRIORITY.booleanValue())))
            .andExpect(jsonPath("$.[*].sixthPriority").value(hasItem(DEFAULT_SIXTH_PRIORITY.booleanValue())));
    }
    
    @Test
    @Transactional
    public void getProductProductPhoto() throws Exception {
        // Initialize the database
        productProductPhotoRepository.saveAndFlush(productProductPhoto);

        // Get the productProductPhoto
        restProductProductPhotoMockMvc.perform(get("/api/product-product-photos/{id}", productProductPhoto.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(productProductPhoto.getId().intValue()))
            .andExpect(jsonPath("$.firstPriority").value(DEFAULT_FIRST_PRIORITY.booleanValue()))
            .andExpect(jsonPath("$.secondPriority").value(DEFAULT_SECOND_PRIORITY.booleanValue()))
            .andExpect(jsonPath("$.thirdPriority").value(DEFAULT_THIRD_PRIORITY.booleanValue()))
            .andExpect(jsonPath("$.fourthPriority").value(DEFAULT_FOURTH_PRIORITY.booleanValue()))
            .andExpect(jsonPath("$.fixthPriority").value(DEFAULT_FIXTH_PRIORITY.booleanValue()))
            .andExpect(jsonPath("$.sixthPriority").value(DEFAULT_SIXTH_PRIORITY.booleanValue()));
    }

    @Test
    @Transactional
    public void getNonExistingProductProductPhoto() throws Exception {
        // Get the productProductPhoto
        restProductProductPhotoMockMvc.perform(get("/api/product-product-photos/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateProductProductPhoto() throws Exception {
        // Initialize the database
        productProductPhotoRepository.saveAndFlush(productProductPhoto);

        int databaseSizeBeforeUpdate = productProductPhotoRepository.findAll().size();

        // Update the productProductPhoto
        ProductProductPhoto updatedProductProductPhoto = productProductPhotoRepository.findById(productProductPhoto.getId()).get();
        // Disconnect from session so that the updates on updatedProductProductPhoto are not directly saved in db
        em.detach(updatedProductProductPhoto);
        updatedProductProductPhoto
            .firstPriority(UPDATED_FIRST_PRIORITY)
            .secondPriority(UPDATED_SECOND_PRIORITY)
            .thirdPriority(UPDATED_THIRD_PRIORITY)
            .fourthPriority(UPDATED_FOURTH_PRIORITY)
            .fixthPriority(UPDATED_FIXTH_PRIORITY)
            .sixthPriority(UPDATED_SIXTH_PRIORITY);
        ProductProductPhotoDTO productProductPhotoDTO = productProductPhotoMapper.toDto(updatedProductProductPhoto);

        restProductProductPhotoMockMvc.perform(put("/api/product-product-photos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productProductPhotoDTO)))
            .andExpect(status().isOk());

        // Validate the ProductProductPhoto in the database
        List<ProductProductPhoto> productProductPhotoList = productProductPhotoRepository.findAll();
        assertThat(productProductPhotoList).hasSize(databaseSizeBeforeUpdate);
        ProductProductPhoto testProductProductPhoto = productProductPhotoList.get(productProductPhotoList.size() - 1);
        assertThat(testProductProductPhoto.isFirstPriority()).isEqualTo(UPDATED_FIRST_PRIORITY);
        assertThat(testProductProductPhoto.isSecondPriority()).isEqualTo(UPDATED_SECOND_PRIORITY);
        assertThat(testProductProductPhoto.isThirdPriority()).isEqualTo(UPDATED_THIRD_PRIORITY);
        assertThat(testProductProductPhoto.isFourthPriority()).isEqualTo(UPDATED_FOURTH_PRIORITY);
        assertThat(testProductProductPhoto.isFixthPriority()).isEqualTo(UPDATED_FIXTH_PRIORITY);
        assertThat(testProductProductPhoto.isSixthPriority()).isEqualTo(UPDATED_SIXTH_PRIORITY);
    }

    @Test
    @Transactional
    public void updateNonExistingProductProductPhoto() throws Exception {
        int databaseSizeBeforeUpdate = productProductPhotoRepository.findAll().size();

        // Create the ProductProductPhoto
        ProductProductPhotoDTO productProductPhotoDTO = productProductPhotoMapper.toDto(productProductPhoto);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restProductProductPhotoMockMvc.perform(put("/api/product-product-photos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productProductPhotoDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ProductProductPhoto in the database
        List<ProductProductPhoto> productProductPhotoList = productProductPhotoRepository.findAll();
        assertThat(productProductPhotoList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteProductProductPhoto() throws Exception {
        // Initialize the database
        productProductPhotoRepository.saveAndFlush(productProductPhoto);

        int databaseSizeBeforeDelete = productProductPhotoRepository.findAll().size();

        // Delete the productProductPhoto
        restProductProductPhotoMockMvc.perform(delete("/api/product-product-photos/{id}", productProductPhoto.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<ProductProductPhoto> productProductPhotoList = productProductPhotoRepository.findAll();
        assertThat(productProductPhotoList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ProductProductPhoto.class);
        ProductProductPhoto productProductPhoto1 = new ProductProductPhoto();
        productProductPhoto1.setId(1L);
        ProductProductPhoto productProductPhoto2 = new ProductProductPhoto();
        productProductPhoto2.setId(productProductPhoto1.getId());
        assertThat(productProductPhoto1).isEqualTo(productProductPhoto2);
        productProductPhoto2.setId(2L);
        assertThat(productProductPhoto1).isNotEqualTo(productProductPhoto2);
        productProductPhoto1.setId(null);
        assertThat(productProductPhoto1).isNotEqualTo(productProductPhoto2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ProductProductPhotoDTO.class);
        ProductProductPhotoDTO productProductPhotoDTO1 = new ProductProductPhotoDTO();
        productProductPhotoDTO1.setId(1L);
        ProductProductPhotoDTO productProductPhotoDTO2 = new ProductProductPhotoDTO();
        assertThat(productProductPhotoDTO1).isNotEqualTo(productProductPhotoDTO2);
        productProductPhotoDTO2.setId(productProductPhotoDTO1.getId());
        assertThat(productProductPhotoDTO1).isEqualTo(productProductPhotoDTO2);
        productProductPhotoDTO2.setId(2L);
        assertThat(productProductPhotoDTO1).isNotEqualTo(productProductPhotoDTO2);
        productProductPhotoDTO1.setId(null);
        assertThat(productProductPhotoDTO1).isNotEqualTo(productProductPhotoDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(productProductPhotoMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(productProductPhotoMapper.fromId(null)).isNull();
    }
}
