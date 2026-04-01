package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MyUser;
import com.example.demo.repository.MyUserRepo;

@Service
public class UserService implements IUserService{
	@Autowired
	MyUserRepo repo;
	
	@Override
	public MyUser addUser(MyUser user) {
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		String encryptedPassword = bCrypt.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		return repo.save(user);
	}

	@Override
	public String authenticateUser(MyUser user) {
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		Optional<MyUser> op = repo.findById(user.getUsername());
		if(op.isPresent()) {
			MyUser dbUser = op.get();
			if(bCrypt.matches(user.getPassword(), dbUser.getPassword())) {
				return "Authorized User.";
			}
			else {
				return "Invalid Password.";
			}
		}
		throw new UsernameNotFoundException("User Not Found");
	}

}
