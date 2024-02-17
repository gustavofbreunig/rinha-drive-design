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
        VALUES                 (1, 10, 'c', 'retirada', '2024-02-17 01:00:00'),
                               (2, 220, 'c', 'retirada', '2024-02-17 02:00:00'),
                               (1, 240, 'c', 'retirada', '2024-02-17 03:00:00'),
                               (1, 5986, 'c', 'retirada', '2024-02-17 04:00:00'),
                               (1, 155, 'c', 'retirada', '2024-02-17 05:00:00'),
                               (1, 985, 'c', 'retirada', '2024-02-17 06:00:00'),
                               (1, 215, 'c', 'retirada', '2024-02-17 07:00:00'),
                               (1, 587, 'c', 'retirada', '2024-02-17 08:00:00'),
                               (1, 1, 'c', 'retirada', '2024-02-17 09:00:00'),
                               (1, 34, 'd', 'debitado', '2024-02-17 10:05:00'),
                               (1, 454, 'd', 'debitado', '2024-02-17 10:02:00'),
                               (1, 8990, 'd', 'debitado', '2024-02-17 10:03:00'),
                               (1, 2584, 'd', 'debitado', '2024-02-17 10:06:00'),
                               (1, 20, 'd', 'debitado', '2024-02-17 10:00:00');

END;
$$;
