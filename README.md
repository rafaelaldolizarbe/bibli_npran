# Biblioteca N para N

De inicio este repositório tem como objetivo compartilhar uma das aulas práticas realizadas durante as aulas de Técnicas de Programação Web. 

Nesta aula especialmente são lecionadas noções de mappers e configurações de DTO´s como medida de personalização de respostas em API´s de consulta em bancos.

Para esta circunstância está sendo usado um banco h2 que funciona em memória ram e tem como objetivo final proporcionar a possibilidade de realizar testes antes de implementar um banco de dados dando agilidade no desenvolvimento de uma api REST em Java. 

Como base para a construção da API REST temos principalmente o framework Spring Boot muito utilizado em desenvolvimento web.

Para testar esta aplicação você precisara de um cliente HTTP completo. Podendo ser Imsonia ou Postman.

Considere:

Para consultar os livros com seus respectivos autores, o endpoint:

`http://localhost:8080/livros`

Para consultar os autores e seus respectivos livros:

`http://localhost:8080/escritores`