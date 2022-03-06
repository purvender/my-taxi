/**
 * 
 */
package com.mytaxi.filter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.mytaxi.controller.mapper.DriverMapper;
import com.mytaxi.datatransferobject.DriverDTO;
import com.mytaxi.service.driver.DriverService;

public class ManualGearDriver  implements Criteria {
	
	
	DriverService driverService;
	
	@Autowired
	public ManualGearDriver(DriverService driverService) {
		this.driverService = driverService;
	}

	@Override
	public List<DriverDTO> meetCriteria() {
		List<DriverDTO> driverList = DriverMapper.makeDriverDTOList(driverService.findAll());
		return driverList.stream().filter(driver -> driver.getGearType().equalsIgnoreCase("manual"))
				.collect(Collectors.toList());
	}

}
