package com.example.t1academylimits.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Table(name = "holds")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Holds {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(nullable = false, name = "limit_id")
        private Integer limit;

        @Column(nullable = false, name = "amount")
        private BigDecimal amount;

        @Column(nullable = false, name = "operation_id")
        private UUID operationId;
}
