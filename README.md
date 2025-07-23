# Repository_Finder

## A RESTful Spring Boot application that fetches non-fork repository data for a given user including branch and commit data

### Features: 
  - fetch public GitHub repositories that are not forks
  - show branch names and last commit's SHA
  - handle non-existent user errors

### Tech and libraries used:
  - Java 21
  - Spring Boot 3.5.3
  - Lombok
  - RestAssured 5.5.5 (integration testing)
  - Gradle 

#### Example request to fetch repository data:
  GET /user/repos/marrosuksw
##### Example JSON response:
<img width="556" height="508" alt="obraz" src="https://github.com/user-attachments/assets/982fcf5d-94ec-4f52-856b-8231b81b3cf8" />

##### Non-existent user example response:
<img width="268" height="60" alt="obraz" src="https://github.com/user-attachments/assets/37472678-2338-47dc-a56a-4214f70abb26" />


#### Testing
  The integration test created in this project is a happy-path test and requires internet connection
