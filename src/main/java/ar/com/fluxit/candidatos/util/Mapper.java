package ar.com.fluxit.candidatos.util;

import ar.com.fluxit.candidatos.dto.CandidatoDTO;
import ar.com.fluxit.candidatos.entity.CandidatoEntity;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by Pablo on 3/11/2019.
 */
public class Mapper {

    public static List<CandidatoDTO> mapList (Iterator<CandidatoEntity> sourceIterator){

        Stream<CandidatoEntity> targetStream = StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(sourceIterator, Spliterator.ORDERED),
                false);

        return targetStream.map(o->{
             return new CandidatoDTO(o.getNombre(),o.getDni());
         }).collect(Collectors.toList());
    }


    public static CandidatoDTO map (CandidatoEntity candidatoEntity){
        CandidatoDTO candidatoDTO = null;
        if (candidatoEntity !=null){
            candidatoDTO = new CandidatoDTO(candidatoEntity.getNombre(),candidatoEntity.getDni());
        }

        return candidatoDTO;

    }

    /**
     * Este metodo cheque si el candidato a actualizar no posee algun atributo entonces setea el valor anterior
     * @param src
     * @param destination
     * @return CandidatoEntity
     */

    public static void mapDifferences (CandidatoEntity src,CandidatoEntity destination){
        destination.setId(src.getId());

        if (destination.getNombre() == null ){
            destination.setNombre(src.getNombre());
        }else if (destination.getNombre().equals("")){
            destination.setNombre(src.getNombre());
        }

        if (destination.getDomicilio() == null ){
            destination.setDomicilio(src.getDomicilio());
        }else  if (destination.getDomicilio().equals("")){
            destination.setDomicilio(src.getDomicilio());
        }


        if (destination.getEmail() == null ){
            destination.setEmail(src.getEmail());
        }else if (destination.getEmail().equals("")){
            destination.setEmail(src.getEmail());
        }

        if (destination.getFechaNacimento() == null) {
            destination.setFechaNacimento(src.getFechaNacimento());
        }else if (destination.getFechaNacimento().equals("")){
            destination.setFechaNacimento(src.getFechaNacimento());
        }

        if (destination.getTelefono() == null ){
            destination.setTelefono(src.getTelefono());
        }else if (destination.getTelefono().equals("")){
            destination.setTelefono(src.getTelefono());
        }
    }



}
