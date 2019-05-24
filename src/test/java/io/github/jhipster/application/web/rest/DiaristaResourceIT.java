package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.TesteApp;
import io.github.jhipster.application.domain.Diarista;
import io.github.jhipster.application.repository.DiaristaRepository;
import io.github.jhipster.application.service.DiaristaService;
import io.github.jhipster.application.service.dto.DiaristaDTO;
import io.github.jhipster.application.service.mapper.DiaristaMapper;
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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static io.github.jhipster.application.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import io.github.jhipster.application.domain.enumeration.UF;
import io.github.jhipster.application.domain.enumeration.TamanhoCamisa;
import io.github.jhipster.application.domain.enumeration.UF;
/**
 * Integration tests for the {@Link DiaristaResource} REST controller.
 */
@SpringBootTest(classes = TesteApp.class)
public class DiaristaResourceIT {

    private static final String DEFAULT_NOME = "AAAAAAAAAA";
    private static final String UPDATED_NOME = "BBBBBBBBBB";

    private static final String DEFAULT_RG = "AAAAAAAAAA";
    private static final String UPDATED_RG = "BBBBBBBBBB";

    private static final String DEFAULT_CPF = "72";
    private static final String UPDATED_CPF = "90";

    private static final String DEFAULT_CEP = "45";
    private static final String UPDATED_CEP = "50";

    private static final String DEFAULT_LOGRADOURO = "AAAAAAAAAA";
    private static final String UPDATED_LOGRADOURO = "BBBBBBBBBB";

    private static final String DEFAULT_LOCALIDADE = "AAAAAAAAAA";
    private static final String UPDATED_LOCALIDADE = "BBBBBBBBBB";

    private static final String DEFAULT_BAIRRO = "AAAAAAAAAA";
    private static final String UPDATED_BAIRRO = "BBBBBBBBBB";

    private static final UF DEFAULT_UF = UF.AC;
    private static final UF UPDATED_UF = UF.AL;

    private static final String DEFAULT_COMPLEMENTO = "AAAAAAAAAA";
    private static final String UPDATED_COMPLEMENTO = "BBBBBBBBBB";

    private static final String DEFAULT_NUMERO = "AAAAAAAAAA";
    private static final String UPDATED_NUMERO = "BBBBBBBBBB";

    private static final String DEFAULT_DDD = "42";
    private static final String UPDATED_DDD = "6";

    private static final String DEFAULT_TELEFONE = "36";
    private static final String UPDATED_TELEFONE = "04";

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_NOME_CONTATO = "AAAAAAAAAA";
    private static final String UPDATED_NOME_CONTATO = "BBBBBBBBBB";

    private static final String DEFAULT_DDD_CONTATO = "75";
    private static final String UPDATED_DDD_CONTATO = "59";

    private static final String DEFAULT_TELEFONE_CONTATO = "0";
    private static final String UPDATED_TELEFONE_CONTATO = "6";

    private static final LocalDate DEFAULT_DATA_NASCIMENTO = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATA_NASCIMENTO = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_CARGO = "AAAAAAAAAA";
    private static final String UPDATED_CARGO = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DATA_ADMISSAO = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATA_ADMISSAO = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATA_SAIDA = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATA_SAIDA = LocalDate.now(ZoneId.systemDefault());

    private static final TamanhoCamisa DEFAULT_TAMANHO_CAMISA = TamanhoCamisa.PP;
    private static final TamanhoCamisa UPDATED_TAMANHO_CAMISA = TamanhoCamisa.P;

    private static final String DEFAULT_PIS = "90";
    private static final String UPDATED_PIS = "2";

    private static final String DEFAULT_CARTAO_CIDADADO = "7";
    private static final String UPDATED_CARTAO_CIDADADO = "6";

    private static final String DEFAULT_NUMERO_TITULO_ELEITOR = "9";
    private static final String UPDATED_NUMERO_TITULO_ELEITOR = "17";

    private static final String DEFAULT_ZONA_TITULO_ELEITOR = "80";
    private static final String UPDATED_ZONA_TITULO_ELEITOR = "80B";

    private static final String DEFAULT_SECAO_TITULO_ELEITOR = "8";
    private static final String UPDATED_SECAO_TITULO_ELEITOR = "97";

    private static final String DEFAULT_NUMERO_CARTEIRA_TRABALHO = "91";
    private static final String UPDATED_NUMERO_CARTEIRA_TRABALHO = "89";

    private static final String DEFAULT_SERIE_CARTEIRA_TRABALHO = "64";
    private static final String UPDATED_SERIE_CARTEIRA_TRABALHO = "44";

    private static final UF DEFAULT_UF_CARTEIRA_TRABALHO = UF.AC;
    private static final UF UPDATED_UF_CARTEIRA_TRABALHO = UF.AL;

    private static final String DEFAULT_NIRE = "9";
    private static final String UPDATED_NIRE = "5";

    private static final String DEFAULT_CNPJ = "3";
    private static final String UPDATED_CNPJ = "2";

    @Autowired
    private DiaristaRepository diaristaRepository;

    @Autowired
    private DiaristaMapper diaristaMapper;

    @Autowired
    private DiaristaService diaristaService;

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

    private MockMvc restDiaristaMockMvc;

    private Diarista diarista;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final DiaristaResource diaristaResource = new DiaristaResource(diaristaService);
        this.restDiaristaMockMvc = MockMvcBuilders.standaloneSetup(diaristaResource)
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
    public static Diarista createEntity(EntityManager em) {
        Diarista diarista = new Diarista()
            .nome(DEFAULT_NOME)
            .rg(DEFAULT_RG)
            .cpf(DEFAULT_CPF)
            .cep(DEFAULT_CEP)
            .logradouro(DEFAULT_LOGRADOURO)
            .localidade(DEFAULT_LOCALIDADE)
            .bairro(DEFAULT_BAIRRO)
            .uf(DEFAULT_UF)
            .complemento(DEFAULT_COMPLEMENTO)
            .numero(DEFAULT_NUMERO)
            .ddd(DEFAULT_DDD)
            .telefone(DEFAULT_TELEFONE)
            .email(DEFAULT_EMAIL)
            .nomeContato(DEFAULT_NOME_CONTATO)
            .dddContato(DEFAULT_DDD_CONTATO)
            .telefoneContato(DEFAULT_TELEFONE_CONTATO)
            .dataNascimento(DEFAULT_DATA_NASCIMENTO)
            .cargo(DEFAULT_CARGO)
            .dataAdmissao(DEFAULT_DATA_ADMISSAO)
            .dataSaida(DEFAULT_DATA_SAIDA)
            .tamanhoCamisa(DEFAULT_TAMANHO_CAMISA)
            .pis(DEFAULT_PIS)
            .cartaoCidadado(DEFAULT_CARTAO_CIDADADO)
            .numeroTituloEleitor(DEFAULT_NUMERO_TITULO_ELEITOR)
            .zonaTituloEleitor(DEFAULT_ZONA_TITULO_ELEITOR)
            .secaoTituloEleitor(DEFAULT_SECAO_TITULO_ELEITOR)
            .numeroCarteiraTrabalho(DEFAULT_NUMERO_CARTEIRA_TRABALHO)
            .serieCarteiraTrabalho(DEFAULT_SERIE_CARTEIRA_TRABALHO)
            .ufCarteiraTrabalho(DEFAULT_UF_CARTEIRA_TRABALHO)
            .nire(DEFAULT_NIRE)
            .cnpj(DEFAULT_CNPJ);
        return diarista;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Diarista createUpdatedEntity(EntityManager em) {
        Diarista diarista = new Diarista()
            .nome(UPDATED_NOME)
            .rg(UPDATED_RG)
            .cpf(UPDATED_CPF)
            .cep(UPDATED_CEP)
            .logradouro(UPDATED_LOGRADOURO)
            .localidade(UPDATED_LOCALIDADE)
            .bairro(UPDATED_BAIRRO)
            .uf(UPDATED_UF)
            .complemento(UPDATED_COMPLEMENTO)
            .numero(UPDATED_NUMERO)
            .ddd(UPDATED_DDD)
            .telefone(UPDATED_TELEFONE)
            .email(UPDATED_EMAIL)
            .nomeContato(UPDATED_NOME_CONTATO)
            .dddContato(UPDATED_DDD_CONTATO)
            .telefoneContato(UPDATED_TELEFONE_CONTATO)
            .dataNascimento(UPDATED_DATA_NASCIMENTO)
            .cargo(UPDATED_CARGO)
            .dataAdmissao(UPDATED_DATA_ADMISSAO)
            .dataSaida(UPDATED_DATA_SAIDA)
            .tamanhoCamisa(UPDATED_TAMANHO_CAMISA)
            .pis(UPDATED_PIS)
            .cartaoCidadado(UPDATED_CARTAO_CIDADADO)
            .numeroTituloEleitor(UPDATED_NUMERO_TITULO_ELEITOR)
            .zonaTituloEleitor(UPDATED_ZONA_TITULO_ELEITOR)
            .secaoTituloEleitor(UPDATED_SECAO_TITULO_ELEITOR)
            .numeroCarteiraTrabalho(UPDATED_NUMERO_CARTEIRA_TRABALHO)
            .serieCarteiraTrabalho(UPDATED_SERIE_CARTEIRA_TRABALHO)
            .ufCarteiraTrabalho(UPDATED_UF_CARTEIRA_TRABALHO)
            .nire(UPDATED_NIRE)
            .cnpj(UPDATED_CNPJ);
        return diarista;
    }

    @BeforeEach
    public void initTest() {
        diarista = createEntity(em);
    }

    @Test
    @Transactional
    public void createDiarista() throws Exception {
        int databaseSizeBeforeCreate = diaristaRepository.findAll().size();

        // Create the Diarista
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);
        restDiaristaMockMvc.perform(post("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isCreated());

        // Validate the Diarista in the database
        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeCreate + 1);
        Diarista testDiarista = diaristaList.get(diaristaList.size() - 1);
        assertThat(testDiarista.getNome()).isEqualTo(DEFAULT_NOME);
        assertThat(testDiarista.getRg()).isEqualTo(DEFAULT_RG);
        assertThat(testDiarista.getCpf()).isEqualTo(DEFAULT_CPF);
        assertThat(testDiarista.getCep()).isEqualTo(DEFAULT_CEP);
        assertThat(testDiarista.getLogradouro()).isEqualTo(DEFAULT_LOGRADOURO);
        assertThat(testDiarista.getLocalidade()).isEqualTo(DEFAULT_LOCALIDADE);
        assertThat(testDiarista.getBairro()).isEqualTo(DEFAULT_BAIRRO);
        assertThat(testDiarista.getUf()).isEqualTo(DEFAULT_UF);
        assertThat(testDiarista.getComplemento()).isEqualTo(DEFAULT_COMPLEMENTO);
        assertThat(testDiarista.getNumero()).isEqualTo(DEFAULT_NUMERO);
        assertThat(testDiarista.getDdd()).isEqualTo(DEFAULT_DDD);
        assertThat(testDiarista.getTelefone()).isEqualTo(DEFAULT_TELEFONE);
        assertThat(testDiarista.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(testDiarista.getNomeContato()).isEqualTo(DEFAULT_NOME_CONTATO);
        assertThat(testDiarista.getDddContato()).isEqualTo(DEFAULT_DDD_CONTATO);
        assertThat(testDiarista.getTelefoneContato()).isEqualTo(DEFAULT_TELEFONE_CONTATO);
        assertThat(testDiarista.getDataNascimento()).isEqualTo(DEFAULT_DATA_NASCIMENTO);
        assertThat(testDiarista.getCargo()).isEqualTo(DEFAULT_CARGO);
        assertThat(testDiarista.getDataAdmissao()).isEqualTo(DEFAULT_DATA_ADMISSAO);
        assertThat(testDiarista.getDataSaida()).isEqualTo(DEFAULT_DATA_SAIDA);
        assertThat(testDiarista.getTamanhoCamisa()).isEqualTo(DEFAULT_TAMANHO_CAMISA);
        assertThat(testDiarista.getPis()).isEqualTo(DEFAULT_PIS);
        assertThat(testDiarista.getCartaoCidadado()).isEqualTo(DEFAULT_CARTAO_CIDADADO);
        assertThat(testDiarista.getNumeroTituloEleitor()).isEqualTo(DEFAULT_NUMERO_TITULO_ELEITOR);
        assertThat(testDiarista.getZonaTituloEleitor()).isEqualTo(DEFAULT_ZONA_TITULO_ELEITOR);
        assertThat(testDiarista.getSecaoTituloEleitor()).isEqualTo(DEFAULT_SECAO_TITULO_ELEITOR);
        assertThat(testDiarista.getNumeroCarteiraTrabalho()).isEqualTo(DEFAULT_NUMERO_CARTEIRA_TRABALHO);
        assertThat(testDiarista.getSerieCarteiraTrabalho()).isEqualTo(DEFAULT_SERIE_CARTEIRA_TRABALHO);
        assertThat(testDiarista.getUfCarteiraTrabalho()).isEqualTo(DEFAULT_UF_CARTEIRA_TRABALHO);
        assertThat(testDiarista.getNire()).isEqualTo(DEFAULT_NIRE);
        assertThat(testDiarista.getCnpj()).isEqualTo(DEFAULT_CNPJ);
    }

    @Test
    @Transactional
    public void createDiaristaWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = diaristaRepository.findAll().size();

        // Create the Diarista with an existing ID
        diarista.setId(1L);
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);

        // An entity with an existing ID cannot be created, so this API call must fail
        restDiaristaMockMvc.perform(post("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Diarista in the database
        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkNomeIsRequired() throws Exception {
        int databaseSizeBeforeTest = diaristaRepository.findAll().size();
        // set the field null
        diarista.setNome(null);

        // Create the Diarista, which fails.
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);

        restDiaristaMockMvc.perform(post("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isBadRequest());

        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkRgIsRequired() throws Exception {
        int databaseSizeBeforeTest = diaristaRepository.findAll().size();
        // set the field null
        diarista.setRg(null);

        // Create the Diarista, which fails.
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);

        restDiaristaMockMvc.perform(post("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isBadRequest());

        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCpfIsRequired() throws Exception {
        int databaseSizeBeforeTest = diaristaRepository.findAll().size();
        // set the field null
        diarista.setCpf(null);

        // Create the Diarista, which fails.
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);

        restDiaristaMockMvc.perform(post("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isBadRequest());

        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCepIsRequired() throws Exception {
        int databaseSizeBeforeTest = diaristaRepository.findAll().size();
        // set the field null
        diarista.setCep(null);

        // Create the Diarista, which fails.
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);

        restDiaristaMockMvc.perform(post("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isBadRequest());

        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkLogradouroIsRequired() throws Exception {
        int databaseSizeBeforeTest = diaristaRepository.findAll().size();
        // set the field null
        diarista.setLogradouro(null);

        // Create the Diarista, which fails.
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);

        restDiaristaMockMvc.perform(post("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isBadRequest());

        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkLocalidadeIsRequired() throws Exception {
        int databaseSizeBeforeTest = diaristaRepository.findAll().size();
        // set the field null
        diarista.setLocalidade(null);

        // Create the Diarista, which fails.
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);

        restDiaristaMockMvc.perform(post("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isBadRequest());

        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkBairroIsRequired() throws Exception {
        int databaseSizeBeforeTest = diaristaRepository.findAll().size();
        // set the field null
        diarista.setBairro(null);

        // Create the Diarista, which fails.
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);

        restDiaristaMockMvc.perform(post("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isBadRequest());

        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkUfIsRequired() throws Exception {
        int databaseSizeBeforeTest = diaristaRepository.findAll().size();
        // set the field null
        diarista.setUf(null);

        // Create the Diarista, which fails.
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);

        restDiaristaMockMvc.perform(post("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isBadRequest());

        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkNumeroIsRequired() throws Exception {
        int databaseSizeBeforeTest = diaristaRepository.findAll().size();
        // set the field null
        diarista.setNumero(null);

        // Create the Diarista, which fails.
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);

        restDiaristaMockMvc.perform(post("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isBadRequest());

        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDddIsRequired() throws Exception {
        int databaseSizeBeforeTest = diaristaRepository.findAll().size();
        // set the field null
        diarista.setDdd(null);

        // Create the Diarista, which fails.
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);

        restDiaristaMockMvc.perform(post("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isBadRequest());

        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkTelefoneIsRequired() throws Exception {
        int databaseSizeBeforeTest = diaristaRepository.findAll().size();
        // set the field null
        diarista.setTelefone(null);

        // Create the Diarista, which fails.
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);

        restDiaristaMockMvc.perform(post("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isBadRequest());

        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkEmailIsRequired() throws Exception {
        int databaseSizeBeforeTest = diaristaRepository.findAll().size();
        // set the field null
        diarista.setEmail(null);

        // Create the Diarista, which fails.
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);

        restDiaristaMockMvc.perform(post("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isBadRequest());

        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkNomeContatoIsRequired() throws Exception {
        int databaseSizeBeforeTest = diaristaRepository.findAll().size();
        // set the field null
        diarista.setNomeContato(null);

        // Create the Diarista, which fails.
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);

        restDiaristaMockMvc.perform(post("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isBadRequest());

        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDddContatoIsRequired() throws Exception {
        int databaseSizeBeforeTest = diaristaRepository.findAll().size();
        // set the field null
        diarista.setDddContato(null);

        // Create the Diarista, which fails.
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);

        restDiaristaMockMvc.perform(post("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isBadRequest());

        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkTelefoneContatoIsRequired() throws Exception {
        int databaseSizeBeforeTest = diaristaRepository.findAll().size();
        // set the field null
        diarista.setTelefoneContato(null);

        // Create the Diarista, which fails.
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);

        restDiaristaMockMvc.perform(post("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isBadRequest());

        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDataNascimentoIsRequired() throws Exception {
        int databaseSizeBeforeTest = diaristaRepository.findAll().size();
        // set the field null
        diarista.setDataNascimento(null);

        // Create the Diarista, which fails.
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);

        restDiaristaMockMvc.perform(post("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isBadRequest());

        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCargoIsRequired() throws Exception {
        int databaseSizeBeforeTest = diaristaRepository.findAll().size();
        // set the field null
        diarista.setCargo(null);

        // Create the Diarista, which fails.
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);

        restDiaristaMockMvc.perform(post("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isBadRequest());

        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDataAdmissaoIsRequired() throws Exception {
        int databaseSizeBeforeTest = diaristaRepository.findAll().size();
        // set the field null
        diarista.setDataAdmissao(null);

        // Create the Diarista, which fails.
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);

        restDiaristaMockMvc.perform(post("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isBadRequest());

        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkTamanhoCamisaIsRequired() throws Exception {
        int databaseSizeBeforeTest = diaristaRepository.findAll().size();
        // set the field null
        diarista.setTamanhoCamisa(null);

        // Create the Diarista, which fails.
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);

        restDiaristaMockMvc.perform(post("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isBadRequest());

        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkPisIsRequired() throws Exception {
        int databaseSizeBeforeTest = diaristaRepository.findAll().size();
        // set the field null
        diarista.setPis(null);

        // Create the Diarista, which fails.
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);

        restDiaristaMockMvc.perform(post("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isBadRequest());

        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCartaoCidadadoIsRequired() throws Exception {
        int databaseSizeBeforeTest = diaristaRepository.findAll().size();
        // set the field null
        diarista.setCartaoCidadado(null);

        // Create the Diarista, which fails.
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);

        restDiaristaMockMvc.perform(post("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isBadRequest());

        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkNumeroTituloEleitorIsRequired() throws Exception {
        int databaseSizeBeforeTest = diaristaRepository.findAll().size();
        // set the field null
        diarista.setNumeroTituloEleitor(null);

        // Create the Diarista, which fails.
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);

        restDiaristaMockMvc.perform(post("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isBadRequest());

        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkZonaTituloEleitorIsRequired() throws Exception {
        int databaseSizeBeforeTest = diaristaRepository.findAll().size();
        // set the field null
        diarista.setZonaTituloEleitor(null);

        // Create the Diarista, which fails.
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);

        restDiaristaMockMvc.perform(post("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isBadRequest());

        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkSecaoTituloEleitorIsRequired() throws Exception {
        int databaseSizeBeforeTest = diaristaRepository.findAll().size();
        // set the field null
        diarista.setSecaoTituloEleitor(null);

        // Create the Diarista, which fails.
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);

        restDiaristaMockMvc.perform(post("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isBadRequest());

        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkNumeroCarteiraTrabalhoIsRequired() throws Exception {
        int databaseSizeBeforeTest = diaristaRepository.findAll().size();
        // set the field null
        diarista.setNumeroCarteiraTrabalho(null);

        // Create the Diarista, which fails.
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);

        restDiaristaMockMvc.perform(post("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isBadRequest());

        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkSerieCarteiraTrabalhoIsRequired() throws Exception {
        int databaseSizeBeforeTest = diaristaRepository.findAll().size();
        // set the field null
        diarista.setSerieCarteiraTrabalho(null);

        // Create the Diarista, which fails.
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);

        restDiaristaMockMvc.perform(post("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isBadRequest());

        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkUfCarteiraTrabalhoIsRequired() throws Exception {
        int databaseSizeBeforeTest = diaristaRepository.findAll().size();
        // set the field null
        diarista.setUfCarteiraTrabalho(null);

        // Create the Diarista, which fails.
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);

        restDiaristaMockMvc.perform(post("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isBadRequest());

        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCnpjIsRequired() throws Exception {
        int databaseSizeBeforeTest = diaristaRepository.findAll().size();
        // set the field null
        diarista.setCnpj(null);

        // Create the Diarista, which fails.
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);

        restDiaristaMockMvc.perform(post("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isBadRequest());

        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllDiaristas() throws Exception {
        // Initialize the database
        diaristaRepository.saveAndFlush(diarista);

        // Get all the diaristaList
        restDiaristaMockMvc.perform(get("/api/diaristas?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(diarista.getId().intValue())))
            .andExpect(jsonPath("$.[*].nome").value(hasItem(DEFAULT_NOME.toString())))
            .andExpect(jsonPath("$.[*].rg").value(hasItem(DEFAULT_RG.toString())))
            .andExpect(jsonPath("$.[*].cpf").value(hasItem(DEFAULT_CPF.toString())))
            .andExpect(jsonPath("$.[*].cep").value(hasItem(DEFAULT_CEP.toString())))
            .andExpect(jsonPath("$.[*].logradouro").value(hasItem(DEFAULT_LOGRADOURO.toString())))
            .andExpect(jsonPath("$.[*].localidade").value(hasItem(DEFAULT_LOCALIDADE.toString())))
            .andExpect(jsonPath("$.[*].bairro").value(hasItem(DEFAULT_BAIRRO.toString())))
            .andExpect(jsonPath("$.[*].uf").value(hasItem(DEFAULT_UF.toString())))
            .andExpect(jsonPath("$.[*].complemento").value(hasItem(DEFAULT_COMPLEMENTO.toString())))
            .andExpect(jsonPath("$.[*].numero").value(hasItem(DEFAULT_NUMERO.toString())))
            .andExpect(jsonPath("$.[*].ddd").value(hasItem(DEFAULT_DDD.toString())))
            .andExpect(jsonPath("$.[*].telefone").value(hasItem(DEFAULT_TELEFONE.toString())))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL.toString())))
            .andExpect(jsonPath("$.[*].nomeContato").value(hasItem(DEFAULT_NOME_CONTATO.toString())))
            .andExpect(jsonPath("$.[*].dddContato").value(hasItem(DEFAULT_DDD_CONTATO.toString())))
            .andExpect(jsonPath("$.[*].telefoneContato").value(hasItem(DEFAULT_TELEFONE_CONTATO.toString())))
            .andExpect(jsonPath("$.[*].dataNascimento").value(hasItem(DEFAULT_DATA_NASCIMENTO.toString())))
            .andExpect(jsonPath("$.[*].cargo").value(hasItem(DEFAULT_CARGO.toString())))
            .andExpect(jsonPath("$.[*].dataAdmissao").value(hasItem(DEFAULT_DATA_ADMISSAO.toString())))
            .andExpect(jsonPath("$.[*].dataSaida").value(hasItem(DEFAULT_DATA_SAIDA.toString())))
            .andExpect(jsonPath("$.[*].tamanhoCamisa").value(hasItem(DEFAULT_TAMANHO_CAMISA.toString())))
            .andExpect(jsonPath("$.[*].pis").value(hasItem(DEFAULT_PIS.toString())))
            .andExpect(jsonPath("$.[*].cartaoCidadado").value(hasItem(DEFAULT_CARTAO_CIDADADO.toString())))
            .andExpect(jsonPath("$.[*].numeroTituloEleitor").value(hasItem(DEFAULT_NUMERO_TITULO_ELEITOR.toString())))
            .andExpect(jsonPath("$.[*].zonaTituloEleitor").value(hasItem(DEFAULT_ZONA_TITULO_ELEITOR.toString())))
            .andExpect(jsonPath("$.[*].secaoTituloEleitor").value(hasItem(DEFAULT_SECAO_TITULO_ELEITOR.toString())))
            .andExpect(jsonPath("$.[*].numeroCarteiraTrabalho").value(hasItem(DEFAULT_NUMERO_CARTEIRA_TRABALHO.toString())))
            .andExpect(jsonPath("$.[*].serieCarteiraTrabalho").value(hasItem(DEFAULT_SERIE_CARTEIRA_TRABALHO.toString())))
            .andExpect(jsonPath("$.[*].ufCarteiraTrabalho").value(hasItem(DEFAULT_UF_CARTEIRA_TRABALHO.toString())))
            .andExpect(jsonPath("$.[*].nire").value(hasItem(DEFAULT_NIRE.toString())))
            .andExpect(jsonPath("$.[*].cnpj").value(hasItem(DEFAULT_CNPJ.toString())));
    }
    
    @Test
    @Transactional
    public void getDiarista() throws Exception {
        // Initialize the database
        diaristaRepository.saveAndFlush(diarista);

        // Get the diarista
        restDiaristaMockMvc.perform(get("/api/diaristas/{id}", diarista.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(diarista.getId().intValue()))
            .andExpect(jsonPath("$.nome").value(DEFAULT_NOME.toString()))
            .andExpect(jsonPath("$.rg").value(DEFAULT_RG.toString()))
            .andExpect(jsonPath("$.cpf").value(DEFAULT_CPF.toString()))
            .andExpect(jsonPath("$.cep").value(DEFAULT_CEP.toString()))
            .andExpect(jsonPath("$.logradouro").value(DEFAULT_LOGRADOURO.toString()))
            .andExpect(jsonPath("$.localidade").value(DEFAULT_LOCALIDADE.toString()))
            .andExpect(jsonPath("$.bairro").value(DEFAULT_BAIRRO.toString()))
            .andExpect(jsonPath("$.uf").value(DEFAULT_UF.toString()))
            .andExpect(jsonPath("$.complemento").value(DEFAULT_COMPLEMENTO.toString()))
            .andExpect(jsonPath("$.numero").value(DEFAULT_NUMERO.toString()))
            .andExpect(jsonPath("$.ddd").value(DEFAULT_DDD.toString()))
            .andExpect(jsonPath("$.telefone").value(DEFAULT_TELEFONE.toString()))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL.toString()))
            .andExpect(jsonPath("$.nomeContato").value(DEFAULT_NOME_CONTATO.toString()))
            .andExpect(jsonPath("$.dddContato").value(DEFAULT_DDD_CONTATO.toString()))
            .andExpect(jsonPath("$.telefoneContato").value(DEFAULT_TELEFONE_CONTATO.toString()))
            .andExpect(jsonPath("$.dataNascimento").value(DEFAULT_DATA_NASCIMENTO.toString()))
            .andExpect(jsonPath("$.cargo").value(DEFAULT_CARGO.toString()))
            .andExpect(jsonPath("$.dataAdmissao").value(DEFAULT_DATA_ADMISSAO.toString()))
            .andExpect(jsonPath("$.dataSaida").value(DEFAULT_DATA_SAIDA.toString()))
            .andExpect(jsonPath("$.tamanhoCamisa").value(DEFAULT_TAMANHO_CAMISA.toString()))
            .andExpect(jsonPath("$.pis").value(DEFAULT_PIS.toString()))
            .andExpect(jsonPath("$.cartaoCidadado").value(DEFAULT_CARTAO_CIDADADO.toString()))
            .andExpect(jsonPath("$.numeroTituloEleitor").value(DEFAULT_NUMERO_TITULO_ELEITOR.toString()))
            .andExpect(jsonPath("$.zonaTituloEleitor").value(DEFAULT_ZONA_TITULO_ELEITOR.toString()))
            .andExpect(jsonPath("$.secaoTituloEleitor").value(DEFAULT_SECAO_TITULO_ELEITOR.toString()))
            .andExpect(jsonPath("$.numeroCarteiraTrabalho").value(DEFAULT_NUMERO_CARTEIRA_TRABALHO.toString()))
            .andExpect(jsonPath("$.serieCarteiraTrabalho").value(DEFAULT_SERIE_CARTEIRA_TRABALHO.toString()))
            .andExpect(jsonPath("$.ufCarteiraTrabalho").value(DEFAULT_UF_CARTEIRA_TRABALHO.toString()))
            .andExpect(jsonPath("$.nire").value(DEFAULT_NIRE.toString()))
            .andExpect(jsonPath("$.cnpj").value(DEFAULT_CNPJ.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingDiarista() throws Exception {
        // Get the diarista
        restDiaristaMockMvc.perform(get("/api/diaristas/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateDiarista() throws Exception {
        // Initialize the database
        diaristaRepository.saveAndFlush(diarista);

        int databaseSizeBeforeUpdate = diaristaRepository.findAll().size();

        // Update the diarista
        Diarista updatedDiarista = diaristaRepository.findById(diarista.getId()).get();
        // Disconnect from session so that the updates on updatedDiarista are not directly saved in db
        em.detach(updatedDiarista);
        updatedDiarista
            .nome(UPDATED_NOME)
            .rg(UPDATED_RG)
            .cpf(UPDATED_CPF)
            .cep(UPDATED_CEP)
            .logradouro(UPDATED_LOGRADOURO)
            .localidade(UPDATED_LOCALIDADE)
            .bairro(UPDATED_BAIRRO)
            .uf(UPDATED_UF)
            .complemento(UPDATED_COMPLEMENTO)
            .numero(UPDATED_NUMERO)
            .ddd(UPDATED_DDD)
            .telefone(UPDATED_TELEFONE)
            .email(UPDATED_EMAIL)
            .nomeContato(UPDATED_NOME_CONTATO)
            .dddContato(UPDATED_DDD_CONTATO)
            .telefoneContato(UPDATED_TELEFONE_CONTATO)
            .dataNascimento(UPDATED_DATA_NASCIMENTO)
            .cargo(UPDATED_CARGO)
            .dataAdmissao(UPDATED_DATA_ADMISSAO)
            .dataSaida(UPDATED_DATA_SAIDA)
            .tamanhoCamisa(UPDATED_TAMANHO_CAMISA)
            .pis(UPDATED_PIS)
            .cartaoCidadado(UPDATED_CARTAO_CIDADADO)
            .numeroTituloEleitor(UPDATED_NUMERO_TITULO_ELEITOR)
            .zonaTituloEleitor(UPDATED_ZONA_TITULO_ELEITOR)
            .secaoTituloEleitor(UPDATED_SECAO_TITULO_ELEITOR)
            .numeroCarteiraTrabalho(UPDATED_NUMERO_CARTEIRA_TRABALHO)
            .serieCarteiraTrabalho(UPDATED_SERIE_CARTEIRA_TRABALHO)
            .ufCarteiraTrabalho(UPDATED_UF_CARTEIRA_TRABALHO)
            .nire(UPDATED_NIRE)
            .cnpj(UPDATED_CNPJ);
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(updatedDiarista);

        restDiaristaMockMvc.perform(put("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isOk());

        // Validate the Diarista in the database
        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeUpdate);
        Diarista testDiarista = diaristaList.get(diaristaList.size() - 1);
        assertThat(testDiarista.getNome()).isEqualTo(UPDATED_NOME);
        assertThat(testDiarista.getRg()).isEqualTo(UPDATED_RG);
        assertThat(testDiarista.getCpf()).isEqualTo(UPDATED_CPF);
        assertThat(testDiarista.getCep()).isEqualTo(UPDATED_CEP);
        assertThat(testDiarista.getLogradouro()).isEqualTo(UPDATED_LOGRADOURO);
        assertThat(testDiarista.getLocalidade()).isEqualTo(UPDATED_LOCALIDADE);
        assertThat(testDiarista.getBairro()).isEqualTo(UPDATED_BAIRRO);
        assertThat(testDiarista.getUf()).isEqualTo(UPDATED_UF);
        assertThat(testDiarista.getComplemento()).isEqualTo(UPDATED_COMPLEMENTO);
        assertThat(testDiarista.getNumero()).isEqualTo(UPDATED_NUMERO);
        assertThat(testDiarista.getDdd()).isEqualTo(UPDATED_DDD);
        assertThat(testDiarista.getTelefone()).isEqualTo(UPDATED_TELEFONE);
        assertThat(testDiarista.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testDiarista.getNomeContato()).isEqualTo(UPDATED_NOME_CONTATO);
        assertThat(testDiarista.getDddContato()).isEqualTo(UPDATED_DDD_CONTATO);
        assertThat(testDiarista.getTelefoneContato()).isEqualTo(UPDATED_TELEFONE_CONTATO);
        assertThat(testDiarista.getDataNascimento()).isEqualTo(UPDATED_DATA_NASCIMENTO);
        assertThat(testDiarista.getCargo()).isEqualTo(UPDATED_CARGO);
        assertThat(testDiarista.getDataAdmissao()).isEqualTo(UPDATED_DATA_ADMISSAO);
        assertThat(testDiarista.getDataSaida()).isEqualTo(UPDATED_DATA_SAIDA);
        assertThat(testDiarista.getTamanhoCamisa()).isEqualTo(UPDATED_TAMANHO_CAMISA);
        assertThat(testDiarista.getPis()).isEqualTo(UPDATED_PIS);
        assertThat(testDiarista.getCartaoCidadado()).isEqualTo(UPDATED_CARTAO_CIDADADO);
        assertThat(testDiarista.getNumeroTituloEleitor()).isEqualTo(UPDATED_NUMERO_TITULO_ELEITOR);
        assertThat(testDiarista.getZonaTituloEleitor()).isEqualTo(UPDATED_ZONA_TITULO_ELEITOR);
        assertThat(testDiarista.getSecaoTituloEleitor()).isEqualTo(UPDATED_SECAO_TITULO_ELEITOR);
        assertThat(testDiarista.getNumeroCarteiraTrabalho()).isEqualTo(UPDATED_NUMERO_CARTEIRA_TRABALHO);
        assertThat(testDiarista.getSerieCarteiraTrabalho()).isEqualTo(UPDATED_SERIE_CARTEIRA_TRABALHO);
        assertThat(testDiarista.getUfCarteiraTrabalho()).isEqualTo(UPDATED_UF_CARTEIRA_TRABALHO);
        assertThat(testDiarista.getNire()).isEqualTo(UPDATED_NIRE);
        assertThat(testDiarista.getCnpj()).isEqualTo(UPDATED_CNPJ);
    }

    @Test
    @Transactional
    public void updateNonExistingDiarista() throws Exception {
        int databaseSizeBeforeUpdate = diaristaRepository.findAll().size();

        // Create the Diarista
        DiaristaDTO diaristaDTO = diaristaMapper.toDto(diarista);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDiaristaMockMvc.perform(put("/api/diaristas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(diaristaDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Diarista in the database
        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteDiarista() throws Exception {
        // Initialize the database
        diaristaRepository.saveAndFlush(diarista);

        int databaseSizeBeforeDelete = diaristaRepository.findAll().size();

        // Delete the diarista
        restDiaristaMockMvc.perform(delete("/api/diaristas/{id}", diarista.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database is empty
        List<Diarista> diaristaList = diaristaRepository.findAll();
        assertThat(diaristaList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Diarista.class);
        Diarista diarista1 = new Diarista();
        diarista1.setId(1L);
        Diarista diarista2 = new Diarista();
        diarista2.setId(diarista1.getId());
        assertThat(diarista1).isEqualTo(diarista2);
        diarista2.setId(2L);
        assertThat(diarista1).isNotEqualTo(diarista2);
        diarista1.setId(null);
        assertThat(diarista1).isNotEqualTo(diarista2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DiaristaDTO.class);
        DiaristaDTO diaristaDTO1 = new DiaristaDTO();
        diaristaDTO1.setId(1L);
        DiaristaDTO diaristaDTO2 = new DiaristaDTO();
        assertThat(diaristaDTO1).isNotEqualTo(diaristaDTO2);
        diaristaDTO2.setId(diaristaDTO1.getId());
        assertThat(diaristaDTO1).isEqualTo(diaristaDTO2);
        diaristaDTO2.setId(2L);
        assertThat(diaristaDTO1).isNotEqualTo(diaristaDTO2);
        diaristaDTO1.setId(null);
        assertThat(diaristaDTO1).isNotEqualTo(diaristaDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(diaristaMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(diaristaMapper.fromId(null)).isNull();
    }
}
