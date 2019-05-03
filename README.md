# chaos-monkey-demo
Demo of spring-boot chaos monkeys, Netflix Hystrix. 

This project describes a small ecosystem of backend "microservices" (some with better architecture than others 
  - cross-service represents an architectural compromise, calling other microservices, with predictably unstable results).
  
These microservices all have [chaos monkeys](https://codecentric.github.io/chaos-monkey-spring-boot/) active at varying degrees of intensity.

The cross-service and weborchestrator both additionally have [Netflix's Hystrix fault tolerance library](https://github.com/Netflix/Hystrix) active and running in a very limited format. There is a simple UI which can be run using Node and NPM.

Each individual project's README describes how to run it. Generally requires Maven and Java 1.8. 
