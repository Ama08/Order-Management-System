package com.project.oms.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDTO {
    private Long productId;
    private String productName;
    private double price;
    private int quantity;


}
