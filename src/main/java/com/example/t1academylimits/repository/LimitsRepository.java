package com.example.t1academylimits.repository;

import com.example.t1academylimits.model.Limits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface LimitsRepository extends JpaRepository<Limits, Long> {

    @Modifying
    @Query("UPDATE Limits l SET l.amount = :newLimit WHERE l.hold <= :newLimit")
    void updateLimitsWhereHoldIsLessThan(@Param("newLimit") BigDecimal newLimit);

    Optional<Limits> findByClientId(Long clientId);
}
