package bieebox.resource.importer.web.rest;

import bieebox.resource.importer.ImporterApp;

import bieebox.resource.importer.domain.Products;
import bieebox.resource.importer.repository.ProductsRepository;
import bieebox.resource.importer.service.ProductsService;
import bieebox.resource.importer.service.dto.ProductsDTO;
import bieebox.resource.importer.service.mapper.ProductsMapper;
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
 * Test class for the ProductsResource REST controller.
 *
 * @see ProductsResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ImporterApp.class)
public class ProductsResourceIntTest {

    private static final String DEFAULT_PRODUCT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_PRODUCT_NAME = "BBBBBBBBBB";

    private static final Boolean DEFAULT_MAKE_FLAG = false;
    private static final Boolean UPDATED_MAKE_FLAG = true;

    private static final Boolean DEFAULT_FINISHED_GOODS_FLAG = false;
    private static final Boolean UPDATED_FINISHED_GOODS_FLAG = true;

    private static final String DEFAULT_COLOR = "AAAAAAAAAA";
    private static final String UPDATED_COLOR = "BBBBBBBBBB";

    private static final Integer DEFAULT_SAFETY_STOCK_LEVEL = 1;
    private static final Integer UPDATED_SAFETY_STOCK_LEVEL = 2;

    private static final Integer DEFAULT_REORDER_POINT = 1;
    private static final Integer UPDATED_REORDER_POINT = 2;

    private static final BigDecimal DEFAULT_STANDARD_COST = new BigDecimal(1);
    private static final BigDecimal UPDATED_STANDARD_COST = new BigDecimal(2);

    private static final BigDecimal DEFAULT_LIST_PRICE = new BigDecimal(1);
    private static final BigDecimal UPDATED_LIST_PRICE = new BigDecimal(2);

    private static final String DEFAULT_SIZE = "AAAAAAAAAA";
    private static final String UPDATED_SIZE = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_WEIGHT = new BigDecimal(1);
    private static final BigDecimal UPDATED_WEIGHT = new BigDecimal(2);

    private static final Integer DEFAULT_DAYS_TO_MANUFACTURE = 1;
    private static final Integer UPDATED_DAYS_TO_MANUFACTURE = 2;

    private static final String DEFAULT_PRODUCT_LINE = "AAAAAAAAAA";
    private static final String UPDATED_PRODUCT_LINE = "BBBBBBBBBB";

    private static final String DEFAULT_CLASS_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_CLASS_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_STYLE = "AAAAAAAAAA";
    private static final String UPDATED_STYLE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_SELL_START_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_SELL_START_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_SELL_END_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_SELL_END_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DISCONTINUED_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DISCONTINUED_DATE = LocalDate.now(ZoneId.systemDefault());

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private ProductsMapper productsMapper;

    @Autowired
    private ProductsService productsService;

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

    private MockMvc restProductsMockMvc;

    private Products products;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ProductsResource productsResource = new ProductsResource(productsService);
        this.restProductsMockMvc = MockMvcBuilders.standaloneSetup(productsResource)
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
    public static Products createEntity(EntityManager em) {
        Products products = new Products()
            .productName(DEFAULT_PRODUCT_NAME)
            .makeFlag(DEFAULT_MAKE_FLAG)
            .finishedGoodsFlag(DEFAULT_FINISHED_GOODS_FLAG)
            .color(DEFAULT_COLOR)
            .safetyStockLevel(DEFAULT_SAFETY_STOCK_LEVEL)
            .reorderPoint(DEFAULT_REORDER_POINT)
            .standardCost(DEFAULT_STANDARD_COST)
            .listPrice(DEFAULT_LIST_PRICE)
            .size(DEFAULT_SIZE)
            .weight(DEFAULT_WEIGHT)
            .daysToManufacture(DEFAULT_DAYS_TO_MANUFACTURE)
            .productLine(DEFAULT_PRODUCT_LINE)
            .classType(DEFAULT_CLASS_TYPE)
            .style(DEFAULT_STYLE)
            .sellStartDate(DEFAULT_SELL_START_DATE)
            .sellEndDate(DEFAULT_SELL_END_DATE)
            .discontinuedDate(DEFAULT_DISCONTINUED_DATE);
        return products;
    }

    @Before
    public void initTest() {
        products = createEntity(em);
    }

    @Test
    @Transactional
    public void createProducts() throws Exception {
        int databaseSizeBeforeCreate = productsRepository.findAll().size();

        // Create the Products
        ProductsDTO productsDTO = productsMapper.toDto(products);
        restProductsMockMvc.perform(post("/api/products")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productsDTO)))
            .andExpect(status().isCreated());

        // Validate the Products in the database
        List<Products> productsList = productsRepository.findAll();
        assertThat(productsList).hasSize(databaseSizeBeforeCreate + 1);
        Products testProducts = productsList.get(productsList.size() - 1);
        assertThat(testProducts.getProductName()).isEqualTo(DEFAULT_PRODUCT_NAME);
        assertThat(testProducts.isMakeFlag()).isEqualTo(DEFAULT_MAKE_FLAG);
        assertThat(testProducts.isFinishedGoodsFlag()).isEqualTo(DEFAULT_FINISHED_GOODS_FLAG);
        assertThat(testProducts.getColor()).isEqualTo(DEFAULT_COLOR);
        assertThat(testProducts.getSafetyStockLevel()).isEqualTo(DEFAULT_SAFETY_STOCK_LEVEL);
        assertThat(testProducts.getReorderPoint()).isEqualTo(DEFAULT_REORDER_POINT);
        assertThat(testProducts.getStandardCost()).isEqualTo(DEFAULT_STANDARD_COST);
        assertThat(testProducts.getListPrice()).isEqualTo(DEFAULT_LIST_PRICE);
        assertThat(testProducts.getSize()).isEqualTo(DEFAULT_SIZE);
        assertThat(testProducts.getWeight()).isEqualTo(DEFAULT_WEIGHT);
        assertThat(testProducts.getDaysToManufacture()).isEqualTo(DEFAULT_DAYS_TO_MANUFACTURE);
        assertThat(testProducts.getProductLine()).isEqualTo(DEFAULT_PRODUCT_LINE);
        assertThat(testProducts.getClassType()).isEqualTo(DEFAULT_CLASS_TYPE);
        assertThat(testProducts.getStyle()).isEqualTo(DEFAULT_STYLE);
        assertThat(testProducts.getSellStartDate()).isEqualTo(DEFAULT_SELL_START_DATE);
        assertThat(testProducts.getSellEndDate()).isEqualTo(DEFAULT_SELL_END_DATE);
        assertThat(testProducts.getDiscontinuedDate()).isEqualTo(DEFAULT_DISCONTINUED_DATE);
    }

    @Test
    @Transactional
    public void createProductsWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = productsRepository.findAll().size();

        // Create the Products with an existing ID
        products.setId(1L);
        ProductsDTO productsDTO = productsMapper.toDto(products);

        // An entity with an existing ID cannot be created, so this API call must fail
        restProductsMockMvc.perform(post("/api/products")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productsDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Products in the database
        List<Products> productsList = productsRepository.findAll();
        assertThat(productsList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkProductNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = productsRepository.findAll().size();
        // set the field null
        products.setProductName(null);

        // Create the Products, which fails.
        ProductsDTO productsDTO = productsMapper.toDto(products);

        restProductsMockMvc.perform(post("/api/products")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productsDTO)))
            .andExpect(status().isBadRequest());

        List<Products> productsList = productsRepository.findAll();
        assertThat(productsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkMakeFlagIsRequired() throws Exception {
        int databaseSizeBeforeTest = productsRepository.findAll().size();
        // set the field null
        products.setMakeFlag(null);

        // Create the Products, which fails.
        ProductsDTO productsDTO = productsMapper.toDto(products);

        restProductsMockMvc.perform(post("/api/products")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productsDTO)))
            .andExpect(status().isBadRequest());

        List<Products> productsList = productsRepository.findAll();
        assertThat(productsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkFinishedGoodsFlagIsRequired() throws Exception {
        int databaseSizeBeforeTest = productsRepository.findAll().size();
        // set the field null
        products.setFinishedGoodsFlag(null);

        // Create the Products, which fails.
        ProductsDTO productsDTO = productsMapper.toDto(products);

        restProductsMockMvc.perform(post("/api/products")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productsDTO)))
            .andExpect(status().isBadRequest());

        List<Products> productsList = productsRepository.findAll();
        assertThat(productsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkSafetyStockLevelIsRequired() throws Exception {
        int databaseSizeBeforeTest = productsRepository.findAll().size();
        // set the field null
        products.setSafetyStockLevel(null);

        // Create the Products, which fails.
        ProductsDTO productsDTO = productsMapper.toDto(products);

        restProductsMockMvc.perform(post("/api/products")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productsDTO)))
            .andExpect(status().isBadRequest());

        List<Products> productsList = productsRepository.findAll();
        assertThat(productsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkReorderPointIsRequired() throws Exception {
        int databaseSizeBeforeTest = productsRepository.findAll().size();
        // set the field null
        products.setReorderPoint(null);

        // Create the Products, which fails.
        ProductsDTO productsDTO = productsMapper.toDto(products);

        restProductsMockMvc.perform(post("/api/products")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productsDTO)))
            .andExpect(status().isBadRequest());

        List<Products> productsList = productsRepository.findAll();
        assertThat(productsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkStandardCostIsRequired() throws Exception {
        int databaseSizeBeforeTest = productsRepository.findAll().size();
        // set the field null
        products.setStandardCost(null);

        // Create the Products, which fails.
        ProductsDTO productsDTO = productsMapper.toDto(products);

        restProductsMockMvc.perform(post("/api/products")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productsDTO)))
            .andExpect(status().isBadRequest());

        List<Products> productsList = productsRepository.findAll();
        assertThat(productsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkListPriceIsRequired() throws Exception {
        int databaseSizeBeforeTest = productsRepository.findAll().size();
        // set the field null
        products.setListPrice(null);

        // Create the Products, which fails.
        ProductsDTO productsDTO = productsMapper.toDto(products);

        restProductsMockMvc.perform(post("/api/products")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productsDTO)))
            .andExpect(status().isBadRequest());

        List<Products> productsList = productsRepository.findAll();
        assertThat(productsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDaysToManufactureIsRequired() throws Exception {
        int databaseSizeBeforeTest = productsRepository.findAll().size();
        // set the field null
        products.setDaysToManufacture(null);

        // Create the Products, which fails.
        ProductsDTO productsDTO = productsMapper.toDto(products);

        restProductsMockMvc.perform(post("/api/products")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productsDTO)))
            .andExpect(status().isBadRequest());

        List<Products> productsList = productsRepository.findAll();
        assertThat(productsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkSellStartDateIsRequired() throws Exception {
        int databaseSizeBeforeTest = productsRepository.findAll().size();
        // set the field null
        products.setSellStartDate(null);

        // Create the Products, which fails.
        ProductsDTO productsDTO = productsMapper.toDto(products);

        restProductsMockMvc.perform(post("/api/products")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productsDTO)))
            .andExpect(status().isBadRequest());

        List<Products> productsList = productsRepository.findAll();
        assertThat(productsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllProducts() throws Exception {
        // Initialize the database
        productsRepository.saveAndFlush(products);

        // Get all the productsList
        restProductsMockMvc.perform(get("/api/products?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(products.getId().intValue())))
            .andExpect(jsonPath("$.[*].productName").value(hasItem(DEFAULT_PRODUCT_NAME.toString())))
            .andExpect(jsonPath("$.[*].makeFlag").value(hasItem(DEFAULT_MAKE_FLAG.booleanValue())))
            .andExpect(jsonPath("$.[*].finishedGoodsFlag").value(hasItem(DEFAULT_FINISHED_GOODS_FLAG.booleanValue())))
            .andExpect(jsonPath("$.[*].color").value(hasItem(DEFAULT_COLOR.toString())))
            .andExpect(jsonPath("$.[*].safetyStockLevel").value(hasItem(DEFAULT_SAFETY_STOCK_LEVEL)))
            .andExpect(jsonPath("$.[*].reorderPoint").value(hasItem(DEFAULT_REORDER_POINT)))
            .andExpect(jsonPath("$.[*].standardCost").value(hasItem(DEFAULT_STANDARD_COST.intValue())))
            .andExpect(jsonPath("$.[*].listPrice").value(hasItem(DEFAULT_LIST_PRICE.intValue())))
            .andExpect(jsonPath("$.[*].size").value(hasItem(DEFAULT_SIZE.toString())))
            .andExpect(jsonPath("$.[*].weight").value(hasItem(DEFAULT_WEIGHT.intValue())))
            .andExpect(jsonPath("$.[*].daysToManufacture").value(hasItem(DEFAULT_DAYS_TO_MANUFACTURE)))
            .andExpect(jsonPath("$.[*].productLine").value(hasItem(DEFAULT_PRODUCT_LINE.toString())))
            .andExpect(jsonPath("$.[*].classType").value(hasItem(DEFAULT_CLASS_TYPE.toString())))
            .andExpect(jsonPath("$.[*].style").value(hasItem(DEFAULT_STYLE.toString())))
            .andExpect(jsonPath("$.[*].sellStartDate").value(hasItem(DEFAULT_SELL_START_DATE.toString())))
            .andExpect(jsonPath("$.[*].sellEndDate").value(hasItem(DEFAULT_SELL_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].discontinuedDate").value(hasItem(DEFAULT_DISCONTINUED_DATE.toString())));
    }
    
    @Test
    @Transactional
    public void getProducts() throws Exception {
        // Initialize the database
        productsRepository.saveAndFlush(products);

        // Get the products
        restProductsMockMvc.perform(get("/api/products/{id}", products.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(products.getId().intValue()))
            .andExpect(jsonPath("$.productName").value(DEFAULT_PRODUCT_NAME.toString()))
            .andExpect(jsonPath("$.makeFlag").value(DEFAULT_MAKE_FLAG.booleanValue()))
            .andExpect(jsonPath("$.finishedGoodsFlag").value(DEFAULT_FINISHED_GOODS_FLAG.booleanValue()))
            .andExpect(jsonPath("$.color").value(DEFAULT_COLOR.toString()))
            .andExpect(jsonPath("$.safetyStockLevel").value(DEFAULT_SAFETY_STOCK_LEVEL))
            .andExpect(jsonPath("$.reorderPoint").value(DEFAULT_REORDER_POINT))
            .andExpect(jsonPath("$.standardCost").value(DEFAULT_STANDARD_COST.intValue()))
            .andExpect(jsonPath("$.listPrice").value(DEFAULT_LIST_PRICE.intValue()))
            .andExpect(jsonPath("$.size").value(DEFAULT_SIZE.toString()))
            .andExpect(jsonPath("$.weight").value(DEFAULT_WEIGHT.intValue()))
            .andExpect(jsonPath("$.daysToManufacture").value(DEFAULT_DAYS_TO_MANUFACTURE))
            .andExpect(jsonPath("$.productLine").value(DEFAULT_PRODUCT_LINE.toString()))
            .andExpect(jsonPath("$.classType").value(DEFAULT_CLASS_TYPE.toString()))
            .andExpect(jsonPath("$.style").value(DEFAULT_STYLE.toString()))
            .andExpect(jsonPath("$.sellStartDate").value(DEFAULT_SELL_START_DATE.toString()))
            .andExpect(jsonPath("$.sellEndDate").value(DEFAULT_SELL_END_DATE.toString()))
            .andExpect(jsonPath("$.discontinuedDate").value(DEFAULT_DISCONTINUED_DATE.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingProducts() throws Exception {
        // Get the products
        restProductsMockMvc.perform(get("/api/products/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateProducts() throws Exception {
        // Initialize the database
        productsRepository.saveAndFlush(products);

        int databaseSizeBeforeUpdate = productsRepository.findAll().size();

        // Update the products
        Products updatedProducts = productsRepository.findById(products.getId()).get();
        // Disconnect from session so that the updates on updatedProducts are not directly saved in db
        em.detach(updatedProducts);
        updatedProducts
            .productName(UPDATED_PRODUCT_NAME)
            .makeFlag(UPDATED_MAKE_FLAG)
            .finishedGoodsFlag(UPDATED_FINISHED_GOODS_FLAG)
            .color(UPDATED_COLOR)
            .safetyStockLevel(UPDATED_SAFETY_STOCK_LEVEL)
            .reorderPoint(UPDATED_REORDER_POINT)
            .standardCost(UPDATED_STANDARD_COST)
            .listPrice(UPDATED_LIST_PRICE)
            .size(UPDATED_SIZE)
            .weight(UPDATED_WEIGHT)
            .daysToManufacture(UPDATED_DAYS_TO_MANUFACTURE)
            .productLine(UPDATED_PRODUCT_LINE)
            .classType(UPDATED_CLASS_TYPE)
            .style(UPDATED_STYLE)
            .sellStartDate(UPDATED_SELL_START_DATE)
            .sellEndDate(UPDATED_SELL_END_DATE)
            .discontinuedDate(UPDATED_DISCONTINUED_DATE);
        ProductsDTO productsDTO = productsMapper.toDto(updatedProducts);

        restProductsMockMvc.perform(put("/api/products")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productsDTO)))
            .andExpect(status().isOk());

        // Validate the Products in the database
        List<Products> productsList = productsRepository.findAll();
        assertThat(productsList).hasSize(databaseSizeBeforeUpdate);
        Products testProducts = productsList.get(productsList.size() - 1);
        assertThat(testProducts.getProductName()).isEqualTo(UPDATED_PRODUCT_NAME);
        assertThat(testProducts.isMakeFlag()).isEqualTo(UPDATED_MAKE_FLAG);
        assertThat(testProducts.isFinishedGoodsFlag()).isEqualTo(UPDATED_FINISHED_GOODS_FLAG);
        assertThat(testProducts.getColor()).isEqualTo(UPDATED_COLOR);
        assertThat(testProducts.getSafetyStockLevel()).isEqualTo(UPDATED_SAFETY_STOCK_LEVEL);
        assertThat(testProducts.getReorderPoint()).isEqualTo(UPDATED_REORDER_POINT);
        assertThat(testProducts.getStandardCost()).isEqualTo(UPDATED_STANDARD_COST);
        assertThat(testProducts.getListPrice()).isEqualTo(UPDATED_LIST_PRICE);
        assertThat(testProducts.getSize()).isEqualTo(UPDATED_SIZE);
        assertThat(testProducts.getWeight()).isEqualTo(UPDATED_WEIGHT);
        assertThat(testProducts.getDaysToManufacture()).isEqualTo(UPDATED_DAYS_TO_MANUFACTURE);
        assertThat(testProducts.getProductLine()).isEqualTo(UPDATED_PRODUCT_LINE);
        assertThat(testProducts.getClassType()).isEqualTo(UPDATED_CLASS_TYPE);
        assertThat(testProducts.getStyle()).isEqualTo(UPDATED_STYLE);
        assertThat(testProducts.getSellStartDate()).isEqualTo(UPDATED_SELL_START_DATE);
        assertThat(testProducts.getSellEndDate()).isEqualTo(UPDATED_SELL_END_DATE);
        assertThat(testProducts.getDiscontinuedDate()).isEqualTo(UPDATED_DISCONTINUED_DATE);
    }

    @Test
    @Transactional
    public void updateNonExistingProducts() throws Exception {
        int databaseSizeBeforeUpdate = productsRepository.findAll().size();

        // Create the Products
        ProductsDTO productsDTO = productsMapper.toDto(products);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restProductsMockMvc.perform(put("/api/products")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productsDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Products in the database
        List<Products> productsList = productsRepository.findAll();
        assertThat(productsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteProducts() throws Exception {
        // Initialize the database
        productsRepository.saveAndFlush(products);

        int databaseSizeBeforeDelete = productsRepository.findAll().size();

        // Delete the products
        restProductsMockMvc.perform(delete("/api/products/{id}", products.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Products> productsList = productsRepository.findAll();
        assertThat(productsList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Products.class);
        Products products1 = new Products();
        products1.setId(1L);
        Products products2 = new Products();
        products2.setId(products1.getId());
        assertThat(products1).isEqualTo(products2);
        products2.setId(2L);
        assertThat(products1).isNotEqualTo(products2);
        products1.setId(null);
        assertThat(products1).isNotEqualTo(products2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ProductsDTO.class);
        ProductsDTO productsDTO1 = new ProductsDTO();
        productsDTO1.setId(1L);
        ProductsDTO productsDTO2 = new ProductsDTO();
        assertThat(productsDTO1).isNotEqualTo(productsDTO2);
        productsDTO2.setId(productsDTO1.getId());
        assertThat(productsDTO1).isEqualTo(productsDTO2);
        productsDTO2.setId(2L);
        assertThat(productsDTO1).isNotEqualTo(productsDTO2);
        productsDTO1.setId(null);
        assertThat(productsDTO1).isNotEqualTo(productsDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(productsMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(productsMapper.fromId(null)).isNull();
    }
}
