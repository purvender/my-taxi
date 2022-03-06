/**
 * 
 */
package com.mytaxi.dataaccessobject;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.mytaxi.domainobject.CarDO;

public interface CarRepository extends MongoRepository<CarDO, String>{
	
	CarDO findByLicensePlate (String plate);

}
