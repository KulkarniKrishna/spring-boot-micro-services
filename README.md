# Microservice Endpoints
- ### [Eureka Server](http://localhost:8761/) - Service Discovery
- ### [Api Gateway](http://localhost:8080)
- ### [Config Server](http://localhost:9003/application/default) - Common/Env configurations of all services
- ### Services:
  - ### [User](http://localhost:9002/swagger-ui/index.html)
  - ### [Contact](http://localhost:9001/swagger-ui/index.html)
- ### [Distributed Tracer](http://localhost:9411/) - configured in docker
- ### [Kafka Magic Dashboard](http://localhost:9080/cluster) - configured in docker


# Kafka
## Install kafka in Docker
 - create docker-compose.yml file with required docker commands
 - move to the directory of docker-compose.yml file and run the command:
   - docker compose up -d
   - docker ps
## Create kafka topic
docker exec broker kafka-topics --bootstrap-server broker:9092 --create --topic user-service-topic