##Expression Converter API

This is a simple web application with an API to convert mathematical functions.

####Quick Start
To see the application running and to start looking at the API, go here (deployed to AWS ECS):

http://ec2co-ecsel-59fovvubh6ap-495900397.us-east-1.elb.amazonaws.com:8080/swagger/swagger-ui.html

####Note:
In order to run and build this project, you do need Java 11+ installed with the JAVA_HOME environment variable set (otherwise, you can download the Docker image from DockerHub and run it):

    JAVA_HOME - location of a JDK home dir
    
###Build and Run    

To build and run the application locally, use the following command from the project root directory:

    ./mvnw spring-boot:run
    
To just build the project, use the following command:
    
    ./mvnw install

Once you build the project and want to create a docker image, use:

     docker build -t expression-converter .
     
To run your Docker image:
   
     docker run -it --rm expression-converter
     
###Usage
Once the application is up and running you can go to your browser and visit the following url:

http://localhost:8080/swagger/swagger-ui.html     

There you'll see a Swagger page where you can test out the different operations.