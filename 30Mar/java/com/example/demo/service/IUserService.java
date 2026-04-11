package com.example.demo.service;

import com.example.demo.entity.MyUser;

public interface IUserService {
	public MyUser addUser(MyUser user);
	public String authenticateUser(MyUser user);
}
