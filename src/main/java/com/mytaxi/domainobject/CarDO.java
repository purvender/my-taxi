/**
 * 
 */
package com.mytaxi.domainobject;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection =  "car")
public class CarDO implements Serializable {
	
	
	public CarDO () {}
	

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String licensePlate;

	private Integer seatCount;

	private Integer convertible;

	private Integer rating;

	private String engineType;

	private String color;

	private String style;

	private String manufacturer;

	private String model;
	
	private String gearType;
	
	private String driverId;

	public CarDO(String licensePlate, Integer seatCount, Integer convertible, Integer rating,
			String engineType, String color, String style, String manufacturer, String model, String gearType) {
		super();
		this.licensePlate = licensePlate;
		this.seatCount = seatCount;
		this.convertible = convertible;
		this.rating = rating;
		this.engineType = engineType;
		this.color = color;
		this.style = style;
		this.manufacturer = manufacturer;
		this.model = model;
		this.gearType = gearType;
	}
	



}