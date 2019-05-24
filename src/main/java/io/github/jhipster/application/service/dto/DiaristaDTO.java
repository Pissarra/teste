package io.github.jhipster.application.service.dto;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.application.domain.enumeration.UF;
import io.github.jhipster.application.domain.enumeration.TamanhoCamisa;
import io.github.jhipster.application.domain.enumeration.UF;

/**
 * A DTO for the {@link io.github.jhipster.application.domain.Diarista} entity.
 */
public class DiaristaDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 3, max = 250)
    private String nome;

    @NotNull
    @Size(min = 3, max = 50)
    private String rg;

    @NotNull
    @Size(min = 11, max = 11)
    @Pattern(regexp = "[0-9]+")
    private String cpf;

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

    @NotNull
    private UF uf;

    @Size(max = 250)
    private String complemento;

    @NotNull
    @Size(min = 1, max = 40)
    private String numero;

    @NotNull
    @Size(min = 2, max = 2)
    @Pattern(regexp = "[0-9]+")
    private String ddd;

    @NotNull
    @Size(min = 8, max = 9)
    @Pattern(regexp = "[0-9]+")
    private String telefone;

    @NotNull
    @Size(min = 3, max = 250)
    private String email;

    @NotNull
    @Size(min = 3, max = 250)
    private String nomeContato;

    @NotNull
    @Size(min = 2, max = 2)
    @Pattern(regexp = "[0-9]+")
    private String dddContato;

    @NotNull
    @Size(min = 8, max = 9)
    @Pattern(regexp = "[0-9]+")
    private String telefoneContato;

    @NotNull
    private LocalDate dataNascimento;

    @NotNull
    @Size(min = 2, max = 250)
    private String cargo;

    @NotNull
    private LocalDate dataAdmissao;

    private LocalDate dataSaida;

    @NotNull
    private TamanhoCamisa tamanhoCamisa;

    @NotNull
    @Size(min = 3, max = 30)
    @Pattern(regexp = "[0-9]+")
    private String pis;

    @NotNull
    @Size(min = 2, max = 30)
    @Pattern(regexp = "[0-9]+")
    private String cartaoCidadado;

    @NotNull
    @Size(min = 6, max = 30)
    @Pattern(regexp = "[0-9]+")
    private String numeroTituloEleitor;

    @NotNull
    @Size(min = 2, max = 5)
    @Pattern(regexp = "[0-9]+")
    private String zonaTituloEleitor;

    @NotNull
    @Size(min = 2, max = 6)
    @Pattern(regexp = "[0-9]+")
    private String secaoTituloEleitor;

    @NotNull
    @Size(min = 2, max = 20)
    @Pattern(regexp = "[0-9]+")
    private String numeroCarteiraTrabalho;

    @NotNull
    @Size(min = 2, max = 6)
    @Pattern(regexp = "[0-9]+")
    private String serieCarteiraTrabalho;

    @NotNull
    private UF ufCarteiraTrabalho;

    @Size(min = 11, max = 11)
    @Pattern(regexp = "[0-9]+")
    private String nire;

    @NotNull
    @Size(min = 14, max = 14)
    @Pattern(regexp = "[0-9]+")
    private String cnpj;


    private Long clienteId;

    private Long clienteId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getDddContato() {
        return dddContato;
    }

    public void setDddContato(String dddContato) {
        this.dddContato = dddContato;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public TamanhoCamisa getTamanhoCamisa() {
        return tamanhoCamisa;
    }

    public void setTamanhoCamisa(TamanhoCamisa tamanhoCamisa) {
        this.tamanhoCamisa = tamanhoCamisa;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getCartaoCidadado() {
        return cartaoCidadado;
    }

    public void setCartaoCidadado(String cartaoCidadado) {
        this.cartaoCidadado = cartaoCidadado;
    }

    public String getNumeroTituloEleitor() {
        return numeroTituloEleitor;
    }

    public void setNumeroTituloEleitor(String numeroTituloEleitor) {
        this.numeroTituloEleitor = numeroTituloEleitor;
    }

    public String getZonaTituloEleitor() {
        return zonaTituloEleitor;
    }

    public void setZonaTituloEleitor(String zonaTituloEleitor) {
        this.zonaTituloEleitor = zonaTituloEleitor;
    }

    public String getSecaoTituloEleitor() {
        return secaoTituloEleitor;
    }

    public void setSecaoTituloEleitor(String secaoTituloEleitor) {
        this.secaoTituloEleitor = secaoTituloEleitor;
    }

    public String getNumeroCarteiraTrabalho() {
        return numeroCarteiraTrabalho;
    }

    public void setNumeroCarteiraTrabalho(String numeroCarteiraTrabalho) {
        this.numeroCarteiraTrabalho = numeroCarteiraTrabalho;
    }

    public String getSerieCarteiraTrabalho() {
        return serieCarteiraTrabalho;
    }

    public void setSerieCarteiraTrabalho(String serieCarteiraTrabalho) {
        this.serieCarteiraTrabalho = serieCarteiraTrabalho;
    }

    public UF getUfCarteiraTrabalho() {
        return ufCarteiraTrabalho;
    }

    public void setUfCarteiraTrabalho(UF ufCarteiraTrabalho) {
        this.ufCarteiraTrabalho = ufCarteiraTrabalho;
    }

    public String getNire() {
        return nire;
    }

    public void setNire(String nire) {
        this.nire = nire;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DiaristaDTO diaristaDTO = (DiaristaDTO) o;
        if (diaristaDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), diaristaDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DiaristaDTO{" +
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
            ", cliente=" + getClienteId() +
            ", cliente=" + getClienteId() +
            "}";
    }
}
