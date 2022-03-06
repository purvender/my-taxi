/**
 * 
 */
package com.mytaxi.datatransferobject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "licensePlate", "seatCount", "convertible", "rating", "engineType", "color", "style",
		"manufacturer", "model" })
public class CarDTO {

	public CarDTO() {
	}

	public CarDTO(String licensePlate, Integer seatCount, Integer convertible, Integer rating, String engineType,
			String color, String style, String manufacturer, String model, String gearType) {
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

	@JsonProperty("licensePlate")
	private String licensePlate;

	@JsonProperty("seatCount")
	private Integer seatCount;

	@JsonProperty("convertible")
	private Integer convertible;

	@JsonProperty("rating")
	private Integer rating;

	@JsonProperty("engineType")
	private String engineType;

	@JsonProperty("color")
	private String color;

	@JsonProperty("style")
	private String style;

	@JsonProperty("manufacturer")
	private String manufacturer;

	@JsonProperty("model")
	private String model;
	
	@JsonProperty ("gearType")
	private String gearType;

	/**
	 * @return the licensePlate
	 */
	@JsonProperty("licensePlate")
	public String getLicensePlate() {
		return licensePlate;
	}

	/**
	 * @param licensePlate
	 *            the licensePlate to set
	 */
	@JsonProperty("licensePlate")
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	/**
	 * @return the seatCount
	 */
	@JsonProperty("seatCount")
	public Integer getSeatCount() {
		return seatCount;
	}

	/**
	 * @param seatCount
	 *            the seatCount to set
	 */
	@JsonProperty("seatCount")
	public void setSeatCount(Integer seatCount) {
		this.seatCount = seatCount;
	}

	/**
	 * @return the convertible
	 */
	@JsonProperty("convertible")
	public Integer getConvertible() {
		return convertible;
	}

	/**
	 * @param convertible
	 *            the convertible to set
	 */
	@JsonProperty("convertible")
	public void setConvertible(Integer convertible) {
		this.convertible = convertible;
	}

	/**
	 * @return the rating
	 */
	@JsonProperty("rating")
	public Integer getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	@JsonProperty("rating")
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	/**
	 * @return the engineType
	 */
	@JsonProperty("engineType")
	public String getEngineType() {
		return engineType;
	}

	/**
	 * @param engineType
	 *            the engineType to set
	 */
	@JsonProperty("engineType")
	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	/**
	 * @return the color
	 */
	@JsonProperty("color")
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	@JsonProperty("color")
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the style
	 */
	@JsonProperty("style")
	public String getStyle() {
		return style;
	}

	/**
	 * @param style
	 *            the style to set
	 */
	@JsonProperty("style")
	public void setStyle(String style) {
		this.style = style;
	}

	/**
	 * @return the manufacturer
	 */
	@JsonProperty("manufacturer")
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * @param manufacturer
	 *            the manufacturer to set
	 */
	@JsonProperty("manufacturer")
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * @return the model
	 */
	@JsonProperty("model")
	public String getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	@JsonProperty("model")
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the transmission
	 */
	@JsonProperty ("gearType")
	public String getGearType() {
		return gearType;
	}

	/**
	 * @param transmission the transmission to set
	 */
	@JsonProperty ("gearType")
	public void setGearType(String gearType) {
		this.gearType = gearType;
	}
	
	

}