## English

[Read in English](README.en.md)

---

# API de Produtos

O projeto da API de Produtos é uma aplicação simples desenvolvida em Spring Boot que gerencia produtos. Utilizando tecnologias como Spring Data JPA, PostgreSQL e ModelMapper, a API fornece funcionalidades para criar, atualizar, listar e excluir produtos. Além disso, a integração com o Docker facilita a implantação e o desenvolvimento consistente em diferentes ambientes.

## Tecnologias Utilizadas
- Spring Boot
- Spring Data JPA
- ModelMapper
- Lombok
- PostgreSQL
- Docker

## Rotas da API

| Rotas              | Verbo  | Funcionalidade                       |
|---------------------|--------|------------------------------------|
| /produtos           | GET    | Listar todos os produtos                  |
| /produtos/{id}      | GET    | Buscar detalhes do produto fornecendo seu Id único           |
| /produtos           | POST   | Adicionar um novo produto ao catálogo            |
| /produtos/{id}      | PUT    | Atualizar informações para o produto especificado    |
| /produtos/{id}      | DELETE | Remover o produto especificado do catálogo      |
