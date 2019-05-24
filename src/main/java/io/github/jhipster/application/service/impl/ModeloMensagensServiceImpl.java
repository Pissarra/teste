package io.github.jhipster.application.service.impl;

import io.github.jhipster.application.service.ModeloMensagensService;
import io.github.jhipster.application.domain.ModeloMensagens;
import io.github.jhipster.application.repository.ModeloMensagensRepository;
import io.github.jhipster.application.service.dto.ModeloMensagensDTO;
import io.github.jhipster.application.service.mapper.ModeloMensagensMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ModeloMensagens}.
 */
@Service
@Transactional
public class ModeloMensagensServiceImpl implements ModeloMensagensService {

    private final Logger log = LoggerFactory.getLogger(ModeloMensagensServiceImpl.class);

    private final ModeloMensagensRepository modeloMensagensRepository;

    private final ModeloMensagensMapper modeloMensagensMapper;

    public ModeloMensagensServiceImpl(ModeloMensagensRepository modeloMensagensRepository, ModeloMensagensMapper modeloMensagensMapper) {
        this.modeloMensagensRepository = modeloMensagensRepository;
        this.modeloMensagensMapper = modeloMensagensMapper;
    }

    /**
     * Save a modeloMensagens.
     *
     * @param modeloMensagensDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ModeloMensagensDTO save(ModeloMensagensDTO modeloMensagensDTO) {
        log.debug("Request to save ModeloMensagens : {}", modeloMensagensDTO);
        ModeloMensagens modeloMensagens = modeloMensagensMapper.toEntity(modeloMensagensDTO);
        modeloMensagens = modeloMensagensRepository.save(modeloMensagens);
        return modeloMensagensMapper.toDto(modeloMensagens);
    }

    /**
     * Get all the modeloMensagens.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ModeloMensagensDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ModeloMensagens");
        return modeloMensagensRepository.findAll(pageable)
            .map(modeloMensagensMapper::toDto);
    }


    /**
     * Get one modeloMensagens by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ModeloMensagensDTO> findOne(Long id) {
        log.debug("Request to get ModeloMensagens : {}", id);
        return modeloMensagensRepository.findById(id)
            .map(modeloMensagensMapper::toDto);
    }

    /**
     * Delete the modeloMensagens by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ModeloMensagens : {}", id);
        modeloMensagensRepository.deleteById(id);
    }
}
