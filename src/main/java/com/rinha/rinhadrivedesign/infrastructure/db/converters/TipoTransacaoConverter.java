package com.rinha.rinhadrivedesign.infrastructure.db.converters;

import com.rinha.rinhadrivedesign.domain.context.TipoTransacao;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TipoTransacaoConverter implements AttributeConverter<TipoTransacao, String> {

    @Override
    public String convertToDatabaseColumn(TipoTransacao attribute) {
        return attribute.getTipo();
    }

    @Override
    public TipoTransacao convertToEntityAttribute(String dbData) {
        return TipoTransacao.fromChar(dbData);
    }
    
}
