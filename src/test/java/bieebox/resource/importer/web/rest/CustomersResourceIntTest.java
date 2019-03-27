package bieebox.resource.importer.web.rest;

import bieebox.resource.importer.ImporterApp;

import bieebox.resource.importer.domain.Customers;
import bieebox.resource.importer.repository.CustomersRepository;
import bieebox.resource.importer.service.CustomersService;
import bieebox.resource.importer.service.dto.CustomersDTO;
import bieebox.resource.importer.service.mapper.CustomersMapper;
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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;


import static bieebox.resource.importer.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the CustomersResource REST controller.
 *
 * @see CustomersResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ImporterApp.class)
public class CustomersResourceIntTest {

    private static final String DEFAULT_CUSTOMER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOMER_NAME = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_CREDIT_LIMIT = new BigDecimal(1);
    private static final BigDecimal UPDATED_CREDIT_LIMIT = new BigDecimal(2);

    private static final LocalDate DEFAULT_ACCOUNT_OPENED_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_ACCOUNT_OPENED_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final BigDecimal DEFAULT_STANDARD_DISCOUNT_PERCENTAGE = new BigDecimal(1);
    private static final BigDecimal UPDATED_STANDARD_DISCOUNT_PERCENTAGE = new BigDecimal(2);

    private static final Boolean DEFAULT_IS_STATEMENT_SENT = false;
    private static final Boolean UPDATED_IS_STATEMENT_SENT = true;

    private static final Boolean DEFAULT_IS_ON_CREDIT_HOLD = false;
    private static final Boolean UPDATED_IS_ON_CREDIT_HOLD = true;

    private static final Integer DEFAULT_PAYMENT_DAYS = 1;
    private static final Integer UPDATED_PAYMENT_DAYS = 2;

    private static final String DEFAULT_PHONE_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_PHONE_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_FAX_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_FAX_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_DELIVERY_RUN = "AAAAAAAAAA";
    private static final String UPDATED_DELIVERY_RUN = "BBBBBBBBBB";

    private static final String DEFAULT_RUN_POSITION = "AAAAAAAAAA";
    private static final String UPDATED_RUN_POSITION = "BBBBBBBBBB";

    private static final String DEFAULT_WEBSITE_URL = "AAAAAAAAAA";
    private static final String UPDATED_WEBSITE_URL = "BBBBBBBBBB";

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

    private static final LocalDate DEFAULT_VALID_FROM = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_VALID_FROM = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_VALID_TO = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_VALID_TO = LocalDate.now(ZoneId.systemDefault());

    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private CustomersMapper customersMapper;

    @Autowired
    private CustomersService customersService;

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

    private MockMvc restCustomersMockMvc;

    private Customers customers;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final CustomersResource customersResource = new CustomersResource(customersService);
        this.restCustomersMockMvc = MockMvcBuilders.standaloneSetup(customersResource)
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
    public static Customers createEntity(EntityManager em) {
        Customers customers = new Customers()
            .customerName(DEFAULT_CUSTOMER_NAME)
            .creditLimit(DEFAULT_CREDIT_LIMIT)
            .accountOpenedDate(DEFAULT_ACCOUNT_OPENED_DATE)
            .standardDiscountPercentage(DEFAULT_STANDARD_DISCOUNT_PERCENTAGE)
            .isStatementSent(DEFAULT_IS_STATEMENT_SENT)
            .isOnCreditHold(DEFAULT_IS_ON_CREDIT_HOLD)
            .paymentDays(DEFAULT_PAYMENT_DAYS)
            .phoneNumber(DEFAULT_PHONE_NUMBER)
            .faxNumber(DEFAULT_FAX_NUMBER)
            .deliveryRun(DEFAULT_DELIVERY_RUN)
            .runPosition(DEFAULT_RUN_POSITION)
            .websiteURL(DEFAULT_WEBSITE_URL)
            .deliveryAddressLine1(DEFAULT_DELIVERY_ADDRESS_LINE_1)
            .deliveryAddressLine2(DEFAULT_DELIVERY_ADDRESS_LINE_2)
            .deliveryPostalCode(DEFAULT_DELIVERY_POSTAL_CODE)
            .deliveryLocation(DEFAULT_DELIVERY_LOCATION)
            .postalAddressLine1(DEFAULT_POSTAL_ADDRESS_LINE_1)
            .postalAddressLine2(DEFAULT_POSTAL_ADDRESS_LINE_2)
            .postalPostalCode(DEFAULT_POSTAL_POSTAL_CODE)
            .validFrom(DEFAULT_VALID_FROM)
            .validTo(DEFAULT_VALID_TO);
        return customers;
    }

    @Before
    public void initTest() {
        customers = createEntity(em);
    }

    @Test
    @Transactional
    public void createCustomers() throws Exception {
        int databaseSizeBeforeCreate = customersRepository.findAll().size();

        // Create the Customers
        CustomersDTO customersDTO = customersMapper.toDto(customers);
        restCustomersMockMvc.perform(post("/api/customers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(customersDTO)))
            .andExpect(status().isCreated());

        // Validate the Customers in the database
        List<Customers> customersList = customersRepository.findAll();
        assertThat(customersList).hasSize(databaseSizeBeforeCreate + 1);
        Customers testCustomers = customersList.get(customersList.size() - 1);
        assertThat(testCustomers.getCustomerName()).isEqualTo(DEFAULT_CUSTOMER_NAME);
        assertThat(testCustomers.getCreditLimit()).isEqualTo(DEFAULT_CREDIT_LIMIT);
        assertThat(testCustomers.getAccountOpenedDate()).isEqualTo(DEFAULT_ACCOUNT_OPENED_DATE);
        assertThat(testCustomers.getStandardDiscountPercentage()).isEqualTo(DEFAULT_STANDARD_DISCOUNT_PERCENTAGE);
        assertThat(testCustomers.isIsStatementSent()).isEqualTo(DEFAULT_IS_STATEMENT_SENT);
        assertThat(testCustomers.isIsOnCreditHold()).isEqualTo(DEFAULT_IS_ON_CREDIT_HOLD);
        assertThat(testCustomers.getPaymentDays()).isEqualTo(DEFAULT_PAYMENT_DAYS);
        assertThat(testCustomers.getPhoneNumber()).isEqualTo(DEFAULT_PHONE_NUMBER);
        assertThat(testCustomers.getFaxNumber()).isEqualTo(DEFAULT_FAX_NUMBER);
        assertThat(testCustomers.getDeliveryRun()).isEqualTo(DEFAULT_DELIVERY_RUN);
        assertThat(testCustomers.getRunPosition()).isEqualTo(DEFAULT_RUN_POSITION);
        assertThat(testCustomers.getWebsiteURL()).isEqualTo(DEFAULT_WEBSITE_URL);
        assertThat(testCustomers.getDeliveryAddressLine1()).isEqualTo(DEFAULT_DELIVERY_ADDRESS_LINE_1);
        assertThat(testCustomers.getDeliveryAddressLine2()).isEqualTo(DEFAULT_DELIVERY_ADDRESS_LINE_2);
        assertThat(testCustomers.getDeliveryPostalCode()).isEqualTo(DEFAULT_DELIVERY_POSTAL_CODE);
        assertThat(testCustomers.getDeliveryLocation()).isEqualTo(DEFAULT_DELIVERY_LOCATION);
        assertThat(testCustomers.getPostalAddressLine1()).isEqualTo(DEFAULT_POSTAL_ADDRESS_LINE_1);
        assertThat(testCustomers.getPostalAddressLine2()).isEqualTo(DEFAULT_POSTAL_ADDRESS_LINE_2);
        assertThat(testCustomers.getPostalPostalCode()).isEqualTo(DEFAULT_POSTAL_POSTAL_CODE);
        assertThat(testCustomers.getValidFrom()).isEqualTo(DEFAULT_VALID_FROM);
        assertThat(testCustomers.getValidTo()).isEqualTo(DEFAULT_VALID_TO);
    }

    @Test
    @Transactional
    public void createCustomersWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = customersRepository.findAll().size();

        // Create the Customers with an existing ID
        customers.setId(1L);
        CustomersDTO customersDTO = customersMapper.toDto(customers);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCustomersMockMvc.perform(post("/api/customers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(customersDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Customers in the database
        List<Customers> customersList = customersRepository.findAll();
        assertThat(customersList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkCustomerNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = customersRepository.findAll().size();
        // set the field null
        customers.setCustomerName(null);

        // Create the Customers, which fails.
        CustomersDTO customersDTO = customersMapper.toDto(customers);

        restCustomersMockMvc.perform(post("/api/customers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(customersDTO)))
            .andExpect(status().isBadRequest());

        List<Customers> customersList = customersRepository.findAll();
        assertThat(customersList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkAccountOpenedDateIsRequired() throws Exception {
        int databaseSizeBeforeTest = customersRepository.findAll().size();
        // set the field null
        customers.setAccountOpenedDate(null);

        // Create the Customers, which fails.
        CustomersDTO customersDTO = customersMapper.toDto(customers);

        restCustomersMockMvc.perform(post("/api/customers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(customersDTO)))
            .andExpect(status().isBadRequest());

        List<Customers> customersList = customersRepository.findAll();
        assertThat(customersList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkStandardDiscountPercentageIsRequired() throws Exception {
        int databaseSizeBeforeTest = customersRepository.findAll().size();
        // set the field null
        customers.setStandardDiscountPercentage(null);

        // Create the Customers, which fails.
        CustomersDTO customersDTO = customersMapper.toDto(customers);

        restCustomersMockMvc.perform(post("/api/customers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(customersDTO)))
            .andExpect(status().isBadRequest());

        List<Customers> customersList = customersRepository.findAll();
        assertThat(customersList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkIsStatementSentIsRequired() throws Exception {
        int databaseSizeBeforeTest = customersRepository.findAll().size();
        // set the field null
        customers.setIsStatementSent(null);

        // Create the Customers, which fails.
        CustomersDTO customersDTO = customersMapper.toDto(customers);

        restCustomersMockMvc.perform(post("/api/customers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(customersDTO)))
            .andExpect(status().isBadRequest());

        List<Customers> customersList = customersRepository.findAll();
        assertThat(customersList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkIsOnCreditHoldIsRequired() throws Exception {
        int databaseSizeBeforeTest = customersRepository.findAll().size();
        // set the field null
        customers.setIsOnCreditHold(null);

        // Create the Customers, which fails.
        CustomersDTO customersDTO = customersMapper.toDto(customers);

        restCustomersMockMvc.perform(post("/api/customers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(customersDTO)))
            .andExpect(status().isBadRequest());

        List<Customers> customersList = customersRepository.findAll();
        assertThat(customersList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkPaymentDaysIsRequired() throws Exception {
        int databaseSizeBeforeTest = customersRepository.findAll().size();
        // set the field null
        customers.setPaymentDays(null);

        // Create the Customers, which fails.
        CustomersDTO customersDTO = customersMapper.toDto(customers);

        restCustomersMockMvc.perform(post("/api/customers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(customersDTO)))
            .andExpect(status().isBadRequest());

        List<Customers> customersList = customersRepository.findAll();
        assertThat(customersList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkPhoneNumberIsRequired() throws Exception {
        int databaseSizeBeforeTest = customersRepository.findAll().size();
        // set the field null
        customers.setPhoneNumber(null);

        // Create the Customers, which fails.
        CustomersDTO customersDTO = customersMapper.toDto(customers);

        restCustomersMockMvc.perform(post("/api/customers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(customersDTO)))
            .andExpect(status().isBadRequest());

        List<Customers> customersList = customersRepository.findAll();
        assertThat(customersList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkFaxNumberIsRequired() throws Exception {
        int databaseSizeBeforeTest = customersRepository.findAll().size();
        // set the field null
        customers.setFaxNumber(null);

        // Create the Customers, which fails.
        CustomersDTO customersDTO = customersMapper.toDto(customers);

        restCustomersMockMvc.perform(post("/api/customers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(customersDTO)))
            .andExpect(status().isBadRequest());

        List<Customers> customersList = customersRepository.findAll();
        assertThat(customersList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkWebsiteURLIsRequired() throws Exception {
        int databaseSizeBeforeTest = customersRepository.findAll().size();
        // set the field null
        customers.setWebsiteURL(null);

        // Create the Customers, which fails.
        CustomersDTO customersDTO = customersMapper.toDto(customers);

        restCustomersMockMvc.perform(post("/api/customers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(customersDTO)))
            .andExpect(status().isBadRequest());

        List<Customers> customersList = customersRepository.findAll();
        assertThat(customersList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDeliveryAddressLine1IsRequired() throws Exception {
        int databaseSizeBeforeTest = customersRepository.findAll().size();
        // set the field null
        customers.setDeliveryAddressLine1(null);

        // Create the Customers, which fails.
        CustomersDTO customersDTO = customersMapper.toDto(customers);

        restCustomersMockMvc.perform(post("/api/customers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(customersDTO)))
            .andExpect(status().isBadRequest());

        List<Customers> customersList = customersRepository.findAll();
        assertThat(customersList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDeliveryPostalCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = customersRepository.findAll().size();
        // set the field null
        customers.setDeliveryPostalCode(null);

        // Create the Customers, which fails.
        CustomersDTO customersDTO = customersMapper.toDto(customers);

        restCustomersMockMvc.perform(post("/api/customers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(customersDTO)))
            .andExpect(status().isBadRequest());

        List<Customers> customersList = customersRepository.findAll();
        assertThat(customersList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkPostalAddressLine1IsRequired() throws Exception {
        int databaseSizeBeforeTest = customersRepository.findAll().size();
        // set the field null
        customers.setPostalAddressLine1(null);

        // Create the Customers, which fails.
        CustomersDTO customersDTO = customersMapper.toDto(customers);

        restCustomersMockMvc.perform(post("/api/customers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(customersDTO)))
            .andExpect(status().isBadRequest());

        List<Customers> customersList = customersRepository.findAll();
        assertThat(customersList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkPostalPostalCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = customersRepository.findAll().size();
        // set the field null
        customers.setPostalPostalCode(null);

        // Create the Customers, which fails.
        CustomersDTO customersDTO = customersMapper.toDto(customers);

        restCustomersMockMvc.perform(post("/api/customers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(customersDTO)))
            .andExpect(status().isBadRequest());

        List<Customers> customersList = customersRepository.findAll();
        assertThat(customersList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkValidFromIsRequired() throws Exception {
        int databaseSizeBeforeTest = customersRepository.findAll().size();
        // set the field null
        customers.setValidFrom(null);

        // Create the Customers, which fails.
        CustomersDTO customersDTO = customersMapper.toDto(customers);

        restCustomersMockMvc.perform(post("/api/customers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(customersDTO)))
            .andExpect(status().isBadRequest());

        List<Customers> customersList = customersRepository.findAll();
        assertThat(customersList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkValidToIsRequired() throws Exception {
        int databaseSizeBeforeTest = customersRepository.findAll().size();
        // set the field null
        customers.setValidTo(null);

        // Create the Customers, which fails.
        CustomersDTO customersDTO = customersMapper.toDto(customers);

        restCustomersMockMvc.perform(post("/api/customers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(customersDTO)))
            .andExpect(status().isBadRequest());

        List<Customers> customersList = customersRepository.findAll();
        assertThat(customersList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllCustomers() throws Exception {
        // Initialize the database
        customersRepository.saveAndFlush(customers);

        // Get all the customersList
        restCustomersMockMvc.perform(get("/api/customers?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(customers.getId().intValue())))
            .andExpect(jsonPath("$.[*].customerName").value(hasItem(DEFAULT_CUSTOMER_NAME.toString())))
            .andExpect(jsonPath("$.[*].creditLimit").value(hasItem(DEFAULT_CREDIT_LIMIT.intValue())))
            .andExpect(jsonPath("$.[*].accountOpenedDate").value(hasItem(DEFAULT_ACCOUNT_OPENED_DATE.toString())))
            .andExpect(jsonPath("$.[*].standardDiscountPercentage").value(hasItem(DEFAULT_STANDARD_DISCOUNT_PERCENTAGE.intValue())))
            .andExpect(jsonPath("$.[*].isStatementSent").value(hasItem(DEFAULT_IS_STATEMENT_SENT.booleanValue())))
            .andExpect(jsonPath("$.[*].isOnCreditHold").value(hasItem(DEFAULT_IS_ON_CREDIT_HOLD.booleanValue())))
            .andExpect(jsonPath("$.[*].paymentDays").value(hasItem(DEFAULT_PAYMENT_DAYS)))
            .andExpect(jsonPath("$.[*].phoneNumber").value(hasItem(DEFAULT_PHONE_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].faxNumber").value(hasItem(DEFAULT_FAX_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].deliveryRun").value(hasItem(DEFAULT_DELIVERY_RUN.toString())))
            .andExpect(jsonPath("$.[*].runPosition").value(hasItem(DEFAULT_RUN_POSITION.toString())))
            .andExpect(jsonPath("$.[*].websiteURL").value(hasItem(DEFAULT_WEBSITE_URL.toString())))
            .andExpect(jsonPath("$.[*].deliveryAddressLine1").value(hasItem(DEFAULT_DELIVERY_ADDRESS_LINE_1.toString())))
            .andExpect(jsonPath("$.[*].deliveryAddressLine2").value(hasItem(DEFAULT_DELIVERY_ADDRESS_LINE_2.toString())))
            .andExpect(jsonPath("$.[*].deliveryPostalCode").value(hasItem(DEFAULT_DELIVERY_POSTAL_CODE.toString())))
            .andExpect(jsonPath("$.[*].deliveryLocation").value(hasItem(DEFAULT_DELIVERY_LOCATION.toString())))
            .andExpect(jsonPath("$.[*].postalAddressLine1").value(hasItem(DEFAULT_POSTAL_ADDRESS_LINE_1.toString())))
            .andExpect(jsonPath("$.[*].postalAddressLine2").value(hasItem(DEFAULT_POSTAL_ADDRESS_LINE_2.toString())))
            .andExpect(jsonPath("$.[*].postalPostalCode").value(hasItem(DEFAULT_POSTAL_POSTAL_CODE.toString())))
            .andExpect(jsonPath("$.[*].validFrom").value(hasItem(DEFAULT_VALID_FROM.toString())))
            .andExpect(jsonPath("$.[*].validTo").value(hasItem(DEFAULT_VALID_TO.toString())));
    }
    
    @Test
    @Transactional
    public void getCustomers() throws Exception {
        // Initialize the database
        customersRepository.saveAndFlush(customers);

        // Get the customers
        restCustomersMockMvc.perform(get("/api/customers/{id}", customers.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(customers.getId().intValue()))
            .andExpect(jsonPath("$.customerName").value(DEFAULT_CUSTOMER_NAME.toString()))
            .andExpect(jsonPath("$.creditLimit").value(DEFAULT_CREDIT_LIMIT.intValue()))
            .andExpect(jsonPath("$.accountOpenedDate").value(DEFAULT_ACCOUNT_OPENED_DATE.toString()))
            .andExpect(jsonPath("$.standardDiscountPercentage").value(DEFAULT_STANDARD_DISCOUNT_PERCENTAGE.intValue()))
            .andExpect(jsonPath("$.isStatementSent").value(DEFAULT_IS_STATEMENT_SENT.booleanValue()))
            .andExpect(jsonPath("$.isOnCreditHold").value(DEFAULT_IS_ON_CREDIT_HOLD.booleanValue()))
            .andExpect(jsonPath("$.paymentDays").value(DEFAULT_PAYMENT_DAYS))
            .andExpect(jsonPath("$.phoneNumber").value(DEFAULT_PHONE_NUMBER.toString()))
            .andExpect(jsonPath("$.faxNumber").value(DEFAULT_FAX_NUMBER.toString()))
            .andExpect(jsonPath("$.deliveryRun").value(DEFAULT_DELIVERY_RUN.toString()))
            .andExpect(jsonPath("$.runPosition").value(DEFAULT_RUN_POSITION.toString()))
            .andExpect(jsonPath("$.websiteURL").value(DEFAULT_WEBSITE_URL.toString()))
            .andExpect(jsonPath("$.deliveryAddressLine1").value(DEFAULT_DELIVERY_ADDRESS_LINE_1.toString()))
            .andExpect(jsonPath("$.deliveryAddressLine2").value(DEFAULT_DELIVERY_ADDRESS_LINE_2.toString()))
            .andExpect(jsonPath("$.deliveryPostalCode").value(DEFAULT_DELIVERY_POSTAL_CODE.toString()))
            .andExpect(jsonPath("$.deliveryLocation").value(DEFAULT_DELIVERY_LOCATION.toString()))
            .andExpect(jsonPath("$.postalAddressLine1").value(DEFAULT_POSTAL_ADDRESS_LINE_1.toString()))
            .andExpect(jsonPath("$.postalAddressLine2").value(DEFAULT_POSTAL_ADDRESS_LINE_2.toString()))
            .andExpect(jsonPath("$.postalPostalCode").value(DEFAULT_POSTAL_POSTAL_CODE.toString()))
            .andExpect(jsonPath("$.validFrom").value(DEFAULT_VALID_FROM.toString()))
            .andExpect(jsonPath("$.validTo").value(DEFAULT_VALID_TO.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingCustomers() throws Exception {
        // Get the customers
        restCustomersMockMvc.perform(get("/api/customers/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCustomers() throws Exception {
        // Initialize the database
        customersRepository.saveAndFlush(customers);

        int databaseSizeBeforeUpdate = customersRepository.findAll().size();

        // Update the customers
        Customers updatedCustomers = customersRepository.findById(customers.getId()).get();
        // Disconnect from session so that the updates on updatedCustomers are not directly saved in db
        em.detach(updatedCustomers);
        updatedCustomers
            .customerName(UPDATED_CUSTOMER_NAME)
            .creditLimit(UPDATED_CREDIT_LIMIT)
            .accountOpenedDate(UPDATED_ACCOUNT_OPENED_DATE)
            .standardDiscountPercentage(UPDATED_STANDARD_DISCOUNT_PERCENTAGE)
            .isStatementSent(UPDATED_IS_STATEMENT_SENT)
            .isOnCreditHold(UPDATED_IS_ON_CREDIT_HOLD)
            .paymentDays(UPDATED_PAYMENT_DAYS)
            .phoneNumber(UPDATED_PHONE_NUMBER)
            .faxNumber(UPDATED_FAX_NUMBER)
            .deliveryRun(UPDATED_DELIVERY_RUN)
            .runPosition(UPDATED_RUN_POSITION)
            .websiteURL(UPDATED_WEBSITE_URL)
            .deliveryAddressLine1(UPDATED_DELIVERY_ADDRESS_LINE_1)
            .deliveryAddressLine2(UPDATED_DELIVERY_ADDRESS_LINE_2)
            .deliveryPostalCode(UPDATED_DELIVERY_POSTAL_CODE)
            .deliveryLocation(UPDATED_DELIVERY_LOCATION)
            .postalAddressLine1(UPDATED_POSTAL_ADDRESS_LINE_1)
            .postalAddressLine2(UPDATED_POSTAL_ADDRESS_LINE_2)
            .postalPostalCode(UPDATED_POSTAL_POSTAL_CODE)
            .validFrom(UPDATED_VALID_FROM)
            .validTo(UPDATED_VALID_TO);
        CustomersDTO customersDTO = customersMapper.toDto(updatedCustomers);

        restCustomersMockMvc.perform(put("/api/customers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(customersDTO)))
            .andExpect(status().isOk());

        // Validate the Customers in the database
        List<Customers> customersList = customersRepository.findAll();
        assertThat(customersList).hasSize(databaseSizeBeforeUpdate);
        Customers testCustomers = customersList.get(customersList.size() - 1);
        assertThat(testCustomers.getCustomerName()).isEqualTo(UPDATED_CUSTOMER_NAME);
        assertThat(testCustomers.getCreditLimit()).isEqualTo(UPDATED_CREDIT_LIMIT);
        assertThat(testCustomers.getAccountOpenedDate()).isEqualTo(UPDATED_ACCOUNT_OPENED_DATE);
        assertThat(testCustomers.getStandardDiscountPercentage()).isEqualTo(UPDATED_STANDARD_DISCOUNT_PERCENTAGE);
        assertThat(testCustomers.isIsStatementSent()).isEqualTo(UPDATED_IS_STATEMENT_SENT);
        assertThat(testCustomers.isIsOnCreditHold()).isEqualTo(UPDATED_IS_ON_CREDIT_HOLD);
        assertThat(testCustomers.getPaymentDays()).isEqualTo(UPDATED_PAYMENT_DAYS);
        assertThat(testCustomers.getPhoneNumber()).isEqualTo(UPDATED_PHONE_NUMBER);
        assertThat(testCustomers.getFaxNumber()).isEqualTo(UPDATED_FAX_NUMBER);
        assertThat(testCustomers.getDeliveryRun()).isEqualTo(UPDATED_DELIVERY_RUN);
        assertThat(testCustomers.getRunPosition()).isEqualTo(UPDATED_RUN_POSITION);
        assertThat(testCustomers.getWebsiteURL()).isEqualTo(UPDATED_WEBSITE_URL);
        assertThat(testCustomers.getDeliveryAddressLine1()).isEqualTo(UPDATED_DELIVERY_ADDRESS_LINE_1);
        assertThat(testCustomers.getDeliveryAddressLine2()).isEqualTo(UPDATED_DELIVERY_ADDRESS_LINE_2);
        assertThat(testCustomers.getDeliveryPostalCode()).isEqualTo(UPDATED_DELIVERY_POSTAL_CODE);
        assertThat(testCustomers.getDeliveryLocation()).isEqualTo(UPDATED_DELIVERY_LOCATION);
        assertThat(testCustomers.getPostalAddressLine1()).isEqualTo(UPDATED_POSTAL_ADDRESS_LINE_1);
        assertThat(testCustomers.getPostalAddressLine2()).isEqualTo(UPDATED_POSTAL_ADDRESS_LINE_2);
        assertThat(testCustomers.getPostalPostalCode()).isEqualTo(UPDATED_POSTAL_POSTAL_CODE);
        assertThat(testCustomers.getValidFrom()).isEqualTo(UPDATED_VALID_FROM);
        assertThat(testCustomers.getValidTo()).isEqualTo(UPDATED_VALID_TO);
    }

    @Test
    @Transactional
    public void updateNonExistingCustomers() throws Exception {
        int databaseSizeBeforeUpdate = customersRepository.findAll().size();

        // Create the Customers
        CustomersDTO customersDTO = customersMapper.toDto(customers);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCustomersMockMvc.perform(put("/api/customers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(customersDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Customers in the database
        List<Customers> customersList = customersRepository.findAll();
        assertThat(customersList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteCustomers() throws Exception {
        // Initialize the database
        customersRepository.saveAndFlush(customers);

        int databaseSizeBeforeDelete = customersRepository.findAll().size();

        // Delete the customers
        restCustomersMockMvc.perform(delete("/api/customers/{id}", customers.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Customers> customersList = customersRepository.findAll();
        assertThat(customersList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Customers.class);
        Customers customers1 = new Customers();
        customers1.setId(1L);
        Customers customers2 = new Customers();
        customers2.setId(customers1.getId());
        assertThat(customers1).isEqualTo(customers2);
        customers2.setId(2L);
        assertThat(customers1).isNotEqualTo(customers2);
        customers1.setId(null);
        assertThat(customers1).isNotEqualTo(customers2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CustomersDTO.class);
        CustomersDTO customersDTO1 = new CustomersDTO();
        customersDTO1.setId(1L);
        CustomersDTO customersDTO2 = new CustomersDTO();
        assertThat(customersDTO1).isNotEqualTo(customersDTO2);
        customersDTO2.setId(customersDTO1.getId());
        assertThat(customersDTO1).isEqualTo(customersDTO2);
        customersDTO2.setId(2L);
        assertThat(customersDTO1).isNotEqualTo(customersDTO2);
        customersDTO1.setId(null);
        assertThat(customersDTO1).isNotEqualTo(customersDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(customersMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(customersMapper.fromId(null)).isNull();
    }
}
