package com.project.oms.repository;

import com.project.oms.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long > {

}
