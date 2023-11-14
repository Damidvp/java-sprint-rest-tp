package fr.diginamic.rest.exceptions;

import java.time.LocalDateTime;

public class ErrorDto {
	
	private final LocalDateTime dateTimeError;
	private final String reasonError;
	private final String urlError;
	
	public ErrorDto(LocalDateTime dateTimeError, String reasonError, String urlError) {
		this.dateTimeError = dateTimeError;
		this.reasonError = reasonError;
		this.urlError = urlError;
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

}
