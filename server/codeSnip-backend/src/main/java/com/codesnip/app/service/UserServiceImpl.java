package com.codesnip.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codesnip.app.dto.UserDto;
import com.codesnip.app.entity.User;
import com.codesnip.app.repository.UserRepository;
import com.codesnip.app.util.Role;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDto createUser(UserDto userDto) {
		// persist new customer data
		User newUser = new User();

		// hash the password using bcrypt!
		String hashedPassword = passwordEncoder.encode(userDto.getPassword());
		userDto.setPassword(hashedPassword);
		// log

		// register current date
		userDto.setDateCreated(new Date(System.currentTimeMillis()));
		// log

		// transfer customer data
		newUser.setUsername(userDto.getUsername());
		newUser.setEmail(userDto.getEmail());
		newUser.setPassword(userDto.getPassword());
		newUser.setDateCreated(userDto.getDateCreated());
		newUser.setRole(Role.ROLE_FREE_USER.name());
		newUser.setEnabled(true);
		userRepository.save(newUser);
		// log

		return userDto;
	}

	@Override
	public UserDto readByEmail(String email) {
		UserDto userDto;
		List<User> users = userRepository.findByEmail(email);

		if (users.size() > 0) {
			// convert and return customer to customerDto type
			userDto = new UserDto(users.get(0));
			// log
			return userDto;
		}

		// return null if no customer is found!
		return null;
	}

}
