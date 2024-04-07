# spring-conditional-annotation-understanding
This is the project which helps you understand why we are using @Conditional Annotation.

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



