package io.github.jhipster.application.service.mapper;

import io.github.jhipster.application.domain.*;
import io.github.jhipster.application.service.dto.ModeloMensagensDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ModeloMensagens} and its DTO {@link ModeloMensagensDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ModeloMensagensMapper extends EntityMapper<ModeloMensagensDTO, ModeloMensagens> {



    default ModeloMensagens fromId(Long id) {
        if (id == null) {
            return null;
        }
        ModeloMensagens modeloMensagens = new ModeloMensagens();
        modeloMensagens.setId(id);
        return modeloMensagens;
    }
}
