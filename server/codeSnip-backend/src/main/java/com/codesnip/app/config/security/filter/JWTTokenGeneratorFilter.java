package com.codesnip.app.config.security.filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.codesnip.app.config.security.constants.JWT;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JWTTokenGeneratorFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// JWT generator
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (null != authentication) {
			SecretKey key = Keys.hmacShaKeyFor(JWT.JWT_KEY.getBytes(StandardCharsets.UTF_8));
			String jwt = Jwts.builder().setIssuer("CodeSnip").setSubject("JWT Token")
					.claim("email", authentication.getName())
					.claim("authorities", populateAuthorities(authentication.getAuthorities())).setIssuedAt(new Date())
					.setExpiration(new Date((new Date()).getTime() + 30000000)).signWith(key).compact();
			response.setHeader(JWT.JWT_HEADER, jwt);
		}

		filterChain.doFilter(request, response);
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {
		// only generate a JWT token when this path is encountered
		return !request.getServletPath().equals("/user");
	}

	private String populateAuthorities(Collection<? extends GrantedAuthority> collection) {
		// get all the authorities and join them in a single string
		Set<String> authoritiesSet = new HashSet<>();
		for (GrantedAuthority authority : collection) {
			authoritiesSet.add(authority.getAuthority());
		}
		return String.join(",", authoritiesSet);
	}

}
