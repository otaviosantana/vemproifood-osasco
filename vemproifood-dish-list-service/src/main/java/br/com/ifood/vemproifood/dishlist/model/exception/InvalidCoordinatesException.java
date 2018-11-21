package br.com.ifood.vemproifood.dishlist.model.exception;

public class InvalidCoordinatesException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private final double invalidCoordinate;

	public InvalidCoordinatesException(final double invalidCoordinate) {
		this.invalidCoordinate = invalidCoordinate;
	}

	public double getInvalidCoordinate() {
		return invalidCoordinate;
	}
}