package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.service.DiaristaService;
import io.github.jhipster.application.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.application.service.dto.DiaristaDTO;

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
 * REST controller for managing {@link io.github.jhipster.application.domain.Diarista}.
 */
@RestController
@RequestMapping("/api")
public class DiaristaResource {

    private final Logger log = LoggerFactory.getLogger(DiaristaResource.class);

    private static final String ENTITY_NAME = "diarista";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DiaristaService diaristaService;

    public DiaristaResource(DiaristaService diaristaService) {
        this.diaristaService = diaristaService;
    }

    /**
     * {@code POST  /diaristas} : Create a new diarista.
     *
     * @param diaristaDTO the diaristaDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new diaristaDTO, or with status {@code 400 (Bad Request)} if the diarista has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/diaristas")
    public ResponseEntity<DiaristaDTO> createDiarista(@Valid @RequestBody DiaristaDTO diaristaDTO) throws URISyntaxException {
        log.debug("REST request to save Diarista : {}", diaristaDTO);
        if (diaristaDTO.getId() != null) {
            throw new BadRequestAlertException("A new diarista cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DiaristaDTO result = diaristaService.save(diaristaDTO);
        return ResponseEntity.created(new URI("/api/diaristas/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /diaristas} : Updates an existing diarista.
     *
     * @param diaristaDTO the diaristaDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated diaristaDTO,
     * or with status {@code 400 (Bad Request)} if the diaristaDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the diaristaDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/diaristas")
    public ResponseEntity<DiaristaDTO> updateDiarista(@Valid @RequestBody DiaristaDTO diaristaDTO) throws URISyntaxException {
        log.debug("REST request to update Diarista : {}", diaristaDTO);
        if (diaristaDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        DiaristaDTO result = diaristaService.save(diaristaDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, diaristaDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /diaristas} : get all the diaristas.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of diaristas in body.
     */
    @GetMapping("/diaristas")
    public ResponseEntity<List<DiaristaDTO>> getAllDiaristas(Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder) {
        log.debug("REST request to get a page of Diaristas");
        Page<DiaristaDTO> page = diaristaService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(uriBuilder.queryParams(queryParams), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /diaristas/:id} : get the "id" diarista.
     *
     * @param id the id of the diaristaDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the diaristaDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/diaristas/{id}")
    public ResponseEntity<DiaristaDTO> getDiarista(@PathVariable Long id) {
        log.debug("REST request to get Diarista : {}", id);
        Optional<DiaristaDTO> diaristaDTO = diaristaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(diaristaDTO);
    }

    /**
     * {@code DELETE  /diaristas/:id} : delete the "id" diarista.
     *
     * @param id the id of the diaristaDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/diaristas/{id}")
    public ResponseEntity<Void> deleteDiarista(@PathVariable Long id) {
        log.debug("REST request to delete Diarista : {}", id);
        diaristaService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
