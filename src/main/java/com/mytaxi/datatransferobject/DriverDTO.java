package com.mytaxi.datatransferobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mytaxi.controller.mapper.CarMapper;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainvalue.OnlineStatus;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DriverDTO
{
    @JsonIgnore
    private String id;

    @NotNull(message = "Username can not be null!")
    private String username;

    @NotNull(message = "Password can not be null!")
    private String password;
    
    private OnlineStatus onlineStatus;
    
    private CarDTO hiredCar;

    
    private String gearType;
    
    private Boolean deleted;


    private DriverDTO()
    {
    }


    private DriverDTO(String id, String username, String password, CarDTO hiredCar, String gearType)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.hiredCar = hiredCar;
        this.gearType = gearType;
    }


    public static DriverDTOBuilder newBuilder()
    {
        return new DriverDTOBuilder();
    }


    @JsonProperty
    public String getId()
    {
        return id;
    }


    public String getUsername()
    {
        return username;
    }


    public String getPassword()
    {
        return password;
    }


    public static class DriverDTOBuilder
    {
        private String id;
        private String username;
        private String password;
        private CarDTO hiredCar;
        private String gearType;


        public DriverDTOBuilder setId(String id)
        {
            this.id = id;
            return this;
        }


        public DriverDTOBuilder setUsername(String username)
        {
            this.username = username;
            return this;
        }


        public DriverDTOBuilder setPassword(String password)
        {
            this.password = password;
            return this;
        }

        
        public DriverDTOBuilder setHiredCar(CarDO hiredCarDO)
        {	
        	if (hiredCarDO != null) {
        		this.hiredCar = CarMapper.makeCarDTO(hiredCarDO);
        	}
            return this;
        }
        
        

        public DriverDTOBuilder setGearType(String gearType)
        {
            this.gearType = gearType;
            return this;
        }
        

        public DriverDTO createDriverDTO()
        {
            return new DriverDTO(id, username, password, hiredCar, gearType);
        }

    }

	/**
	 * @return the onlineStatus
	 */
	public OnlineStatus getOnlineStatus() {
		return onlineStatus;
	}


	/**
	 * @param onlineStatus the onlineStatus to set
	 */
	public void setOnlineStatus(OnlineStatus onlineStatus) {
		this.onlineStatus = onlineStatus;
	}


	/**
	 * @return the hiredCar
	 */
	public CarDTO getHiredCar() {
		return hiredCar;
	}


	/**
	 * @param hiredCar the hiredCar to set
	 */
	public void setHiredCar(CarDTO hiredCar) {
		this.hiredCar = hiredCar;
	}


	/**
	 * @return the gearType
	 */
	public String getGearType() {
		return gearType;
	}


	/**
	 * @param gearType the gearType to set
	 */
	public void setGearType(String gearType) {
		this.gearType = gearType;
	}


	public Boolean getDeleted() {
		return deleted;
	}


	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}



	
	
    
    
}