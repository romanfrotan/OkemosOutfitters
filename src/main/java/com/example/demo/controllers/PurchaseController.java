package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class PurchaseController {

    @Autowired
    private ProductRepository productRepository;


    @GetMapping("/buyNow")
    @Transactional
    public String buyProduct(@RequestParam("productID")long theId, Model theModel){

      Optional<Product> theProduct = productRepository.findById(theId);

        if(theProduct.isPresent()){
            Product ourProduct=theProduct.get();
          if(ourProduct.getInv()>0) {

              System.out.println(ourProduct.getInv());
              System.out.println(ourProduct.getName());

              int decrement = ourProduct.getInv() - 1;
              ourProduct.setInv(decrement);
              return "confirmation-page";
          }

        }

        return "error-page";

    }

}
