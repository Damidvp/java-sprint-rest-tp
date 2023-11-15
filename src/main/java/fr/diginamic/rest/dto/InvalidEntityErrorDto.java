package fr.diginamic.rest.dto;

import java.util.List;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class InvalidEntityErrorDto extends ErrorDto{
	
	private final List<ObjectError> globalErrors;
	private final List<FieldError> fieldErrors;
	
	public InvalidEntityErrorDto(String reasonError, String urlError, List<ObjectError> globalErrors, 
			List<FieldError> fieldErrors) {
		super(reasonError, urlError);
		this.globalErrors = globalErrors;
		this.fieldErrors = fieldErrors;
	}

	public List<ObjectError> getGlobalErrors() {
		return globalErrors;
	}

	public List<FieldError> getFieldErrors() {
		return fieldErrors;
	}
	
}
