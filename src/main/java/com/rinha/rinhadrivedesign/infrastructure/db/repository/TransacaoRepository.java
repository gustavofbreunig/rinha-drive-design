package com.rinha.rinhadrivedesign.infrastructure.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rinha.rinhadrivedesign.infrastructure.db.entities.ClienteEntity;
import com.rinha.rinhadrivedesign.infrastructure.db.entities.TransacaoEntity;
import java.util.List;


public interface TransacaoRepository extends JpaRepository<TransacaoEntity, Integer> {
    List<TransacaoEntity> findFirst10ByClienteOrderByRealizadaEmDesc(ClienteEntity cliente);
}
