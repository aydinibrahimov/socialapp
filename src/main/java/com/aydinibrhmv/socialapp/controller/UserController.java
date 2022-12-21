package com.aydinibrhmv.socialapp.controller;
import com.aydinibrhmv.socialapp.domain.User;
import com.aydinibrhmv.socialapp.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")

public class UserController {
    private final UserService userService;

    public  UserController(UserService userService){
        this.userService=userService;
    }
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping
    public User createUser(@RequestBody User newUser){
        return userService.insert(newUser);
    }
    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId) {
        return userService.getOneUser(userId);
    }

    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId,@RequestBody User newUser){
        return userService.update(userId ,newUser);
    }

    @DeleteMapping("/{userId}")
public void deleteOneUser(@PathVariable Long userId){
        userService.removeById(userId);
    }
}






