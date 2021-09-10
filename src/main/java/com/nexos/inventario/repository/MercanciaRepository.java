package com.nexos.inventario.repository;

import com.nexos.inventario.model.Mercancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;

import java.util.Date;
import java.util.List;

public interface MercanciaRepository extends JpaRepository<Mercancia, Long>,
        QuerydslPredicateExecutor<Mercancia>{




}