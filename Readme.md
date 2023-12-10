#INSTRUCTIONS TO RUN THE EMPLOYEE MANAGEMENT SYSTEM?#

1. Open the project in an IDE.
2. Check your database connection in src/main/resources/application.properties file and change if needed.
4. Go to com.example.employee.EmployeeManagementSystems.EmployeeManagementSystems.java class
5. Right Click on class Application and hit 'Run as java application'.
6. Check if localhost server has started.
7. Open Postman client service on Google chrome.
8. Hit url : "localhost:8080/auth/login" with method as POST.
9. Now under body >> raw then choose script as  json,Provide name as "Anand" and password as "Anand" and hit 'SEND'.
10. Now you will be getting a 'jwtToken' and name as "Anand".
11. Accordingly select the request method and the url as follows like for example if you are selecting: 
		GET - "http://localhost:8080/employee/allEmployees" - gets list of all Employees
		Then before hitting SEND give KEY as "Authorization" and VALUE as the jwtToken you have got under HEAD
		And then Hit SEND.
12. Similarly test these APIs as well: 
		POST - "http://localhost:8080/employee/addEmployee" - For adding the employee
		DELETE - "http://localhost:8080/employee/removeEmployee/{id}" - For deleting a specific employee by id
		GET - "http://localhost:8080/employee/findEmployee/{id}" - For finding any employee by id
		PUT - "http://localhost:8080/employee/UpdateEmployee/{id}" - updates employees with selected id
		
#TECHNOLOGY STACK#
1. Java
2. Eclipse 4.26.0
3. Postgres SQL 
4. Postman
