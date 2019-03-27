package bieebox.resource.importer.web.rest;

import bieebox.resource.importer.ImporterApp;

import bieebox.resource.importer.domain.SystemParameters;
import bieebox.resource.importer.repository.SystemParametersRepository;
import bieebox.resource.importer.service.SystemParametersService;
import bieebox.resource.importer.service.dto.SystemParametersDTO;
import bieebox.resource.importer.service.mapper.SystemParametersMapper;
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
 * Test class for the SystemParametersResource REST controller.
 *
 * @see SystemParametersResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ImporterApp.class)
public class SystemParametersResourceIntTest {

    private static final String DEFAULT_DELIVERY_ADDRESS_LINE_1 = "AAAAAAAAAA";
    private static final String UPDATED_DELIVERY_ADDRESS_LINE_1 = "BBBBBBBBBB";

    private static final String DEFAULT_DELIVERY_ADDRESS_LINE_2 = "AAAAAAAAAA";
    private static final String UPDATED_DELIVERY_ADDRESS_LINE_2 = "BBBBBBBBBB";

    private static final String DEFAULT_DELIVERY_POSTAL_CODE = "AAAAAAAAAA";
    private static final String UPDATED_DELIVERY_POSTAL_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_DELIVERY_LOCATION = "AAAAAAAAAA";
    private static final String UPDATED_DELIVERY_LOCATION = "BBBBBBBBBB";

    private static final String DEFAULT_POSTAL_ADDRESS_LINE_1 = "AAAAAAAAAA";
    private static final String UPDATED_POSTAL_ADDRESS_LINE_1 = "BBBBBBBBBB";

    private static final String DEFAULT_POSTAL_ADDRESS_LINE_2 = "AAAAAAAAAA";
    private static final String UPDATED_POSTAL_ADDRESS_LINE_2 = "BBBBBBBBBB";

    private static final String DEFAULT_POSTAL_POSTAL_CODE = "AAAAAAAAAA";
    private static final String UPDATED_POSTAL_POSTAL_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_APPLICATION_SETTINGS = "AAAAAAAAAA";
    private static final String UPDATED_APPLICATION_SETTINGS = "BBBBBBBBBB";

    @Autowired
    private SystemParametersRepository systemParametersRepository;

    @Autowired
    private SystemParametersMapper systemParametersMapper;

    @Autowired
    private SystemParametersService systemParametersService;

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

    private MockMvc restSystemParametersMockMvc;

    private SystemParameters systemParameters;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final SystemParametersResource systemParametersResource = new SystemParametersResource(systemParametersService);
        this.restSystemParametersMockMvc = MockMvcBuilders.standaloneSetup(systemParametersResource)
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
    public static SystemParameters createEntity(EntityManager em) {
        SystemParameters systemParameters = new SystemParameters()
            .deliveryAddressLine1(DEFAULT_DELIVERY_ADDRESS_LINE_1)
            .deliveryAddressLine2(DEFAULT_DELIVERY_ADDRESS_LINE_2)
            .deliveryPostalCode(DEFAULT_DELIVERY_POSTAL_CODE)
            .deliveryLocation(DEFAULT_DELIVERY_LOCATION)
            .postalAddressLine1(DEFAULT_POSTAL_ADDRESS_LINE_1)
            .postalAddressLine2(DEFAULT_POSTAL_ADDRESS_LINE_2)
            .postalPostalCode(DEFAULT_POSTAL_POSTAL_CODE)
            .applicationSettings(DEFAULT_APPLICATION_SETTINGS);
        return systemParameters;
    }

    @Before
    public void initTest() {
        systemParameters = createEntity(em);
    }

    @Test
    @Transactional
    public void createSystemParameters() throws Exception {
        int databaseSizeBeforeCreate = systemParametersRepository.findAll().size();

        // Create the SystemParameters
        SystemParametersDTO systemParametersDTO = systemParametersMapper.toDto(systemParameters);
        restSystemParametersMockMvc.perform(post("/api/system-parameters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(systemParametersDTO)))
            .andExpect(status().isCreated());

        // Validate the SystemParameters in the database
        List<SystemParameters> systemParametersList = systemParametersRepository.findAll();
        assertThat(systemParametersList).hasSize(databaseSizeBeforeCreate + 1);
        SystemParameters testSystemParameters = systemParametersList.get(systemParametersList.size() - 1);
        assertThat(testSystemParameters.getDeliveryAddressLine1()).isEqualTo(DEFAULT_DELIVERY_ADDRESS_LINE_1);
        assertThat(testSystemParameters.getDeliveryAddressLine2()).isEqualTo(DEFAULT_DELIVERY_ADDRESS_LINE_2);
        assertThat(testSystemParameters.getDeliveryPostalCode()).isEqualTo(DEFAULT_DELIVERY_POSTAL_CODE);
        assertThat(testSystemParameters.getDeliveryLocation()).isEqualTo(DEFAULT_DELIVERY_LOCATION);
        assertThat(testSystemParameters.getPostalAddressLine1()).isEqualTo(DEFAULT_POSTAL_ADDRESS_LINE_1);
        assertThat(testSystemParameters.getPostalAddressLine2()).isEqualTo(DEFAULT_POSTAL_ADDRESS_LINE_2);
        assertThat(testSystemParameters.getPostalPostalCode()).isEqualTo(DEFAULT_POSTAL_POSTAL_CODE);
        assertThat(testSystemParameters.getApplicationSettings()).isEqualTo(DEFAULT_APPLICATION_SETTINGS);
    }

    @Test
    @Transactional
    public void createSystemParametersWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = systemParametersRepository.findAll().size();

        // Create the SystemParameters with an existing ID
        systemParameters.setId(1L);
        SystemParametersDTO systemParametersDTO = systemParametersMapper.toDto(systemParameters);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSystemParametersMockMvc.perform(post("/api/system-parameters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(systemParametersDTO)))
            .andExpect(status().isBadRequest());

        // Validate the SystemParameters in the database
        List<SystemParameters> systemParametersList = systemParametersRepository.findAll();
        assertThat(systemParametersList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkDeliveryAddressLine1IsRequired() throws Exception {
        int databaseSizeBeforeTest = systemParametersRepository.findAll().size();
        // set the field null
        systemParameters.setDeliveryAddressLine1(null);

        // Create the SystemParameters, which fails.
        SystemParametersDTO systemParametersDTO = systemParametersMapper.toDto(systemParameters);

        restSystemParametersMockMvc.perform(post("/api/system-parameters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(systemParametersDTO)))
            .andExpect(status().isBadRequest());

        List<SystemParameters> systemParametersList = systemParametersRepository.findAll();
        assertThat(systemParametersList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDeliveryPostalCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = systemParametersRepository.findAll().size();
        // set the field null
        systemParameters.setDeliveryPostalCode(null);

        // Create the SystemParameters, which fails.
        SystemParametersDTO systemParametersDTO = systemParametersMapper.toDto(systemParameters);

        restSystemParametersMockMvc.perform(post("/api/system-parameters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(systemParametersDTO)))
            .andExpect(status().isBadRequest());

        List<SystemParameters> systemParametersList = systemParametersRepository.findAll();
        assertThat(systemParametersList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDeliveryLocationIsRequired() throws Exception {
        int databaseSizeBeforeTest = systemParametersRepository.findAll().size();
        // set the field null
        systemParameters.setDeliveryLocation(null);

        // Create the SystemParameters, which fails.
        SystemParametersDTO systemParametersDTO = systemParametersMapper.toDto(systemParameters);

        restSystemParametersMockMvc.perform(post("/api/system-parameters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(systemParametersDTO)))
            .andExpect(status().isBadRequest());

        List<SystemParameters> systemParametersList = systemParametersRepository.findAll();
        assertThat(systemParametersList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkPostalAddressLine1IsRequired() throws Exception {
        int databaseSizeBeforeTest = systemParametersRepository.findAll().size();
        // set the field null
        systemParameters.setPostalAddressLine1(null);

        // Create the SystemParameters, which fails.
        SystemParametersDTO systemParametersDTO = systemParametersMapper.toDto(systemParameters);

        restSystemParametersMockMvc.perform(post("/api/system-parameters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(systemParametersDTO)))
            .andExpect(status().isBadRequest());

        List<SystemParameters> systemParametersList = systemParametersRepository.findAll();
        assertThat(systemParametersList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkPostalPostalCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = systemParametersRepository.findAll().size();
        // set the field null
        systemParameters.setPostalPostalCode(null);

        // Create the SystemParameters, which fails.
        SystemParametersDTO systemParametersDTO = systemParametersMapper.toDto(systemParameters);

        restSystemParametersMockMvc.perform(post("/api/system-parameters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(systemParametersDTO)))
            .andExpect(status().isBadRequest());

        List<SystemParameters> systemParametersList = systemParametersRepository.findAll();
        assertThat(systemParametersList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkApplicationSettingsIsRequired() throws Exception {
        int databaseSizeBeforeTest = systemParametersRepository.findAll().size();
        // set the field null
        systemParameters.setApplicationSettings(null);

        // Create the SystemParameters, which fails.
        SystemParametersDTO systemParametersDTO = systemParametersMapper.toDto(systemParameters);

        restSystemParametersMockMvc.perform(post("/api/system-parameters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(systemParametersDTO)))
            .andExpect(status().isBadRequest());

        List<SystemParameters> systemParametersList = systemParametersRepository.findAll();
        assertThat(systemParametersList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllSystemParameters() throws Exception {
        // Initialize the database
        systemParametersRepository.saveAndFlush(systemParameters);

        // Get all the systemParametersList
        restSystemParametersMockMvc.perform(get("/api/system-parameters?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(systemParameters.getId().intValue())))
            .andExpect(jsonPath("$.[*].deliveryAddressLine1").value(hasItem(DEFAULT_DELIVERY_ADDRESS_LINE_1.toString())))
            .andExpect(jsonPath("$.[*].deliveryAddressLine2").value(hasItem(DEFAULT_DELIVERY_ADDRESS_LINE_2.toString())))
            .andExpect(jsonPath("$.[*].deliveryPostalCode").value(hasItem(DEFAULT_DELIVERY_POSTAL_CODE.toString())))
            .andExpect(jsonPath("$.[*].deliveryLocation").value(hasItem(DEFAULT_DELIVERY_LOCATION.toString())))
            .andExpect(jsonPath("$.[*].postalAddressLine1").value(hasItem(DEFAULT_POSTAL_ADDRESS_LINE_1.toString())))
            .andExpect(jsonPath("$.[*].postalAddressLine2").value(hasItem(DEFAULT_POSTAL_ADDRESS_LINE_2.toString())))
            .andExpect(jsonPath("$.[*].postalPostalCode").value(hasItem(DEFAULT_POSTAL_POSTAL_CODE.toString())))
            .andExpect(jsonPath("$.[*].applicationSettings").value(hasItem(DEFAULT_APPLICATION_SETTINGS.toString())));
    }
    
    @Test
    @Transactional
    public void getSystemParameters() throws Exception {
        // Initialize the database
        systemParametersRepository.saveAndFlush(systemParameters);

        // Get the systemParameters
        restSystemParametersMockMvc.perform(get("/api/system-parameters/{id}", systemParameters.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(systemParameters.getId().intValue()))
            .andExpect(jsonPath("$.deliveryAddressLine1").value(DEFAULT_DELIVERY_ADDRESS_LINE_1.toString()))
            .andExpect(jsonPath("$.deliveryAddressLine2").value(DEFAULT_DELIVERY_ADDRESS_LINE_2.toString()))
            .andExpect(jsonPath("$.deliveryPostalCode").value(DEFAULT_DELIVERY_POSTAL_CODE.toString()))
            .andExpect(jsonPath("$.deliveryLocation").value(DEFAULT_DELIVERY_LOCATION.toString()))
            .andExpect(jsonPath("$.postalAddressLine1").value(DEFAULT_POSTAL_ADDRESS_LINE_1.toString()))
            .andExpect(jsonPath("$.postalAddressLine2").value(DEFAULT_POSTAL_ADDRESS_LINE_2.toString()))
            .andExpect(jsonPath("$.postalPostalCode").value(DEFAULT_POSTAL_POSTAL_CODE.toString()))
            .andExpect(jsonPath("$.applicationSettings").value(DEFAULT_APPLICATION_SETTINGS.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingSystemParameters() throws Exception {
        // Get the systemParameters
        restSystemParametersMockMvc.perform(get("/api/system-parameters/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSystemParameters() throws Exception {
        // Initialize the database
        systemParametersRepository.saveAndFlush(systemParameters);

        int databaseSizeBeforeUpdate = systemParametersRepository.findAll().size();

        // Update the systemParameters
        SystemParameters updatedSystemParameters = systemParametersRepository.findById(systemParameters.getId()).get();
        // Disconnect from session so that the updates on updatedSystemParameters are not directly saved in db
        em.detach(updatedSystemParameters);
        updatedSystemParameters
            .deliveryAddressLine1(UPDATED_DELIVERY_ADDRESS_LINE_1)
            .deliveryAddressLine2(UPDATED_DELIVERY_ADDRESS_LINE_2)
            .deliveryPostalCode(UPDATED_DELIVERY_POSTAL_CODE)
            .deliveryLocation(UPDATED_DELIVERY_LOCATION)
            .postalAddressLine1(UPDATED_POSTAL_ADDRESS_LINE_1)
            .postalAddressLine2(UPDATED_POSTAL_ADDRESS_LINE_2)
            .postalPostalCode(UPDATED_POSTAL_POSTAL_CODE)
            .applicationSettings(UPDATED_APPLICATION_SETTINGS);
        SystemParametersDTO systemParametersDTO = systemParametersMapper.toDto(updatedSystemParameters);

        restSystemParametersMockMvc.perform(put("/api/system-parameters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(systemParametersDTO)))
            .andExpect(status().isOk());

        // Validate the SystemParameters in the database
        List<SystemParameters> systemParametersList = systemParametersRepository.findAll();
        assertThat(systemParametersList).hasSize(databaseSizeBeforeUpdate);
        SystemParameters testSystemParameters = systemParametersList.get(systemParametersList.size() - 1);
        assertThat(testSystemParameters.getDeliveryAddressLine1()).isEqualTo(UPDATED_DELIVERY_ADDRESS_LINE_1);
        assertThat(testSystemParameters.getDeliveryAddressLine2()).isEqualTo(UPDATED_DELIVERY_ADDRESS_LINE_2);
        assertThat(testSystemParameters.getDeliveryPostalCode()).isEqualTo(UPDATED_DELIVERY_POSTAL_CODE);
        assertThat(testSystemParameters.getDeliveryLocation()).isEqualTo(UPDATED_DELIVERY_LOCATION);
        assertThat(testSystemParameters.getPostalAddressLine1()).isEqualTo(UPDATED_POSTAL_ADDRESS_LINE_1);
        assertThat(testSystemParameters.getPostalAddressLine2()).isEqualTo(UPDATED_POSTAL_ADDRESS_LINE_2);
        assertThat(testSystemParameters.getPostalPostalCode()).isEqualTo(UPDATED_POSTAL_POSTAL_CODE);
        assertThat(testSystemParameters.getApplicationSettings()).isEqualTo(UPDATED_APPLICATION_SETTINGS);
    }

    @Test
    @Transactional
    public void updateNonExistingSystemParameters() throws Exception {
        int databaseSizeBeforeUpdate = systemParametersRepository.findAll().size();

        // Create the SystemParameters
        SystemParametersDTO systemParametersDTO = systemParametersMapper.toDto(systemParameters);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSystemParametersMockMvc.perform(put("/api/system-parameters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(systemParametersDTO)))
            .andExpect(status().isBadRequest());

        // Validate the SystemParameters in the database
        List<SystemParameters> systemParametersList = systemParametersRepository.findAll();
        assertThat(systemParametersList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSystemParameters() throws Exception {
        // Initialize the database
        systemParametersRepository.saveAndFlush(systemParameters);

        int databaseSizeBeforeDelete = systemParametersRepository.findAll().size();

        // Delete the systemParameters
        restSystemParametersMockMvc.perform(delete("/api/system-parameters/{id}", systemParameters.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<SystemParameters> systemParametersList = systemParametersRepository.findAll();
        assertThat(systemParametersList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SystemParameters.class);
        SystemParameters systemParameters1 = new SystemParameters();
        systemParameters1.setId(1L);
        SystemParameters systemParameters2 = new SystemParameters();
        systemParameters2.setId(systemParameters1.getId());
        assertThat(systemParameters1).isEqualTo(systemParameters2);
        systemParameters2.setId(2L);
        assertThat(systemParameters1).isNotEqualTo(systemParameters2);
        systemParameters1.setId(null);
        assertThat(systemParameters1).isNotEqualTo(systemParameters2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SystemParametersDTO.class);
        SystemParametersDTO systemParametersDTO1 = new SystemParametersDTO();
        systemParametersDTO1.setId(1L);
        SystemParametersDTO systemParametersDTO2 = new SystemParametersDTO();
        assertThat(systemParametersDTO1).isNotEqualTo(systemParametersDTO2);
        systemParametersDTO2.setId(systemParametersDTO1.getId());
        assertThat(systemParametersDTO1).isEqualTo(systemParametersDTO2);
        systemParametersDTO2.setId(2L);
        assertThat(systemParametersDTO1).isNotEqualTo(systemParametersDTO2);
        systemParametersDTO1.setId(null);
        assertThat(systemParametersDTO1).isNotEqualTo(systemParametersDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(systemParametersMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(systemParametersMapper.fromId(null)).isNull();
    }
}
