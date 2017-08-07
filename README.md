# helloSpringBoot
Command to Run helloSpringBoot Application:
    mvn clean package spring-boot:run

Command to run the helloSpringBoot executable JAR:
    java -jar helloSpringBoot.jar

Service Sandbox:
1. methods=[POST] [/api/employee/add]
2. methods=[GET], [/api/employee/{id}], produces=[application/json]
3. methods=[GET], [/api/employee/fname/{firstName}], produces=[application/json]
4. methods=[GET], [/api/employee/lname/{lastName}], produces=[application/json]
5. methods=[GET], [/api/employees], produces=[application/json]
6. methods=[PUT], [/api/employee/update/{id}]
7. methods=[DELETE], [/api/employees/delete], produces=[application/json]
8. methods=[DELETE], [/api/employee/delete/{id}], produces=[application/json]
9. methods=[GET], [/api/build],produces=[application/json] // For Git Commit and Build Information
