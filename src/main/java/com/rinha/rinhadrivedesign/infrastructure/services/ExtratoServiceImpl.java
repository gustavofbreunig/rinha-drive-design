package com.rinha.rinhadrivedesign.infrastructure.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.rinha.rinhadrivedesign.domain.context.Cliente;
import com.rinha.rinhadrivedesign.domain.context.Transacao;
import com.rinha.rinhadrivedesign.domain.context.extrato.Extrato;
import com.rinha.rinhadrivedesign.infrastructure.db.entities.ClienteEntity;
import com.rinha.rinhadrivedesign.infrastructure.db.entities.TransacaoEntity;
import com.rinha.rinhadrivedesign.infrastructure.db.repository.ClienteRepository;
import com.rinha.rinhadrivedesign.infrastructure.db.repository.TransacaoRepository;
import com.rinha.rinhadrivedesign.infrastructure.error.NotFoundException;
import com.rinha.rinhadrivedesign.infrastructure.mappers.ClienteMapperImpl;
import com.rinha.rinhadrivedesign.infrastructure.mappers.TransacaoMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExtratoServiceImpl implements ExtratoService  {

    private final ClienteRepository clienteRepository;
    private final TransacaoRepository transacaoRepository;

    private final ClienteMapperImpl clienteMapper;
    private final TransacaoMapper transacaoMapper;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED) 
    public Extrato obtemExtrato(int ClienteId) throws NotFoundException {
        //busca o cliente no bd
        ClienteEntity clienteEntity = clienteRepository
                .findById(ClienteId)
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado"));

        //busca transacoes
        List<TransacaoEntity> transacoesEntity = 
                transacaoRepository.findFirst10ByClienteOrderByRealizadaEmDesc(clienteEntity);        

        //objetos de domínio
        List<Transacao> transacoes = transacaoMapper.paraTransacoes(transacoesEntity);

        //monta a estrutura no domínio
        Cliente cliente = clienteMapper.paraCliente(clienteEntity);
        Extrato response = Extrato.montaExtrato(cliente, transacoes);
        
        return response;
    }
    
}
