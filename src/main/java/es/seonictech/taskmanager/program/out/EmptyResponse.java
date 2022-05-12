package es.seonictech.taskmanager.program.out;

public class EmptyResponse implements ProgramResponseInterface {

	public int getCode() {
		return ProgramResponseCode.OK_EMPTY.value();
	}

}
