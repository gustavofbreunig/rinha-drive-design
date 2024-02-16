CREATE UNLOGGED TABLE clientes (
        id SERIAL PRIMARY KEY,
        limite INTEGER NOT NULL,
        saldo INTEGER NOT NULL
);

CREATE UNLOGGED TABLE transacoes (
        id SERIAL PRIMARY KEY,
        cliente_id INTEGER NOT NULL,
        valor INTEGER NOT NULL,
        tipo CHAR(1) NOT NULL,
        descricao VARCHAR(10) NOT NULL,
        realizada_em TIMESTAMP NOT NULL DEFAULT NOW(),
        CONSTRAINT fk_clientes_transacoes_id
                FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

DO $$
BEGIN
        INSERT INTO clientes (limite, saldo)
        VALUES
                (1000 * 100, 0),
                (800 * 100, 0);

        INSERT INTO transacoes (cliente_id, valor, tipo, descricao, realizada_em)
        VALUES                 (1, 10, 'c', 'retirada', CURRENT_TIMESTAMP),
                               (1, 20, 'd', 'debitado', CURRENT_TIMESTAMP);

END;
$$;
