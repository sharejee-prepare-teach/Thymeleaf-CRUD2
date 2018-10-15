package com.example.springmvc.service;

import com.example.springmvc.model.Product;
import com.example.springmvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Rith on 10/13/2018.
 */
@Service
@Transactional
public class ProductServiceImpl  implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public java.util.List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
