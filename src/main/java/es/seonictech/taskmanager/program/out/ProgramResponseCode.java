package es.seonictech.taskmanager.program.out;

public enum ProgramResponseCode {
	
	OK(200),
	OK_EMPTY(204),
	VALIDATION_ERROR(400),
	INTERNAL_ERROR(500);

	private int value;
	
	private ProgramResponseCode(int value) {
		this.value = value;
	}
	
	public int value() {
		return this.value;
	}
}
