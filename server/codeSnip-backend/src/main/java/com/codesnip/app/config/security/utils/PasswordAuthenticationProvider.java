package com.codesnip.app.config.security.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.codesnip.app.entity.Authority;
import com.codesnip.app.entity.User;
import com.codesnip.app.repository.UserRepository;

// password auth and bcrypt provider
@Component
public class PasswordAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	// authentication method that validates user credential
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String email = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		List<User> user = userRepository.findByEmail(email);
		if (user.size() > 0) {
			if (passwordEncoder.matches(pwd, user.get(0).getPassword())) {
				return new UsernamePasswordAuthenticationToken(email, pwd,
						getGrantedAuthorities(user.get(0).getAuthorities()));
			} else {
				throw new BadCredentialsException("The email or password is incorrect.");
			}
		} else {
			throw new BadCredentialsException(
					"This email does not belong to an account. Please check your email and try again");
		}
	}

	// authority or role fetcher
	private List<GrantedAuthority> getGrantedAuthorities(Set<Authority> authorities) {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		for (Authority authority : authorities) {
			grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
		}
		return grantedAuthorities;
	}

	// checks if the provider supports the object
	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
