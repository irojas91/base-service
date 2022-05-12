package es.seonictech.taskmanager.program.exception;

public class InputValidationException extends RuntimeException {

	private static final long serialVersionUID = -1966326874415809202L;

	public InputValidationException(String message) {
		super(message);
	}
}
