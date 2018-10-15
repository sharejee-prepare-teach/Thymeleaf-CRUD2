package com.example.springmvc.controller;

import com.example.springmvc.model.Product;
import com.example.springmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Rith on 10/14/2018.
 */
@RestController
public class RestProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/list_pros",method = RequestMethod.GET)
    private List<Product> getAllProducts(){
        return productService.findAll();
    }

    @RequestMapping(value = "/list_pros/{name}",method = RequestMethod.GET)
    private List<Product> getProductByName(@PathVariable("name") String name){
        List<Product> products = productService.findByName(name);
        System.out.println("Product: " + products);
        return products;
    }

}
