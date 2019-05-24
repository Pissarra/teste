package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.service.ModeloMensagensService;
import io.github.jhipster.application.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.application.service.dto.ModeloMensagensDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link io.github.jhipster.application.domain.ModeloMensagens}.
 */
@RestController
@RequestMapping("/api")
public class ModeloMensagensResource {

    private final Logger log = LoggerFactory.getLogger(ModeloMensagensResource.class);

    private static final String ENTITY_NAME = "modeloMensagens";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ModeloMensagensService modeloMensagensService;

    public ModeloMensagensResource(ModeloMensagensService modeloMensagensService) {
        this.modeloMensagensService = modeloMensagensService;
    }

    /**
     * {@code POST  /modelo-mensagens} : Create a new modeloMensagens.
     *
     * @param modeloMensagensDTO the modeloMensagensDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new modeloMensagensDTO, or with status {@code 400 (Bad Request)} if the modeloMensagens has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/modelo-mensagens")
    public ResponseEntity<ModeloMensagensDTO> createModeloMensagens(@Valid @RequestBody ModeloMensagensDTO modeloMensagensDTO) throws URISyntaxException {
        log.debug("REST request to save ModeloMensagens : {}", modeloMensagensDTO);
        if (modeloMensagensDTO.getId() != null) {
            throw new BadRequestAlertException("A new modeloMensagens cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ModeloMensagensDTO result = modeloMensagensService.save(modeloMensagensDTO);
        return ResponseEntity.created(new URI("/api/modelo-mensagens/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /modelo-mensagens} : Updates an existing modeloMensagens.
     *
     * @param modeloMensagensDTO the modeloMensagensDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated modeloMensagensDTO,
     * or with status {@code 400 (Bad Request)} if the modeloMensagensDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the modeloMensagensDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/modelo-mensagens")
    public ResponseEntity<ModeloMensagensDTO> updateModeloMensagens(@Valid @RequestBody ModeloMensagensDTO modeloMensagensDTO) throws URISyntaxException {
        log.debug("REST request to update ModeloMensagens : {}", modeloMensagensDTO);
        if (modeloMensagensDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ModeloMensagensDTO result = modeloMensagensService.save(modeloMensagensDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, modeloMensagensDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /modelo-mensagens} : get all the modeloMensagens.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of modeloMensagens in body.
     */
    @GetMapping("/modelo-mensagens")
    public ResponseEntity<List<ModeloMensagensDTO>> getAllModeloMensagens(Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder) {
        log.debug("REST request to get a page of ModeloMensagens");
        Page<ModeloMensagensDTO> page = modeloMensagensService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(uriBuilder.queryParams(queryParams), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /modelo-mensagens/:id} : get the "id" modeloMensagens.
     *
     * @param id the id of the modeloMensagensDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the modeloMensagensDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/modelo-mensagens/{id}")
    public ResponseEntity<ModeloMensagensDTO> getModeloMensagens(@PathVariable Long id) {
        log.debug("REST request to get ModeloMensagens : {}", id);
        Optional<ModeloMensagensDTO> modeloMensagensDTO = modeloMensagensService.findOne(id);
        return ResponseUtil.wrapOrNotFound(modeloMensagensDTO);
    }

    /**
     * {@code DELETE  /modelo-mensagens/:id} : delete the "id" modeloMensagens.
     *
     * @param id the id of the modeloMensagensDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/modelo-mensagens/{id}")
    public ResponseEntity<Void> deleteModeloMensagens(@PathVariable Long id) {
        log.debug("REST request to delete ModeloMensagens : {}", id);
        modeloMensagensService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
