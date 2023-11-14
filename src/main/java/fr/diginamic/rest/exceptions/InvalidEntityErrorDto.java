package fr.diginamic.rest.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class InvalidEntityErrorDto {

	private final LocalDateTime dateTimeError;
	private final String reasonError;
	private final String urlError;
	private final List<ObjectError> globalErrors;
	private final List<FieldError> fieldErrors;
	
	public InvalidEntityErrorDto(LocalDateTime dateTimeError, String reasonError, String urlError,
			List<ObjectError> globalErrors, List<FieldError> fieldErrors) {
		this.dateTimeError = dateTimeError;
		this.reasonError = reasonError;
		this.urlError = urlError;
		this.globalErrors = globalErrors;
		this.fieldErrors = fieldErrors;
	}

	public LocalDateTime getDateTimeError() {
		return dateTimeError;
	}

	public String getReasonError() {
		return reasonError;
	}

	public String getUrlError() {
		return urlError;
	}

	public List<ObjectError> getGlobalErrors() {
		return globalErrors;
	}

	public List<FieldError> getFieldErrors() {
		return fieldErrors;
	}
	
}
