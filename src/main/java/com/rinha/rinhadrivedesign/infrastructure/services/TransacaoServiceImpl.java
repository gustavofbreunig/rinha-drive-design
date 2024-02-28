package com.rinha.rinhadrivedesign.infrastructure.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rinha.rinhadrivedesign.domain.context.Cliente;
import com.rinha.rinhadrivedesign.domain.context.Transacao;
import com.rinha.rinhadrivedesign.domain.dto.TransacaoCriada;
import com.rinha.rinhadrivedesign.domain.dto.TransacaoRequest;
import com.rinha.rinhadrivedesign.domain.dto.TransacaoResponse;
import com.rinha.rinhadrivedesign.domain.errors.TipoTransacaoInvalido;
import com.rinha.rinhadrivedesign.domain.errors.TransacaoInvalida;
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
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public TransacaoResponse efetuaTransacao(TransacaoRequest transacaoRequest) throws NotFoundException, UnprocessableEntityException {       
        //busca informações do cliente
        ClienteEntity clienteEntity = clienteRepository
                                            .findById(transacaoRequest.getClienteId())
                                            .orElseThrow(() -> new NotFoundException("Cliente não encontrado"));

        //domain objects
        Cliente cliente = clienteMapper.paraCliente(clienteEntity);        

        //a lógica da transação mora no domínio, o erro é capturado na infraestrutura e traduzido para as regras HTTP

        try
        {
            TransacaoCriada novaTransacao = Transacao.efetuaTransacao(cliente, transacaoRequest.getTipo(), transacaoRequest.getValor(), transacaoRequest.getDescricao());
            TransacaoEntity transacaoEntity = transacaoMapper.paraTransacaoEntity(novaTransacao.getTransacao());
            ClienteEntity clienteEntityUpdated = clienteMapper.paraClienteEntity(novaTransacao.getCliente());

            if (transacaoEntity != null) 
            {
                transacaoRepository.save(transacaoEntity);
            }

            if (clienteEntityUpdated != null)
            {
                clienteRepository.save(clienteEntityUpdated);
            }

            return new TransacaoResponse(novaTransacao.getCliente().getLimite(), novaTransacao.getCliente().getSaldo());  
        }
        catch (TransacaoInvalida exc) {
            //exceção emitida pelo domínio, tratada pela infra, inserindo o HTTP code e subindo
            throw new UnprocessableEntityException(exc.getMessage());
        }
        catch (TipoTransacaoInvalido exc)
        {
            throw new UnprocessableEntityException(exc.getMessage());
        }
        catch (NumberFormatException exc) 
        {
            throw new UnprocessableEntityException(exc.getMessage());
        }                        
    }
    
}
