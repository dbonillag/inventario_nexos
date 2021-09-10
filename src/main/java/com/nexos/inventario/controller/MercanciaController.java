package com.nexos.inventario.controller;

import com.nexos.inventario.dto.CargoDTO;
import com.nexos.inventario.dto.MercanciaDTO;
import com.nexos.inventario.model.Mercancia;
import com.nexos.inventario.model.QMercancia;
import com.nexos.inventario.model.Usuario;
import com.nexos.inventario.repository.MercanciaRepository;
import com.nexos.inventario.repository.UsuarioRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class MercanciaController {

    @Autowired
    MercanciaRepository mercanciaRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/mercancias")
    public ResponseEntity<?> getAllMercancias(@RequestParam(required = false) @DateTimeFormat(pattern="ddMMyyyy") Date fechaIngreso,
                                                            @RequestParam(required = false) Long usuarioId,
                                                            @RequestParam(required = false) String nombre) {
        try {
            List<MercanciaDTO> mercancias = new ArrayList<MercanciaDTO>();

            if (fechaIngreso == null && usuarioId == null && nombre == null){
                mercanciaRepository.findAll().forEach((mercancia -> {mercancias.add(new MercanciaDTO(mercancia));}));
            }else {

                QMercancia qMercancia = QMercancia.mercancia;

                BooleanExpression predicate = null;
                if (fechaIngreso != null){
                    predicate = qMercancia.fechaIngreso.eq(fechaIngreso);
                }
                if (usuarioId != null){

                    Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);
                    BooleanExpression condicion = qMercancia.createUid.eq(usuario.get());
                    predicate = predicate == null? condicion :predicate.and(condicion);
                }
                if (nombre != null){
                    BooleanExpression condicion = qMercancia.nombre.containsIgnoreCase(nombre);
                    predicate = predicate == null? condicion :predicate.and(condicion);
                }

                mercanciaRepository.findAll(predicate).forEach((mercancia -> {mercancias.add(new MercanciaDTO(mercancia));}));;
            }



            if (mercancias.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(mercancias, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/mercancias/{id}")
    public ResponseEntity<MercanciaDTO> getMercanciaById(@PathVariable("id") long id) {
        Optional<Mercancia> mercanciaData = mercanciaRepository.findById(id);

        if (mercanciaData.isPresent()) {
            return new ResponseEntity<>(new MercanciaDTO(mercanciaData.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/mercancias")
    public ResponseEntity<?> createMercancia(@RequestBody Mercancia mercancia) {
        try {

            Mercancia _mercancia = mercanciaRepository
                    .save(new Mercancia(mercancia.getNombre(), mercancia.getCantidad(), mercancia.getFechaIngreso(), mercancia.getCreateUid()));
            return new ResponseEntity<>(new MercanciaDTO(_mercancia), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/mercancias/{id}")
    public ResponseEntity<MercanciaDTO> writeMercancia(@PathVariable("id") long id, @RequestBody Mercancia mercancia) {
        try {
            Mercancia _mercancia = mercanciaRepository.getById(id);
            _mercancia.setCantidad(mercancia.getCantidad());
            _mercancia.setNombre(mercancia.getNombre());
            _mercancia.setFechaIngreso(mercancia.getFechaIngreso());
            _mercancia.setWriteUid(mercancia.getWriteUid());
            _mercancia.setWriteDate(mercancia.getWriteDate());
            _mercancia = mercanciaRepository
                    .save(_mercancia);
            return new ResponseEntity<>(new MercanciaDTO(_mercancia), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/mercancias/{id}")
    public ResponseEntity<String> deleteMercancia(@PathVariable("id") Long id, @RequestParam long uid) {
        try{
            Optional<Mercancia> mercancia = mercanciaRepository.findById(id);

            if (mercancia.isPresent()) {
                if (mercancia.get().getCreateUid().getId() == uid){
                    mercanciaRepository.deleteById(id);
                    return new ResponseEntity<>("{\"mensaje\":\"Registro eliminado\"}", HttpStatus.OK);
                }else{
                    return new ResponseEntity<>("{\"mensaje\":\"Solo el usuario que creó el registro puede eliminarlo\"}", HttpStatus.CONFLICT);
                }

            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    

}