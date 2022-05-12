package es.seonictech.taskmanager.program;

import java.lang.reflect.ParameterizedType;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.seonictech.taskmanager.program.exception.ProgramExceptionManager;
import es.seonictech.taskmanager.program.out.EmptyResponse;
import es.seonictech.taskmanager.program.out.ProgramResponseInterface;

public abstract class BaseProgram<Model> implements ProgramInterface<Model> {

	private ProgramExceptionManager exceptionManager;
	private Class<Model> inputType;
	protected ObjectMapper serializer;

	@SuppressWarnings("unchecked")
	protected BaseProgram() {
		exceptionManager = new ProgramExceptionManager();
		inputType = (Class<Model>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		serializer = new ObjectMapper();
	}

	public ProgramResponseInterface execute(String input) {
		return processInput(input);
	}

	private ProgramResponseInterface processInput(String input) {

		try {
			Model unserializedInput = serializer.readValue(input, inputType);

			return this.process(unserializedInput);
		} catch (Throwable e) {
			return exceptionManager.manageException(e);
		}

	}

	protected ProgramResponseInterface emptyResponse() {
		return new EmptyResponse();
	}

	protected abstract ProgramResponseInterface process(Model input);

}
