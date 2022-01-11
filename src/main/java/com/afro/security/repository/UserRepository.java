package com.afro.security.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.afro.security.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public Optional<User>  findByUserName(String userName);
}
