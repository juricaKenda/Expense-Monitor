# Group Expense Monitor REST Service

## Structure of this README
* About the service  
* Trying out the service (with steps)  
* Structure of the service and the code (components, tests, interaction..)

## About the service
This **REST service** is made to **track financial transactions and debts** between **members of a group**. Each group member starts off with an initial amount of debt on his account budget. Whether that amount is positive or negative (debt towards other members) is irrelevant.  

Only important thing is that the **group total is equal to zero**. The moment when all group members have zero balance, is the moment when no one has extra "group money" and no one is owed any money.


### Example:
* **Frank's budget** displays :  **100**
* **Mark's budget** displays : **-50**
* **Joe's budget** displays : **-50** 

This **indicates Frank is owed 50 (money units) each by Mark and Joe **.

### An important note:
The **service does not track who owes what to whom**, it only **tracks the debt towards the group** of each group member **and their transactions** as means of balancing their debts as a group.

## Trying out the service
### Spring Boot Maven project
To test this REST service directly on your localhost, download the entire project and import it into your IDE as an existing Maven project.  
After running the main method, Spring Boot will deploy the Spring Boot application in Tomcat web server.

* Entering endpoint of this project is : http://localhost:8080/home  
## You will be presented with the following html page :
![](/Visuals/welcomePage.png)

## After the insertion of the first group member, the page will look like this:
![](/Visuals/insertGroupMember.png)

## After more insertions of group members, the page will look like this:
![](/Visuals/moreGroupMembers.png)

## After requesting to start managing transactions, you will be taken to the transactions page:
![](/Visuals/transactionPage.png)

## After defining the first transaction, the page will look like this:
![](/Visuals/afterFirstTransaction.png)

## After defining more transactions, the page will look like this:
![](/Visuals/afterMoreTransactions.png)

## After performing an outter transaction, the page will look like this:
![](/Visuals/afterOutterTransaction.png)


## Structure of the service and the code
