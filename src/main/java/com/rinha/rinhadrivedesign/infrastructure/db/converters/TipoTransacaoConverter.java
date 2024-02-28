package com.rinha.rinhadrivedesign.infrastructure.db.converters;

import org.hibernate.MappingException;

import com.rinha.rinhadrivedesign.domain.context.TipoTransacao;
import com.rinha.rinhadrivedesign.domain.errors.TipoTransacaoInvalido;

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
        try {
            return TipoTransacao.fromString(dbData);
        } catch (TipoTransacaoInvalido e) {
            throw new MappingException(dbData);
        }
    }
    
}
