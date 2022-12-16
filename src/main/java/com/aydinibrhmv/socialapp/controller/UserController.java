package com.aydinibrhmv.socialapp.controller;
import com.aydinibrhmv.socialapp.domain.User;
import com.aydinibrhmv.socialapp.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")

public class UserController {
    private final UserRepository userRepository;

    public  UserController(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }
    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId,@RequestBody User newUser){
        Optional<User> user=userRepository.findById(userId);
    if(user.isPresent()){
    User foundUser=user.get();
    foundUser.setFirstname(newUser.getFirstname());
    foundUser.setLastname(newUser.getLastname());
    foundUser.setPassword(newUser.getPassword());
    return userRepository.save(foundUser);}
    else{
    return null;}
    }
    @DeleteMapping("/{userId}")
public void deleteOneUser(@PathVariable Long userId){
        userRepository.deleteById(userId);
    }
}






