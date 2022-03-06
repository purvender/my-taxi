package com.mytaxi.domainobject;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mytaxi.domainvalue.OnlineStatus;

import lombok.Data;

@Data
@Document(collection = "driver")
public class DriverDO {

	@Id
	private String id;

	private String username;

	private String password;

	private Boolean deleted = false;

	private OnlineStatus onlineStatus;

	private CarDO carDO;
	private String gearType;

	private DriverDO() {
	}

	public DriverDO(String username, String password, Boolean deleted, OnlineStatus onlineStatus, String gearType) {
		super();
		this.username = username;
		this.password = password;
		this.deleted = deleted;
		this.onlineStatus = onlineStatus;
		this.gearType = gearType;
	}

	



}
