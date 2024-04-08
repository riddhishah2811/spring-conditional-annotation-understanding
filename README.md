# spring-conditional-annotation-understanding
This is the project which helps you understand why we are using @Conditional Annotation.
@Conditional annotation will evalute the condition just before the classes loading as spring beans into the application context.
@Conditional annotation will only load the beans into the application context when the condition matches. the conditions that we can load the class as spring beans:
1. based on the system property
2. based on the perticluar class availble in the class path.
3. based on the dependency avallble in the class path
4. based on the environment specific property
   
What is AutoConfiguration: 
* @auto-configuration helps us automatically configure a Spring application based on the dependencies that are present on the classpath.
* AutoConfiguration is the process of loading the classes based on some condition for which only the spring Application context will creates the spring beans. The Spring Boot autoconfiguration mechanism heavily depends on the @Conditional feature introduced from the spring 4. x onwards. To Understanding the @Conditional annotation, we first must Understand the @Profile annotation.
What is a Profile?
Environemnt specific configurations is called as profile.

## Problem
* This is the solution for spring-profile-understanding repository.
* If we can see in that project we are selecting the profile and based on that we are getting the respective result. But If we closely observe whenever we change the profile in application.properties we have to build the application. Which is the violation of 12-factor design pattern which tells you to follow WORA(Write Once Read Anytime).
* So, If we can see on that repository we are building application on every change in profile and internally it is loading all the classes of all specified profiles.Which is not correct.
* For that reasonn,this repository will helps you to use the maven project with the @Conditional Annotation.

## Solution
Now, In this project we are following the below Architecture to resolve the problem.

<img width="539" alt="Screenshot 2024-04-07 at 11 25 09 PM" src="https://github.com/riddhishah2811/spring-conditional-annotation-understanding/assets/59967480/400121bc-2bbc-4441-8005-b57e28eee15a">

## Output
If we can see, by using @Conditional annotation we are restricting the H2Class to load when the dbType=MYSQL or vice versa in the ApplicationContext Container.

<img width="802" alt="Screenshot 2024-04-07 at 11 06 46 PM" src="https://github.com/riddhishah2811/spring-conditional-annotation-understanding/assets/59967480/bc49bc5a-039c-46d7-bbba-26a7d1b66402">
<img width="464" alt="Screenshot 2024-04-07 at 11 07 22 PM" src="https://github.com/riddhishah2811/spring-conditional-annotation-understanding/assets/59967480/834d295a-617f-4907-8de8-7c355a9491b5">

<img width="802" alt="Screenshot 2024-04-07 at 11 06 25 PM" src="https://github.com/riddhishah2811/spring-conditional-annotation-understanding/assets/59967480/1f9cdf14-063d-4fef-ab38-657d8dc32a25">
<img width="458" alt="Screenshot 2024-04-07 at 11 05 31 PM" src="https://github.com/riddhishah2811/spring-conditional-annotation-understanding/assets/59967480/2f0113f5-70db-4a3c-bbec-28299e462700">

## Understanding
* Spring boot Autoconfiguration is using @conditional annotation extensively to load the autoconfiguration classes based on
  1. @ConditionalOnBean
  2. @ConditionalOnClass
  3. @ConditionalOnProperty
  4. @ConditionalOnMissingBean
 
  For example, to enable the H2AutoConfiguration, it is looking for:
  @ConditionalOnWebApplication(type = Type.SERVLET)
  @ConditionalOnClass(WebServlet.class)
  @ConditionalOnProperty(prefix = "spring.h2.console", name"enabled",havingValue = "true")
  @EnableConfigurationProperties(H2ConsoleProperties.class)

  --> looking first whether the application is a web application or standalone
application, if it is the web application then only the one of the condition match.
  --›Checking h2 maven dependency is there and the org.h2.* classes were there in
classpath or not. perticluarly the org.h2.web.server.WebServlet.class
  --> though we have taken the h2 maven dependency, and the webapplication, 1f still we dont set the "spring.h2.console.enabled=true" it wont autoconfigure the H2 database. hence we also need to set this property i.e. "spring.h2.console.enabled=true" in our application.properties file.

  then only as all the above mentioned 4 conditions will satisfy and then only the h2 in memory database will be configured.

  Like that there are many autoconfiguration classes like jpaautoconfiguration,..etc which were written for starters inside autoconfiguration dependencies.




