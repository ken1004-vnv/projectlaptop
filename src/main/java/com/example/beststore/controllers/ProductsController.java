package com.example.beststore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.beststore.models.Product;
import com.example.beststore.services.ProductsRepository;


@Controller
@RequestMapping("/")
public class ProductsController {
    @Autowired
    private ProductsRepository repo;


    @GetMapping({ "/"})
    public String ShowProductList(Model model) {
        List<Product> products = repo.findAll();//Sort.by(Sort.Direction.DESC, "id")
        model.addAttribute("products", products);
        return "products/index";
    }

    @GetMapping({"/home"})
    public String showhomeProductList(Model model) {
        List<Product> products = repo.findAll();//Sort.by(Sort.Direction.DESC, "id")
        model.addAttribute("products", products);
        return "products/home";
    }


}

