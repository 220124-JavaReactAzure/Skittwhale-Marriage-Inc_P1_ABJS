package com.revature.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.services.UserService;

public class Wedding {
	private final UserService userService;
	private final ObjectMapper mapper;

	public Wedding(UserService userService, ObjectMapper mapper) {
		this.userService = userService;
		this.mapper = mapper;
	}

}
