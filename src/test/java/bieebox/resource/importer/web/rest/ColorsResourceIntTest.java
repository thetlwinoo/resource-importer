package bieebox.resource.importer.web.rest;

import bieebox.resource.importer.ImporterApp;

import bieebox.resource.importer.domain.Colors;
import bieebox.resource.importer.repository.ColorsRepository;
import bieebox.resource.importer.service.ColorsService;
import bieebox.resource.importer.service.dto.ColorsDTO;
import bieebox.resource.importer.service.mapper.ColorsMapper;
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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;


import static bieebox.resource.importer.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the ColorsResource REST controller.
 *
 * @see ColorsResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ImporterApp.class)
public class ColorsResourceIntTest {

    private static final String DEFAULT_COLOR_NAME = "AAAAAAAAAA";
    private static final String UPDATED_COLOR_NAME = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_VALID_FROM = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_VALID_FROM = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_VALID_TO = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_VALID_TO = LocalDate.now(ZoneId.systemDefault());

    @Autowired
    private ColorsRepository colorsRepository;

    @Autowired
    private ColorsMapper colorsMapper;

    @Autowired
    private ColorsService colorsService;

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

    private MockMvc restColorsMockMvc;

    private Colors colors;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ColorsResource colorsResource = new ColorsResource(colorsService);
        this.restColorsMockMvc = MockMvcBuilders.standaloneSetup(colorsResource)
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
    public static Colors createEntity(EntityManager em) {
        Colors colors = new Colors()
            .colorName(DEFAULT_COLOR_NAME)
            .validFrom(DEFAULT_VALID_FROM)
            .validTo(DEFAULT_VALID_TO);
        return colors;
    }

    @Before
    public void initTest() {
        colors = createEntity(em);
    }

    @Test
    @Transactional
    public void createColors() throws Exception {
        int databaseSizeBeforeCreate = colorsRepository.findAll().size();

        // Create the Colors
        ColorsDTO colorsDTO = colorsMapper.toDto(colors);
        restColorsMockMvc.perform(post("/api/colors")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(colorsDTO)))
            .andExpect(status().isCreated());

        // Validate the Colors in the database
        List<Colors> colorsList = colorsRepository.findAll();
        assertThat(colorsList).hasSize(databaseSizeBeforeCreate + 1);
        Colors testColors = colorsList.get(colorsList.size() - 1);
        assertThat(testColors.getColorName()).isEqualTo(DEFAULT_COLOR_NAME);
        assertThat(testColors.getValidFrom()).isEqualTo(DEFAULT_VALID_FROM);
        assertThat(testColors.getValidTo()).isEqualTo(DEFAULT_VALID_TO);
    }

    @Test
    @Transactional
    public void createColorsWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = colorsRepository.findAll().size();

        // Create the Colors with an existing ID
        colors.setId(1L);
        ColorsDTO colorsDTO = colorsMapper.toDto(colors);

        // An entity with an existing ID cannot be created, so this API call must fail
        restColorsMockMvc.perform(post("/api/colors")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(colorsDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Colors in the database
        List<Colors> colorsList = colorsRepository.findAll();
        assertThat(colorsList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkColorNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = colorsRepository.findAll().size();
        // set the field null
        colors.setColorName(null);

        // Create the Colors, which fails.
        ColorsDTO colorsDTO = colorsMapper.toDto(colors);

        restColorsMockMvc.perform(post("/api/colors")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(colorsDTO)))
            .andExpect(status().isBadRequest());

        List<Colors> colorsList = colorsRepository.findAll();
        assertThat(colorsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkValidFromIsRequired() throws Exception {
        int databaseSizeBeforeTest = colorsRepository.findAll().size();
        // set the field null
        colors.setValidFrom(null);

        // Create the Colors, which fails.
        ColorsDTO colorsDTO = colorsMapper.toDto(colors);

        restColorsMockMvc.perform(post("/api/colors")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(colorsDTO)))
            .andExpect(status().isBadRequest());

        List<Colors> colorsList = colorsRepository.findAll();
        assertThat(colorsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkValidToIsRequired() throws Exception {
        int databaseSizeBeforeTest = colorsRepository.findAll().size();
        // set the field null
        colors.setValidTo(null);

        // Create the Colors, which fails.
        ColorsDTO colorsDTO = colorsMapper.toDto(colors);

        restColorsMockMvc.perform(post("/api/colors")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(colorsDTO)))
            .andExpect(status().isBadRequest());

        List<Colors> colorsList = colorsRepository.findAll();
        assertThat(colorsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllColors() throws Exception {
        // Initialize the database
        colorsRepository.saveAndFlush(colors);

        // Get all the colorsList
        restColorsMockMvc.perform(get("/api/colors?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(colors.getId().intValue())))
            .andExpect(jsonPath("$.[*].colorName").value(hasItem(DEFAULT_COLOR_NAME.toString())))
            .andExpect(jsonPath("$.[*].validFrom").value(hasItem(DEFAULT_VALID_FROM.toString())))
            .andExpect(jsonPath("$.[*].validTo").value(hasItem(DEFAULT_VALID_TO.toString())));
    }
    
    @Test
    @Transactional
    public void getColors() throws Exception {
        // Initialize the database
        colorsRepository.saveAndFlush(colors);

        // Get the colors
        restColorsMockMvc.perform(get("/api/colors/{id}", colors.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(colors.getId().intValue()))
            .andExpect(jsonPath("$.colorName").value(DEFAULT_COLOR_NAME.toString()))
            .andExpect(jsonPath("$.validFrom").value(DEFAULT_VALID_FROM.toString()))
            .andExpect(jsonPath("$.validTo").value(DEFAULT_VALID_TO.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingColors() throws Exception {
        // Get the colors
        restColorsMockMvc.perform(get("/api/colors/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateColors() throws Exception {
        // Initialize the database
        colorsRepository.saveAndFlush(colors);

        int databaseSizeBeforeUpdate = colorsRepository.findAll().size();

        // Update the colors
        Colors updatedColors = colorsRepository.findById(colors.getId()).get();
        // Disconnect from session so that the updates on updatedColors are not directly saved in db
        em.detach(updatedColors);
        updatedColors
            .colorName(UPDATED_COLOR_NAME)
            .validFrom(UPDATED_VALID_FROM)
            .validTo(UPDATED_VALID_TO);
        ColorsDTO colorsDTO = colorsMapper.toDto(updatedColors);

        restColorsMockMvc.perform(put("/api/colors")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(colorsDTO)))
            .andExpect(status().isOk());

        // Validate the Colors in the database
        List<Colors> colorsList = colorsRepository.findAll();
        assertThat(colorsList).hasSize(databaseSizeBeforeUpdate);
        Colors testColors = colorsList.get(colorsList.size() - 1);
        assertThat(testColors.getColorName()).isEqualTo(UPDATED_COLOR_NAME);
        assertThat(testColors.getValidFrom()).isEqualTo(UPDATED_VALID_FROM);
        assertThat(testColors.getValidTo()).isEqualTo(UPDATED_VALID_TO);
    }

    @Test
    @Transactional
    public void updateNonExistingColors() throws Exception {
        int databaseSizeBeforeUpdate = colorsRepository.findAll().size();

        // Create the Colors
        ColorsDTO colorsDTO = colorsMapper.toDto(colors);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restColorsMockMvc.perform(put("/api/colors")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(colorsDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Colors in the database
        List<Colors> colorsList = colorsRepository.findAll();
        assertThat(colorsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteColors() throws Exception {
        // Initialize the database
        colorsRepository.saveAndFlush(colors);

        int databaseSizeBeforeDelete = colorsRepository.findAll().size();

        // Delete the colors
        restColorsMockMvc.perform(delete("/api/colors/{id}", colors.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Colors> colorsList = colorsRepository.findAll();
        assertThat(colorsList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Colors.class);
        Colors colors1 = new Colors();
        colors1.setId(1L);
        Colors colors2 = new Colors();
        colors2.setId(colors1.getId());
        assertThat(colors1).isEqualTo(colors2);
        colors2.setId(2L);
        assertThat(colors1).isNotEqualTo(colors2);
        colors1.setId(null);
        assertThat(colors1).isNotEqualTo(colors2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ColorsDTO.class);
        ColorsDTO colorsDTO1 = new ColorsDTO();
        colorsDTO1.setId(1L);
        ColorsDTO colorsDTO2 = new ColorsDTO();
        assertThat(colorsDTO1).isNotEqualTo(colorsDTO2);
        colorsDTO2.setId(colorsDTO1.getId());
        assertThat(colorsDTO1).isEqualTo(colorsDTO2);
        colorsDTO2.setId(2L);
        assertThat(colorsDTO1).isNotEqualTo(colorsDTO2);
        colorsDTO1.setId(null);
        assertThat(colorsDTO1).isNotEqualTo(colorsDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(colorsMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(colorsMapper.fromId(null)).isNull();
    }
}
