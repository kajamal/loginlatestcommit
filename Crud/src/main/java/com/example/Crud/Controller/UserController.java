package com.example.Crud.Controller;

import com.example.Crud.Model.Product;
import com.example.Crud.Service.Productservice;
import com.example.Crud.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.Crud.Model.Userlogin;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Productservice productservice;


    @GetMapping("/")
    public String showCreateUserForm() {
        return "login";
    }

    @GetMapping("/createUser")
    public String showCreateUserPages() {
        return "createUser";
    }

    @PostMapping("/register_success")
    public String createUser(@ModelAttribute Userlogin userlogin, Model model) {

        if (userlogin.getPassword().equals(userlogin.getConfirm_password())) {;
            userService.createuser(userlogin);
            model.addAttribute("message", "Register successful");

            return "createUser";


        } else {
            model.addAttribute("error", "Password do not match.");

            return "createUser";
        }
    }
    @GetMapping("/tologin")
    public String backtosignin() {
        return "login";
    }

    
    @GetMapping("/showproductindex")
    public String showproductform() {
        return "products";
    }

    @PostMapping("/createpro")
    public Product senddata(@RequestBody Product product){
        return productservice.send(product);

    }




    @GetMapping("/products")
    public String getAllProducts(Model model) {
        List<Product> products = productservice.showall();
        model.addAttribute("products", products);
        return "productindex";
    }



    @PostMapping("/login")
    public String login(@ModelAttribute Userlogin userlogin, Model model) {
        Userlogin authenticated = userService.authenticate(userlogin.getUsername(), userlogin.getPassword());
        if (authenticated != null) {
            return "products";
        } else {
            model.addAttribute("error_message", "Invalid username or password");
            return "login";
        }

    }

//    @GetMapping("/welcome")
//    public String showWelcomePage() {
//        return "welcome";
//    }




//        @GetMapping("/login")
//        public  String loginsuccess (@ModelAttribute Userlogin userlogin, Model model)
//
//
//
//        }


    }




