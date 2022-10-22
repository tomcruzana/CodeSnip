package com.codesnip.app.config.security.filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.codesnip.app.config.security.constants.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JWTTokenValidatorFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(javax.servlet.http.HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response, javax.servlet.FilterChain filterChain)
			throws javax.servlet.ServletException, IOException {

		// get request header matching the JWT header constant key
		String jwt = request.getHeader(JWT.JWT_HEADER);

		// if JWT header is present
		if (null != jwt) {
			try {
				SecretKey key = Keys.hmacShaKeyFor(JWT.JWT_KEY.getBytes(StandardCharsets.UTF_8));

				Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
				String email = String.valueOf(claims.get("email"));
				String authorities = (String) claims.get("authorities");
				Authentication auth = new UsernamePasswordAuthenticationToken(email, null,
						AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));
				SecurityContextHolder.getContext().setAuthentication(auth);
			} catch (Exception e) {
				throw new BadCredentialsException("Invalid Token received!");
			}

		}
		filterChain.doFilter(request, response);
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {
		return request.getServletPath().equals("/user");
	}

}
