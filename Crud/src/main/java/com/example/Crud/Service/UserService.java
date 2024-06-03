package com.example.Crud.Service;

import com.example.Crud.Model.Userlogin;
import com.example.Crud.Repository.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService  {

    @Autowired
    private  Userrepo userrepo;

//    @Autowired
//    PasswordEncoder passwordEncoder;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public Userlogin createuser(Userlogin user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userrepo.save(user);
        return user;
    }

//    public Userlogin authenticate(String username, String password) {
//        return userrepo.findByUsernameAndPassword(username, password).orElse(null);
//    }


    public Userlogin authenticate(String username, String password) {
        Userlogin user = userrepo.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        } else {
            return null;
        }
        }

    }





