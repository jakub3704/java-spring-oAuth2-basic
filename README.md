# Java / Spring - basic oAuth2

### Introduction
Basic oAuth2 security implementation.

Testing with POSTMAN or similar.

1. To Get Token:  
  POST http://localhost:7788/oauth/token  
  - Authorization method: Basic Auth  
  Username: tutorial-client  
  Password: tutorial-secret  

 - Body: x-www-form-urlencoded  
   grant_type: password  
   password: adminp (userp)
   username: admin (user)

2. GET http://localhost:7788/hello/world

3. GET http://localhost:7788/hello
  - Authorization: Bearer Token: "your_access_token"
  - For admin and user

4. GET http://localhost:7788/hello/admin
  - Authorization: Bearer Token: "your_access_token"
  - For admin

5. GET http://localhost:7788/hello/user
  - Authorization: Bearer Token: "your_access_token"
  - For user

### Running
  gradlew clean build  
  gradlew bootRun  

Used technologies:  
- Java - source compatibility 1.8
- Gradle - 6.6.1
- Spring - 5.2.9.RELEASE
- org.springframework.boot - 2.3.4.RELEASE