# BTPN-JP Final Project
Employee management app for mitrais-btpn jp final project

## Technical Specifications
* Spring-boot backend
    * H2 database
    * Unit-testing for custom query in repository
    * Flyway database-migration
* Angular-2 frontend
    * Material Design byb material.angular.io
    * Date-picker by md2

## Requirement Specifications
* CRUD Employee (including photo)
* Location dropdown provided by database
* Search Employee by name
* Filter Employee by location and or gender

## How-to
* Clone this git
* Go to employee-backend folder and run `mvn spring-boot:run`
* Spring-boot will run on `localhost:8080`
* Go to employee-frontend folder and run `npm install` and then `npm start`
* Angular-2 will run on `localhost:4200`
