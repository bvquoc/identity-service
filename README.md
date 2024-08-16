# Identity Service

This microservice is responsible for:
* Onboarding users
* Roles and permissions
* Authentication

## Tech stack
* Build tool: maven >= 3.9.5
* Java: 17
* Framework: Spring boot 3.2.x
* DBMS: MySQL

## Prerequisites
* Java SDK 17
* MySQL server

## Start application

```bash
mvn spring-boot:run
```

## Build application

```bash
mvn clean package
```

## Docker guideline

### Build docker image

```bash
docker build -t <account>/identity-service:0.9.0 .
```

### Push docker image to Docker Hub

```bash
docker image push <account>/identity-service:0.9.0
```
### Create network:

```bash
docker network create devteria-network
```
### Start MySQL in devteria-network

```bash
docker run --network devteria-network --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:8.0.36-debian
```
### Run your application in devteria-network
```bash
docker run --name identity-service --network devteria-network -p 8080:8080 -e DBMS_CONNECTION=jdbc:mysql://mysql:3306/identity_service identity-service:0.9.0
```

## Install Docker on ubuntu

# Add Docker's official GPG key:

```bash
sudo apt-get update
```
```bash
sudo apt-get install ca-certificates curl
```
```bash
sudo install -m 0755 -d /etc/apt/keyrings
```
```bash
sudo curl -fsSL https://download.docker.com/linux/ubuntu/gpg -o /etc/apt/keyrings/docker.asc
```
```bash
sudo chmod a+r /etc/apt/keyrings/docker.asc
```

# Add the repository to Apt sources:

```bash
echo \
"deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.asc] https://download.docker.com/linux/ubuntu \
$(. /etc/os-release && echo "$VERSION_CODENAME") stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
```
```bash
sudo apt-get update
```
```bash
sudo apt-get install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin
```
```bash
sudo docker run hello-world
```
