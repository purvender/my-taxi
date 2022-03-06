package com.mytaxi.controller;

import com.mytaxi.controller.mapper.DriverMapper;
import com.mytaxi.datatransferobject.DriverDTO;
import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.domainvalue.OnlineStatus;
import com.mytaxi.exception.CarAlreadyInUseException;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;
import com.mytaxi.exception.ServiceException;
import com.mytaxi.filter.Criteria;
import com.mytaxi.filter.DriverFactory;
import com.mytaxi.service.driver.DriverService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * All operations with a driver will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("v1/drivers")
public class DriverController
{

    private final DriverService driverService;
    
    @Autowired
    private DriverFactory driverFactory;


    @Autowired
    public DriverController(final DriverService driverService)
    {
        this.driverService = driverService;
    }


    @GetMapping("/{driverId}")
    public DriverDTO getDriver(@Valid @PathVariable String driverId) throws EntityNotFoundException
    {
        return DriverMapper.makeDriverDTO(driverService.find(driverId));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DriverDTO createDriver(@Valid @RequestBody DriverDTO driverDTO) throws ConstraintsViolationException
    {
        DriverDO driverDO = DriverMapper.makeDriverDO(driverDTO);
        return DriverMapper.makeDriverDTO(driverService.create(driverDO));
    }


    @DeleteMapping("/{driverId}")
    public void deleteDriver(@Valid @PathVariable String driverId) throws EntityNotFoundException
    {
        driverService.delete(driverId);
    }


    @GetMapping
    public List<DriverDTO> findDrivers(@RequestParam OnlineStatus onlineStatus)
        throws ConstraintsViolationException, EntityNotFoundException
    {
        return DriverMapper.makeDriverDTOList(driverService.find(onlineStatus));
    }
    
    @PutMapping("/selectcar")
    public void selectCar (@RequestParam("driverid") String driverId, @RequestParam("licenseplate") String licenseplate) throws CarAlreadyInUseException, ServiceException {
    	driverService.selectCar(driverId, licenseplate.replaceAll(" ", "").toUpperCase());
    }
    
    @PutMapping("/deselectcar")
    public void deSelectCar (@RequestParam("driverid") String driverId, @RequestParam("licenseplate") String licenseplate) throws ServiceException{
    	driverService.deSelectCar(driverId, licenseplate.replaceAll(" ", "").toUpperCase());
    }
    
    @GetMapping("/all")
    public List<DriverDTO> getDrivers () {
    	return DriverMapper.makeDriverDTOList(driverService.findAll());
    }
    
    @GetMapping ("/filter")
    public List<DriverDTO> filterByType (@RequestParam String driverType) {
    	Criteria criteria = driverFactory.createFactory(driverType);
    	return criteria.meetCriteria();
    }
}
