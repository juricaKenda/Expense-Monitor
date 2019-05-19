# Group Expense Monitor REST Service

## Structure of this README
* About the service  
* Trying out the service (with steps)  
* Structure of the service and the code (components, tests, interaction..)

## About the service
This **REST service** is made to **track financial transactions** between **members of a group**. Each group member starts off with an initial amount of money on his account budget. Whether that amount is positive or negative (debt towards other members) is irrelevant.  

Only important thing is that the **group total is equal to zero**. The moment when all group members have zero balance, is the moment when no one has extra "group money" and no one is owed any money.


### Example:
* **Frank's budget** displays :  **100**
* **Mark's budget** displays : **-50**
* **Joe's budget** displays : **-50** 

This **indicates Frank owes Mark and Joe 50 (money units) each**.
### An important note:
The **service does not track who owes what to whom**, it only **tracks the initial budget** values of each group member **and their transactions** as means of balancing their budgets as a group.

## Trying out the service
### Spring Boot Maven project
To test this REST service directly on your localhost, download the entire project and import it into your IDE as an existing Maven project.  
* Entering endpoint of this project is located here : http://localhost:8080/home



## Structure of the service and the code
