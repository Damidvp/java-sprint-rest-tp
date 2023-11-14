package fr.diginamic.rest.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import fr.diginamic.rest.dto.ErrorDto;
import fr.diginamic.rest.dto.InvalidEntityErrorDto;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
	@ExceptionHandler({jakarta.persistence.EntityNotFoundException.class})
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorDto handleExceptionNotFound(Exception exception, WebRequest request) {
		exception.printStackTrace();
		return new ErrorDto(
				LocalDateTime.now(),
				"Entité non trouvée",
				request.getDescription(false)
			);
	}
	
	@ExceptionHandler({fr.diginamic.rest.exceptions.EntityToCreateHasAnIdException.class})
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorDto handleExceptionCreateHasId(Exception exception, WebRequest request) {
		exception.printStackTrace();
		return new ErrorDto(
				LocalDateTime.now(),
				"Entité créée a un ID",
				request.getDescription(false)
			);
				
	}
	
	@ExceptionHandler({MethodArgumentNotValidException.class})
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public InvalidEntityErrorDto handleExceptionArgumentNotValid(MethodArgumentNotValidException exception, WebRequest request) {
		exception.printStackTrace();
		return new InvalidEntityErrorDto(
				LocalDateTime.now(),
				"Un ou plusieurs arguments invalides",
				request.getDescription(false),
				exception.getBindingResult().getGlobalErrors(),
				exception.getBindingResult().getFieldErrors()
			);
	}
	
}
