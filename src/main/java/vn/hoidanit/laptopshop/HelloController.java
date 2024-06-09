package vn.hoidanit.laptopshop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String sayHello() {
        return "Hello, World!";
    }

    @GetMapping("/user")
    public String userPage() {
        return "only user!";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "only admin!";
    }
}
