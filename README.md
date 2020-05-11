![Java CI with Maven](https://github.com/wkennedy/expression-parentheses/workflows/Java%20CI%20with%20Maven/badge.svg)

## Expression Converter API

This is a simple web application with an API to convert mathematical functions.

#### Overview

The main logic for this application occurs in the following classes:

com.github.wkennedy.expressionparentheses.services.ExpressionService
com.github.wkennedy.expressionparentheses.converters.InfixToPostfixExpressionConverter
com.github.wkennedy.expressionparentheses.converters.PostfixToInfixExpressionConverter

The redudant parentheses functionality uses the infix to postfix converter to remove all the parentheses, then uses the postfix to infix converter to build the infix expression with minimum parentheses.

#### Demo URL
To see the application running and to start looking at the API, go here (deployed to AWS ECS). If you get a 503, give it a few seconds, it might take a little bit to spin back up:

http://expressionconvert-env.eba-rrz3fvyk.us-east-1.elasticbeanstalk.com/swagger/swagger-ui.html

#### Note:
In order to run and build this project, you do need Java 11+ installed with the JAVA_HOME environment variable set (otherwise, you can download the Docker image from DockerHub and run it):

    JAVA_HOME - location of a JDK home dir
    
### Run (executable jar)

    java -jar expression-converter.jar
    //Then go to http://localhost:8080/swagger/swagger-ui.html
    
### Build and Run    

To build and run the application locally, use the following command from the project root directory:

    ./mvnw spring-boot:run
    
To just build the project, use the following command:
    
    ./mvnw install

Once you build the project and want to create a docker image, use:

     docker build -t expression-converter .
     
To run your Docker image:
   
     docker run -it --rm expression-converter

or if you just want to run the Docker image from my repo:

    docker run -it --rm -p 8080:8080 waggins/expression-converter:v1
     
### Usage
Once the application is up and running you can go to your browser and visit the following url:

http://localhost:8080/swagger/swagger-ui.html     

There you'll see a Swagger page where you can test out the different operations.
