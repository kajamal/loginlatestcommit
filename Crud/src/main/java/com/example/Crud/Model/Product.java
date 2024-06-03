package com.example.Crud.Model;

import lombok.Data;


import javax.persistence.*;


@Entity
@Data
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private String productname;
    private  String description;
    private String price;
    private String category;


}



