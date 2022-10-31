package com.aydinibrhmv.socialapp.controller;

import com.aydinibrhmv.socialapp.domain.User;
import com.aydinibrhmv.socialapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers(){
        return  userRepository.findAll();
    }
    @PostMapping
    public User insert(@RequestBody User user){
        return userRepository.save(user);
    }
    @GetMapping("/{userId")
    public User getuserById(@PathVariable Long userId){
       return userRepository.findById(userId).orElseThrow(()->new RuntimeException("Not specified user with "+userId));
    }
    @PutMapping("/{userId}")
    public User update(@PathVariable Long userId,@RequestBody User newUser){
        Optional<User> user=userRepository.findById(userId);
        if(user.isPresent()) {
        user.
    }

}
