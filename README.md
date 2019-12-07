# TestWebApp 
`TestWebApp` is developed to learn and implement new things. It consists of 
* `web` as Web Application developed using `Spring Boot`
* `demoservicev1` as Micro Service.

Right now, these are two different `Spring` applications and are not considered as sub-project of `TestWebApp` 

# How to Build #
As mentioned above, right now these are two separate projects. So to build needs to be taken individually.

Clone the repository using following command - 
``` git
git clone https://github.com/ksjoshi/TestWebApp.git
``` 

### Build `web` ### 
Following steps will help you to build the project
```git
cd web
./gradlew clean build
```

### Build `demoservicev1` ###
`demoservicev1` uses `Docker`. Please have docker installed on machine and run following command. 
```
cd demoservicev1
docker-compose up -d
``` 
Assuming you under `demoservicev1` project, following steps will help you to build the project
```git
cd demoservicev1
./gradlew clean build
```

# How to test #
Start following application in order to test - 
* DemoApplication (which is `web1)
* Demoservicev1Application

Also Start `webpack` server which will host static content.

Use following url - 
* [Login Page](http://localhost:8082/login)
* [Registration Page](http://localhost:8082/register) 
