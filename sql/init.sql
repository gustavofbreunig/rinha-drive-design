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
        realizada_em TIMESTAMP WITH TIME ZONE NOT NULL,
        CONSTRAINT fk_clientes_transacoes_id
                FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

DO $$
BEGIN
        INSERT INTO clientes (limite, saldo)
        VALUES
                (100000, 0),
                (80000, 0),
                (1000000, 0),
                (10000000, 0),
                (500000, 0);

END;
$$;
