package com.mytaxi.service.driver;

import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.domainvalue.OnlineStatus;
import com.mytaxi.exception.CarAlreadyInUseException;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;
import com.mytaxi.exception.ServiceException;

import java.util.List;

public interface DriverService
{

    DriverDO find(String driverId) throws EntityNotFoundException;

    DriverDO create(DriverDO driverDO) throws ConstraintsViolationException;

    void delete(String driverId) throws EntityNotFoundException;

    List<DriverDO> find(OnlineStatus onlineStatus);
    
   void selectCar (String id, String licensePlate) throws CarAlreadyInUseException, ServiceException;
   
   void deSelectCar (String id, String licensePlate)  throws ServiceException;
   
   DriverDO findByUsernameAndPassword (String username, String password);
   
   List<DriverDO> findAll ();

}
