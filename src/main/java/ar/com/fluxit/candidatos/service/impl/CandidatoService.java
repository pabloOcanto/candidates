package ar.com.fluxit.candidatos.service.impl;

import ar.com.fluxit.candidatos.entity.CandidatoEntity;
import ar.com.fluxit.candidatos.exception.CreateException;
import ar.com.fluxit.candidatos.exception.DeleteException;
import ar.com.fluxit.candidatos.exception.NotExistException;
import ar.com.fluxit.candidatos.exception.UpdateException;
import ar.com.fluxit.candidatos.repository.CandidatoRepository;
import ar.com.fluxit.candidatos.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Optional;

/**
 * Created by Pablo on 2/11/2019.
 */
@Service
public class CandidatoService implements ICandidatoService {

    private CandidatoRepository repository;

    @Autowired
    public CandidatoService(CandidatoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(CandidatoEntity entity) throws Exception {
        try {
            repository.save(entity);
        }catch (Exception e){
            throw new CreateException();
        }

    }

    @Override
    public void update(CandidatoEntity destination) throws Exception {
        try {
            Optional<CandidatoEntity> src =repository.findByDni(destination.getDni());
            if (!src.isPresent()){
                throw new NotExistException();
            }
            Mapper.mapDifferences(src.get(),destination);
            repository.save(destination);
        }catch (Exception e){
            throw new UpdateException();
        }

    }

    @Override
    public void delete(CandidatoEntity entity) throws Exception {
        try {

            Optional<CandidatoEntity> candidatoEntity =repository.findByDni(entity.getDni());
            if (!candidatoEntity.isPresent()){
                throw new NotExistException();
            }

            repository.delete(entity);
        }catch (Exception e){
            throw new DeleteException();
        }
    }

    @Override
    public Iterator<CandidatoEntity> all(Pageable pageable) {
        return repository.findAll(pageable).iterator();
    }

    @Override
    public Iterator<CandidatoEntity> findByName(String name, Pageable pageable) {
        return repository.findByNombre(name,pageable).iterator();

    }

    @Override
    public CandidatoEntity findByDni(String dni, Pageable pageable) {
        CandidatoEntity candidatoEntity= null;
        Iterator<CandidatoEntity> iterator = repository.findByDni(dni,pageable).iterator();
        if (iterator.hasNext()){
            candidatoEntity = iterator.next();
        }
        return candidatoEntity;
    }
}
