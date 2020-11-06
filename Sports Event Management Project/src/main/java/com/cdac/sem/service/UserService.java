package com.cdac.sem.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.cdac.sem.model.User;
import com.cdac.sem.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
