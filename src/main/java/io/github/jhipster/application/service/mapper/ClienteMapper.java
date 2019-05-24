package io.github.jhipster.application.service.mapper;

import io.github.jhipster.application.domain.*;
import io.github.jhipster.application.service.dto.ClienteDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Cliente} and its DTO {@link ClienteDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ClienteMapper extends EntityMapper<ClienteDTO, Cliente> {


    @Mapping(target = "restricoes", ignore = true)
    @Mapping(target = "diaristasPreferidas", ignore = true)
    Cliente toEntity(ClienteDTO clienteDTO);

    default Cliente fromId(Long id) {
        if (id == null) {
            return null;
        }
        Cliente cliente = new Cliente();
        cliente.setId(id);
        return cliente;
    }
}
