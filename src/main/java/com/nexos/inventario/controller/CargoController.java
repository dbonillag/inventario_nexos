package com.nexos.inventario.controller;

import com.nexos.inventario.dto.CargoDTO;
import com.nexos.inventario.model.Cargo;
import com.nexos.inventario.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CargoController {

    @Autowired
    CargoRepository cargoRepository;

    @GetMapping("/cargos")
    public ResponseEntity<List<CargoDTO>> getAllCargos() {
        try {
            List<CargoDTO> cargos = new ArrayList<CargoDTO>();


            cargoRepository.findAll().forEach((cargo -> {cargos.add(new CargoDTO(cargo));}));


            if (cargos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(cargos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cargos/{id}")
    public ResponseEntity<CargoDTO> getCargoById(@PathVariable("id") long id) {
        Optional<Cargo> cargoData = cargoRepository.findById(id);

        if (cargoData.isPresent()) {
            return new ResponseEntity<>(new CargoDTO(cargoData.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/cargos")
    public ResponseEntity<CargoDTO> createCargo(@RequestBody Cargo cargo) {
        try {
            Cargo _cargo = cargoRepository
                    .save(new Cargo(cargo.getNombre()));
            return new ResponseEntity<>(new CargoDTO(_cargo), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}