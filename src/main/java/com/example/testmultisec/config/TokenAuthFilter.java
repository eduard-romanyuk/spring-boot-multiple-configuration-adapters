package com.example.testmultisec.config;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class TokenAuthFilter extends OncePerRequestFilter {
	private final String token;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		Optional.ofNullable(request.getHeader("Authorization"))
				.filter(token::equals)
				.ifPresent(this::setAuthentication);
		filterChain.doFilter(request, response);
	}

	private void setAuthentication(String token) {
		Authentication authentication = new UsernamePasswordAuthenticationToken("test", token, Collections.emptyList());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
}
