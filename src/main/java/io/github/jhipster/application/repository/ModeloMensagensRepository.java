package io.github.jhipster.application.repository;

import io.github.jhipster.application.domain.ModeloMensagens;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the ModeloMensagens entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ModeloMensagensRepository extends JpaRepository<ModeloMensagens, Long> {

}
