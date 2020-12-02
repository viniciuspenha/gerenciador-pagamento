# gerenciador-pagamento
Esta API tem como objetivo gerenciar os pagamentos de automoveis.

# Config
### DB
Para inicializar o banco de dados MySql:
```
docker-compose up dbmysql
```

### Build
Buildar o projeto usando o maven:
```
mvn clean install
```

### Run
Após isso execute o comando abaixo para inicializar a aplicaçao na porta 8081:
```
mvn spring-boot:run
```

#Endpoints
- Para criar um novo boleto:
```
Post: localhost:8081/pagamento/boleto
Body: {
      	"automovelId" : 1,
      	"valor" : 150000.00,
      	"vencimento" : "2020-12-10"
      }

Obs.: 
- Caso o valor nao seja enviado, será gerado um boleto com o valor total do automovel
- Caso a data de vencimento nao seja enviada, será gerado um boleto com vencimento D+5 dias
```