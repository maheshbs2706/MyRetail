# MyRetail

(Note : Please provide lambok.jar in the Runtime Environment)

How to use :-

1) clone the code (Clone with HTTPS : https://github.com/maheshbs2706/MyRetail.git)

//via IDE
2) import into any IDE which support java.
3) if auto build is enabled in the IDE, wait till it build, then run the application as spring boot application.

//via command line
4) setup maven
5) goto the folder where code is cloned, build using maven command(mvn clean install)
6) goto the target folder and find the "MyRetail-0.0.1.jar" file.
7) start the application using command java -jar MyRetail-0.0.1.jar

Following api's are available in the service

//get
http://localhost:8080/products/{id}

//post and PUT
http://localhost:8080/products/{id}
body : 
{
    "id": 13860428,
    "name": "The Big Lebowski (Blu-ray)",
    "current_price": {
        "value": 0.36,
        "currency_code": "USD"
    }
}

