Service which talks to the UI. No chaos monkeys installed, only Spring Hystrix. 

```
$ mvn clean install
$ mvn spring-boot:run
```

Runs on port 8085. View the hystrix dashboard at http://localhost:8085/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A8085%2Factuator%2Fhystrix.stream

Access the hystrix stream at http://localhost:8085/actuator/hystrix.stream