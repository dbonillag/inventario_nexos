package com.nexos.inventario.repository;

import com.nexos.inventario.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CargoRepository extends JpaRepository<Cargo, Long> {

}
