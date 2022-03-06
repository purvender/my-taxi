/**
 * 
 */
package com.mytaxi.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytaxi.service.driver.DriverService;

@Service
public class DriverFactory {
	
	@Autowired
	DriverService dataService;
	
	public Criteria createFactory (String driverType) {
		Criteria criteria = null;
		if (driverType.equalsIgnoreCase("manual")) {
			criteria = new ManualGearDriver(dataService);
		} else {
			criteria = new AutoGearDriver(dataService);
		}
		return criteria;
	}

}
