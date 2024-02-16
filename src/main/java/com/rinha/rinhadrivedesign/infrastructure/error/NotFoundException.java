package com.rinha.rinhadrivedesign.infrastructure.error;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.rinha.rinhadrivedesign.domain.error.DomainException;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends DomainException {
	
	public NotFoundException(String message) {
		super(message);
	}
}
