package io.github.jhipster.application.domain;



import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A ModeloMensagens.
 */
@Entity
@Table(name = "modelo_mensagens")
public class ModeloMensagens implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Size(min = 3, max = 250)
    @Column(name = "titulo", length = 250, nullable = false)
    private String titulo;

    @NotNull
    @Size(min = 3, max = 250)
    @Column(name = "mensagem", length = 250, nullable = false)
    private String mensagem;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public ModeloMensagens titulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public ModeloMensagens mensagem(String mensagem) {
        this.mensagem = mensagem;
        return this;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ModeloMensagens)) {
            return false;
        }
        return id != null && id.equals(((ModeloMensagens) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "ModeloMensagens{" +
            "id=" + getId() +
            ", titulo='" + getTitulo() + "'" +
            ", mensagem='" + getMensagem() + "'" +
            "}";
    }
}
