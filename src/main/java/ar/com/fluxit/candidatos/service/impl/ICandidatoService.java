package ar.com.fluxit.candidatos.service.impl;

import ar.com.fluxit.candidatos.entity.CandidatoEntity;
import ar.com.fluxit.candidatos.service.IDAO;
import org.springframework.data.domain.Pageable;

import java.util.Iterator;


/**
 * Created by Pablo on 2/11/2019.
 */
public interface ICandidatoService extends IDAO<CandidatoEntity> {
    Iterator<CandidatoEntity> all(Pageable pageable);
    Iterator<CandidatoEntity> findByName(String name, Pageable pageable);
    CandidatoEntity findByDni(String dni, Pageable pageable);

}
