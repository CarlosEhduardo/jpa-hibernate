# Mapeamento Objeto-Relacional com JPA/Hibernate

## Sobre o projeto
Já conhecendo a base da API JDBC, a implementação do JPA com Hibernate se mostrou bem vantajoso, onde a produtivade é maior, as consultas e demais funções
são mais simples de serem feitas e possui melhor facilidade de manutenção, tendo esse conhecimento, foi criado este projeto demonstrativo.

## Descrição
Foi usado o Hibernate como implementação do JPA com foco em demonstrativo simples onde está presente a inserção(Insert), deleção(delete) e consulta(find).
Em deleção, foi abordado as duas formas para se fazer, por ser necessário que um objeto deva ser monitorado antes de ser deletado, sendo elas:
- Remoção por objeto monitorado recuperado.
  
  Foi feita a recuperação no banco de dados, armazenado em um objeto atravez do EntityManager.find() para que posteriormente fosse deletado com EntityManager.remove().

- Remoção por objeto monitorado inserido.

  Foi feita a inserção de um objeto no banco de dados com EntityManager.persist() e recuperado para que posteriormente fosse deletado com EntityManager.remove().

O acesso ao banco de dados pode ser feito pelo persistence.xml onde se pode adicionar ou modificar valores importantes, como:
- persistence-unit
- jdbc.driver
- jdbc.user
- jdbc.password

## Mapeamento 
Com base em apenas uma classe foi usado anotações para que fosse feita o mapeamento, sendo elas:
- @Entity - Define a classe como uma entidade relacionada ao banco de dados
- @Id - Define que uma variavel pode ser um id
- @GeneratedValue(strategy = GenerationType.IDENTITY) - Define que cada id deve ser incrementado conforme é adicionado no banco de dados
