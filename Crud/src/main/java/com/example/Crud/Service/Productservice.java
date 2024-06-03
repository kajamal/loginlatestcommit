package com.example.Crud.Service;


import com.example.Crud.Model.Product;
import com.example.Crud.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Productservice {

    @Autowired
    private ProductRepo productRepo;

    public Product send(Product product){
        return productRepo.save(product);
    }

    public List<Product> showall() {
        return productRepo.findAll();
    }


}
