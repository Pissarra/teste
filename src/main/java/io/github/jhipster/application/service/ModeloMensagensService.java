package io.github.jhipster.application.service;

import io.github.jhipster.application.service.dto.ModeloMensagensDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link io.github.jhipster.application.domain.ModeloMensagens}.
 */
public interface ModeloMensagensService {

    /**
     * Save a modeloMensagens.
     *
     * @param modeloMensagensDTO the entity to save.
     * @return the persisted entity.
     */
    ModeloMensagensDTO save(ModeloMensagensDTO modeloMensagensDTO);

    /**
     * Get all the modeloMensagens.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ModeloMensagensDTO> findAll(Pageable pageable);


    /**
     * Get the "id" modeloMensagens.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ModeloMensagensDTO> findOne(Long id);

    /**
     * Delete the "id" modeloMensagens.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
