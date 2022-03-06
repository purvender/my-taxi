/**
 * 
 */
package com.mytaxi.service.car;

import java.util.List;

import com.mytaxi.domainobject.CarDO;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;

public interface CarService {
	
    CarDO find(String carId) throws EntityNotFoundException;

    CarDO create(CarDO carDO) throws ConstraintsViolationException;

    void delete(String carId) throws EntityNotFoundException;

    CarDO find2(String licensePlate) throws EntityNotFoundException;
    
    List<CarDO> findAll ();

}
 