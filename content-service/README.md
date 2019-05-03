Stateless application simulating a worker service. No DB connections. Runs on port 8090.

Has an aggressive chaos monkey running.

```
$ mvn clean install
$ mvn spring-boot:run
```

Access Chaos Monkey APIs from base http://127.0.0.1:8090/actuator/chaosmonkey 
(/assaults GET, POST, /enable POST, /disable POST)


Or, modify them in application.properties.