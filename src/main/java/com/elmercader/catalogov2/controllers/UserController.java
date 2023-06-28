package com.elmercader.catalogov2.controllers;

import com.elmercader.catalogov2.models.User;
import com.elmercader.catalogov2.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserServices userServices;

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userServices.getAllUsers();
    }

    @GetMapping("/zone/{zone}")
    public List<User> getUsersByZone(@PathVariable("zone") String zone){
        return userServices.getUsersByZone(zone);
    }

    @GetMapping("/type/{type}")
    public List<User> getUsersByType(@PathVariable("type") String type){
        return userServices.getUsersByType(type);
    }

    @GetMapping("/{userId}")
    public Optional<User> getUserById(@PathVariable("userId") Integer userId){
        return userServices.getUserById(userId);
    }

    @GetMapping("/emailexist/{email}")
    public Optional<User> getUserByEmail(@PathVariable("email") String email){
        return userServices.getUserByEmail(email);
    }

    @GetMapping("/{email}/{password}")
    public Optional<User> validateLogin(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userServices.validateUserLogin(email, password);
    }

    @PostMapping("/new")
    public User insertUser(@RequestBody User user){
        return userServices.insertUser(user);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user){
        return userServices.updateUser(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId){
        userServices.deleteUser(userId);
    }
}
