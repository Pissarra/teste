package io.github.jhipster.application.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import io.github.jhipster.application.domain.enumeration.TipoPessoa;

import io.github.jhipster.application.domain.enumeration.UF;

/**
 * A Cliente.
 */
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoPessoa tipo;

    @NotNull
    @Size(min = 3, max = 250)
    @Column(name = "nome", length = 250, nullable = false)
    private String nome;

    @Size(min = 3, max = 50)
    @Column(name = "rg", length = 50)
    private String rg;

    @Size(min = 11, max = 11)
    @Pattern(regexp = "[0-9]+")
    @Column(name = "cpf", length = 11)
    private String cpf;

    @Size(min = 3, max = 15)
    @Pattern(regexp = "[0-9]+")
    @Column(name = "cfdf", length = 15)
    private String cfdf;

    @Size(min = 14, max = 14)
    @Pattern(regexp = "[0-9]+")
    @Column(name = "cnpj", length = 14)
    private String cnpj;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "data_criacao")
    private LocalDate dataCriacao;

    @NotNull
    @Column(name = "data_cadastro", nullable = false)
    private LocalDate dataCadastro;

    @Size(max = 250)
    @Column(name = "profissao", length = 250)
    private String profissao;

    @NotNull
    @Size(min = 3, max = 250)
    @Column(name = "email", length = 250, nullable = false)
    private String email;

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

    @Size(max = 250)
    @Column(name = "complemento", length = 250)
    private String complemento;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "uf", nullable = false)
    private UF uf;

    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "numero", length = 40, nullable = false)
    private String numero;

    @Size(max = 250)
    @Column(name = "pontos_referencia_endereco", length = 250)
    private String pontosReferenciaEndereco;

    @Size(max = 250)
    @Column(name = "estacao_metro_mais_proxima", length = 250)
    private String estacaoMetroMaisProxima;

    @OneToMany
    private Set<Diarista> restricoes = new HashSet<>();

    @OneToMany
    private Set<Diarista> diaristasPreferidas = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoPessoa getTipo() {
        return tipo;
    }

    public Cliente tipo(TipoPessoa tipo) {
        this.tipo = tipo;
        return this;
    }

    public void setTipo(TipoPessoa tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public Cliente nome(String nome) {
        this.nome = nome;
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public Cliente rg(String rg) {
        this.rg = rg;
        return this;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public Cliente cpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCfdf() {
        return cfdf;
    }

    public Cliente cfdf(String cfdf) {
        this.cfdf = cfdf;
        return this;
    }

    public void setCfdf(String cfdf) {
        this.cfdf = cfdf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Cliente cnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Cliente dataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public Cliente dataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
        return this;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public Cliente dataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
        return this;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getProfissao() {
        return profissao;
    }

    public Cliente profissao(String profissao) {
        this.profissao = profissao;
        return this;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEmail() {
        return email;
    }

    public Cliente email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDdd() {
        return ddd;
    }

    public Cliente ddd(String ddd) {
        this.ddd = ddd;
        return this;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public Cliente telefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public Cliente cep(String cep) {
        this.cep = cep;
        return this;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Cliente logradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public Cliente localidade(String localidade) {
        this.localidade = localidade;
        return this;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getBairro() {
        return bairro;
    }

    public Cliente bairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public Cliente complemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public UF getUf() {
        return uf;
    }

    public Cliente uf(UF uf) {
        this.uf = uf;
        return this;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public String getNumero() {
        return numero;
    }

    public Cliente numero(String numero) {
        this.numero = numero;
        return this;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPontosReferenciaEndereco() {
        return pontosReferenciaEndereco;
    }

    public Cliente pontosReferenciaEndereco(String pontosReferenciaEndereco) {
        this.pontosReferenciaEndereco = pontosReferenciaEndereco;
        return this;
    }

    public void setPontosReferenciaEndereco(String pontosReferenciaEndereco) {
        this.pontosReferenciaEndereco = pontosReferenciaEndereco;
    }

    public String getEstacaoMetroMaisProxima() {
        return estacaoMetroMaisProxima;
    }

    public Cliente estacaoMetroMaisProxima(String estacaoMetroMaisProxima) {
        this.estacaoMetroMaisProxima = estacaoMetroMaisProxima;
        return this;
    }

    public void setEstacaoMetroMaisProxima(String estacaoMetroMaisProxima) {
        this.estacaoMetroMaisProxima = estacaoMetroMaisProxima;
    }

    public Set<Diarista> getRestricoes() {
        return restricoes;
    }

    public Cliente restricoes(Set<Diarista> diaristas) {
        this.restricoes = diaristas;
        return this;
    }

    public Cliente addRestricoes(Diarista diarista) {
        this.restricoes.add(diarista);
        diarista.setCliente(this);
        return this;
    }

    public Cliente removeRestricoes(Diarista diarista) {
        this.restricoes.remove(diarista);
        diarista.setCliente(null);
        return this;
    }

    public void setRestricoes(Set<Diarista> diaristas) {
        this.restricoes = diaristas;
    }

    public Set<Diarista> getDiaristasPreferidas() {
        return diaristasPreferidas;
    }

    public Cliente diaristasPreferidas(Set<Diarista> diaristas) {
        this.diaristasPreferidas = diaristas;
        return this;
    }

    public Cliente addDiaristasPreferidas(Diarista diarista) {
        this.diaristasPreferidas.add(diarista);
        diarista.setCliente(this);
        return this;
    }

    public Cliente removeDiaristasPreferidas(Diarista diarista) {
        this.diaristasPreferidas.remove(diarista);
        diarista.setCliente(null);
        return this;
    }

    public void setDiaristasPreferidas(Set<Diarista> diaristas) {
        this.diaristasPreferidas = diaristas;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cliente)) {
            return false;
        }
        return id != null && id.equals(((Cliente) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Cliente{" +
            "id=" + getId() +
            ", tipo='" + getTipo() + "'" +
            ", nome='" + getNome() + "'" +
            ", rg='" + getRg() + "'" +
            ", cpf='" + getCpf() + "'" +
            ", cfdf='" + getCfdf() + "'" +
            ", cnpj='" + getCnpj() + "'" +
            ", dataNascimento='" + getDataNascimento() + "'" +
            ", dataCriacao='" + getDataCriacao() + "'" +
            ", dataCadastro='" + getDataCadastro() + "'" +
            ", profissao='" + getProfissao() + "'" +
            ", email='" + getEmail() + "'" +
            ", ddd='" + getDdd() + "'" +
            ", telefone='" + getTelefone() + "'" +
            ", cep='" + getCep() + "'" +
            ", logradouro='" + getLogradouro() + "'" +
            ", localidade='" + getLocalidade() + "'" +
            ", bairro='" + getBairro() + "'" +
            ", complemento='" + getComplemento() + "'" +
            ", uf='" + getUf() + "'" +
            ", numero='" + getNumero() + "'" +
            ", pontosReferenciaEndereco='" + getPontosReferenciaEndereco() + "'" +
            ", estacaoMetroMaisProxima='" + getEstacaoMetroMaisProxima() + "'" +
            "}";
    }
}
