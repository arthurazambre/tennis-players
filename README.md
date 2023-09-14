# Test technique L'Atelier

## Requirements

For building and running the application you need:

- [JDK 17](https://www.oracle.com/java/technologies/downloads/#java17)
- [Maven 3](https://maven.apache.org)

## Running the application locally

```shell
mvn spring-boot:run
```

OR execute the jar file using
```shell
java -jar .\tennis-players-0.0.1-SNAPSHOT.jar
```

## Testing the endpoints

- Task 1: http://localhost:8080/players
- Task 2: http://localhost:8080/players/52 (replace 52 by any other id)
- Task 3: http://localhost:8080/players/stats