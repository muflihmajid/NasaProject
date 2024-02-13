# Clean Architecture with Spring Boot

This Rest API using spring boot using Clean Architecture and hit API from NASA gov


## The target application

Project to implement a web application of a system for NASA API using the technologies **Java [Spring Boot] for the development of a [API REST]**, The RESTful endpoint should allow consumer to specify a date filter range that processes the data to identify and present information about the top 10 asteroids closest to earth, and also Develop an endpoint utilizing data from the NASA public API to facilitate searching for the total number of asteroids that are x kilometers or more
away.

### Features

This system was based on the requirements document proposed by the task.

- `Feature 1` `NEO Feed top 10`:  The system allows user get top 10 nearest Asteroid.
- `Feature 2` `Search asteroid in date and spesific distance`: The system allow user to search the asteroid in spesific distance.

### Technologies

- [Spring Boot]
- [REST API]

## Simplified Spring Boot Architecture with Clean Architecture

Trying to improve code organization, the clean architecture is a good start with that rules. We can arrive in an well-defined vertial boundaries, with a rigid hierarchy between the layers, the rules of the domain code is encapsulated of the framework code, and basically the code of the inner layers. 

<p align="center">
  <img src="https://github.com/muflihmajid/NasaProject/blob/main/public/Untitled%20Diagram-Clean%20arch%20java.drawio(1).png" />
  <p align="center">
      <i>Spring boot architecture with clean arhcitecture</i>
   </p>
</p>

The resulting architecture proposed for the application of Clean Architecture will contain 3 layers, they are: Infraestructure, Use case and Entity. In which follows a rigid hierarchy between the layers - the codes of the innermost layers do not know those of the outermost.

This architecture implemented is in the [simplified project].

[Spring Boot]: https://spring.io/projects/spring-boot
[API REST]: https://www.redhat.com/pt-br/topics/api/what-is-a-rest-api

## How to run
1. Download the lastest code
2. run using visual studio code or in terminal type mvn spring-boot:run
## List API
variable are startDate,endDate, and Distance

example

1. http://localhost:8080/NeoFeed?startDate=2021-02-01&endDate=2021-02-01
2. http://localhost:8080/NeoFeed/SpesificDistanceAndDate?startDate=2021-02-01&endDate=2021-02-01&distance=21758056
