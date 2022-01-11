package com.afro.security.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user ;
	
	public CustomUserDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomUserDetails(User user)
	{
		this.user=user ;
		
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		return getGrantedAuthority(user.getRole());
	
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return user.isStatus();
		
	}

		//--------------------------------
	private List<GrantedAuthority> getGrantedAuthority(String roles)
	{
		return Arrays.stream(roles.split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}
}
