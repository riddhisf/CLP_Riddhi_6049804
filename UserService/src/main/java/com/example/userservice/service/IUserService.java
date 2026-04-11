package com.example.userservice.service;

import java.util.List;

import com.example.userservice.model.User;

public interface IUserService {
	public User createUser(User user);
	public User getUserById(int id);
	public List<User> getAllUsers();
}
