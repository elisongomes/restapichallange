# SWAPI Challenger

## _REST API with WebFlux and MySQL_

The purpose of this project is to demonstrate how use the reactive framework [Spring WebFlux](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html) and  [MySQL](https://www.mysql.com/) with implementation of the [R2DBC](https://github.com/mirromutth/r2dbc-mysqll).

## Configuring application

Change the `application.properties` file located in `resources` folder:

```
spring.r2dbc.url=r2dbc:mysql://localhost:3306/[database_name]
spring.r2dbc.username=[username]
spring.r2dbc.password=[password]
```

## Exploring the REST APIs

The application contains the following REST APIs:

Method | Target | Description
-------|--------|------------
`GET` | `/planets` | List all planets stored in database
`GET` | `/planets/sw` | List all planets fetched from `https://swapi.dev` that are stored in database
`GET` | `/planets/{id}` | Get an planet by the `id`
`GET` | `/planets/search?name={name}` | Search an planet by `name` word
`POST` | `/planets` | Insert an planet to database. Fields: `name` (string), `climate` (string), `terrain` (strign) and `filmsCount` (integer).
`DELETE` | `/planets/{id}` | Delete an planet by the `id`