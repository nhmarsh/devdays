"Bad service" which violates clean microservice architecture with cross-talk to other microservices.

```
$ mvn clean install
$ mvn spring-boot:run
```

Comes with Chaos Monkeys and Spring Hystrix installed. Runs on port 8100.

View the hystrix dashboard at 

http://localhost:8100/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A8100%2Factuator%2Fhystrix.stream&title=Cross service

Access the Hystrix stream at http://localhost:8100/actuator/hystrix.stream