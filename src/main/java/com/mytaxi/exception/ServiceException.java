/**
 * 
 */
package com.mytaxi.exception;

public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2204989547717554575L;

	public ServiceException(String message) {

		super(message);
	}

	public ServiceException(Exception e) {

		super(e);
	}

}
