package com.rinha.rinhadrivedesign.infrastructure.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rinha.rinhadrivedesign.infrastructure.db.entities.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {
    
}
