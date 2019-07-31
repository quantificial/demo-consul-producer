## demo of providing service and register to the consul server

start a local consul server

`consul agent -server -bootstrap-expect=1 -data-dir=consul-data -ui -bind=127.0.0.1`


set the environment variables for the spring application to use

```
set CONSUL_NAME=2222

or 

export CONSUL_NAME=2222
```

run the application to register as "demo-consul-producer" service in consul

`java -jar demo-consul-producer-0.0.1-SNAPSHOT.jar --server.port=8082`





### run with out consul

```
mvn spring-boot:run -Dspring-boot.run.arguments=--spring.cloud.consul.enabled=false
```