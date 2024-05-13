# Getting Started
# make sure the $JAVA_HOME is same as the application jdk version
... let's start
update

# run the application by using following command in console:
./mvnw spring-boot:run

# build the JAR file as follows:
./mvnw clean package

# run the JAR file as follows:
java -jar target/project-{version}.jar

# run project with java vm parameters
# The profile names can be passed in via a JVM system parameter. These profiles will be activated during application startup:
# Go to edit Configuration in the IntelliJ IDEA, in the environment, and in the VM option, adding the following parameter
-Dspring.profiles.active=development

# using curl command to execute a http request
# or we can use postman to test the endpoints
```shell
$ curl -v localhost:9080/employees
```

# Using Yaml file to configure development, staging and production environment
# Launching application using specific property configuration
launch with a specific command line switch
for example:
$  java -jar \
 -Dspring.profiles.active=production \
 -Dcustomized.application.name="Anything" \ 
 target/project-{version}.jar

