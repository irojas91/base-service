package es.seonictech.taskmanager.program.exception;

import es.seonictech.taskmanager.program.out.ErrorResponse;
import es.seonictech.taskmanager.program.out.ValidationErrorResponse;

public class ValidationExceptionHandler implements ProgramExceptionHandlerInterface {

	@Override
	public boolean support(Throwable exception) {
		return exception instanceof InputValidationException;
	}

	@Override
	public int getPriority() {
		return 1;
	}

	@Override
	public ErrorResponse manage(Throwable exception) {
		return new ValidationErrorResponse(exception.getMessage());
	}

}
