package com.girault.thomas.planning.web.domains;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The Class BaseEntity.
 * 
 * @author Thomas Girault
 * @version 1.0
 * @since 12/02/2016
 */
public abstract class BaseEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2579342256929023832L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/** The time created. */
	private Date timeCreated;

	/**
	 * Instantiates a new base entity.
	 */
	public BaseEntity() {
		super();
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
	 * Gets the time created.
	 *
	 * @return the time created
	 */
	public Date getTimeCreated() {
		return timeCreated;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return getId().hashCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		BaseEntity that = (BaseEntity) o;

		if (!id.equals(that.id))
			return false;

		return true;
	}
}