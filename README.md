# Sobre
O app consiste em criar sondas que explorem uma determinada área.

# Cenários de testes
http://scenario-test-mars-exploration-rovers.surge.sh

# Docker
### Build
`docker build --no-cache --network host -t mars-exploration-rovers:1.0.0-SNAPSHOT -f Dockerfile .`

### Run
`docker container run -d --name some-mars -p 8080:8080 mars-exploration-rovers:1.0.0-SNAPSHOT`

# Kubernetes
### Create service
`kubectl create -f mars-exploration-rovers-service.yaml --record`

### Create deployment
`kubectl create -f mars-exploration-rovers-deployment.yaml --record`
