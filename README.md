# rinha-drive-design

todo
connection pool
transaction
exceptions nas validacoes

curl teste GET
curl -v -X GET http://localhost:8080/clientes/1/extrato

curl teste POST
curl -v -X POST http://localhost:8080/clientes/2/transacoes -H "Content-Type: application/json" -d '{"valor": 1000,"tipo" : "c","descricao" : "descricao"}'