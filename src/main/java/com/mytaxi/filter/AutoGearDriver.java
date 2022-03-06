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

public class AutoGearDriver implements Criteria {

	
	DriverService driverSerive;
	
	public AutoGearDriver(DriverService driverSerive) {
		this.driverSerive = driverSerive;
	}

	@Override
	public List<DriverDTO> meetCriteria() {
		List<DriverDTO> driverList = DriverMapper.makeDriverDTOList(driverSerive.findAll());
		return driverList.stream().filter(driver -> driver.getGearType().equalsIgnoreCase("auto"))
				.collect(Collectors.toList());
	}

}
