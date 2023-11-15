package fr.diginamic.rest.dto;

import java.time.LocalDateTime;

public class ErrorDto {
	
	private final LocalDateTime dateTimeError;
	private final String reasonError;
	private final String urlError;
	
	public ErrorDto(String reasonError, String urlError) {
		this.dateTimeError = LocalDateTime.now();
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
