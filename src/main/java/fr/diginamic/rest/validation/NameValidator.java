package fr.diginamic.rest.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<NameFormat, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if(value == null) {
			return false;
		}
		return !value.isBlank() && !value.isEmpty() && Character.isUpperCase(value.charAt(0));
	}

}
