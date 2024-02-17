package com.rinha.rinhadrivedesign.infrastructure.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.rinha.rinhadrivedesign.domain.context.Transacao;
import com.rinha.rinhadrivedesign.infrastructure.db.entities.TransacaoEntity;

@Mapper(componentModel = "spring")
public interface TransacaoMapper {
    List<Transacao> paraTransacoes(List<TransacaoEntity> transacoes);
}
