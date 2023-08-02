package com.aydinibrhmv.socialapp.service;

import com.aydinibrhmv.socialapp.domain.User;
import com.aydinibrhmv.socialapp.enums.CustomErrorCode;
import com.aydinibrhmv.socialapp.exception.CustomException;
import com.aydinibrhmv.socialapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User insert(User newUser) {
        return userRepository.save(newUser);
    }

    public User getOneUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(CustomErrorCode.USER_NOT_FOUND));
    }

    public User update(Long userId, User newUser) {
            User foundUser = getUser(userId);
            foundUser.setFirstname(newUser.getFirstname());
            foundUser.setLastname(newUser.getLastname());
            foundUser.setPassword(newUser.getPassword());
            return userRepository.save(foundUser);

    }


    public void removeById(Long userId) {
        userRepository.delete(getUser(userId));
        ;

    }

    private User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new CustomException(CustomErrorCode.USER_NOT_FOUND));
    }
}
