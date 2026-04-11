package com.example.userservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userservice.exception.UserNotFoundException;
import com.example.userservice.model.User;
import com.example.userservice.repository.IUserRepository;

@Service
public class UserService {
	
	@Autowired
    private IUserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(int id) {
    	Optional<User> op = userRepository.findById(id);
    	if(op.isPresent()) {
    		User user = op.get();
    		return user;
    	}
    	else {
    		throw new UserNotFoundException("UserNotFound!");
    	}
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}