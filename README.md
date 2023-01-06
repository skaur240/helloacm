# RestAssuredTestNGFramework
REST Assured API test automation framework using Java + Maven + TestNG.
Framework follows many of the  best practices.


Technologies/Tools used in building the framework
=================================================
- Rest Assured
- TestNG
- Java
- Allure Reports
- Lombok
- IntelliJ
- GitHub

Steps to generate Report
=========================================
run below commands on cmd line after executing DateTimeConverterTest.java File 
( or execute cmd : mvn clean test)

**Allure Report Generation:**
npm install -g allure-report
npm install -g allure-commandline

After executing testng.xml
allure serve target/allure-results
