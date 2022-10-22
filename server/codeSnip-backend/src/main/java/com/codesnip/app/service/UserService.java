package com.codesnip.app.service;

import com.codesnip.app.dto.UserDto;
//service interface
public interface UserService {
	public UserDto createUser(UserDto userDto);

	public UserDto readByEmail(String email);

}
