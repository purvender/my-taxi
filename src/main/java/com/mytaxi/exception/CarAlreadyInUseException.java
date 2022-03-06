/**
 * 
 */
package com.mytaxi.exception;

public class CarAlreadyInUseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8286002109063841731L;
	
	public CarAlreadyInUseException(String message) {
		super(message);
	}

	public CarAlreadyInUseException(Exception e) {
		super(e);
	}

}
