package com.thomascruzana.codesnip.service;

import com.thomascruzana.codesnip.dto.UserDto;
//service interface
public interface UserService {
	public UserDto createUser(UserDto userDto);

	public UserDto readByEmail(String email);

}
