package com.girault.thomas.planning.web.dto;

import java.io.Serializable;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDTO.
 */
public class UserDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2827755345888213978L;

	/** The email. */
	private String email;

	/** The hashed password. */
	private String hashedPassword;

	/** The roles. */
	private Set<RoleDTO> roles;

	/**
	 * Instantiates a new user dto.
	 */
	public UserDTO() {
		super();
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the hashed password.
	 *
	 * @return the hashed password
	 */
	public String getHashedPassword() {
		return hashedPassword;
	}

	/**
	 * Sets the hashed password.
	 *
	 * @param hashedPassword
	 *            the new hashed password
	 */
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	/**
	 * Gets the roles.
	 *
	 * @return the roles
	 */
	public Set<RoleDTO> getRoles() {
		return roles;
	}

	/**
	 * Sets the roles.
	 *
	 * @param roles
	 *            the new roles
	 */
	public void setRoles(Set<RoleDTO> roles) {
		this.roles = roles;
	}
}
