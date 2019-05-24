package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.TesteApp;
import io.github.jhipster.application.domain.ModeloMensagens;
import io.github.jhipster.application.repository.ModeloMensagensRepository;
import io.github.jhipster.application.service.ModeloMensagensService;
import io.github.jhipster.application.service.dto.ModeloMensagensDTO;
import io.github.jhipster.application.service.mapper.ModeloMensagensMapper;
import io.github.jhipster.application.web.rest.errors.ExceptionTranslator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.util.List;

import static io.github.jhipster.application.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@Link ModeloMensagensResource} REST controller.
 */
@SpringBootTest(classes = TesteApp.class)
public class ModeloMensagensResourceIT {

    private static final String DEFAULT_TITULO = "AAAAAAAAAA";
    private static final String UPDATED_TITULO = "BBBBBBBBBB";

    private static final String DEFAULT_MENSAGEM = "AAAAAAAAAA";
    private static final String UPDATED_MENSAGEM = "BBBBBBBBBB";

    @Autowired
    private ModeloMensagensRepository modeloMensagensRepository;

    @Autowired
    private ModeloMensagensMapper modeloMensagensMapper;

    @Autowired
    private ModeloMensagensService modeloMensagensService;

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

    private MockMvc restModeloMensagensMockMvc;

    private ModeloMensagens modeloMensagens;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ModeloMensagensResource modeloMensagensResource = new ModeloMensagensResource(modeloMensagensService);
        this.restModeloMensagensMockMvc = MockMvcBuilders.standaloneSetup(modeloMensagensResource)
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
    public static ModeloMensagens createEntity(EntityManager em) {
        ModeloMensagens modeloMensagens = new ModeloMensagens()
            .titulo(DEFAULT_TITULO)
            .mensagem(DEFAULT_MENSAGEM);
        return modeloMensagens;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ModeloMensagens createUpdatedEntity(EntityManager em) {
        ModeloMensagens modeloMensagens = new ModeloMensagens()
            .titulo(UPDATED_TITULO)
            .mensagem(UPDATED_MENSAGEM);
        return modeloMensagens;
    }

    @BeforeEach
    public void initTest() {
        modeloMensagens = createEntity(em);
    }

    @Test
    @Transactional
    public void createModeloMensagens() throws Exception {
        int databaseSizeBeforeCreate = modeloMensagensRepository.findAll().size();

        // Create the ModeloMensagens
        ModeloMensagensDTO modeloMensagensDTO = modeloMensagensMapper.toDto(modeloMensagens);
        restModeloMensagensMockMvc.perform(post("/api/modelo-mensagens")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(modeloMensagensDTO)))
            .andExpect(status().isCreated());

        // Validate the ModeloMensagens in the database
        List<ModeloMensagens> modeloMensagensList = modeloMensagensRepository.findAll();
        assertThat(modeloMensagensList).hasSize(databaseSizeBeforeCreate + 1);
        ModeloMensagens testModeloMensagens = modeloMensagensList.get(modeloMensagensList.size() - 1);
        assertThat(testModeloMensagens.getTitulo()).isEqualTo(DEFAULT_TITULO);
        assertThat(testModeloMensagens.getMensagem()).isEqualTo(DEFAULT_MENSAGEM);
    }

    @Test
    @Transactional
    public void createModeloMensagensWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = modeloMensagensRepository.findAll().size();

        // Create the ModeloMensagens with an existing ID
        modeloMensagens.setId(1L);
        ModeloMensagensDTO modeloMensagensDTO = modeloMensagensMapper.toDto(modeloMensagens);

        // An entity with an existing ID cannot be created, so this API call must fail
        restModeloMensagensMockMvc.perform(post("/api/modelo-mensagens")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(modeloMensagensDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ModeloMensagens in the database
        List<ModeloMensagens> modeloMensagensList = modeloMensagensRepository.findAll();
        assertThat(modeloMensagensList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkTituloIsRequired() throws Exception {
        int databaseSizeBeforeTest = modeloMensagensRepository.findAll().size();
        // set the field null
        modeloMensagens.setTitulo(null);

        // Create the ModeloMensagens, which fails.
        ModeloMensagensDTO modeloMensagensDTO = modeloMensagensMapper.toDto(modeloMensagens);

        restModeloMensagensMockMvc.perform(post("/api/modelo-mensagens")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(modeloMensagensDTO)))
            .andExpect(status().isBadRequest());

        List<ModeloMensagens> modeloMensagensList = modeloMensagensRepository.findAll();
        assertThat(modeloMensagensList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkMensagemIsRequired() throws Exception {
        int databaseSizeBeforeTest = modeloMensagensRepository.findAll().size();
        // set the field null
        modeloMensagens.setMensagem(null);

        // Create the ModeloMensagens, which fails.
        ModeloMensagensDTO modeloMensagensDTO = modeloMensagensMapper.toDto(modeloMensagens);

        restModeloMensagensMockMvc.perform(post("/api/modelo-mensagens")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(modeloMensagensDTO)))
            .andExpect(status().isBadRequest());

        List<ModeloMensagens> modeloMensagensList = modeloMensagensRepository.findAll();
        assertThat(modeloMensagensList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllModeloMensagens() throws Exception {
        // Initialize the database
        modeloMensagensRepository.saveAndFlush(modeloMensagens);

        // Get all the modeloMensagensList
        restModeloMensagensMockMvc.perform(get("/api/modelo-mensagens?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(modeloMensagens.getId().intValue())))
            .andExpect(jsonPath("$.[*].titulo").value(hasItem(DEFAULT_TITULO.toString())))
            .andExpect(jsonPath("$.[*].mensagem").value(hasItem(DEFAULT_MENSAGEM.toString())));
    }
    
    @Test
    @Transactional
    public void getModeloMensagens() throws Exception {
        // Initialize the database
        modeloMensagensRepository.saveAndFlush(modeloMensagens);

        // Get the modeloMensagens
        restModeloMensagensMockMvc.perform(get("/api/modelo-mensagens/{id}", modeloMensagens.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(modeloMensagens.getId().intValue()))
            .andExpect(jsonPath("$.titulo").value(DEFAULT_TITULO.toString()))
            .andExpect(jsonPath("$.mensagem").value(DEFAULT_MENSAGEM.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingModeloMensagens() throws Exception {
        // Get the modeloMensagens
        restModeloMensagensMockMvc.perform(get("/api/modelo-mensagens/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateModeloMensagens() throws Exception {
        // Initialize the database
        modeloMensagensRepository.saveAndFlush(modeloMensagens);

        int databaseSizeBeforeUpdate = modeloMensagensRepository.findAll().size();

        // Update the modeloMensagens
        ModeloMensagens updatedModeloMensagens = modeloMensagensRepository.findById(modeloMensagens.getId()).get();
        // Disconnect from session so that the updates on updatedModeloMensagens are not directly saved in db
        em.detach(updatedModeloMensagens);
        updatedModeloMensagens
            .titulo(UPDATED_TITULO)
            .mensagem(UPDATED_MENSAGEM);
        ModeloMensagensDTO modeloMensagensDTO = modeloMensagensMapper.toDto(updatedModeloMensagens);

        restModeloMensagensMockMvc.perform(put("/api/modelo-mensagens")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(modeloMensagensDTO)))
            .andExpect(status().isOk());

        // Validate the ModeloMensagens in the database
        List<ModeloMensagens> modeloMensagensList = modeloMensagensRepository.findAll();
        assertThat(modeloMensagensList).hasSize(databaseSizeBeforeUpdate);
        ModeloMensagens testModeloMensagens = modeloMensagensList.get(modeloMensagensList.size() - 1);
        assertThat(testModeloMensagens.getTitulo()).isEqualTo(UPDATED_TITULO);
        assertThat(testModeloMensagens.getMensagem()).isEqualTo(UPDATED_MENSAGEM);
    }

    @Test
    @Transactional
    public void updateNonExistingModeloMensagens() throws Exception {
        int databaseSizeBeforeUpdate = modeloMensagensRepository.findAll().size();

        // Create the ModeloMensagens
        ModeloMensagensDTO modeloMensagensDTO = modeloMensagensMapper.toDto(modeloMensagens);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restModeloMensagensMockMvc.perform(put("/api/modelo-mensagens")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(modeloMensagensDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ModeloMensagens in the database
        List<ModeloMensagens> modeloMensagensList = modeloMensagensRepository.findAll();
        assertThat(modeloMensagensList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteModeloMensagens() throws Exception {
        // Initialize the database
        modeloMensagensRepository.saveAndFlush(modeloMensagens);

        int databaseSizeBeforeDelete = modeloMensagensRepository.findAll().size();

        // Delete the modeloMensagens
        restModeloMensagensMockMvc.perform(delete("/api/modelo-mensagens/{id}", modeloMensagens.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database is empty
        List<ModeloMensagens> modeloMensagensList = modeloMensagensRepository.findAll();
        assertThat(modeloMensagensList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ModeloMensagens.class);
        ModeloMensagens modeloMensagens1 = new ModeloMensagens();
        modeloMensagens1.setId(1L);
        ModeloMensagens modeloMensagens2 = new ModeloMensagens();
        modeloMensagens2.setId(modeloMensagens1.getId());
        assertThat(modeloMensagens1).isEqualTo(modeloMensagens2);
        modeloMensagens2.setId(2L);
        assertThat(modeloMensagens1).isNotEqualTo(modeloMensagens2);
        modeloMensagens1.setId(null);
        assertThat(modeloMensagens1).isNotEqualTo(modeloMensagens2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ModeloMensagensDTO.class);
        ModeloMensagensDTO modeloMensagensDTO1 = new ModeloMensagensDTO();
        modeloMensagensDTO1.setId(1L);
        ModeloMensagensDTO modeloMensagensDTO2 = new ModeloMensagensDTO();
        assertThat(modeloMensagensDTO1).isNotEqualTo(modeloMensagensDTO2);
        modeloMensagensDTO2.setId(modeloMensagensDTO1.getId());
        assertThat(modeloMensagensDTO1).isEqualTo(modeloMensagensDTO2);
        modeloMensagensDTO2.setId(2L);
        assertThat(modeloMensagensDTO1).isNotEqualTo(modeloMensagensDTO2);
        modeloMensagensDTO1.setId(null);
        assertThat(modeloMensagensDTO1).isNotEqualTo(modeloMensagensDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(modeloMensagensMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(modeloMensagensMapper.fromId(null)).isNull();
    }
}
