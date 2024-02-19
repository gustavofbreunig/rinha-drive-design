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
                (100000, 0),
                (80000, 10),
                (1000000, 0),
                (10000000, 0),
                (500000, 0);

        INSERT INTO transacoes (cliente_id, valor, tipo, descricao, realizada_em)
        VALUES                 (1, 10, 'c', 'retirada', '2024-02-17 01:00:00'),
                               (2, 10, 'd', 'add     ', '2024-02-17 02:00:00'),
                               (1, 10, 'c', 'retirada', '2024-02-17 03:00:00'),
                               (1, 10, 'c', 'retirada', '2024-02-17 04:00:00'),
                               (1, 10, 'c', 'retirada', '2024-02-17 05:00:00'),
                               (1, 10, 'c', 'retirada', '2024-02-17 06:00:00'),
                               (1, 10, 'c', 'retirada', '2024-02-17 07:00:00'),
                               (1, 10, 'c', 'retirada', '2024-02-17 08:00:00'),
                               (1, 10, 'c', 'retirada', '2024-02-17 09:00:00'),
                               (1, 10, 'c', 'retirada', '2024-02-18 09:00:00'),
                               (1, 10, 'c', 'retirada', '2024-02-19 09:00:00'),
                               (1, 10, 'c', 'desc234', '2024-02-19 09:00:00'),
                               (1, 110, 'd', 'debitado', '2024-02-17 10:05:00');

END;
$$;
