package com.girault.thomas.planning.web.repositories;

import com.girault.thomas.planning.web.domains.Role;

public interface RoleRepository extends BaseRepository<Role, Long> {
	
	Role findByName(String name);
}