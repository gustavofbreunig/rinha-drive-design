package com.rinha.rinhadrivedesign.infrastructure.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rinha.rinhadrivedesign.domain.context.Cliente;
import com.rinha.rinhadrivedesign.domain.dto.ExtratoRequest;
import com.rinha.rinhadrivedesign.domain.dto.ExtratoResponse;
import com.rinha.rinhadrivedesign.domain.services.ExtratoServiceAdapter;
import com.rinha.rinhadrivedesign.infrastructure.db.entities.ClienteEntity;
import com.rinha.rinhadrivedesign.infrastructure.db.entities.TransacaoEntity;
import com.rinha.rinhadrivedesign.infrastructure.db.repository.ClienteRepository;
import com.rinha.rinhadrivedesign.infrastructure.error.NotFoundException;
import com.rinha.rinhadrivedesign.infrastructure.mappers.ClienteMapperImpl;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExtratoServiceImpl implements ExtratoService  {

    private final ClienteRepository clienteRepository;

    private final ExtratoServiceAdapter extratoServiceAdapter;

    private final ClienteMapperImpl clienteMapper;

    @Override
    public ExtratoResponse obtemExtrato(int ClienteId) throws NotFoundException {
        ClienteEntity clienteEntity = clienteRepository.findById(ClienteId).orElseThrow(() -> new NotFoundException("Cliente não encontrado"));

        List<TransacaoEntity> transacoes = clienteEntity.getTransacoes();
        
        Cliente cliente = clienteMapper.paraCliente(clienteEntity);

        ExtratoRequest request = ExtratoRequest.builder()
                .cliente(cliente)
                .build();

        ExtratoResponse response = extratoServiceAdapter.montaExtrato(request);

        return response;
    }
    
}
