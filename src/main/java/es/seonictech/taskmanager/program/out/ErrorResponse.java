package es.seonictech.taskmanager.program.out;

public class ErrorResponse implements ProgramErrorResponseInterface {

	private final String error;
	
	public ErrorResponse(String error) {
		this.error = error;
	}
	
	public int getCode() {
		return ProgramResponseCode.INTERNAL_ERROR.value();
	}

	public String getError() {
		return this.error;
	}

}
