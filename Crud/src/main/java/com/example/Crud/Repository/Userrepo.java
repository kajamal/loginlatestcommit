package com.example.Crud.Repository;

import com.example.Crud.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Userrepo extends JpaRepository<Userlogin,Integer> {

  Optional<Userlogin> findByUsernameAndPassword(String username, String password);

  Userlogin findByUsername(String username);

//  Userlogin findByUsername(String username);

//
//  Userlogin findByUsername(String username);
}