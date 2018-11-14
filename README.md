# backend-for-testers

Ready-made project for a Tester/QA assignment.

## The setup

- JAVA 8+ jdk must be [installed](https://www.oracle.com/technetwork/java/javase/downloads/index.html)
- MAVEN must be [installed](https://maven.apache.org/download.cgi)

## Running the application

From the project root folder:

1. run `mvn clean test`
2. run `mvn exec:java`

The service runs on `localhost:8081` by default.  
You can change the port by running `mvn exec:java -Dexec.args="8888"`, for example.

### Examples

#### Retrieving information for one user

-  Request:
    - GET `http://localhost:8081/waesheroes/api/v1/users/details?username=dev`
-  Response body:  
```
        {  
         "dateOfBirth": "1999-10-10",  
         "email": "zd.dev@wearewaes.com",  
         "isAdmin": false,  
         "name": "Zuper Dooper Dev",  
         "superpower": "Debug a repellent factory storage."  
        }  
```

#### Retrieving information from all users

-  Request:
    - GET `http://localhost:8081/waesheroes/api/v1/users/all`  
    - Basic Auth: `username=admin` , `password=hero`

#### Login

-  Request:
    - GET `http://localhost:8081/waesheroes/api/v1/users/access`  
    - Basic Auth: `username=tester` , `password=maniac`

#### Sign up

-  Request:
    - POST `http://localhost:8081/waesheroes/api/v1/users`
    - Header: `username=new_user` , `Content-Type=application/json`
    - Body:
```
           {  
             "isAdmin": false,  
             "dateOfBirth": "1984-09-18",  
             "email": "new.user@wearewaes.com",  
             "name": "New User",  
             "pw": "wololo",  
             "superpower": "Kamehameha."  
           }  
```

#### Update user

-  Request:
    - PUT `http://localhost:8081/waesheroes/api/v1/users`
    - Basic Auth: `username=dev` , `password=wizard`
    - Body:
```
           {  
             "dateOfBirth": "1999-10-10",  
             "email": "zd.dev@wearewaes.com",  
             "isAdmin": false,  
             "name": "Zuper Dooper Dev",  
             "pw": "wizard",  
             "superpower": "A new power."  
           }  
```

#### Delete user

-  Request:
    - DELETE `http://localhost:8081/waesheroes/api/v1/users`
    - Basic Auth: `username=tester` , `password=maniac`
-  Response body:
```
        {  
          "dateOfBirth": "2014-07-15",  
          "email": "as.tester@wearewaes.com",  
          "isAdmin": false,  
          "name": "Al Skept-Cal Tester",  
          "superpower": "Voltage AND Current."  
        }
```