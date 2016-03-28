package com.girault.thomas.planning.web.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.girault.thomas.planning.web.domains.Role;
import com.girault.thomas.planning.web.domains.User;
import com.girault.thomas.planning.web.dto.UserDTO;
import com.girault.thomas.planning.web.repositories.RoleRepository;
import com.girault.thomas.planning.web.repositories.UserRepository;

/**
 * The Class UserService.
 */
@Service("userService")
public class UserService implements UserDetailsService {

	/** The user repository. */
	@Autowired
	private UserRepository userRepository;
	
	/** The role repository. */
	@Autowired
	private RoleRepository roleRepository;

	/**
	 * Creates the.
	 *
	 * @param userDTO
	 *            the user dto
	 * @return the user dto
	 */
	public UserDTO save(@RequestBody UserDTO userDTO) {
		User user = new User();
		user.setEmail(userDTO.getEmail());
		user.setHashedPassword(userDTO.getHashedPassword());
		
		Role role = this.roleRepository.findByName("USER");
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		
		user.setRoles(roles);
		
		user.setEnabled(Boolean.TRUE);

		user = this.userRepository.save(user);

		UserDTO newUserDTO = new UserDTO();
		newUserDTO.setEmail(user.getEmail());

		return newUserDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("No user found with username: " + email);
		}
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword().toLowerCase(),
				enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, user.getAuthorities());
	}
}
