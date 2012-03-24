package org.kirino.coderwall4j.exception;

public class CoderwallException extends Exception {

	private static final long serialVersionUID = 1L;
	final String message;

	public CoderwallException(String message) {
		this.message = message;
	}

}
