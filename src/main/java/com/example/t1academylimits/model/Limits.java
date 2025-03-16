package com.example.t1academylimits.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Table(name = "limits")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Limits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "limit")
    private BigDecimal limit;

    @Column(nullable = false, name = "hold")
    private BigDecimal hold;

    @Column(nullable = false, name = "client_id")
    private Long clientId;
}
