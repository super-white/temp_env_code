package com.autosys.cloud.provider1.controller;


import com.autosys.cloud.provider1.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        System.out.println("服务端提供服务，id");
        System.out.println(id);
        return new User(id, "John Doe");
    }

    @PostMapping
    public String addUser(@RequestBody Map<String, Object> userData) {
        Long id = ((Number) userData.get("id")).longValue();
        String name = (String) userData.get("name");

        User user = new User(id, name);
        System.out.println("服务端 user add ");
        System.out.println(user);
        return "User added: " + user.getName();
    }
}

