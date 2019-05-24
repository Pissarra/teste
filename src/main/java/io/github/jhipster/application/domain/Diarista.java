package io.github.jhipster.application.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import io.github.jhipster.application.domain.enumeration.UF;

import io.github.jhipster.application.domain.enumeration.TamanhoCamisa;

/**
 * A Diarista.
 */
@Entity
@Table(name = "diarista")
public class Diarista implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Size(min = 3, max = 250)
    @Column(name = "nome", length = 250, nullable = false)
    private String nome;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "rg", length = 50, nullable = false)
    private String rg;

    @NotNull
    @Size(min = 11, max = 11)
    @Pattern(regexp = "[0-9]+")
    @Column(name = "cpf", length = 11, nullable = false)
    private String cpf;

    @NotNull
    @Size(min = 8, max = 8)
    @Pattern(regexp = "[0-9]+")
    @Column(name = "cep", length = 8, nullable = false)
    private String cep;

    @NotNull
    @Size(min = 2, max = 250)
    @Column(name = "logradouro", length = 250, nullable = false)
    private String logradouro;

    @NotNull
    @Size(min = 2, max = 250)
    @Column(name = "localidade", length = 250, nullable = false)
    private String localidade;

    @NotNull
    @Size(min = 2, max = 250)
    @Column(name = "bairro", length = 250, nullable = false)
    private String bairro;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "uf", nullable = false)
    private UF uf;

    @Size(max = 250)
    @Column(name = "complemento", length = 250)
    private String complemento;

    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "numero", length = 40, nullable = false)
    private String numero;

    @NotNull
    @Size(min = 2, max = 2)
    @Pattern(regexp = "[0-9]+")
    @Column(name = "ddd", length = 2, nullable = false)
    private String ddd;

    @NotNull
    @Size(min = 8, max = 9)
    @Pattern(regexp = "[0-9]+")
    @Column(name = "telefone", length = 9, nullable = false)
    private String telefone;

    @NotNull
    @Size(min = 3, max = 250)
    @Column(name = "email", length = 250, nullable = false)
    private String email;

    @NotNull
    @Size(min = 3, max = 250)
    @Column(name = "nome_contato", length = 250, nullable = false)
    private String nomeContato;

    @NotNull
    @Size(min = 2, max = 2)
    @Pattern(regexp = "[0-9]+")
    @Column(name = "ddd_contato", length = 2, nullable = false)
    private String dddContato;

    @NotNull
    @Size(min = 8, max = 9)
    @Pattern(regexp = "[0-9]+")
    @Column(name = "telefone_contato", length = 9, nullable = false)
    private String telefoneContato;

    @NotNull
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @NotNull
    @Size(min = 2, max = 250)
    @Column(name = "cargo", length = 250, nullable = false)
    private String cargo;

    @NotNull
    @Column(name = "data_admissao", nullable = false)
    private LocalDate dataAdmissao;

    @Column(name = "data_saida")
    private LocalDate dataSaida;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tamanho_camisa", nullable = false)
    private TamanhoCamisa tamanhoCamisa;

    @NotNull
    @Size(min = 3, max = 30)
    @Pattern(regexp = "[0-9]+")
    @Column(name = "pis", length = 30, nullable = false)
    private String pis;

    @NotNull
    @Size(min = 2, max = 30)
    @Pattern(regexp = "[0-9]+")
    @Column(name = "cartao_cidadado", length = 30, nullable = false)
    private String cartaoCidadado;

    @NotNull
    @Size(min = 6, max = 30)
    @Pattern(regexp = "[0-9]+")
    @Column(name = "numero_titulo_eleitor", length = 30, nullable = false)
    private String numeroTituloEleitor;

    @NotNull
    @Size(min = 2, max = 5)
    @Pattern(regexp = "[0-9]+")
    @Column(name = "zona_titulo_eleitor", length = 5, nullable = false)
    private String zonaTituloEleitor;

    @NotNull
    @Size(min = 2, max = 6)
    @Pattern(regexp = "[0-9]+")
    @Column(name = "secao_titulo_eleitor", length = 6, nullable = false)
    private String secaoTituloEleitor;

    @NotNull
    @Size(min = 2, max = 20)
    @Pattern(regexp = "[0-9]+")
    @Column(name = "numero_carteira_trabalho", length = 20, nullable = false)
    private String numeroCarteiraTrabalho;

    @NotNull
    @Size(min = 2, max = 6)
    @Pattern(regexp = "[0-9]+")
    @Column(name = "serie_carteira_trabalho", length = 6, nullable = false)
    private String serieCarteiraTrabalho;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "uf_carteira_trabalho", nullable = false)
    private UF ufCarteiraTrabalho;

    @Size(min = 11, max = 11)
    @Pattern(regexp = "[0-9]+")
    @Column(name = "nire", length = 11)
    private String nire;

    @NotNull
    @Size(min = 14, max = 14)
    @Pattern(regexp = "[0-9]+")
    @Column(name = "cnpj", length = 14, nullable = false)
    private String cnpj;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public Diarista nome(String nome) {
        this.nome = nome;
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public Diarista rg(String rg) {
        this.rg = rg;
        return this;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public Diarista cpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public Diarista cep(String cep) {
        this.cep = cep;
        return this;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Diarista logradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public Diarista localidade(String localidade) {
        this.localidade = localidade;
        return this;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getBairro() {
        return bairro;
    }

    public Diarista bairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public UF getUf() {
        return uf;
    }

    public Diarista uf(UF uf) {
        this.uf = uf;
        return this;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public String getComplemento() {
        return complemento;
    }

    public Diarista complemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public Diarista numero(String numero) {
        this.numero = numero;
        return this;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public Diarista ddd(String ddd) {
        this.ddd = ddd;
        return this;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public Diarista telefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public Diarista email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public Diarista nomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
        return this;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getDddContato() {
        return dddContato;
    }

    public Diarista dddContato(String dddContato) {
        this.dddContato = dddContato;
        return this;
    }

    public void setDddContato(String dddContato) {
        this.dddContato = dddContato;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public Diarista telefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
        return this;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Diarista dataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCargo() {
        return cargo;
    }

    public Diarista cargo(String cargo) {
        this.cargo = cargo;
        return this;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public Diarista dataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
        return this;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public Diarista dataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
        return this;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public TamanhoCamisa getTamanhoCamisa() {
        return tamanhoCamisa;
    }

    public Diarista tamanhoCamisa(TamanhoCamisa tamanhoCamisa) {
        this.tamanhoCamisa = tamanhoCamisa;
        return this;
    }

    public void setTamanhoCamisa(TamanhoCamisa tamanhoCamisa) {
        this.tamanhoCamisa = tamanhoCamisa;
    }

    public String getPis() {
        return pis;
    }

    public Diarista pis(String pis) {
        this.pis = pis;
        return this;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getCartaoCidadado() {
        return cartaoCidadado;
    }

    public Diarista cartaoCidadado(String cartaoCidadado) {
        this.cartaoCidadado = cartaoCidadado;
        return this;
    }

    public void setCartaoCidadado(String cartaoCidadado) {
        this.cartaoCidadado = cartaoCidadado;
    }

    public String getNumeroTituloEleitor() {
        return numeroTituloEleitor;
    }

    public Diarista numeroTituloEleitor(String numeroTituloEleitor) {
        this.numeroTituloEleitor = numeroTituloEleitor;
        return this;
    }

    public void setNumeroTituloEleitor(String numeroTituloEleitor) {
        this.numeroTituloEleitor = numeroTituloEleitor;
    }

    public String getZonaTituloEleitor() {
        return zonaTituloEleitor;
    }

    public Diarista zonaTituloEleitor(String zonaTituloEleitor) {
        this.zonaTituloEleitor = zonaTituloEleitor;
        return this;
    }

    public void setZonaTituloEleitor(String zonaTituloEleitor) {
        this.zonaTituloEleitor = zonaTituloEleitor;
    }

    public String getSecaoTituloEleitor() {
        return secaoTituloEleitor;
    }

    public Diarista secaoTituloEleitor(String secaoTituloEleitor) {
        this.secaoTituloEleitor = secaoTituloEleitor;
        return this;
    }

    public void setSecaoTituloEleitor(String secaoTituloEleitor) {
        this.secaoTituloEleitor = secaoTituloEleitor;
    }

    public String getNumeroCarteiraTrabalho() {
        return numeroCarteiraTrabalho;
    }

    public Diarista numeroCarteiraTrabalho(String numeroCarteiraTrabalho) {
        this.numeroCarteiraTrabalho = numeroCarteiraTrabalho;
        return this;
    }

    public void setNumeroCarteiraTrabalho(String numeroCarteiraTrabalho) {
        this.numeroCarteiraTrabalho = numeroCarteiraTrabalho;
    }

    public String getSerieCarteiraTrabalho() {
        return serieCarteiraTrabalho;
    }

    public Diarista serieCarteiraTrabalho(String serieCarteiraTrabalho) {
        this.serieCarteiraTrabalho = serieCarteiraTrabalho;
        return this;
    }

    public void setSerieCarteiraTrabalho(String serieCarteiraTrabalho) {
        this.serieCarteiraTrabalho = serieCarteiraTrabalho;
    }

    public UF getUfCarteiraTrabalho() {
        return ufCarteiraTrabalho;
    }

    public Diarista ufCarteiraTrabalho(UF ufCarteiraTrabalho) {
        this.ufCarteiraTrabalho = ufCarteiraTrabalho;
        return this;
    }

    public void setUfCarteiraTrabalho(UF ufCarteiraTrabalho) {
        this.ufCarteiraTrabalho = ufCarteiraTrabalho;
    }

    public String getNire() {
        return nire;
    }

    public Diarista nire(String nire) {
        this.nire = nire;
        return this;
    }

    public void setNire(String nire) {
        this.nire = nire;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Diarista cnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Diarista cliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Diarista cliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Diarista)) {
            return false;
        }
        return id != null && id.equals(((Diarista) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Diarista{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            ", rg='" + getRg() + "'" +
            ", cpf='" + getCpf() + "'" +
            ", cep='" + getCep() + "'" +
            ", logradouro='" + getLogradouro() + "'" +
            ", localidade='" + getLocalidade() + "'" +
            ", bairro='" + getBairro() + "'" +
            ", uf='" + getUf() + "'" +
            ", complemento='" + getComplemento() + "'" +
            ", numero='" + getNumero() + "'" +
            ", ddd='" + getDdd() + "'" +
            ", telefone='" + getTelefone() + "'" +
            ", email='" + getEmail() + "'" +
            ", nomeContato='" + getNomeContato() + "'" +
            ", dddContato='" + getDddContato() + "'" +
            ", telefoneContato='" + getTelefoneContato() + "'" +
            ", dataNascimento='" + getDataNascimento() + "'" +
            ", cargo='" + getCargo() + "'" +
            ", dataAdmissao='" + getDataAdmissao() + "'" +
            ", dataSaida='" + getDataSaida() + "'" +
            ", tamanhoCamisa='" + getTamanhoCamisa() + "'" +
            ", pis='" + getPis() + "'" +
            ", cartaoCidadado='" + getCartaoCidadado() + "'" +
            ", numeroTituloEleitor='" + getNumeroTituloEleitor() + "'" +
            ", zonaTituloEleitor='" + getZonaTituloEleitor() + "'" +
            ", secaoTituloEleitor='" + getSecaoTituloEleitor() + "'" +
            ", numeroCarteiraTrabalho='" + getNumeroCarteiraTrabalho() + "'" +
            ", serieCarteiraTrabalho='" + getSerieCarteiraTrabalho() + "'" +
            ", ufCarteiraTrabalho='" + getUfCarteiraTrabalho() + "'" +
            ", nire='" + getNire() + "'" +
            ", cnpj='" + getCnpj() + "'" +
            "}";
    }
}
