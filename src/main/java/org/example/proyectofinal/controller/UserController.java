package org.example.proyectofinal.controller;

import org.springframework.stereotype.Controller;
import org.example.proyectofinal.service.UserService;

import java.util.Scanner;

@Controller
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void createUser() {
        String username;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your username");
        username = sc.nextLine();
    }
}
