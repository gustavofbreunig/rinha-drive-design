package com.rinha.rinhadrivedesign.infrastructure.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.rinha.rinhadrivedesign.domain.error.LimiteExcedidoException;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntityException extends LimiteExcedidoException {
    public UnprocessableEntityException(String message) {
		super(message);
	}
}
