Microservice with a database connection. Runs an aggressive chaos monkey. Runs on port 8080.

```
$ mvn clean install
$ mvn spring-boot:run
```

Modify the chaos monkey configuration via application.properties. 
Access the H2 dashboard at http://localhost:8080/h2-console