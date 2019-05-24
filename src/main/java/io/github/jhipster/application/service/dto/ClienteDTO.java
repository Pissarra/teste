package io.github.jhipster.application.service.dto;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.application.domain.enumeration.TipoPessoa;
import io.github.jhipster.application.domain.enumeration.UF;

/**
 * A DTO for the {@link io.github.jhipster.application.domain.Cliente} entity.
 */
public class ClienteDTO implements Serializable {

    private Long id;

    @NotNull
    private TipoPessoa tipo;

    @NotNull
    @Size(min = 3, max = 250)
    private String nome;

    @Size(min = 3, max = 50)
    private String rg;

    @Size(min = 11, max = 11)
    @Pattern(regexp = "[0-9]+")
    private String cpf;

    @Size(min = 3, max = 15)
    @Pattern(regexp = "[0-9]+")
    private String cfdf;

    @Size(min = 14, max = 14)
    @Pattern(regexp = "[0-9]+")
    private String cnpj;

    private LocalDate dataNascimento;

    private LocalDate dataCriacao;

    @NotNull
    private LocalDate dataCadastro;

    @Size(max = 250)
    private String profissao;

    @NotNull
    @Size(min = 3, max = 250)
    private String email;

    @NotNull
    @Size(min = 2, max = 2)
    @Pattern(regexp = "[0-9]+")
    private String ddd;

    @NotNull
    @Size(min = 8, max = 9)
    @Pattern(regexp = "[0-9]+")
    private String telefone;

    @NotNull
    @Size(min = 8, max = 8)
    @Pattern(regexp = "[0-9]+")
    private String cep;

    @NotNull
    @Size(min = 2, max = 250)
    private String logradouro;

    @NotNull
    @Size(min = 2, max = 250)
    private String localidade;

    @NotNull
    @Size(min = 2, max = 250)
    private String bairro;

    @Size(max = 250)
    private String complemento;

    @NotNull
    private UF uf;

    @NotNull
    @Size(min = 1, max = 40)
    private String numero;

    @Size(max = 250)
    private String pontosReferenciaEndereco;

    @Size(max = 250)
    private String estacaoMetroMaisProxima;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoPessoa getTipo() {
        return tipo;
    }

    public void setTipo(TipoPessoa tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCfdf() {
        return cfdf;
    }

    public void setCfdf(String cfdf) {
        this.cfdf = cfdf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPontosReferenciaEndereco() {
        return pontosReferenciaEndereco;
    }

    public void setPontosReferenciaEndereco(String pontosReferenciaEndereco) {
        this.pontosReferenciaEndereco = pontosReferenciaEndereco;
    }

    public String getEstacaoMetroMaisProxima() {
        return estacaoMetroMaisProxima;
    }

    public void setEstacaoMetroMaisProxima(String estacaoMetroMaisProxima) {
        this.estacaoMetroMaisProxima = estacaoMetroMaisProxima;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ClienteDTO clienteDTO = (ClienteDTO) o;
        if (clienteDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), clienteDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ClienteDTO{" +
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
