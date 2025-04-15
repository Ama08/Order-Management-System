package com.project.oms.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orderItems")

public class OrderItem extends Order{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long OrderItemId;



}
