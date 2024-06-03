package com.example.Crud.Model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Users")
public class Userlogin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String email;
    private String password;
    private String confirm_password;
}

