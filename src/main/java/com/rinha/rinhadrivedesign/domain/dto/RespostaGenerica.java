package com.rinha.rinhadrivedesign.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class RespostaGenerica<T> {
    
    private int code;

    private String message;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Object reason;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private T data;
}
