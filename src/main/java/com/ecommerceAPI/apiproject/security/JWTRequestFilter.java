package com.ecommerceAPI.apiproject.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.ecommerceAPI.apiproject.entity.User;
import com.ecommerceAPI.apiproject.repository.UserRepository;
import com.ecommerceAPI.apiproject.security.service.JWTService;

@Component
public class JWTRequestFilter extends OncePerRequestFilter {

  private JWTService jwtService;
  private UserRepository userRepository;

 
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    String tokenHeader = request.getHeader("Authorization");
    if (tokenHeader != null && tokenHeader.startsWith("Bearer ")) {
      String token = tokenHeader.substring(7);
      try {
        String username = jwtService.getUsername(token);
        Optional<User> opUser = userRepository.findByUsernameIgnoreCase(username);
        if (opUser.isPresent()) {
          User user = opUser.get();
          UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, new ArrayList());
          authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
          SecurityContextHolder.getContext().setAuthentication(authentication);
        }
      } catch (JWTDecodeException ex) {
      }
    }
    filterChain.doFilter(request, response);
  }

}