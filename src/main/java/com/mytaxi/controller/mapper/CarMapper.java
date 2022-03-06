/**
 * 
 */
package com.mytaxi.controller.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.domainobject.CarDO;

public class CarMapper {

	public static CarDO makeCarDO(CarDTO carDTO) {
		return new CarDO(carDTO.getLicensePlate(), carDTO.getSeatCount(), carDTO.getConvertible(), carDTO.getRating(),
				carDTO.getEngineType(), carDTO.getColor(), carDTO.getStyle(), carDTO.getManufacturer(),
				carDTO.getModel(), carDTO.getGearType());
	}

	public static CarDTO makeCarDTO(CarDO carDO) {

		return new CarDTO(carDO.getLicensePlate(), carDO.getSeatCount(), carDO.getConvertible(), carDO.getRating(),
				carDO.getEngineType(), carDO.getColor(), carDO.getStyle(), carDO.getManufacturer(), carDO.getModel(), carDO.getGearType());
	}

	public static List<CarDTO> makeCarDTOList(Collection<CarDO> cars) {
		return cars.stream().map(CarMapper::makeCarDTO).collect(Collectors.toList());
	}

}