# Login_system
Registration and login  Backend using  Springboot

1. Set up files for springboot
   project: Mavaen, Language: java, Springboot:3+, 
   Group:jmu3d.com.example
   Artifact: Login_System
   Name: Login_System
   Description:Demo project for Spring Boot
   Package name: jmu3d.com.example.Login_system
   Dependancies:
        Spring Web
        Spring Data MongoDB (optional for future adaptations)
        Spring Data JPA
        Spring Security
        H2Database
        Lombok
        MySQL JDBC driver
2. create new package: user
    a.create User class module  file>new> Class
        add code for user class module
     
    b.Create user Service class module
        UserService
            
    c. Create interface
        IUserService
    d. create interface
        UserRepository
            findbyemail method created by UserService
    e. create class UserController

3. create new package: registration
        add code for registration
        find out how record works
        b. create RegistrationController
        c.create new package token
            create class verificationToken
            generate constructor right click > generate > constructor
            create VerificationTokenRepository

4. create new package: security
    create class UserRegistrationSecurityConfig
    create class UserRegistrationDetails
    create class UserRegistrationDetailsService
5. create new package: exception
    create class UserAlreadyExistsException

6. Create package event
    a. create class RegistrationCompleteEvent
         generate constructor right click > generate > constructor

    b. create new package listener
       create j RegistrationCompleteEventListener
        1:18:00
7. install mysql locally  at https://dev.mysql.com/downloads/mysql/ for local test not using h2
        install  mysqlworkbench for local test
        in query:
            CREATE DATABASE registration_db;
            use registeration_db;

            then: SELECT * from registration_db.user
            to delete entry: DELETE FROM registration_db.user WHERE email='email@example';
