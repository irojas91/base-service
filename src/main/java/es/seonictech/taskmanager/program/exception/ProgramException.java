package es.seonictech.taskmanager.program.exception;

public class ProgramException extends RuntimeException {

	private static final long serialVersionUID = 641518497693281425L;
	
	public ProgramException(String message) {
		super(message);
	}
	
	public ProgramException(String message, Throwable cause) {
		super(message, cause);
	}

}
