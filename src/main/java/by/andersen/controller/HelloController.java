package by.andersen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/check")
    public String check() {
        return "I'm alive";
    }

    @PostMapping("/check")
    public String checkPost(@RequestParam String postName) {
        return "I'm alive POST TYPE REQUEST " + postName;
    }
}
