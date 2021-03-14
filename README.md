# LabelMaster2.0-WebServer
REST API. It's main purpose is to handle requests aimed at MySql database. It can check if a label is genui by checking if it exist in given database. Part of Label Master 2.0
<BR><BR>
   
Check also the main mobile app that uses this functionality: https://github.com/PDymala/LabelMaster2.1-Android
<BR><BR>
Urls in my case (POSTMAN or web browser):
<BR><BR>
//h.ttp://localhost:8080/LabelMaster2/restapi/standardlabel/checklabel/AA123  GET<BR>
//h.ttp://localhost:8080/LabelMaster2/restapi/standardlabel/putlabel/AA123   POST<BR>
//h.ttp://localhost:8080/LabelMaster2/restapi/standardlabel/deletelabel/AA123   DELETE<BR>
<BR><BR>
For external device connection local IPv4 has to be used e.g. 

//h.ttp://192.168.0.22:8080/LabelMaster2/restapi/standardlabel/checklabel/AA123"   GET
   
<BR><BR>

All of those produce JSON response:<BR>
//	0 = false<BR>
//	1 = true / success<BR>
//	99 = error<BR>


MySql database creation (via Workbench)<BR>
<BR><BR>
--creating database<BR>
CREATE DATABASE test;<BR>
<BR><BR>
-- creating mysql database for this project:<BR>
CREATE TABLE labels (<BR>
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,<BR>
numbers VARCHAR(30) NOT NULL,<BR>
reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP);<BR>
<BR><BR>
-- inserting a sample record <BR>
INSERT INTO labels (numbers) values ('AA123');



Software:

Java EE : Eclipse IDE JEE 2018-09<BR>
Server: Tomcat v9.0<BR>
Jersey 2.30<BR>
Mysql Workbench 8.0<BR>
Testing REST API: Postman
