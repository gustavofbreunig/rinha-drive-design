package com.rinha.rinhadrivedesign.infrastructure.services;

import java.util.AbstractMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.rinha.rinhadrivedesign.domain.context.Cliente;
import com.rinha.rinhadrivedesign.domain.context.TipoTransacao;
import com.rinha.rinhadrivedesign.domain.context.Transacao;
import com.rinha.rinhadrivedesign.domain.dto.TransacaoRequest;
import com.rinha.rinhadrivedesign.domain.dto.TransacaoResponse;
import com.rinha.rinhadrivedesign.domain.error.LimiteExcedidoException;
import com.rinha.rinhadrivedesign.infrastructure.db.entities.ClienteEntity;
import com.rinha.rinhadrivedesign.infrastructure.db.entities.TransacaoEntity;
import com.rinha.rinhadrivedesign.infrastructure.db.repository.ClienteRepository;
import com.rinha.rinhadrivedesign.infrastructure.db.repository.TransacaoRepository;
import com.rinha.rinhadrivedesign.infrastructure.error.NotFoundException;
import com.rinha.rinhadrivedesign.infrastructure.error.UnprocessableEntityException;
import com.rinha.rinhadrivedesign.infrastructure.mappers.ClienteMapper;
import com.rinha.rinhadrivedesign.infrastructure.mappers.TransacaoMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransacaoServiceImpl implements TransacaoService {

    private final ClienteRepository clienteRepository;
    private final TransacaoRepository transacaoRepository;

    private final TransacaoMapper transacaoMapper;
    private final ClienteMapper clienteMapper;     

    @Override
    public TransacaoResponse efetuaTransacao(int clienteId, TransacaoRequest transacaoRequest) throws NotFoundException, UnprocessableEntityException {       
        //busca informações do cliente
        ClienteEntity clienteEntity = clienteRepository.findById(clienteId).orElseThrow(() -> new NotFoundException("Cliente não encontrado"));

        TipoTransacao tipoTransacao = TipoTransacao.fromChar(transacaoRequest.getTipo());

        //domain objects
        Cliente cliente = clienteMapper.paraCliente(clienteEntity);
        Transacao transacao;

        try
        {
            //a lógica da transação mora no domínio, o erro é capturado na infraestrutura e traduzido para as regras HTTP            
            transacao = cliente.efetuaTransacao(tipoTransacao, transacaoRequest.getValor(), transacaoRequest.getDescricao());          
        }
        catch (LimiteExcedidoException exc) {
            //exceção emitida pelo domínio, tratada pela infra, inserindo o HTTP code e subindo
            throw new UnprocessableEntityException(exc.getMessage());
        }

        //persiste
        ClienteEntity clienteEntityUpdated = clienteMapper.paraClienteEntity(cliente);        
        
        if (clienteEntityUpdated != null)
        {
            clienteRepository.save(clienteEntityUpdated);
        }
        
        TransacaoEntity transacaoEntity = transacaoMapper.paraTransacaoEntity(transacao);

        if (transacaoEntity != null) 
        {
            transacaoRepository.save(transacaoEntity);
        }

        return new TransacaoResponse(cliente.getLimite(), cliente.getSaldo());          
    }
    
}
