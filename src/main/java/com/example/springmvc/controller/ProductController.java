package com.example.springmvc.controller;

import com.example.springmvc.model.Product;
import com.example.springmvc.repository.ProductRepository;
import com.example.springmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService perProductService;


    @RequestMapping(path = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public String getAllProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    @RequestMapping(path = "/products/add", method = RequestMethod.GET)
    public String createProduct(Model model) {
        model.addAttribute("product", new Product());
        return "edit";
    }

    @RequestMapping(path = "products", method = RequestMethod.POST)
    public String saveProduct(Product product) {
        productRepository.save(product);
        return "redirect:/";
    }

    @RequestMapping(path = "/products/edit/{id}", method = RequestMethod.GET)
    public String editProduct(Model model, @PathVariable(value = "id") Long id) {
        model.addAttribute("product", productRepository.findOne(id));
        return "edit";
    }

    @RequestMapping(path = "/products/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        productRepository.delete(id);
        return "redirect:/products";
    }

    @RequestMapping(path = "/products/search",method = RequestMethod.POST)
    public String getNameProduct(Model model,Product product) {
        List<Product> perProduct = perProductService.findByName(product.getName());
        System.out.println("Product: " + perProduct);
        model.addAttribute("products", perProduct);
        return "redirect:/products";
    }

    @RequestMapping(path = "/products/search", method = RequestMethod.GET)
    public String searchProduct(Model model) {
        model.addAttribute("product", new Product());
        return "search";
    }

}
