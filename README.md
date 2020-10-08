# animal-service
Web-app for the animal shelter "Dim Sirka".

## Project status
[![Build Status](https://travis-ci.com/dim-sirka/animal-service.svg?branch=main)](https://travis-ci.com/dim-sirka/animal-service)

## Requirements
* Java 11
* Docker

## Building Instructions
(If running from windows - replace / to \ )
 * ./gradlew clean build -- build the project and run the tests

## Launch Instructions 
 - terminal:
 * java -jar build/libs/*.jar -- run the project
 - docker:
 * docker build -t animal-service . - build the docker image with name animal-service
 * docker run --name animal-service-container -p 8070:8080 -d animal-service - run container with name animal-service-container based on the animal-service image
 (make calls to port: `8070`)