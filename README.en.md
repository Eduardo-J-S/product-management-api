## Portuguese

[Leia em Português](README.md)

---

# Products Api

The Products API project is a simple application developed in Spring Boot that manages products. Utilizing technologies such as Spring Data JPA, PostgreSQL, and ModelMapper, the API provides functionalities for creating, updating, listing, and deleting products. Additionally, Docker integration facilitates deployment and consistent development across different environments.

## Technologies Used
- Spring Boot
- Spring Data JPA
- ModelMapper
- Lombok
- PostgreSQL
- Docker


## API routes

| Routes              | Verb  | Functionality                       |
|---------------------|--------|------------------------------------|
| /products           | GET    | List all products                  |
| /products/{id}      | GET    | Fetch product details by providing its unique Id           |
| /products           | POST   | Add a new product to the catalog            |
| /products/{id}      | PUT    | Update information for the specified product    |
| /products/{id}      | DELETE | Remove the specified product from the catalog      |

