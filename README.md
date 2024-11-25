# Gerenciamento de Automóveis 🚗

Este é um sistema de gerenciamento de pedidos de compra de veículos desenvolvido em **Java** com **Spring Boot**. Ele permite o registro de veículos, cálculo do valor total de pedidos com opcionais, validações para evitar duplicidade, além de listagem e consulta de pedidos.

## 🚀 Funcionalidades

- **Cadastro de Pedidos**: Permite criar pedidos associando um veículo e seus opcionais.  
- **Validação de Pedidos Duplicados**: Verifica se um pedido com o mesmo veículo e opcionais já existe.  
- **Cálculo de Preço Total**: Inclui o valor do veículo e dos opcionais selecionados.  
- **Listagem e Consulta**: Permite listar e consultar os pedidos criados.  

## 🛠️ Tecnologias Utilizadas

- **Java 17**  
- **Spring Boot**  
  - Spring Data JPA  
  - Spring Web  
- **H2 Database** (para testes)  
- **Maven** (gerenciamento de dependências)  

## ⚙️ Instalação e Configuração

### Pré-requisitos

- [Java 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)  
- [Maven](https://maven.apache.org/install.html)  

### Passos para Executar

1. Clone o repositório:  
   ``git clone https://github.com/jpfariaa/gerenciadorAutomoveis.git``
   ``cd gerenciadorAutomoveis``

2. Compile e execute o projeto:
  ``mvn spring-boot:run``

3. Acesse a aplicação:
   - A API estará disponibilizada em: http://localhost:8080

### Banco de Dados

O projeto utiliza H2 Database configurado para rodar em memória por padrão.
Para acessar o console do H2, vá para http://localhost:8080/h2-console e use as credenciais padrão:

- JDBC URL: ``jdbc:h2:mem:automoveisdb``
- Username: ``sa``
- Password: ``password``

### Endpoints Disponíveis

Veículos
  - **GET** /veiculos/{id}: Retorna informações de um veículo.
  - **GET** /veiculos: Lista todos os veículos.

Pedidos
  - **POST** /pedidos: Cria um novo pedido.
    - Body Exemplo:
        ```
        {
          "veiculoId": 1,
          "opcionaisIds": [1, 2]
        }
        ```
- **GET** /pedidos/{id}: Retorna detalhes de um pedido.
- **GET** /pedidos: Lista todos os pedidos.

## Testes

Para executar os testes automatizados:
``mvn test``
Os testes cobrem:

  - Validação de pedidos duplicados;
  - Cálculo do valor total do pedido;
  - Integração com o banco de dados.
