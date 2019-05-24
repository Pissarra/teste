package io.github.jhipster.application.service.impl;

import io.github.jhipster.application.service.DiaristaService;
import io.github.jhipster.application.domain.Diarista;
import io.github.jhipster.application.repository.DiaristaRepository;
import io.github.jhipster.application.service.dto.DiaristaDTO;
import io.github.jhipster.application.service.mapper.DiaristaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Diarista}.
 */
@Service
@Transactional
public class DiaristaServiceImpl implements DiaristaService {

    private final Logger log = LoggerFactory.getLogger(DiaristaServiceImpl.class);

    private final DiaristaRepository diaristaRepository;

    private final DiaristaMapper diaristaMapper;

    public DiaristaServiceImpl(DiaristaRepository diaristaRepository, DiaristaMapper diaristaMapper) {
        this.diaristaRepository = diaristaRepository;
        this.diaristaMapper = diaristaMapper;
    }

    /**
     * Save a diarista.
     *
     * @param diaristaDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public DiaristaDTO save(DiaristaDTO diaristaDTO) {
        log.debug("Request to save Diarista : {}", diaristaDTO);
        Diarista diarista = diaristaMapper.toEntity(diaristaDTO);
        diarista = diaristaRepository.save(diarista);
        return diaristaMapper.toDto(diarista);
    }

    /**
     * Get all the diaristas.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<DiaristaDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Diaristas");
        return diaristaRepository.findAll(pageable)
            .map(diaristaMapper::toDto);
    }


    /**
     * Get one diarista by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<DiaristaDTO> findOne(Long id) {
        log.debug("Request to get Diarista : {}", id);
        return diaristaRepository.findById(id)
            .map(diaristaMapper::toDto);
    }

    /**
     * Delete the diarista by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Diarista : {}", id);
        diaristaRepository.deleteById(id);
    }
}
