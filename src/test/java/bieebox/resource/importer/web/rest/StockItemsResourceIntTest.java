package bieebox.resource.importer.web.rest;

import bieebox.resource.importer.ImporterApp;

import bieebox.resource.importer.domain.StockItems;
import bieebox.resource.importer.repository.StockItemsRepository;
import bieebox.resource.importer.service.StockItemsService;
import bieebox.resource.importer.service.dto.StockItemsDTO;
import bieebox.resource.importer.service.mapper.StockItemsMapper;
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
 * Test class for the StockItemsResource REST controller.
 *
 * @see StockItemsResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ImporterApp.class)
public class StockItemsResourceIntTest {

    private static final String DEFAULT_STOCK_ITEM_NAME = "AAAAAAAAAA";
    private static final String UPDATED_STOCK_ITEM_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_BRAND = "AAAAAAAAAA";
    private static final String UPDATED_BRAND = "BBBBBBBBBB";

    private static final String DEFAULT_SIZE = "AAAAAAAAAA";
    private static final String UPDATED_SIZE = "BBBBBBBBBB";

    private static final Integer DEFAULT_LEAD_TIME_DAYS = 1;
    private static final Integer UPDATED_LEAD_TIME_DAYS = 2;

    private static final Integer DEFAULT_QUANTITY_PER_OUTER = 1;
    private static final Integer UPDATED_QUANTITY_PER_OUTER = 2;

    private static final Boolean DEFAULT_IS_CHILLER_STOCK = false;
    private static final Boolean UPDATED_IS_CHILLER_STOCK = true;

    private static final String DEFAULT_BARCODE = "AAAAAAAAAA";
    private static final String UPDATED_BARCODE = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_TAX_RATE = new BigDecimal(1);
    private static final BigDecimal UPDATED_TAX_RATE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_UNIT_PRICE = new BigDecimal(1);
    private static final BigDecimal UPDATED_UNIT_PRICE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_RECOMMENDED_RETAIL_PRICE = new BigDecimal(1);
    private static final BigDecimal UPDATED_RECOMMENDED_RETAIL_PRICE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_TYPICAL_WEIGHT_PER_UNIT = new BigDecimal(1);
    private static final BigDecimal UPDATED_TYPICAL_WEIGHT_PER_UNIT = new BigDecimal(2);

    private static final String DEFAULT_MARKETING_COMMENTS = "AAAAAAAAAA";
    private static final String UPDATED_MARKETING_COMMENTS = "BBBBBBBBBB";

    private static final String DEFAULT_INTERNAL_COMMENTS = "AAAAAAAAAA";
    private static final String UPDATED_INTERNAL_COMMENTS = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO = "BBBBBBBBBB";

    private static final String DEFAULT_CUSTOM_FIELDS = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOM_FIELDS = "BBBBBBBBBB";

    private static final String DEFAULT_TAGS = "AAAAAAAAAA";
    private static final String UPDATED_TAGS = "BBBBBBBBBB";

    private static final String DEFAULT_SEARCH_DETAILS = "AAAAAAAAAA";
    private static final String UPDATED_SEARCH_DETAILS = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_VALID_FROM = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_VALID_FROM = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_VALID_TO = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_VALID_TO = LocalDate.now(ZoneId.systemDefault());

    @Autowired
    private StockItemsRepository stockItemsRepository;

    @Autowired
    private StockItemsMapper stockItemsMapper;

    @Autowired
    private StockItemsService stockItemsService;

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

    private MockMvc restStockItemsMockMvc;

    private StockItems stockItems;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final StockItemsResource stockItemsResource = new StockItemsResource(stockItemsService);
        this.restStockItemsMockMvc = MockMvcBuilders.standaloneSetup(stockItemsResource)
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
    public static StockItems createEntity(EntityManager em) {
        StockItems stockItems = new StockItems()
            .stockItemName(DEFAULT_STOCK_ITEM_NAME)
            .brand(DEFAULT_BRAND)
            .size(DEFAULT_SIZE)
            .leadTimeDays(DEFAULT_LEAD_TIME_DAYS)
            .quantityPerOuter(DEFAULT_QUANTITY_PER_OUTER)
            .isChillerStock(DEFAULT_IS_CHILLER_STOCK)
            .barcode(DEFAULT_BARCODE)
            .taxRate(DEFAULT_TAX_RATE)
            .unitPrice(DEFAULT_UNIT_PRICE)
            .recommendedRetailPrice(DEFAULT_RECOMMENDED_RETAIL_PRICE)
            .typicalWeightPerUnit(DEFAULT_TYPICAL_WEIGHT_PER_UNIT)
            .marketingComments(DEFAULT_MARKETING_COMMENTS)
            .internalComments(DEFAULT_INTERNAL_COMMENTS)
            .photo(DEFAULT_PHOTO)
            .customFields(DEFAULT_CUSTOM_FIELDS)
            .tags(DEFAULT_TAGS)
            .searchDetails(DEFAULT_SEARCH_DETAILS)
            .validFrom(DEFAULT_VALID_FROM)
            .validTo(DEFAULT_VALID_TO);
        return stockItems;
    }

    @Before
    public void initTest() {
        stockItems = createEntity(em);
    }

    @Test
    @Transactional
    public void createStockItems() throws Exception {
        int databaseSizeBeforeCreate = stockItemsRepository.findAll().size();

        // Create the StockItems
        StockItemsDTO stockItemsDTO = stockItemsMapper.toDto(stockItems);
        restStockItemsMockMvc.perform(post("/api/stock-items")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(stockItemsDTO)))
            .andExpect(status().isCreated());

        // Validate the StockItems in the database
        List<StockItems> stockItemsList = stockItemsRepository.findAll();
        assertThat(stockItemsList).hasSize(databaseSizeBeforeCreate + 1);
        StockItems testStockItems = stockItemsList.get(stockItemsList.size() - 1);
        assertThat(testStockItems.getStockItemName()).isEqualTo(DEFAULT_STOCK_ITEM_NAME);
        assertThat(testStockItems.getBrand()).isEqualTo(DEFAULT_BRAND);
        assertThat(testStockItems.getSize()).isEqualTo(DEFAULT_SIZE);
        assertThat(testStockItems.getLeadTimeDays()).isEqualTo(DEFAULT_LEAD_TIME_DAYS);
        assertThat(testStockItems.getQuantityPerOuter()).isEqualTo(DEFAULT_QUANTITY_PER_OUTER);
        assertThat(testStockItems.isIsChillerStock()).isEqualTo(DEFAULT_IS_CHILLER_STOCK);
        assertThat(testStockItems.getBarcode()).isEqualTo(DEFAULT_BARCODE);
        assertThat(testStockItems.getTaxRate()).isEqualTo(DEFAULT_TAX_RATE);
        assertThat(testStockItems.getUnitPrice()).isEqualTo(DEFAULT_UNIT_PRICE);
        assertThat(testStockItems.getRecommendedRetailPrice()).isEqualTo(DEFAULT_RECOMMENDED_RETAIL_PRICE);
        assertThat(testStockItems.getTypicalWeightPerUnit()).isEqualTo(DEFAULT_TYPICAL_WEIGHT_PER_UNIT);
        assertThat(testStockItems.getMarketingComments()).isEqualTo(DEFAULT_MARKETING_COMMENTS);
        assertThat(testStockItems.getInternalComments()).isEqualTo(DEFAULT_INTERNAL_COMMENTS);
        assertThat(testStockItems.getPhoto()).isEqualTo(DEFAULT_PHOTO);
        assertThat(testStockItems.getCustomFields()).isEqualTo(DEFAULT_CUSTOM_FIELDS);
        assertThat(testStockItems.getTags()).isEqualTo(DEFAULT_TAGS);
        assertThat(testStockItems.getSearchDetails()).isEqualTo(DEFAULT_SEARCH_DETAILS);
        assertThat(testStockItems.getValidFrom()).isEqualTo(DEFAULT_VALID_FROM);
        assertThat(testStockItems.getValidTo()).isEqualTo(DEFAULT_VALID_TO);
    }

    @Test
    @Transactional
    public void createStockItemsWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = stockItemsRepository.findAll().size();

        // Create the StockItems with an existing ID
        stockItems.setId(1L);
        StockItemsDTO stockItemsDTO = stockItemsMapper.toDto(stockItems);

        // An entity with an existing ID cannot be created, so this API call must fail
        restStockItemsMockMvc.perform(post("/api/stock-items")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(stockItemsDTO)))
            .andExpect(status().isBadRequest());

        // Validate the StockItems in the database
        List<StockItems> stockItemsList = stockItemsRepository.findAll();
        assertThat(stockItemsList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkLeadTimeDaysIsRequired() throws Exception {
        int databaseSizeBeforeTest = stockItemsRepository.findAll().size();
        // set the field null
        stockItems.setLeadTimeDays(null);

        // Create the StockItems, which fails.
        StockItemsDTO stockItemsDTO = stockItemsMapper.toDto(stockItems);

        restStockItemsMockMvc.perform(post("/api/stock-items")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(stockItemsDTO)))
            .andExpect(status().isBadRequest());

        List<StockItems> stockItemsList = stockItemsRepository.findAll();
        assertThat(stockItemsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkQuantityPerOuterIsRequired() throws Exception {
        int databaseSizeBeforeTest = stockItemsRepository.findAll().size();
        // set the field null
        stockItems.setQuantityPerOuter(null);

        // Create the StockItems, which fails.
        StockItemsDTO stockItemsDTO = stockItemsMapper.toDto(stockItems);

        restStockItemsMockMvc.perform(post("/api/stock-items")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(stockItemsDTO)))
            .andExpect(status().isBadRequest());

        List<StockItems> stockItemsList = stockItemsRepository.findAll();
        assertThat(stockItemsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkIsChillerStockIsRequired() throws Exception {
        int databaseSizeBeforeTest = stockItemsRepository.findAll().size();
        // set the field null
        stockItems.setIsChillerStock(null);

        // Create the StockItems, which fails.
        StockItemsDTO stockItemsDTO = stockItemsMapper.toDto(stockItems);

        restStockItemsMockMvc.perform(post("/api/stock-items")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(stockItemsDTO)))
            .andExpect(status().isBadRequest());

        List<StockItems> stockItemsList = stockItemsRepository.findAll();
        assertThat(stockItemsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkTaxRateIsRequired() throws Exception {
        int databaseSizeBeforeTest = stockItemsRepository.findAll().size();
        // set the field null
        stockItems.setTaxRate(null);

        // Create the StockItems, which fails.
        StockItemsDTO stockItemsDTO = stockItemsMapper.toDto(stockItems);

        restStockItemsMockMvc.perform(post("/api/stock-items")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(stockItemsDTO)))
            .andExpect(status().isBadRequest());

        List<StockItems> stockItemsList = stockItemsRepository.findAll();
        assertThat(stockItemsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkUnitPriceIsRequired() throws Exception {
        int databaseSizeBeforeTest = stockItemsRepository.findAll().size();
        // set the field null
        stockItems.setUnitPrice(null);

        // Create the StockItems, which fails.
        StockItemsDTO stockItemsDTO = stockItemsMapper.toDto(stockItems);

        restStockItemsMockMvc.perform(post("/api/stock-items")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(stockItemsDTO)))
            .andExpect(status().isBadRequest());

        List<StockItems> stockItemsList = stockItemsRepository.findAll();
        assertThat(stockItemsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkTypicalWeightPerUnitIsRequired() throws Exception {
        int databaseSizeBeforeTest = stockItemsRepository.findAll().size();
        // set the field null
        stockItems.setTypicalWeightPerUnit(null);

        // Create the StockItems, which fails.
        StockItemsDTO stockItemsDTO = stockItemsMapper.toDto(stockItems);

        restStockItemsMockMvc.perform(post("/api/stock-items")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(stockItemsDTO)))
            .andExpect(status().isBadRequest());

        List<StockItems> stockItemsList = stockItemsRepository.findAll();
        assertThat(stockItemsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkSearchDetailsIsRequired() throws Exception {
        int databaseSizeBeforeTest = stockItemsRepository.findAll().size();
        // set the field null
        stockItems.setSearchDetails(null);

        // Create the StockItems, which fails.
        StockItemsDTO stockItemsDTO = stockItemsMapper.toDto(stockItems);

        restStockItemsMockMvc.perform(post("/api/stock-items")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(stockItemsDTO)))
            .andExpect(status().isBadRequest());

        List<StockItems> stockItemsList = stockItemsRepository.findAll();
        assertThat(stockItemsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkValidFromIsRequired() throws Exception {
        int databaseSizeBeforeTest = stockItemsRepository.findAll().size();
        // set the field null
        stockItems.setValidFrom(null);

        // Create the StockItems, which fails.
        StockItemsDTO stockItemsDTO = stockItemsMapper.toDto(stockItems);

        restStockItemsMockMvc.perform(post("/api/stock-items")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(stockItemsDTO)))
            .andExpect(status().isBadRequest());

        List<StockItems> stockItemsList = stockItemsRepository.findAll();
        assertThat(stockItemsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkValidToIsRequired() throws Exception {
        int databaseSizeBeforeTest = stockItemsRepository.findAll().size();
        // set the field null
        stockItems.setValidTo(null);

        // Create the StockItems, which fails.
        StockItemsDTO stockItemsDTO = stockItemsMapper.toDto(stockItems);

        restStockItemsMockMvc.perform(post("/api/stock-items")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(stockItemsDTO)))
            .andExpect(status().isBadRequest());

        List<StockItems> stockItemsList = stockItemsRepository.findAll();
        assertThat(stockItemsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllStockItems() throws Exception {
        // Initialize the database
        stockItemsRepository.saveAndFlush(stockItems);

        // Get all the stockItemsList
        restStockItemsMockMvc.perform(get("/api/stock-items?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(stockItems.getId().intValue())))
            .andExpect(jsonPath("$.[*].stockItemName").value(hasItem(DEFAULT_STOCK_ITEM_NAME.toString())))
            .andExpect(jsonPath("$.[*].brand").value(hasItem(DEFAULT_BRAND.toString())))
            .andExpect(jsonPath("$.[*].size").value(hasItem(DEFAULT_SIZE.toString())))
            .andExpect(jsonPath("$.[*].leadTimeDays").value(hasItem(DEFAULT_LEAD_TIME_DAYS)))
            .andExpect(jsonPath("$.[*].quantityPerOuter").value(hasItem(DEFAULT_QUANTITY_PER_OUTER)))
            .andExpect(jsonPath("$.[*].isChillerStock").value(hasItem(DEFAULT_IS_CHILLER_STOCK.booleanValue())))
            .andExpect(jsonPath("$.[*].barcode").value(hasItem(DEFAULT_BARCODE.toString())))
            .andExpect(jsonPath("$.[*].taxRate").value(hasItem(DEFAULT_TAX_RATE.intValue())))
            .andExpect(jsonPath("$.[*].unitPrice").value(hasItem(DEFAULT_UNIT_PRICE.intValue())))
            .andExpect(jsonPath("$.[*].recommendedRetailPrice").value(hasItem(DEFAULT_RECOMMENDED_RETAIL_PRICE.intValue())))
            .andExpect(jsonPath("$.[*].typicalWeightPerUnit").value(hasItem(DEFAULT_TYPICAL_WEIGHT_PER_UNIT.intValue())))
            .andExpect(jsonPath("$.[*].marketingComments").value(hasItem(DEFAULT_MARKETING_COMMENTS.toString())))
            .andExpect(jsonPath("$.[*].internalComments").value(hasItem(DEFAULT_INTERNAL_COMMENTS.toString())))
            .andExpect(jsonPath("$.[*].photo").value(hasItem(DEFAULT_PHOTO.toString())))
            .andExpect(jsonPath("$.[*].customFields").value(hasItem(DEFAULT_CUSTOM_FIELDS.toString())))
            .andExpect(jsonPath("$.[*].tags").value(hasItem(DEFAULT_TAGS.toString())))
            .andExpect(jsonPath("$.[*].searchDetails").value(hasItem(DEFAULT_SEARCH_DETAILS.toString())))
            .andExpect(jsonPath("$.[*].validFrom").value(hasItem(DEFAULT_VALID_FROM.toString())))
            .andExpect(jsonPath("$.[*].validTo").value(hasItem(DEFAULT_VALID_TO.toString())));
    }
    
    @Test
    @Transactional
    public void getStockItems() throws Exception {
        // Initialize the database
        stockItemsRepository.saveAndFlush(stockItems);

        // Get the stockItems
        restStockItemsMockMvc.perform(get("/api/stock-items/{id}", stockItems.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(stockItems.getId().intValue()))
            .andExpect(jsonPath("$.stockItemName").value(DEFAULT_STOCK_ITEM_NAME.toString()))
            .andExpect(jsonPath("$.brand").value(DEFAULT_BRAND.toString()))
            .andExpect(jsonPath("$.size").value(DEFAULT_SIZE.toString()))
            .andExpect(jsonPath("$.leadTimeDays").value(DEFAULT_LEAD_TIME_DAYS))
            .andExpect(jsonPath("$.quantityPerOuter").value(DEFAULT_QUANTITY_PER_OUTER))
            .andExpect(jsonPath("$.isChillerStock").value(DEFAULT_IS_CHILLER_STOCK.booleanValue()))
            .andExpect(jsonPath("$.barcode").value(DEFAULT_BARCODE.toString()))
            .andExpect(jsonPath("$.taxRate").value(DEFAULT_TAX_RATE.intValue()))
            .andExpect(jsonPath("$.unitPrice").value(DEFAULT_UNIT_PRICE.intValue()))
            .andExpect(jsonPath("$.recommendedRetailPrice").value(DEFAULT_RECOMMENDED_RETAIL_PRICE.intValue()))
            .andExpect(jsonPath("$.typicalWeightPerUnit").value(DEFAULT_TYPICAL_WEIGHT_PER_UNIT.intValue()))
            .andExpect(jsonPath("$.marketingComments").value(DEFAULT_MARKETING_COMMENTS.toString()))
            .andExpect(jsonPath("$.internalComments").value(DEFAULT_INTERNAL_COMMENTS.toString()))
            .andExpect(jsonPath("$.photo").value(DEFAULT_PHOTO.toString()))
            .andExpect(jsonPath("$.customFields").value(DEFAULT_CUSTOM_FIELDS.toString()))
            .andExpect(jsonPath("$.tags").value(DEFAULT_TAGS.toString()))
            .andExpect(jsonPath("$.searchDetails").value(DEFAULT_SEARCH_DETAILS.toString()))
            .andExpect(jsonPath("$.validFrom").value(DEFAULT_VALID_FROM.toString()))
            .andExpect(jsonPath("$.validTo").value(DEFAULT_VALID_TO.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingStockItems() throws Exception {
        // Get the stockItems
        restStockItemsMockMvc.perform(get("/api/stock-items/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateStockItems() throws Exception {
        // Initialize the database
        stockItemsRepository.saveAndFlush(stockItems);

        int databaseSizeBeforeUpdate = stockItemsRepository.findAll().size();

        // Update the stockItems
        StockItems updatedStockItems = stockItemsRepository.findById(stockItems.getId()).get();
        // Disconnect from session so that the updates on updatedStockItems are not directly saved in db
        em.detach(updatedStockItems);
        updatedStockItems
            .stockItemName(UPDATED_STOCK_ITEM_NAME)
            .brand(UPDATED_BRAND)
            .size(UPDATED_SIZE)
            .leadTimeDays(UPDATED_LEAD_TIME_DAYS)
            .quantityPerOuter(UPDATED_QUANTITY_PER_OUTER)
            .isChillerStock(UPDATED_IS_CHILLER_STOCK)
            .barcode(UPDATED_BARCODE)
            .taxRate(UPDATED_TAX_RATE)
            .unitPrice(UPDATED_UNIT_PRICE)
            .recommendedRetailPrice(UPDATED_RECOMMENDED_RETAIL_PRICE)
            .typicalWeightPerUnit(UPDATED_TYPICAL_WEIGHT_PER_UNIT)
            .marketingComments(UPDATED_MARKETING_COMMENTS)
            .internalComments(UPDATED_INTERNAL_COMMENTS)
            .photo(UPDATED_PHOTO)
            .customFields(UPDATED_CUSTOM_FIELDS)
            .tags(UPDATED_TAGS)
            .searchDetails(UPDATED_SEARCH_DETAILS)
            .validFrom(UPDATED_VALID_FROM)
            .validTo(UPDATED_VALID_TO);
        StockItemsDTO stockItemsDTO = stockItemsMapper.toDto(updatedStockItems);

        restStockItemsMockMvc.perform(put("/api/stock-items")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(stockItemsDTO)))
            .andExpect(status().isOk());

        // Validate the StockItems in the database
        List<StockItems> stockItemsList = stockItemsRepository.findAll();
        assertThat(stockItemsList).hasSize(databaseSizeBeforeUpdate);
        StockItems testStockItems = stockItemsList.get(stockItemsList.size() - 1);
        assertThat(testStockItems.getStockItemName()).isEqualTo(UPDATED_STOCK_ITEM_NAME);
        assertThat(testStockItems.getBrand()).isEqualTo(UPDATED_BRAND);
        assertThat(testStockItems.getSize()).isEqualTo(UPDATED_SIZE);
        assertThat(testStockItems.getLeadTimeDays()).isEqualTo(UPDATED_LEAD_TIME_DAYS);
        assertThat(testStockItems.getQuantityPerOuter()).isEqualTo(UPDATED_QUANTITY_PER_OUTER);
        assertThat(testStockItems.isIsChillerStock()).isEqualTo(UPDATED_IS_CHILLER_STOCK);
        assertThat(testStockItems.getBarcode()).isEqualTo(UPDATED_BARCODE);
        assertThat(testStockItems.getTaxRate()).isEqualTo(UPDATED_TAX_RATE);
        assertThat(testStockItems.getUnitPrice()).isEqualTo(UPDATED_UNIT_PRICE);
        assertThat(testStockItems.getRecommendedRetailPrice()).isEqualTo(UPDATED_RECOMMENDED_RETAIL_PRICE);
        assertThat(testStockItems.getTypicalWeightPerUnit()).isEqualTo(UPDATED_TYPICAL_WEIGHT_PER_UNIT);
        assertThat(testStockItems.getMarketingComments()).isEqualTo(UPDATED_MARKETING_COMMENTS);
        assertThat(testStockItems.getInternalComments()).isEqualTo(UPDATED_INTERNAL_COMMENTS);
        assertThat(testStockItems.getPhoto()).isEqualTo(UPDATED_PHOTO);
        assertThat(testStockItems.getCustomFields()).isEqualTo(UPDATED_CUSTOM_FIELDS);
        assertThat(testStockItems.getTags()).isEqualTo(UPDATED_TAGS);
        assertThat(testStockItems.getSearchDetails()).isEqualTo(UPDATED_SEARCH_DETAILS);
        assertThat(testStockItems.getValidFrom()).isEqualTo(UPDATED_VALID_FROM);
        assertThat(testStockItems.getValidTo()).isEqualTo(UPDATED_VALID_TO);
    }

    @Test
    @Transactional
    public void updateNonExistingStockItems() throws Exception {
        int databaseSizeBeforeUpdate = stockItemsRepository.findAll().size();

        // Create the StockItems
        StockItemsDTO stockItemsDTO = stockItemsMapper.toDto(stockItems);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restStockItemsMockMvc.perform(put("/api/stock-items")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(stockItemsDTO)))
            .andExpect(status().isBadRequest());

        // Validate the StockItems in the database
        List<StockItems> stockItemsList = stockItemsRepository.findAll();
        assertThat(stockItemsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteStockItems() throws Exception {
        // Initialize the database
        stockItemsRepository.saveAndFlush(stockItems);

        int databaseSizeBeforeDelete = stockItemsRepository.findAll().size();

        // Delete the stockItems
        restStockItemsMockMvc.perform(delete("/api/stock-items/{id}", stockItems.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<StockItems> stockItemsList = stockItemsRepository.findAll();
        assertThat(stockItemsList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(StockItems.class);
        StockItems stockItems1 = new StockItems();
        stockItems1.setId(1L);
        StockItems stockItems2 = new StockItems();
        stockItems2.setId(stockItems1.getId());
        assertThat(stockItems1).isEqualTo(stockItems2);
        stockItems2.setId(2L);
        assertThat(stockItems1).isNotEqualTo(stockItems2);
        stockItems1.setId(null);
        assertThat(stockItems1).isNotEqualTo(stockItems2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(StockItemsDTO.class);
        StockItemsDTO stockItemsDTO1 = new StockItemsDTO();
        stockItemsDTO1.setId(1L);
        StockItemsDTO stockItemsDTO2 = new StockItemsDTO();
        assertThat(stockItemsDTO1).isNotEqualTo(stockItemsDTO2);
        stockItemsDTO2.setId(stockItemsDTO1.getId());
        assertThat(stockItemsDTO1).isEqualTo(stockItemsDTO2);
        stockItemsDTO2.setId(2L);
        assertThat(stockItemsDTO1).isNotEqualTo(stockItemsDTO2);
        stockItemsDTO1.setId(null);
        assertThat(stockItemsDTO1).isNotEqualTo(stockItemsDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(stockItemsMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(stockItemsMapper.fromId(null)).isNull();
    }
}
