package es.seonictech.taskmanager.program.exception;

import es.seonictech.taskmanager.program.out.ErrorResponse;

public class InternalExceptionHandler implements ProgramExceptionHandlerInterface {

	@Override
	public boolean support(Throwable exception) {
		return true;
	}

	@Override
	public int getPriority() {
		return 0;
	}

	@Override
	public ErrorResponse manage(Throwable exception) {
		StringBuilder message = new StringBuilder();
		
		message.append(exception.getMessage());
		
		Throwable prev = exception;
		while((prev = prev.getCause()) != null) {
			message.append(" -> ");
			message.append(prev.getMessage());
		}
		
		return new ErrorResponse(message.toString());
	}

}
