package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MyUser;
import com.example.demo.repository.MyUserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	MyUserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<MyUser> op= repo.findById(username);
		if(op.isPresent()) {
			MyUser user= op.get();
			return new MyUserDetails(user);
		}
		else {
			throw new UsernameNotFoundException("User Not Found");
		}
	}

}
