package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.TesteApp;
import io.github.jhipster.application.domain.Cliente;
import io.github.jhipster.application.repository.ClienteRepository;
import io.github.jhipster.application.service.ClienteService;
import io.github.jhipster.application.service.dto.ClienteDTO;
import io.github.jhipster.application.service.mapper.ClienteMapper;
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

import io.github.jhipster.application.domain.enumeration.TipoPessoa;
import io.github.jhipster.application.domain.enumeration.UF;
/**
 * Integration tests for the {@Link ClienteResource} REST controller.
 */
@SpringBootTest(classes = TesteApp.class)
public class ClienteResourceIT {

    private static final TipoPessoa DEFAULT_TIPO = TipoPessoa.PESSOA_FISICA;
    private static final TipoPessoa UPDATED_TIPO = TipoPessoa.PESSOA_JURIDICA;

    private static final String DEFAULT_NOME = "AAAAAAAAAA";
    private static final String UPDATED_NOME = "BBBBBBBBBB";

    private static final String DEFAULT_RG = "AAAAAAAAAA";
    private static final String UPDATED_RG = "BBBBBBBBBB";

    private static final String DEFAULT_CPF = "5";
    private static final String UPDATED_CPF = "1";

    private static final String DEFAULT_CFDF = "8";
    private static final String UPDATED_CFDF = "56";

    private static final String DEFAULT_CNPJ = "1";
    private static final String UPDATED_CNPJ = "5";

    private static final LocalDate DEFAULT_DATA_NASCIMENTO = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATA_NASCIMENTO = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATA_CRIACAO = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATA_CRIACAO = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATA_CADASTRO = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATA_CADASTRO = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_PROFISSAO = "AAAAAAAAAA";
    private static final String UPDATED_PROFISSAO = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_DDD = "58";
    private static final String UPDATED_DDD = "50";

    private static final String DEFAULT_TELEFONE = "7";
    private static final String UPDATED_TELEFONE = "98";

    private static final String DEFAULT_CEP = "25";
    private static final String UPDATED_CEP = "91";

    private static final String DEFAULT_LOGRADOURO = "AAAAAAAAAA";
    private static final String UPDATED_LOGRADOURO = "BBBBBBBBBB";

    private static final String DEFAULT_LOCALIDADE = "AAAAAAAAAA";
    private static final String UPDATED_LOCALIDADE = "BBBBBBBBBB";

    private static final String DEFAULT_BAIRRO = "AAAAAAAAAA";
    private static final String UPDATED_BAIRRO = "BBBBBBBBBB";

    private static final String DEFAULT_COMPLEMENTO = "AAAAAAAAAA";
    private static final String UPDATED_COMPLEMENTO = "BBBBBBBBBB";

    private static final UF DEFAULT_UF = UF.AC;
    private static final UF UPDATED_UF = UF.AL;

    private static final String DEFAULT_NUMERO = "AAAAAAAAAA";
    private static final String UPDATED_NUMERO = "BBBBBBBBBB";

    private static final String DEFAULT_PONTOS_REFERENCIA_ENDERECO = "AAAAAAAAAA";
    private static final String UPDATED_PONTOS_REFERENCIA_ENDERECO = "BBBBBBBBBB";

    private static final String DEFAULT_ESTACAO_METRO_MAIS_PROXIMA = "AAAAAAAAAA";
    private static final String UPDATED_ESTACAO_METRO_MAIS_PROXIMA = "BBBBBBBBBB";

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private ClienteService clienteService;

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

    private MockMvc restClienteMockMvc;

    private Cliente cliente;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ClienteResource clienteResource = new ClienteResource(clienteService);
        this.restClienteMockMvc = MockMvcBuilders.standaloneSetup(clienteResource)
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
    public static Cliente createEntity(EntityManager em) {
        Cliente cliente = new Cliente()
            .tipo(DEFAULT_TIPO)
            .nome(DEFAULT_NOME)
            .rg(DEFAULT_RG)
            .cpf(DEFAULT_CPF)
            .cfdf(DEFAULT_CFDF)
            .cnpj(DEFAULT_CNPJ)
            .dataNascimento(DEFAULT_DATA_NASCIMENTO)
            .dataCriacao(DEFAULT_DATA_CRIACAO)
            .dataCadastro(DEFAULT_DATA_CADASTRO)
            .profissao(DEFAULT_PROFISSAO)
            .email(DEFAULT_EMAIL)
            .ddd(DEFAULT_DDD)
            .telefone(DEFAULT_TELEFONE)
            .cep(DEFAULT_CEP)
            .logradouro(DEFAULT_LOGRADOURO)
            .localidade(DEFAULT_LOCALIDADE)
            .bairro(DEFAULT_BAIRRO)
            .complemento(DEFAULT_COMPLEMENTO)
            .uf(DEFAULT_UF)
            .numero(DEFAULT_NUMERO)
            .pontosReferenciaEndereco(DEFAULT_PONTOS_REFERENCIA_ENDERECO)
            .estacaoMetroMaisProxima(DEFAULT_ESTACAO_METRO_MAIS_PROXIMA);
        return cliente;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Cliente createUpdatedEntity(EntityManager em) {
        Cliente cliente = new Cliente()
            .tipo(UPDATED_TIPO)
            .nome(UPDATED_NOME)
            .rg(UPDATED_RG)
            .cpf(UPDATED_CPF)
            .cfdf(UPDATED_CFDF)
            .cnpj(UPDATED_CNPJ)
            .dataNascimento(UPDATED_DATA_NASCIMENTO)
            .dataCriacao(UPDATED_DATA_CRIACAO)
            .dataCadastro(UPDATED_DATA_CADASTRO)
            .profissao(UPDATED_PROFISSAO)
            .email(UPDATED_EMAIL)
            .ddd(UPDATED_DDD)
            .telefone(UPDATED_TELEFONE)
            .cep(UPDATED_CEP)
            .logradouro(UPDATED_LOGRADOURO)
            .localidade(UPDATED_LOCALIDADE)
            .bairro(UPDATED_BAIRRO)
            .complemento(UPDATED_COMPLEMENTO)
            .uf(UPDATED_UF)
            .numero(UPDATED_NUMERO)
            .pontosReferenciaEndereco(UPDATED_PONTOS_REFERENCIA_ENDERECO)
            .estacaoMetroMaisProxima(UPDATED_ESTACAO_METRO_MAIS_PROXIMA);
        return cliente;
    }

    @BeforeEach
    public void initTest() {
        cliente = createEntity(em);
    }

    @Test
    @Transactional
    public void createCliente() throws Exception {
        int databaseSizeBeforeCreate = clienteRepository.findAll().size();

        // Create the Cliente
        ClienteDTO clienteDTO = clienteMapper.toDto(cliente);
        restClienteMockMvc.perform(post("/api/clientes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(clienteDTO)))
            .andExpect(status().isCreated());

        // Validate the Cliente in the database
        List<Cliente> clienteList = clienteRepository.findAll();
        assertThat(clienteList).hasSize(databaseSizeBeforeCreate + 1);
        Cliente testCliente = clienteList.get(clienteList.size() - 1);
        assertThat(testCliente.getTipo()).isEqualTo(DEFAULT_TIPO);
        assertThat(testCliente.getNome()).isEqualTo(DEFAULT_NOME);
        assertThat(testCliente.getRg()).isEqualTo(DEFAULT_RG);
        assertThat(testCliente.getCpf()).isEqualTo(DEFAULT_CPF);
        assertThat(testCliente.getCfdf()).isEqualTo(DEFAULT_CFDF);
        assertThat(testCliente.getCnpj()).isEqualTo(DEFAULT_CNPJ);
        assertThat(testCliente.getDataNascimento()).isEqualTo(DEFAULT_DATA_NASCIMENTO);
        assertThat(testCliente.getDataCriacao()).isEqualTo(DEFAULT_DATA_CRIACAO);
        assertThat(testCliente.getDataCadastro()).isEqualTo(DEFAULT_DATA_CADASTRO);
        assertThat(testCliente.getProfissao()).isEqualTo(DEFAULT_PROFISSAO);
        assertThat(testCliente.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(testCliente.getDdd()).isEqualTo(DEFAULT_DDD);
        assertThat(testCliente.getTelefone()).isEqualTo(DEFAULT_TELEFONE);
        assertThat(testCliente.getCep()).isEqualTo(DEFAULT_CEP);
        assertThat(testCliente.getLogradouro()).isEqualTo(DEFAULT_LOGRADOURO);
        assertThat(testCliente.getLocalidade()).isEqualTo(DEFAULT_LOCALIDADE);
        assertThat(testCliente.getBairro()).isEqualTo(DEFAULT_BAIRRO);
        assertThat(testCliente.getComplemento()).isEqualTo(DEFAULT_COMPLEMENTO);
        assertThat(testCliente.getUf()).isEqualTo(DEFAULT_UF);
        assertThat(testCliente.getNumero()).isEqualTo(DEFAULT_NUMERO);
        assertThat(testCliente.getPontosReferenciaEndereco()).isEqualTo(DEFAULT_PONTOS_REFERENCIA_ENDERECO);
        assertThat(testCliente.getEstacaoMetroMaisProxima()).isEqualTo(DEFAULT_ESTACAO_METRO_MAIS_PROXIMA);
    }

    @Test
    @Transactional
    public void createClienteWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = clienteRepository.findAll().size();

        // Create the Cliente with an existing ID
        cliente.setId(1L);
        ClienteDTO clienteDTO = clienteMapper.toDto(cliente);

        // An entity with an existing ID cannot be created, so this API call must fail
        restClienteMockMvc.perform(post("/api/clientes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(clienteDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Cliente in the database
        List<Cliente> clienteList = clienteRepository.findAll();
        assertThat(clienteList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkTipoIsRequired() throws Exception {
        int databaseSizeBeforeTest = clienteRepository.findAll().size();
        // set the field null
        cliente.setTipo(null);

        // Create the Cliente, which fails.
        ClienteDTO clienteDTO = clienteMapper.toDto(cliente);

        restClienteMockMvc.perform(post("/api/clientes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(clienteDTO)))
            .andExpect(status().isBadRequest());

        List<Cliente> clienteList = clienteRepository.findAll();
        assertThat(clienteList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkNomeIsRequired() throws Exception {
        int databaseSizeBeforeTest = clienteRepository.findAll().size();
        // set the field null
        cliente.setNome(null);

        // Create the Cliente, which fails.
        ClienteDTO clienteDTO = clienteMapper.toDto(cliente);

        restClienteMockMvc.perform(post("/api/clientes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(clienteDTO)))
            .andExpect(status().isBadRequest());

        List<Cliente> clienteList = clienteRepository.findAll();
        assertThat(clienteList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDataCadastroIsRequired() throws Exception {
        int databaseSizeBeforeTest = clienteRepository.findAll().size();
        // set the field null
        cliente.setDataCadastro(null);

        // Create the Cliente, which fails.
        ClienteDTO clienteDTO = clienteMapper.toDto(cliente);

        restClienteMockMvc.perform(post("/api/clientes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(clienteDTO)))
            .andExpect(status().isBadRequest());

        List<Cliente> clienteList = clienteRepository.findAll();
        assertThat(clienteList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkEmailIsRequired() throws Exception {
        int databaseSizeBeforeTest = clienteRepository.findAll().size();
        // set the field null
        cliente.setEmail(null);

        // Create the Cliente, which fails.
        ClienteDTO clienteDTO = clienteMapper.toDto(cliente);

        restClienteMockMvc.perform(post("/api/clientes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(clienteDTO)))
            .andExpect(status().isBadRequest());

        List<Cliente> clienteList = clienteRepository.findAll();
        assertThat(clienteList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDddIsRequired() throws Exception {
        int databaseSizeBeforeTest = clienteRepository.findAll().size();
        // set the field null
        cliente.setDdd(null);

        // Create the Cliente, which fails.
        ClienteDTO clienteDTO = clienteMapper.toDto(cliente);

        restClienteMockMvc.perform(post("/api/clientes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(clienteDTO)))
            .andExpect(status().isBadRequest());

        List<Cliente> clienteList = clienteRepository.findAll();
        assertThat(clienteList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkTelefoneIsRequired() throws Exception {
        int databaseSizeBeforeTest = clienteRepository.findAll().size();
        // set the field null
        cliente.setTelefone(null);

        // Create the Cliente, which fails.
        ClienteDTO clienteDTO = clienteMapper.toDto(cliente);

        restClienteMockMvc.perform(post("/api/clientes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(clienteDTO)))
            .andExpect(status().isBadRequest());

        List<Cliente> clienteList = clienteRepository.findAll();
        assertThat(clienteList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCepIsRequired() throws Exception {
        int databaseSizeBeforeTest = clienteRepository.findAll().size();
        // set the field null
        cliente.setCep(null);

        // Create the Cliente, which fails.
        ClienteDTO clienteDTO = clienteMapper.toDto(cliente);

        restClienteMockMvc.perform(post("/api/clientes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(clienteDTO)))
            .andExpect(status().isBadRequest());

        List<Cliente> clienteList = clienteRepository.findAll();
        assertThat(clienteList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkLogradouroIsRequired() throws Exception {
        int databaseSizeBeforeTest = clienteRepository.findAll().size();
        // set the field null
        cliente.setLogradouro(null);

        // Create the Cliente, which fails.
        ClienteDTO clienteDTO = clienteMapper.toDto(cliente);

        restClienteMockMvc.perform(post("/api/clientes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(clienteDTO)))
            .andExpect(status().isBadRequest());

        List<Cliente> clienteList = clienteRepository.findAll();
        assertThat(clienteList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkLocalidadeIsRequired() throws Exception {
        int databaseSizeBeforeTest = clienteRepository.findAll().size();
        // set the field null
        cliente.setLocalidade(null);

        // Create the Cliente, which fails.
        ClienteDTO clienteDTO = clienteMapper.toDto(cliente);

        restClienteMockMvc.perform(post("/api/clientes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(clienteDTO)))
            .andExpect(status().isBadRequest());

        List<Cliente> clienteList = clienteRepository.findAll();
        assertThat(clienteList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkBairroIsRequired() throws Exception {
        int databaseSizeBeforeTest = clienteRepository.findAll().size();
        // set the field null
        cliente.setBairro(null);

        // Create the Cliente, which fails.
        ClienteDTO clienteDTO = clienteMapper.toDto(cliente);

        restClienteMockMvc.perform(post("/api/clientes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(clienteDTO)))
            .andExpect(status().isBadRequest());

        List<Cliente> clienteList = clienteRepository.findAll();
        assertThat(clienteList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkUfIsRequired() throws Exception {
        int databaseSizeBeforeTest = clienteRepository.findAll().size();
        // set the field null
        cliente.setUf(null);

        // Create the Cliente, which fails.
        ClienteDTO clienteDTO = clienteMapper.toDto(cliente);

        restClienteMockMvc.perform(post("/api/clientes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(clienteDTO)))
            .andExpect(status().isBadRequest());

        List<Cliente> clienteList = clienteRepository.findAll();
        assertThat(clienteList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkNumeroIsRequired() throws Exception {
        int databaseSizeBeforeTest = clienteRepository.findAll().size();
        // set the field null
        cliente.setNumero(null);

        // Create the Cliente, which fails.
        ClienteDTO clienteDTO = clienteMapper.toDto(cliente);

        restClienteMockMvc.perform(post("/api/clientes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(clienteDTO)))
            .andExpect(status().isBadRequest());

        List<Cliente> clienteList = clienteRepository.findAll();
        assertThat(clienteList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllClientes() throws Exception {
        // Initialize the database
        clienteRepository.saveAndFlush(cliente);

        // Get all the clienteList
        restClienteMockMvc.perform(get("/api/clientes?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(cliente.getId().intValue())))
            .andExpect(jsonPath("$.[*].tipo").value(hasItem(DEFAULT_TIPO.toString())))
            .andExpect(jsonPath("$.[*].nome").value(hasItem(DEFAULT_NOME.toString())))
            .andExpect(jsonPath("$.[*].rg").value(hasItem(DEFAULT_RG.toString())))
            .andExpect(jsonPath("$.[*].cpf").value(hasItem(DEFAULT_CPF.toString())))
            .andExpect(jsonPath("$.[*].cfdf").value(hasItem(DEFAULT_CFDF.toString())))
            .andExpect(jsonPath("$.[*].cnpj").value(hasItem(DEFAULT_CNPJ.toString())))
            .andExpect(jsonPath("$.[*].dataNascimento").value(hasItem(DEFAULT_DATA_NASCIMENTO.toString())))
            .andExpect(jsonPath("$.[*].dataCriacao").value(hasItem(DEFAULT_DATA_CRIACAO.toString())))
            .andExpect(jsonPath("$.[*].dataCadastro").value(hasItem(DEFAULT_DATA_CADASTRO.toString())))
            .andExpect(jsonPath("$.[*].profissao").value(hasItem(DEFAULT_PROFISSAO.toString())))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL.toString())))
            .andExpect(jsonPath("$.[*].ddd").value(hasItem(DEFAULT_DDD.toString())))
            .andExpect(jsonPath("$.[*].telefone").value(hasItem(DEFAULT_TELEFONE.toString())))
            .andExpect(jsonPath("$.[*].cep").value(hasItem(DEFAULT_CEP.toString())))
            .andExpect(jsonPath("$.[*].logradouro").value(hasItem(DEFAULT_LOGRADOURO.toString())))
            .andExpect(jsonPath("$.[*].localidade").value(hasItem(DEFAULT_LOCALIDADE.toString())))
            .andExpect(jsonPath("$.[*].bairro").value(hasItem(DEFAULT_BAIRRO.toString())))
            .andExpect(jsonPath("$.[*].complemento").value(hasItem(DEFAULT_COMPLEMENTO.toString())))
            .andExpect(jsonPath("$.[*].uf").value(hasItem(DEFAULT_UF.toString())))
            .andExpect(jsonPath("$.[*].numero").value(hasItem(DEFAULT_NUMERO.toString())))
            .andExpect(jsonPath("$.[*].pontosReferenciaEndereco").value(hasItem(DEFAULT_PONTOS_REFERENCIA_ENDERECO.toString())))
            .andExpect(jsonPath("$.[*].estacaoMetroMaisProxima").value(hasItem(DEFAULT_ESTACAO_METRO_MAIS_PROXIMA.toString())));
    }
    
    @Test
    @Transactional
    public void getCliente() throws Exception {
        // Initialize the database
        clienteRepository.saveAndFlush(cliente);

        // Get the cliente
        restClienteMockMvc.perform(get("/api/clientes/{id}", cliente.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(cliente.getId().intValue()))
            .andExpect(jsonPath("$.tipo").value(DEFAULT_TIPO.toString()))
            .andExpect(jsonPath("$.nome").value(DEFAULT_NOME.toString()))
            .andExpect(jsonPath("$.rg").value(DEFAULT_RG.toString()))
            .andExpect(jsonPath("$.cpf").value(DEFAULT_CPF.toString()))
            .andExpect(jsonPath("$.cfdf").value(DEFAULT_CFDF.toString()))
            .andExpect(jsonPath("$.cnpj").value(DEFAULT_CNPJ.toString()))
            .andExpect(jsonPath("$.dataNascimento").value(DEFAULT_DATA_NASCIMENTO.toString()))
            .andExpect(jsonPath("$.dataCriacao").value(DEFAULT_DATA_CRIACAO.toString()))
            .andExpect(jsonPath("$.dataCadastro").value(DEFAULT_DATA_CADASTRO.toString()))
            .andExpect(jsonPath("$.profissao").value(DEFAULT_PROFISSAO.toString()))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL.toString()))
            .andExpect(jsonPath("$.ddd").value(DEFAULT_DDD.toString()))
            .andExpect(jsonPath("$.telefone").value(DEFAULT_TELEFONE.toString()))
            .andExpect(jsonPath("$.cep").value(DEFAULT_CEP.toString()))
            .andExpect(jsonPath("$.logradouro").value(DEFAULT_LOGRADOURO.toString()))
            .andExpect(jsonPath("$.localidade").value(DEFAULT_LOCALIDADE.toString()))
            .andExpect(jsonPath("$.bairro").value(DEFAULT_BAIRRO.toString()))
            .andExpect(jsonPath("$.complemento").value(DEFAULT_COMPLEMENTO.toString()))
            .andExpect(jsonPath("$.uf").value(DEFAULT_UF.toString()))
            .andExpect(jsonPath("$.numero").value(DEFAULT_NUMERO.toString()))
            .andExpect(jsonPath("$.pontosReferenciaEndereco").value(DEFAULT_PONTOS_REFERENCIA_ENDERECO.toString()))
            .andExpect(jsonPath("$.estacaoMetroMaisProxima").value(DEFAULT_ESTACAO_METRO_MAIS_PROXIMA.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingCliente() throws Exception {
        // Get the cliente
        restClienteMockMvc.perform(get("/api/clientes/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCliente() throws Exception {
        // Initialize the database
        clienteRepository.saveAndFlush(cliente);

        int databaseSizeBeforeUpdate = clienteRepository.findAll().size();

        // Update the cliente
        Cliente updatedCliente = clienteRepository.findById(cliente.getId()).get();
        // Disconnect from session so that the updates on updatedCliente are not directly saved in db
        em.detach(updatedCliente);
        updatedCliente
            .tipo(UPDATED_TIPO)
            .nome(UPDATED_NOME)
            .rg(UPDATED_RG)
            .cpf(UPDATED_CPF)
            .cfdf(UPDATED_CFDF)
            .cnpj(UPDATED_CNPJ)
            .dataNascimento(UPDATED_DATA_NASCIMENTO)
            .dataCriacao(UPDATED_DATA_CRIACAO)
            .dataCadastro(UPDATED_DATA_CADASTRO)
            .profissao(UPDATED_PROFISSAO)
            .email(UPDATED_EMAIL)
            .ddd(UPDATED_DDD)
            .telefone(UPDATED_TELEFONE)
            .cep(UPDATED_CEP)
            .logradouro(UPDATED_LOGRADOURO)
            .localidade(UPDATED_LOCALIDADE)
            .bairro(UPDATED_BAIRRO)
            .complemento(UPDATED_COMPLEMENTO)
            .uf(UPDATED_UF)
            .numero(UPDATED_NUMERO)
            .pontosReferenciaEndereco(UPDATED_PONTOS_REFERENCIA_ENDERECO)
            .estacaoMetroMaisProxima(UPDATED_ESTACAO_METRO_MAIS_PROXIMA);
        ClienteDTO clienteDTO = clienteMapper.toDto(updatedCliente);

        restClienteMockMvc.perform(put("/api/clientes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(clienteDTO)))
            .andExpect(status().isOk());

        // Validate the Cliente in the database
        List<Cliente> clienteList = clienteRepository.findAll();
        assertThat(clienteList).hasSize(databaseSizeBeforeUpdate);
        Cliente testCliente = clienteList.get(clienteList.size() - 1);
        assertThat(testCliente.getTipo()).isEqualTo(UPDATED_TIPO);
        assertThat(testCliente.getNome()).isEqualTo(UPDATED_NOME);
        assertThat(testCliente.getRg()).isEqualTo(UPDATED_RG);
        assertThat(testCliente.getCpf()).isEqualTo(UPDATED_CPF);
        assertThat(testCliente.getCfdf()).isEqualTo(UPDATED_CFDF);
        assertThat(testCliente.getCnpj()).isEqualTo(UPDATED_CNPJ);
        assertThat(testCliente.getDataNascimento()).isEqualTo(UPDATED_DATA_NASCIMENTO);
        assertThat(testCliente.getDataCriacao()).isEqualTo(UPDATED_DATA_CRIACAO);
        assertThat(testCliente.getDataCadastro()).isEqualTo(UPDATED_DATA_CADASTRO);
        assertThat(testCliente.getProfissao()).isEqualTo(UPDATED_PROFISSAO);
        assertThat(testCliente.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testCliente.getDdd()).isEqualTo(UPDATED_DDD);
        assertThat(testCliente.getTelefone()).isEqualTo(UPDATED_TELEFONE);
        assertThat(testCliente.getCep()).isEqualTo(UPDATED_CEP);
        assertThat(testCliente.getLogradouro()).isEqualTo(UPDATED_LOGRADOURO);
        assertThat(testCliente.getLocalidade()).isEqualTo(UPDATED_LOCALIDADE);
        assertThat(testCliente.getBairro()).isEqualTo(UPDATED_BAIRRO);
        assertThat(testCliente.getComplemento()).isEqualTo(UPDATED_COMPLEMENTO);
        assertThat(testCliente.getUf()).isEqualTo(UPDATED_UF);
        assertThat(testCliente.getNumero()).isEqualTo(UPDATED_NUMERO);
        assertThat(testCliente.getPontosReferenciaEndereco()).isEqualTo(UPDATED_PONTOS_REFERENCIA_ENDERECO);
        assertThat(testCliente.getEstacaoMetroMaisProxima()).isEqualTo(UPDATED_ESTACAO_METRO_MAIS_PROXIMA);
    }

    @Test
    @Transactional
    public void updateNonExistingCliente() throws Exception {
        int databaseSizeBeforeUpdate = clienteRepository.findAll().size();

        // Create the Cliente
        ClienteDTO clienteDTO = clienteMapper.toDto(cliente);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restClienteMockMvc.perform(put("/api/clientes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(clienteDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Cliente in the database
        List<Cliente> clienteList = clienteRepository.findAll();
        assertThat(clienteList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteCliente() throws Exception {
        // Initialize the database
        clienteRepository.saveAndFlush(cliente);

        int databaseSizeBeforeDelete = clienteRepository.findAll().size();

        // Delete the cliente
        restClienteMockMvc.perform(delete("/api/clientes/{id}", cliente.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database is empty
        List<Cliente> clienteList = clienteRepository.findAll();
        assertThat(clienteList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Cliente.class);
        Cliente cliente1 = new Cliente();
        cliente1.setId(1L);
        Cliente cliente2 = new Cliente();
        cliente2.setId(cliente1.getId());
        assertThat(cliente1).isEqualTo(cliente2);
        cliente2.setId(2L);
        assertThat(cliente1).isNotEqualTo(cliente2);
        cliente1.setId(null);
        assertThat(cliente1).isNotEqualTo(cliente2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ClienteDTO.class);
        ClienteDTO clienteDTO1 = new ClienteDTO();
        clienteDTO1.setId(1L);
        ClienteDTO clienteDTO2 = new ClienteDTO();
        assertThat(clienteDTO1).isNotEqualTo(clienteDTO2);
        clienteDTO2.setId(clienteDTO1.getId());
        assertThat(clienteDTO1).isEqualTo(clienteDTO2);
        clienteDTO2.setId(2L);
        assertThat(clienteDTO1).isNotEqualTo(clienteDTO2);
        clienteDTO1.setId(null);
        assertThat(clienteDTO1).isNotEqualTo(clienteDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(clienteMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(clienteMapper.fromId(null)).isNull();
    }
}
