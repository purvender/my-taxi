/**
 * 
 */
package com.mytaxi.security.configuration;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.service.driver.DriverService;

@Component
public class TaxiAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	DriverService driverService;

	@Override
	public Authentication authenticate(Authentication authentication) {

		String name = authentication.getName();
		String password = authentication.getCredentials().toString();

		DriverDO driver = driverService.findByUsernameAndPassword(name, password);
		if (driver == null)
			return null;
		if (!name.equals(driver.getUsername()) || !password.equals(driver.getPassword()))
			return null;

		// use the credentials
		// and authenticate against the third-party system
		return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
