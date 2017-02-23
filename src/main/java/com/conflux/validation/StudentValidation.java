package com.conflux.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.conflux.dao.StudentDAO;

public class StudentValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return StudentDAO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

	}

}
