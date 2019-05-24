package io.github.jhipster.application.repository;

import io.github.jhipster.application.domain.Diarista;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Diarista entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DiaristaRepository extends JpaRepository<Diarista, Long> {

}
