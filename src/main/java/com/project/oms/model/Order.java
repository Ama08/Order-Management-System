package com.project.oms.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long OrderIds;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne // many orders to one user
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;

}
