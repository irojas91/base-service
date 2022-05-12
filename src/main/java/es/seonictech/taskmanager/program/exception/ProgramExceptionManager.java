package es.seonictech.taskmanager.program.exception;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import es.seonictech.taskmanager.program.out.ErrorResponse;

public class ProgramExceptionManager {

	private final List<ProgramExceptionHandlerInterface> handlers = new ArrayList<ProgramExceptionHandlerInterface>();
	
	public ProgramExceptionManager() {
		this.handlers.add(new InternalExceptionHandler());
		this.handlers.add(new ValidationExceptionHandler());
	}
	
	public ErrorResponse manageException(Throwable exception) {
		ProgramExceptionHandlerInterface handler = getHandler(exception);
		
		if(handler != null) {
			return handler.manage(exception);
		}
		
		return new ErrorResponse(exception.getMessage());
	}
	
	private ProgramExceptionHandlerInterface getHandler(Throwable exception) {
		return handlers.stream().filter(handler -> handler.support(exception)).max(Comparator.comparing(ProgramExceptionHandlerInterface::getPriority)).orElse(null);
	}
	
}
