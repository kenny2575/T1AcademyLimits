package com.example.t1academylimits.repository;

import com.example.t1academylimits.model.Holds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface HoldsRepository extends JpaRepository<Holds, Integer> {

    Optional<Holds> findByOperationId(UUID operationId);

    void deleteByOperationId(UUID operationId);
}
