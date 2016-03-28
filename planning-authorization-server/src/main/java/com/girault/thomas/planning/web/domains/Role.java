package com.girault.thomas.planning.web.domains;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The Class Role.
 */
@Entity
@Table(name = "roles")
public class Role implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8524731862669992327L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_id_seq")
	@SequenceGenerator(name = "roles_id_seq", sequenceName = "roles_id_seq", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	/** The name. */
	private String name;

	/** The users. */
	@ManyToMany(mappedBy = "roles")
	private Collection<User> users;

	/**
	 * Instantiates a new role.
	 */
	public Role() {
		super();
	}

	/**
	 * Instantiates a new role.
	 *
	 * @param aName
	 *            the a name
	 */
	public Role(String aName) {
		super();
		this.name = aName;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
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

	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	public Collection<User> getUsers() {
		return users;
	}

	/**
	 * Sets the users.
	 *
	 * @param users
	 *            the new users
	 */
	public void setUsers(Collection<User> users) {
		this.users = users;
	}

}