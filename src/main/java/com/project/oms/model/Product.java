package com.project.oms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(unique = true, nullable = false)
    private String productName;

    @Column(nullable = false)
    private double price;

    private int quantity;


}
