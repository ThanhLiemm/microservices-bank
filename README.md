# Spring Boot, Spring Cloud MicroServices
This repository is an example of how to get Microservices going using Spring Boot, Spring Cloud, Spring OAuth 2 and Netflix OSS frameworks.

It also builds on distributed system concepts and tries to provide solutions for common distributed system problem using implementations for circuit breakers, consumer driven contracts etc.

## <a name="application-architecture"></a>Application Architecture

The application consists of 6 different services

* [configserver](https://github.com/ThanhLiemm/microservices-bank-config) - Setup external configuration
* eurekaserver - Spring Cloud Eureka Server will act as a service discovery & registration agent
* accounts - Containing our sample microservices that allows to perform CRUD operation on in-memory repository of accounts
* cards - Containing our sample microservices that allows to perform CRUD operation on in-memory repository of cards
* loans - Containing our sample microservices that allows to perform CRUD operation on in-memory repository of loans
* gatewayserver - API gateway server built using Spring Cloud Gateway

![image](https://github.com/ThanhLiemm/microservices-bank/assets/44218427/8364cf30-b7b4-4737-9fdb-3050fd431e0e)

## <a name="using-application"></a>Using the application

### <a name="run_local_mc"></a>Running on local m/c
* There are several ways to run a Spring Boot Application services on your local machine. One way is to execute the `main` method in the `com.thanhliem.accounts.AccountsApplication` class from your IDE.
* Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

### <a name="run_docker"></a>Running using docker
```shell
cd docker-compose/prod  //choose production env
docker compose up
```

## <a name="using-application"></a>Testing

* Using postman by import files: [microservice_api](Microservices API.postman_collection.json), [microservie_api_env](Microservices local.postman_environment.json)
* Using api OpenAPI in localhost
