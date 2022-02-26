package by.andersen.controller;

import by.andersen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        userService.saveUserWithCreds(username, password);
        return "SUCCESS";
    }
}
