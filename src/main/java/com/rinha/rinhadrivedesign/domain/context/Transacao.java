package com.rinha.rinhadrivedesign.domain.context;

import java.time.Instant;

import com.rinha.rinhadrivedesign.domain.dto.TransacaoCriada;
import com.rinha.rinhadrivedesign.domain.errors.TransacaoInvalida;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Transacao {
    private int id;
    
    private Cliente cliente;
    
    private int valor;

    private TipoTransacao tipo;
    
    private String descricao;
    
    private Instant realizadaEm;

    private Transacao(Cliente cliente, int valor, TipoTransacao tipo, String descricao)
    {       
        this.cliente = cliente;
        this.valor = valor;
        this.tipo = tipo;
        this.descricao = descricao;
        this.realizadaEm = Instant.now();
    }

    private static TransacaoCriada efetuaTransacao(Cliente cliente, TipoTransacao tipo, int valor, String descricao) 
    {
        //faz uma nova transação de crédito ou débito
        //sempre com uma validação antes, a entidade (Cliente) nunca poderá 
        //ficar em um estado inválido
        //retorna o dto com a transação criada e o cliente com o novo saldo
        validaTransacao(cliente, tipo, valor, descricao);

        tipo.getTransacaoStrategy().efetuaTransacao(cliente, valor);

        return TransacaoCriada
                    .builder()
                    .cliente(cliente)
                    .transacao(new Transacao(cliente, valor, tipo, descricao))
                    .build();

    }

    public static TransacaoCriada efetuaTransacao(Cliente cliente, String tipo, String valor, String descricao) 
    {
        //overload com tipos string                        
        TipoTransacao tipoTransacao = TipoTransacao.fromString(tipo);
        int valorParsed = Integer.parseInt(valor);
        return efetuaTransacao(cliente, tipoTransacao, valorParsed, descricao);        
    }    

    public static void validaTransacao(Cliente cliente, TipoTransacao tipo, int valor, String descricao) {

        if (valor < 0)
        {
            throw new TransacaoInvalida("valor menor que 0");
        }

        if (descricao == null || descricao.isBlank() || descricao.isEmpty())
        {
            throw new TransacaoInvalida("descrição não informada");
        }

        if (descricao != null && descricao.length() > 10)
        {
            throw new TransacaoInvalida("descrição com mais de 10 caracteres");
        }

        if (tipo.equals(TipoTransacao.Debito) && cliente.estouraLimite(valor))
        {
            throw new TransacaoInvalida("saldo insuficiente");
        }
    }

}
