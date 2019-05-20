# Group Expense Monitor REST Service

## Structure of this README
* About the service  
* Trying out the service (with steps)  
* Structure of the service and the code (components, tests, interaction..)

# About the service
This **REST service** is made to **track financial transactions and debts** between **members of a group**. Each group member starts off with an initial amount of debt on his account budget. Whether that amount is positive or negative (debt towards other members) is irrelevant.  

Only important thing is that the **group total is equal to zero**. The moment when all group members have zero balance, is the moment when no one has extra "group money" and no one is owed any money.


### Example:
* **Frank's budget** displays :  **100**
* **Mark's budget** displays : **-30**
* **Joe's budget** displays : **-70** 

This **indicates Frank is owed 100 (money units), Mark owes 30 (money units), and Joe owes 70 (money units)**.
To whom they owe it, it does not intrest us.

### An important note:
The **service does not track who owes what to whom**, it only **tracks the debt towards the group** of each group member **and their transactions** as means of balancing their debts as a group.

# Trying out the service
### Spring Boot Maven project
To test this REST service directly on your localhost, download the entire project and import it into your IDE as an existing Maven project.  
After running the main method, Spring Boot will deploy the Spring Boot application in Tomcat web server.

* Entering endpoint of this project is : http://localhost:8080/home  
## 1) Welcome page :
![](/Visuals/welcomePage.png)

## 2) After the insertion of the first group member, the page will look like this:
![](/Visuals/insertGroupMember.png)

## 3) After more insertions of group members, the page will look like this:
![](/Visuals/moreGroupMembers.png)

## 4) After requesting to start managing transactions, you will be taken to the transactions page:
![](/Visuals/transactionPage.png)

## 5) After defining the first transaction, the page will look like this:
![](/Visuals/afterFirstTransaction.png)

## 6) After defining more transactions, the page will look like this:
![](/Visuals/afterMoreTransactions.png)

## 7) After performing an outter transaction, the page will look like this:
![](/Visuals/afterOutterTransaction.png)


## Structure of the service and the code

### Visual approximate of the service structure
![](/Visuals/MVCStructure.png)


# Code structure - elements

* **interfaces** - govern the interaction between all components
* **controllers** - provide REST endpoint mappings and error mappings
* **service layer** - performs the business logic in the application
* **model** - models the entities in the aplication as abstractions from the real world
* **mock repository** - data storage, that acts as a database
* **user defined exceptions** - application specific exceptions 
* **tests** - unit tests for important business layer components


## 1) Interfaces 

**BudgetingEssentials** - defines important budget related operations such as the increase and decrease of members debt
**ServiceEssentials** - defines important service related operations with regards to transactions, repository, and members
**RepositoryEssentials** - defines basic repository related operation such as registering and fetching members
**MemberEssentials** - defines member operations which are in essence cascaded budget operations

## 2) Controllers 
**Very important note!**  
*I used GET method in two of my mappings that I used for the deletion of existing group members. I am aware this is bad practice, but I wanted to give the user the opportunity to fully interact with the application through a basic browser, without any external apps such as Postman, and this is the only way I currently know how to achieve the deletion and have this request met*

**RestRequestController :** 
* handles the mapping request and forwards the important business and application logic requests to the *ExpenseService* that is autowired upon the creation of the controller
* makes sure the proper html file is displayed to the user
* sets up the model parameters for creating POJOs from user's interaction with the html templates

**ErrorHandlerController :** 
* handles the errors that are caught by the controller layer of the application logic (eg. invalid inputs into input fields)
* since the UI was not focal point of this project, this controller redirects the user to a page indicating something went wrong, it does not give any additional info about what exactly went wrong and how to repair it

## 3) Service Layer

**ExpenseService :** 
* the most important component of the service layer
* takes care of all transactions (member-to-member or member-to-external) and the logging process
* takes care of communication with the repository
* uses two additional helper classes (autowired upon creation) - TransactionLog & GroupMemberIDgenerator

**TransactionLog :** 
* logs, stores and fetches all transactions performed by the expense service

**GroupMemberIDgenerator :** 
* assigns a unique identification number to each group member, upon his registration

## 4) Model layer

**GroupMember :**
* represents an abstraction of a member within a given group
* each group member is uniquely identifiable by his ID
* each group is directly related to his own balance (budget, or debt)

**Transaction :**
* represents an abstraction of a transaction between two group members, or between a group member and external money source
* records the *sender ID*, *receiver ID*, and *transaction amount*

## 5) Mock repository

**MemberRepository :**
* represents a placeholder for all members within one group
* provides the expense service with some basic operations such as : registry of new members, fetching and deletion of members by their ID

## 6) Application specific exceptions
**GroupMemberNotFoundException** - occurs when a member with a given ID is not found in the repository
**InvalidTransactionException** - occurs when something is wrong about the transaction; invalid transaction amount, invalid group member IDs, attempt of a reflective transaction..
**RepositoryNotInstantiatedException** - occurs when a component tries to access uninstantiated repository

## 7) Tests
**ServiceTests :** 
* *performTransactionTest()* - tests if a valid transaction results with a valid and expected outcome
* *testInvalidTransactionException()* - tests if an invalid transaction throws an expected exception
* *getAllTransactionsTest()* - tests if the transaction logger is working properly

**IDgeneratorTests :**
* *testAllUnique()* - tests if a requested amount of IDs will be distinct and unique
