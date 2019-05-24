package io.github.jhipster.application.service;

import io.github.jhipster.application.service.dto.DiaristaDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link io.github.jhipster.application.domain.Diarista}.
 */
public interface DiaristaService {

    /**
     * Save a diarista.
     *
     * @param diaristaDTO the entity to save.
     * @return the persisted entity.
     */
    DiaristaDTO save(DiaristaDTO diaristaDTO);

    /**
     * Get all the diaristas.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<DiaristaDTO> findAll(Pageable pageable);


    /**
     * Get the "id" diarista.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DiaristaDTO> findOne(Long id);

    /**
     * Delete the "id" diarista.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
