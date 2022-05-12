package es.seonictech.taskmanager.program;

import com.fasterxml.jackson.core.JsonProcessingException;

import es.seonictech.taskmanager.program.out.ProgramResponseInterface;

public interface ProgramInterface<Model> {

	/**
	 * @param args
	 * 
	 * @return the service response serialized in json
	 */
	public ProgramResponseInterface execute(String args) throws JsonProcessingException;
}
