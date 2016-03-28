package com.girault.thomas.planning.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ServerSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username, password, enabled from users where username=?")
				.authoritiesByUsernameQuery("select u.username, r.name "
						+ "from users_roles ur inner join users u on u.id = ur.user_id "
						+ "inner join roles r on r.id = ur.role_id "
						+ "where u.username=?");
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		// @formatter:off
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/user/register").permitAll().and().csrf().disable();

		http.authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/oauth/token").permitAll();
		// @formatter:on
	}

}
