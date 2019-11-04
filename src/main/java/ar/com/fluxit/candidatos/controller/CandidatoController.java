package ar.com.fluxit.candidatos.controller;

import ar.com.fluxit.candidatos.dto.CandidatoDTO;
import ar.com.fluxit.candidatos.dto.CandidatoDtoDAO;
import ar.com.fluxit.candidatos.entity.CandidatoEntity;
import ar.com.fluxit.candidatos.service.impl.ICandidatoService;
import ar.com.fluxit.candidatos.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;


import javax.validation.Valid;
import java.util.List;

/**
 * Created by Pablo on 2/11/2019.
 */
@RestController
@RequestMapping("/candidato")
public class CandidatoController {

    @Autowired
    private ICandidatoService iCandidatoService;

    @GetMapping("/search")
    public ResponseEntity<List<CandidatoDTO>> list(@RequestParam(value = "page", defaultValue = "0")  int page, @RequestParam(value = "size",defaultValue = "10") int size){
        return ResponseEntity.ok(Mapper.mapList(iCandidatoService.all(this.paging(page, size))));
    }

    @GetMapping("/search/name")
    public ResponseEntity<List<CandidatoDTO>> filterByName(@RequestParam("parameter") String name, @RequestParam(value = "page", defaultValue = "0")  int page, @RequestParam(value = "size",defaultValue = "10") int size){
        return ResponseEntity.ok(Mapper.mapList(iCandidatoService.findByName(name,this.paging(page, size))));
    }

    @GetMapping("/search/dni")
    public ResponseEntity<CandidatoDTO> filterByDni(@RequestParam("parameter") String dni, @RequestParam(value = "page", defaultValue = "0")  int page, @RequestParam(value = "size",defaultValue = "10") int size){
        return ResponseEntity.ok(Mapper.map(iCandidatoService.findByDni(dni,this.paging(page, size))));
    }


    @PostMapping
    public ResponseEntity<CandidatoDtoDAO> create(@RequestBody @Valid CandidatoEntity candidatoEntity) throws Exception {
        candidatoEntity.setId(0);
        iCandidatoService.create(candidatoEntity);
        return ResponseEntity.ok(new CandidatoDtoDAO("Se creo correctamente el candidato",candidatoEntity.getDni(),candidatoEntity.getNombre()));
    }

    @PutMapping
    public ResponseEntity<CandidatoDtoDAO> update(@RequestBody CandidatoEntity candidatoEntity) throws Exception {
        iCandidatoService.update(candidatoEntity);
        return ResponseEntity.ok(new CandidatoDtoDAO("Se actualizo correctamente el candidato",candidatoEntity.getDni(),candidatoEntity.getNombre()));
    }

    @DeleteMapping
    public ResponseEntity<CandidatoDtoDAO> delete(@RequestBody @Valid CandidatoEntity candidatoEntity) throws Exception {
        iCandidatoService.delete(candidatoEntity);
        return ResponseEntity.ok(new CandidatoDtoDAO("Se eleimino correctamente el candidato",candidatoEntity.getDni(),candidatoEntity.getNombre()));
    }


    private  Pageable paging (int page,int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by(
                Sort.Order.asc("nombre")));
        return pageable;
    }



}
