package com.bc.d3;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2584498451614241308L;

	public NotFoundException() {
	}

	public NotFoundException(String message) {
		super(message);
	}

}
