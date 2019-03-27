package bieebox.resource.importer.web.rest;

import bieebox.resource.importer.ImporterApp;

import bieebox.resource.importer.domain.ProductPhoto;
import bieebox.resource.importer.repository.ProductPhotoRepository;
import bieebox.resource.importer.service.ProductPhotoService;
import bieebox.resource.importer.service.dto.ProductPhotoDTO;
import bieebox.resource.importer.service.mapper.ProductPhotoMapper;
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
 * Test class for the ProductPhotoResource REST controller.
 *
 * @see ProductPhotoResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ImporterApp.class)
public class ProductPhotoResourceIntTest {

    private static final String DEFAULT_THUMB_NAIL_PHOTO = "AAAAAAAAAA";
    private static final String UPDATED_THUMB_NAIL_PHOTO = "BBBBBBBBBB";

    private static final String DEFAULT_THUMB_NAIL_PHOTO_FILE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_THUMB_NAIL_PHOTO_FILE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_LARGE_PHOTO = "AAAAAAAAAA";
    private static final String UPDATED_LARGE_PHOTO = "BBBBBBBBBB";

    private static final String DEFAULT_LARGE_PHOTO_FILE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_LARGE_PHOTO_FILE_NAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_PRIORITY = 1;
    private static final Integer UPDATED_PRIORITY = 2;

    @Autowired
    private ProductPhotoRepository productPhotoRepository;

    @Autowired
    private ProductPhotoMapper productPhotoMapper;

    @Autowired
    private ProductPhotoService productPhotoService;

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

    private MockMvc restProductPhotoMockMvc;

    private ProductPhoto productPhoto;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ProductPhotoResource productPhotoResource = new ProductPhotoResource(productPhotoService);
        this.restProductPhotoMockMvc = MockMvcBuilders.standaloneSetup(productPhotoResource)
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
    public static ProductPhoto createEntity(EntityManager em) {
        ProductPhoto productPhoto = new ProductPhoto()
            .thumbNailPhoto(DEFAULT_THUMB_NAIL_PHOTO)
            .thumbNailPhotoFileName(DEFAULT_THUMB_NAIL_PHOTO_FILE_NAME)
            .largePhoto(DEFAULT_LARGE_PHOTO)
            .largePhotoFileName(DEFAULT_LARGE_PHOTO_FILE_NAME)
            .priority(DEFAULT_PRIORITY);
        return productPhoto;
    }

    @Before
    public void initTest() {
        productPhoto = createEntity(em);
    }

    @Test
    @Transactional
    public void createProductPhoto() throws Exception {
        int databaseSizeBeforeCreate = productPhotoRepository.findAll().size();

        // Create the ProductPhoto
        ProductPhotoDTO productPhotoDTO = productPhotoMapper.toDto(productPhoto);
        restProductPhotoMockMvc.perform(post("/api/product-photos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productPhotoDTO)))
            .andExpect(status().isCreated());

        // Validate the ProductPhoto in the database
        List<ProductPhoto> productPhotoList = productPhotoRepository.findAll();
        assertThat(productPhotoList).hasSize(databaseSizeBeforeCreate + 1);
        ProductPhoto testProductPhoto = productPhotoList.get(productPhotoList.size() - 1);
        assertThat(testProductPhoto.getThumbNailPhoto()).isEqualTo(DEFAULT_THUMB_NAIL_PHOTO);
        assertThat(testProductPhoto.getThumbNailPhotoFileName()).isEqualTo(DEFAULT_THUMB_NAIL_PHOTO_FILE_NAME);
        assertThat(testProductPhoto.getLargePhoto()).isEqualTo(DEFAULT_LARGE_PHOTO);
        assertThat(testProductPhoto.getLargePhotoFileName()).isEqualTo(DEFAULT_LARGE_PHOTO_FILE_NAME);
        assertThat(testProductPhoto.getPriority()).isEqualTo(DEFAULT_PRIORITY);
    }

    @Test
    @Transactional
    public void createProductPhotoWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = productPhotoRepository.findAll().size();

        // Create the ProductPhoto with an existing ID
        productPhoto.setId(1L);
        ProductPhotoDTO productPhotoDTO = productPhotoMapper.toDto(productPhoto);

        // An entity with an existing ID cannot be created, so this API call must fail
        restProductPhotoMockMvc.perform(post("/api/product-photos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productPhotoDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ProductPhoto in the database
        List<ProductPhoto> productPhotoList = productPhotoRepository.findAll();
        assertThat(productPhotoList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllProductPhotos() throws Exception {
        // Initialize the database
        productPhotoRepository.saveAndFlush(productPhoto);

        // Get all the productPhotoList
        restProductPhotoMockMvc.perform(get("/api/product-photos?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(productPhoto.getId().intValue())))
            .andExpect(jsonPath("$.[*].thumbNailPhoto").value(hasItem(DEFAULT_THUMB_NAIL_PHOTO.toString())))
            .andExpect(jsonPath("$.[*].thumbNailPhotoFileName").value(hasItem(DEFAULT_THUMB_NAIL_PHOTO_FILE_NAME.toString())))
            .andExpect(jsonPath("$.[*].largePhoto").value(hasItem(DEFAULT_LARGE_PHOTO.toString())))
            .andExpect(jsonPath("$.[*].largePhotoFileName").value(hasItem(DEFAULT_LARGE_PHOTO_FILE_NAME.toString())))
            .andExpect(jsonPath("$.[*].priority").value(hasItem(DEFAULT_PRIORITY)));
    }
    
    @Test
    @Transactional
    public void getProductPhoto() throws Exception {
        // Initialize the database
        productPhotoRepository.saveAndFlush(productPhoto);

        // Get the productPhoto
        restProductPhotoMockMvc.perform(get("/api/product-photos/{id}", productPhoto.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(productPhoto.getId().intValue()))
            .andExpect(jsonPath("$.thumbNailPhoto").value(DEFAULT_THUMB_NAIL_PHOTO.toString()))
            .andExpect(jsonPath("$.thumbNailPhotoFileName").value(DEFAULT_THUMB_NAIL_PHOTO_FILE_NAME.toString()))
            .andExpect(jsonPath("$.largePhoto").value(DEFAULT_LARGE_PHOTO.toString()))
            .andExpect(jsonPath("$.largePhotoFileName").value(DEFAULT_LARGE_PHOTO_FILE_NAME.toString()))
            .andExpect(jsonPath("$.priority").value(DEFAULT_PRIORITY));
    }

    @Test
    @Transactional
    public void getNonExistingProductPhoto() throws Exception {
        // Get the productPhoto
        restProductPhotoMockMvc.perform(get("/api/product-photos/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateProductPhoto() throws Exception {
        // Initialize the database
        productPhotoRepository.saveAndFlush(productPhoto);

        int databaseSizeBeforeUpdate = productPhotoRepository.findAll().size();

        // Update the productPhoto
        ProductPhoto updatedProductPhoto = productPhotoRepository.findById(productPhoto.getId()).get();
        // Disconnect from session so that the updates on updatedProductPhoto are not directly saved in db
        em.detach(updatedProductPhoto);
        updatedProductPhoto
            .thumbNailPhoto(UPDATED_THUMB_NAIL_PHOTO)
            .thumbNailPhotoFileName(UPDATED_THUMB_NAIL_PHOTO_FILE_NAME)
            .largePhoto(UPDATED_LARGE_PHOTO)
            .largePhotoFileName(UPDATED_LARGE_PHOTO_FILE_NAME)
            .priority(UPDATED_PRIORITY);
        ProductPhotoDTO productPhotoDTO = productPhotoMapper.toDto(updatedProductPhoto);

        restProductPhotoMockMvc.perform(put("/api/product-photos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productPhotoDTO)))
            .andExpect(status().isOk());

        // Validate the ProductPhoto in the database
        List<ProductPhoto> productPhotoList = productPhotoRepository.findAll();
        assertThat(productPhotoList).hasSize(databaseSizeBeforeUpdate);
        ProductPhoto testProductPhoto = productPhotoList.get(productPhotoList.size() - 1);
        assertThat(testProductPhoto.getThumbNailPhoto()).isEqualTo(UPDATED_THUMB_NAIL_PHOTO);
        assertThat(testProductPhoto.getThumbNailPhotoFileName()).isEqualTo(UPDATED_THUMB_NAIL_PHOTO_FILE_NAME);
        assertThat(testProductPhoto.getLargePhoto()).isEqualTo(UPDATED_LARGE_PHOTO);
        assertThat(testProductPhoto.getLargePhotoFileName()).isEqualTo(UPDATED_LARGE_PHOTO_FILE_NAME);
        assertThat(testProductPhoto.getPriority()).isEqualTo(UPDATED_PRIORITY);
    }

    @Test
    @Transactional
    public void updateNonExistingProductPhoto() throws Exception {
        int databaseSizeBeforeUpdate = productPhotoRepository.findAll().size();

        // Create the ProductPhoto
        ProductPhotoDTO productPhotoDTO = productPhotoMapper.toDto(productPhoto);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restProductPhotoMockMvc.perform(put("/api/product-photos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productPhotoDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ProductPhoto in the database
        List<ProductPhoto> productPhotoList = productPhotoRepository.findAll();
        assertThat(productPhotoList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteProductPhoto() throws Exception {
        // Initialize the database
        productPhotoRepository.saveAndFlush(productPhoto);

        int databaseSizeBeforeDelete = productPhotoRepository.findAll().size();

        // Delete the productPhoto
        restProductPhotoMockMvc.perform(delete("/api/product-photos/{id}", productPhoto.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<ProductPhoto> productPhotoList = productPhotoRepository.findAll();
        assertThat(productPhotoList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ProductPhoto.class);
        ProductPhoto productPhoto1 = new ProductPhoto();
        productPhoto1.setId(1L);
        ProductPhoto productPhoto2 = new ProductPhoto();
        productPhoto2.setId(productPhoto1.getId());
        assertThat(productPhoto1).isEqualTo(productPhoto2);
        productPhoto2.setId(2L);
        assertThat(productPhoto1).isNotEqualTo(productPhoto2);
        productPhoto1.setId(null);
        assertThat(productPhoto1).isNotEqualTo(productPhoto2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ProductPhotoDTO.class);
        ProductPhotoDTO productPhotoDTO1 = new ProductPhotoDTO();
        productPhotoDTO1.setId(1L);
        ProductPhotoDTO productPhotoDTO2 = new ProductPhotoDTO();
        assertThat(productPhotoDTO1).isNotEqualTo(productPhotoDTO2);
        productPhotoDTO2.setId(productPhotoDTO1.getId());
        assertThat(productPhotoDTO1).isEqualTo(productPhotoDTO2);
        productPhotoDTO2.setId(2L);
        assertThat(productPhotoDTO1).isNotEqualTo(productPhotoDTO2);
        productPhotoDTO1.setId(null);
        assertThat(productPhotoDTO1).isNotEqualTo(productPhotoDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(productPhotoMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(productPhotoMapper.fromId(null)).isNull();
    }
}
