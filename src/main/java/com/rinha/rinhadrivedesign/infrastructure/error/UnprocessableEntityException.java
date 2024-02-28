package com.rinha.rinhadrivedesign.infrastructure.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.rinha.rinhadrivedesign.domain.errors.TransacaoInvalida;


@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntityException extends TransacaoInvalida {
    public UnprocessableEntityException(String message) {
		super(message);
	}


}
