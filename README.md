## demo of providing service and register to the consul server

start a local consul server

`consul agent -server -bootstrap-expect=1 -data-dir=consul-data -ui -bind=127.0.0.1`


set the environment variable

set CONSUL_NAME=2222

export CONSUL_NAME=2222


run the application

`java -jar demo-consul-producer-0.0.1-SNAPSHOT.jar --server.port=8082`


