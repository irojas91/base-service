package es.seonictech.taskmanager.program.out;

public class ValidationErrorResponse extends ErrorResponse {

	public ValidationErrorResponse(String error) {
		super(error);
	}

	@Override
	public int getCode() {
		return ProgramResponseCode.VALIDATION_ERROR.value();
	}
}
