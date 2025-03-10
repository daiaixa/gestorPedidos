# Sistema de gestión de pedidos

## Descripción del Proyecto
Este proyecto esta desarrollado para permitir el manejo y control de los pedidos que realiza un determinado cliente.
Funciones:
- Permite crear un pedido y/o cliente.
- Permite modificar los datos de un pedido o cliente.
- Permite eliminar un pedido o cliente.
- Permite buscar un pedido o cliente especifico.
- Permite listar todos los pedidos y los clientes.
- Permite listar los pedidos de un cliente determinado.
- Permite listar los pedidos pendientes.


## Tecnologias Utilizadas
- Java 17
- Spring Boot 3.4.3
- Maven 
- JPA con Hibernate
- H2
- PostgreSQL 

- Para pruebas: Postman


### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.3/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.4.3/maven-plugin/build-image.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/3.4.3/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Validation](https://docs.spring.io/spring-boot/3.4.3/reference/io/validation.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.4.3/reference/web/servlet.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

