package com.example.springmvc.service;

import com.example.springmvc.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Rith on 10/13/2018.
 */
public interface ProductService {
    List<Product> findByName(String name);

    List<Product> findAll();
}
