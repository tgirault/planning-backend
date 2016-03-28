package com.girault.thomas.planning.web.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class RoleDTO.
 */
public class RoleDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1917227704624075358L;

	/** The name. */
	private String name;

	/**
	 * Instantiates a new role dto.
	 */
	public RoleDTO() {
		super();
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
