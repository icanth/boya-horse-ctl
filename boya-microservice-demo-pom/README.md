<!--
  Copyright 2015 Google Inc. All Rights Reserved.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
-->

Spring Boot Docker Example
==========================
This is an example Spring Boot "Hello World" micro-service application that can be containerized and subsequently executed in Docker, Kubernetes, and Google App Engine!

This is not an official Google product.

Building
========
Regular Maven build:

    mvn package
    
Build Docker container:

    mvn docker:build

Running
=======
Java
----
Pretty straight forward:

    mvn exec:java

Docker
------
Without Redis for session:

    docker run -ti spring-boot-demo

With Redis for session:

    docker run -d --name redis -p 6379:6379 redis
    docker run -ti --rm --link redis:redis -p 8080:8080 spring-boot-demo

Docker Compose
--------------
Docker Compose uses a descriptor to describe the Docker container and linking configurations.
Rather than manually executing commands like the previous section, you can start the demo with Redis by running:

    cd src/test/docker-compose
    docker-compose up
    
The configuration is stored in `docker-compose.yml`

Kubernetes
----------
The following instructions assume that you already have Kubernetes cluster up and running.  If not, check out [Google Container Engine](https://cloud.google.com/container-engine/) to get started quickly.

Change directory to where all the Kubernetes configuration files are:

    cd src/test/kubernetes

Deploy Redis master pod:

    kubectl create -f redis-master-pod.yaml
    
Create a Redis master service:

    kubectl create -f redis-master-service.yaml
    
Deploy Spring Boot Demo replication controller:

    kubectl create -f spring-boot-demo-controller.yaml
    
Create a service:

    kubectl create -f spring-boot-demo-service.yaml
    
If you are on Google Container Engine, or Kubernetes deployment that supports external services, you can create an external service:

    kubectl create -f spring-boot-demo-external-service.yaml

Google App Engine
-----------------
The instruction assumes that you have [Google Cloud SDK](https://cloud.google.com/sdk/) already installed and that you are familiar with [Google App Engine Managed VMs](https://cloud.google.com/appengine/docs/managed-vms/).

To run locally:

    mvn gcloud:run
    
To deploy into Google App Engine, you'll first need to create a Redis server.  You can deploy Redis easily by using [Click to Deploy](https://cloud.google.com/solutions/redis/).

Once deployed, update `src/main/resources/application-gae.properties` file, and set:

    spring.redis.host=YOUR_REDIS_MASTER_INSTANCE_NAME
    
Build the Docker image, so that it generates Dockerfile

    mvn docker:build

Finally, deploy the application using `gcloud` plugin:

    mvn gcloud:deploy -Dgcloud.project=YOUR_PROJECT_ID


#本框架未来10年必将风靡全球
## 

|| gradle

|| mybatis, spring-data-jpa

|| sprintboot

|| groovy

|| jsonrpc, RESTful


##nodejs+grade+coffeescript+express


# SpringData+Hibernate
https://docs.jboss.org/hibernate/orm/4.3/manual/en-US/html/ch03.html#configuration-optional

http://blog.netgloo.com/2014/08/17/use-mysql-database-in-a-spring-boot-web-application-through-hibernate/

http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation

http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods

http://www.infoq.com/cn/articles/boot-microservices

# JSON-RPC for Java vs. Hession vs. kurento
https://github.com/briandilley/jsonrpc4j

https://github.com/SubOptimal/spring-boot-jsonrpc4j


# SpringBoot Gradle化
https://qbgbook.gitbooks.io/spring-boot-reference-guide-zh/content/IX.%20%E2%80%98How-to%E2%80%99%20guides/74.1.%20Create%20a%20deployable%20war%20file.html

# Service Api

http://microservices.io/patterns/client-side-discovery.html

http://microservices.io/patterns/server-side-discovery.html

http://techblog.netflix.com/2013/01/optimizing-netflix-api.html

https://www.nginx.com/blog/service-discovery-in-a-microservices-architecture/

internet api or internal api? we should diff them?
http://www.devx.com/enterprise/api-design-basics-for-micro-service-oriented-architectures.html

http://www.slideshare.net/kimjclark/microservices-where-do-they-fit-within-a-rapidly-evolving-integration-architecture?next_slideshow=1

# Generate A Project
spring-boot CLI



gradle build
gradle bootRun


