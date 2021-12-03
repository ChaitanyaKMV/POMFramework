# POMFramework
Hybrid TestNG POM Framework


This code runs to test sample website i.e: https://Freecrm.com to test Login flow and logout

Java: Used openjdk version "16"

To run this on local configured pom.xml is parameterized 'XMLFiles/testng.xml' where user can pass arguments for url,browser & testng xml

Ex- To run with maven command:     mvn clean install -Dbrowser=Chrome -DurlToTest=https://freecrm.com -DtestngXML=testng.xml
