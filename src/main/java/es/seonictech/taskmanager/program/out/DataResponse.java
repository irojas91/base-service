package es.seonictech.taskmanager.program.out;

public class DataResponse<Model> implements ProgramDataResponseInterface<Model> {

	private final Model data;
	
	public DataResponse(Model data) {
		this.data = data;
	}
	
	public int getCode() {
		return ProgramResponseCode.OK.value();
	}

	public Model getData() {
		return this.data;
	}

}
