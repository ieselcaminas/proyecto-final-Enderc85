package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;

import java.util.Scanner;

@Controller
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void createUser() {
        String username;
        String password;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your username");
        username = sc.nextLine();

        System.out.println("Enter a valid password");
        password = sc.nextLine();
    }
}
