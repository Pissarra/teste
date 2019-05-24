package io.github.jhipster.application.service.mapper;

import io.github.jhipster.application.domain.*;
import io.github.jhipster.application.service.dto.DiaristaDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Diarista} and its DTO {@link DiaristaDTO}.
 */
@Mapper(componentModel = "spring", uses = {ClienteMapper.class})
public interface DiaristaMapper extends EntityMapper<DiaristaDTO, Diarista> {

    @Mapping(source = "cliente.id", target = "clienteId")
    @Mapping(source = "cliente.id", target = "clienteId")
    DiaristaDTO toDto(Diarista diarista);

    @Mapping(source = "clienteId", target = "cliente")
    @Mapping(source = "clienteId", target = "cliente")
    Diarista toEntity(DiaristaDTO diaristaDTO);

    default Diarista fromId(Long id) {
        if (id == null) {
            return null;
        }
        Diarista diarista = new Diarista();
        diarista.setId(id);
        return diarista;
    }
}
