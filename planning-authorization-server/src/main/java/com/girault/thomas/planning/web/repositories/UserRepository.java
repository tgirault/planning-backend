package com.girault.thomas.planning.web.repositories;

import com.girault.thomas.planning.web.domains.User;

public interface UserRepository extends BaseRepository<User, Long> {
	
	/**
	 * Find by email.
	 *
	 * @param email the email
	 * @return the user
	 */
	User findByEmail(String email);
}