package com.girault.thomas.planning.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.girault.thomas.planning.web.dto.UserDTO;
import com.girault.thomas.planning.web.services.UserService;

/**
 * The Class UserController.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

	/** The user service. */
	@Autowired(required = true)
	@Qualifier("userService")
	private UserService userService;

	/**
	 * Creates the.
	 *
	 * @param userDTO
	 *            the user dto
	 * @return the user dto
	 */
	@CrossOrigin
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public UserDTO create(@RequestBody UserDTO userDTO) {
		return this.userService.save(userDTO);
	}
}