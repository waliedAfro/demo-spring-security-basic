package com.afro.security.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.afro.security.model.CustomUserDetails;
import com.afro.security.model.User;
import com.afro.security.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	private UserRepository  userRepository ; 
	
	public CustomUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> user=  userRepository.findByUserName(username);
		
		user.orElseThrow(()-> new UsernameNotFoundException("User Not found :"+username));
		
		return user.map(CustomUserDetails::new).get();
	}

}
