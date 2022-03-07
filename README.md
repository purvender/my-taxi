**mytaxi backend Applicant Service**<br />

**Run mongodb in docker with provided docker-compose.yaml (docker compose up)**<br />
username=rootuser<br />
password=rootpass<br />
database=purvender<br />
port=27017<br />

Initial data is feeded with commandLineRunner in MytaxiServerApplicantTestApplication<br />

2 cars: <br />
3 drivers: 2 online, 1 offline: drivers username and password will be used to sign in from spring security: use any:<br />
ex: username: driver01<br />
    password: driver01pw<br />

CarDO("XYAB0087", 0, 5, 5, "petrol", "black", "Sedan", "Audi", "A7", "manual"));<br />
CarDO("XYAB0088", 4, 0, 5, "petrol", "black", "Sedan", "Audi2", "A7", "auto"));<br />
DriverDO("driver04pw", "driver04",false, OnlineStatus.OFFLINE, "auto"));<br />
DriverDO("driver01", "driver01pw",false, OnlineStatus.ONLINE, "auto"));<br />
DriverDO("driver02", "driver02pw",true, OnlineStatus.ONLINE, "manual"));<br />


Execute com.mytaxi.MytaxiServerApplicantTestApplication, which starts a webserver on port 8080 (http://localhost:8080) and serves SwaggerUI where can inspect and try existing endpoints.<br />

The project is based on a small web service which uses the following technologies:<br />

* Java 1.8<br />
* Spring Boot Starter Web<br />
* Mongo db (running on docker local)<br />
* Maven<br />
* Eclipse as IDE <br />
* Swagger<br />
* Spring Security<br />


 All new entities should have an ID with type of String or big integer for mongo.<br />
 The architecture of the web service is built with the following components:<br />
 DataTransferObjects: Objects which are used for outside communication via the API<br />
 Controller: Implements the processing logic of the web service, parsing of parameters and validation of in- and outputs.<br />
 Service: Implements the business logic and handles the access to the DataAccessObjects.<br />
 DataAccessObjects: Interface for the database. Inserts, updates, deletes and reads objects from the database.<br />
 DomainObjects: Functional Objects which might be persisted in the database.<br />

## Task 1
 * Write a new Controller for maintaining cars (CRUD).
   * Decide on your own how the methods should look like.
   * Entity Car: Should have at least the following characteristics: license_plate, seat_count, convertible, rating, engine_type (electric, gas, ...)
   * Entity Manufacturer: Decide on your own if you will use a new table or just a string column in the car table.
 * Extend the DriverController to enable drivers to select a car they are driving with.
 * Extend the DriverController to enable drivers to deselect a car.
 * Extend the DriverDo to map the selected car to the driver.

<pre>
Car controller:<br />
GET /v1/cars					findAll<br />
POST /v1/cars					create<br />
GET /v1/cars/licenseplate/{licensePlate}	findLicense<br />
DELETE /v1/cars/{carId}				delete<br />
GET /v1/cars/{carId}                            find<br />

Driver Controller:<br />
GET /v1/drivers					findDrivers<br />
POST /v1/drivers				createDriver<br />
GET /v1/drivers/all				getDrivers<br />
PUT /v1/drivers/deselectcar			deSelectCar<br />
GET /v1/drivers/filter				filterByType<br />
PUT /v1/drivers/selectcar			selectCar<br />
DELETE /v1/drivers/{driverId}			deleteDriver<br />
GET /v1/drivers/{driverId}			getDriver<br />

</pre>

## Task 2
First come first serve: A car can be selected by exactly one ONLINE Driver. If a second driver tries to select a already used car you should throw a CarAlreadyInUseException.

	public void selectCar(String id, String licensePlate) throws CarAlreadyInUseException, ServiceException {
		DriverDO driverDO = null;
		try {
			driverDO = driverRepository.findByIdAndOnlineStatus(id, OnlineStatus.ONLINE);
			if (driverDO == null) {
				throw new EntityNotFoundException(null);
			}
			CarDO carDO = carService.find2(licensePlate);
			if (carDO.getDriverId() != null && carDO.getDriverId() != driverDO.getId()) {
				throw new CarAlreadyInUseException("Selected car is already hired");
			}
			driverDO.setCarDO(carDO);
			create(driverDO);
			carDO.setDriverId(driverDO.getId());
			carService.create(carDO);
		} catch (ConstraintsViolationException | EntityNotFoundException e) {
			throw new ServiceException("Driver is not online Status or information not found! ");
		}

	}
	
## Task 3
Make use of the filter pattern to implement an endpoint in the DriverController to get a list of drivers with specific characteristics. Reuse the characteristics you implemented in task 1.

<pre>
2 filters created: 
AutoGearDriver
ManualGearDriver

Driver controller
GET /v1/drivers/filter				filterByType
takes input driver type as "manual" or "auto"
</pre>

## Task 4
Security: secure the API. It's up to you how you are going to implement the security.

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

