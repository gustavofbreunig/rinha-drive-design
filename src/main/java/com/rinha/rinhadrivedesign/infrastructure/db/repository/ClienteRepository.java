package com.rinha.rinhadrivedesign.infrastructure.db.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import com.rinha.rinhadrivedesign.infrastructure.db.entities.ClienteEntity;

import jakarta.persistence.LockModeType;


public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {

    @SuppressWarnings("null")
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<ClienteEntity> findById(Integer id);
}
