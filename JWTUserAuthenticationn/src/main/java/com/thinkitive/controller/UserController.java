package com.thinkitive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thinkitive.model.AuthRequest;
import com.thinkitive.model.User;
import com.thinkitive.repository.UserRepository;
import com.thinkitive.util.JwtUtil;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class UserController {
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthenticationManager authenticationmanager;
	@Autowired
	private JwtUtil jwtUtil;
	
	@RequestMapping(value = "/adduser",method =RequestMethod.POST )
	public String insertUser(@RequestBody User user)
	{
		userRepository.save(user);
		return "User Added Successfully";
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/hello",method =RequestMethod.GET )
	public String getHello()
	{
		return "Hello world";
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/authenticate",method = RequestMethod.POST)
	public String generateToken(@RequestBody AuthRequest authrequest) throws Exception
	{
		try
		{
			authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(authrequest.getUsername(), authrequest.getPassword()));
			
			
		}
		catch(BadCredentialsException e)
		{
			throw new Exception("Incorrect username or password");
		}
		final UserDetails userDetails=userDetailsService.loadUserByUsername(authrequest.getUsername());
		return jwtUtil.generateToken(userDetails.getUsername());
		
	}

}
