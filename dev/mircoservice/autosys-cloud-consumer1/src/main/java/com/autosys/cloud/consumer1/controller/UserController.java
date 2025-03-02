package com.autosys.cloud.consumer1.controller;


import com.autosys.cloud.consumer1.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/client")
@RefreshScope
public class UserController {

    @Autowired
    private UserClient userClient;

    @GetMapping("/{id}")
    public Map<String, Object> getUser(@PathVariable Long id) {
        return userClient.getUserById(id);
    }

    @GetMapping("/users")
//    public String addUser(@RequestParam Long id, @RequestParam String name) {
    public String addUser() {
        Long id = 1L;
        String name = "Alice";
        System.out.println("消费端发送 ");
        System.out.println("id -> " + id);
        System.out.println("name -> " + name);
        Map<String, Object> user = new HashMap<>();
        user.put("id", id);
        user.put("name", name);
        return userClient.addUser(user);
    }
}

