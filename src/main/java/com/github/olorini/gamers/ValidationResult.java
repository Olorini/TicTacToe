package com.github.olorini.gamers;

public enum ValidationResult {

	OCCUPIED("This cell is occupied! Choose another one!"),
	NOT_IN_RANGE("Coordinates should be from 1 to 3!"),
	NOT_NUMBER("You should enter numbers!"),
	OK("");

	private final String errorText;

	ValidationResult(String errorText) {
		this.errorText = errorText;
	}

	@Override
	public String toString() {
		return errorText;
	}

}
