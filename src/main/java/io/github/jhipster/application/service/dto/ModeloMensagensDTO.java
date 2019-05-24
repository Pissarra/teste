package io.github.jhipster.application.service.dto;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link io.github.jhipster.application.domain.ModeloMensagens} entity.
 */
public class ModeloMensagensDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 3, max = 250)
    private String titulo;

    @NotNull
    @Size(min = 3, max = 250)
    private String mensagem;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ModeloMensagensDTO modeloMensagensDTO = (ModeloMensagensDTO) o;
        if (modeloMensagensDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), modeloMensagensDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ModeloMensagensDTO{" +
            "id=" + getId() +
            ", titulo='" + getTitulo() + "'" +
            ", mensagem='" + getMensagem() + "'" +
            "}";
    }
}
