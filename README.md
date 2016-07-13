# clock-rest
Desafio da ContaAzul.
Uma API REST que, dado um determinado horário (hora/minutos), calcula o ângulo entre os 2 ponteiros do relógio e responde em formato JSON.

Requisitos:
- O movimento dos ponteiros ocorrem de minuto em minuto;
- O resultado não deverá ser recalcula caso a mesma consulta seja executada duas vezes;
- Deve ser retornado sempre o menor ângulo;

Desenvolvido usando Eclipse e Apache Tomcat 7.
Tech: Java, Maven, Servlets.

## Testando
```
$ curl request GET http://localhost:8080/rest/clock/6/0
{"angle":180}

$ curl request GET http://localhost:8080/rest/clock/3
{"angle":90}

$ curl request GET http://localhost:8080/rest/clock/9
{"angle":90}
 
```

## Arquivos
```
TestClock.java - junit tests para a classe Clock
Clock.java - classe que realiza os cálculos
ClockController.java - classe que recebe as requisições e responde para o usuário
```


