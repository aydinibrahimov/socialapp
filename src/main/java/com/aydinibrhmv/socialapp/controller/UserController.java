package com.aydinibrhmv.socialapp.controller;

import com.aydinibrhmv.socialapp.domain.User;
import com.aydinibrhmv.socialapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.util.BeanDefinitionUtils;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
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
    @GetMapping("/{userId}")
    public User getuserById(@PathVariable Long userId){
       return userRepository.findById(userId).orElseThrow(()->new RuntimeException("Not specified user with "+userId));
    }
    @PutMapping("/{userId}")
    public User update(@PathVariable Long userId,@RequestBody User newUser) {
        return userRepository.findById(userId)
                    .map(user -> {
                        BeanUtils.copyProperties(newUser,user);
                        return userRepository.save(user);
                    }).orElseGet(()->{
                    newUser.setId(userId);
                    return userRepository.save(newUser);
        });}

    @DeleteMapping("{userId}")
    public void delete(@PathVariable Long userId){
        userRepository.deleteById(userId);

    }
}