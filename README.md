# LabelMaster2.0-WebServer
REST API. It's main purpose is to handle requests aimed at MySql database. It can check if a label is genui by checking if it exist in given table. Part of Label Master 2.0

Urls in my case (POSTMAN or web browser):

//http://localhost:8080/LabelMaster2/restapi/standardlabel/checklabel/AA123  GET
//http://localhost:8080/LabelMaster2/restapi/standardlabel/putlabel/AA123   POST
//http://localhost:8080/LabelMaster2/restapi/standardlabel/deletelabel/AA123   DELETE

For external device connection local IPv4 has to be used e.g. 
//http://192.168.0.22:8080/LabelMaster2/restapi/standardlabel/checklabel/AA123";
   


All of those produce JSON response:
//	0 = false
//	1 = true / success
//	99 = error


MySql database creation (via Workbench)

--creating database
CREATE DATABASE test;

-- creating mysql database for this project:
CREATE TABLE labels (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
numbers VARCHAR(30) NOT NULL,
reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP);

-- inserting a sample record 
INSERT INTO labels (numbers) values ('AA123');



Software:

Java EE : Eclipse IDE JEE 2018-09
Server: Tomcat v9.0
Jersey 2.30
Mysql Workbench 8.0
Testing REST API: Postman
