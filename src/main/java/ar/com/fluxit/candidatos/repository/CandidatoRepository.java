package ar.com.fluxit.candidatos.repository;

import ar.com.fluxit.candidatos.entity.CandidatoEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.Optional;

/**
 * Created by Pablo on 2/11/2019.
 */
@Repository
@Qualifier("CandidatoRepository")
public interface CandidatoRepository extends JpaRepository<CandidatoEntity,Long> {
    Page<CandidatoEntity> findByNombre(String nombre, Pageable pageable);
    Page<CandidatoEntity> findByDni(String dni, Pageable pageable);
    Optional<CandidatoEntity> findByDni(String dni);

}
