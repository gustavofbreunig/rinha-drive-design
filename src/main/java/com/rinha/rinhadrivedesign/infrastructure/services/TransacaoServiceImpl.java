package com.rinha.rinhadrivedesign.infrastructure.services;

import org.springframework.stereotype.Service;

import com.rinha.rinhadrivedesign.domain.context.Transacao;
import com.rinha.rinhadrivedesign.domain.dto.TransacaoRequest;
import com.rinha.rinhadrivedesign.domain.dto.TransacaoResponse;
import com.rinha.rinhadrivedesign.infrastructure.db.entities.ClienteEntity;
import com.rinha.rinhadrivedesign.infrastructure.db.entities.TransacaoEntity;
import com.rinha.rinhadrivedesign.infrastructure.db.repository.ClienteRepository;
import com.rinha.rinhadrivedesign.infrastructure.error.NotFoundException;
import com.rinha.rinhadrivedesign.infrastructure.mappers.TransacaoMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransacaoServiceImpl implements TransacaoService {

    private final ClienteRepository clienteRepository;

    private final TransacaoMapper transacaoMapper;

    @Override
    public TransacaoResponse registraTransacao(int clienteId, TransacaoRequest transacaoRequest) {       
        //busca informações do cliente
        ClienteEntity clienteEntity = clienteRepository.findById(clienteId).orElseThrow(() -> new NotFoundException("Cliente não encontrado"));

        //cria objeto de transacao
        TransacaoEntity transacaoEntity = 
                TransacaoEntity
                        .builder()
                        .cliente(clienteEntity)
                        .descricao(transacaoRequest.descricao())
                        .tipo(transacaoRequest.tipo())
                        .valor(transacaoRequest.valor())
                        .build();

        //mapeia para objeto de domínio
        Transacao transacao = transacaoMapper.paraTransacao(transacaoEntity);

        //passa as informações necessárias para o domínio validar a transação
        TransacaoResponse response = Transacao.valida(transacao);

        //persiste

        return response;
    }
    
}
