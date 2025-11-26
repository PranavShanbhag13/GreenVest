Admin login system
A simple username and password login is implemented for the admin.
Default login details:
Username: admin
Password: password123

Approve sustainability actions
The admin can view all submitted sustainability actions.
The admin can choose an Action ID and approve it.
Once approved, the system generates a carbon credit.

Automatic credit generation
Each approved action results in the creation of a new carbon credit.
The credit contains a unique ID, amount and expiry date.
This is handled using a Factory pattern.

Expiry alert system
The system checks whether a credit is near its expiry date.
If a credit is close to expiry, the admin is alerted.
This is implemented using the Observer pattern.

Command logging
Each key admin action is logged through the Command pattern.
Admin can view a history of executed commands.

State concept
Credits represent a basic state of active or expired.
This can be expanded further in later stages.

Data storage
The project currently uses an in-memory repository.
Data is stored using ArrayLists.
This can later be replaced by JSON files or a database.

Project structure

The project is organised into the following packages:

admin – contains AdminController and command-related files
model – contains Credit, SustainabilityAction, and AdminUser
patterns – contains design pattern implementations
repo – contains InMemoryRepository
service – contains business logic such as CreditFactory, RuleEngineService, AlertService and AdminService

How to run the project

Go to the src folder of the project

C:\Users\prath\OneDrive\Desktop\Greenvest\src

Compile the Admin controller

javac com\greenvest\admin\AdminController.java

Run the program

java -cp . com.greenvest.admin.AdminController

Login using the following details

Username: admin
Password: password123

Sample data used in the system

Two sustainability actions are added at the start for testing:

Action ID A1 – Installed solar panels
Action ID A2 – Planted 400 trees

These actions can be approved by the admin.

Admin Menu Options

1 – View pending sustainability actions
2 – Approve action and issue credits
3 – View all generated credits
4 – Check expiry alerts
5 – View command history
0 – Exit

Design patterns used

Factory Pattern – Used for creating Credit objects
Observer Pattern – Used for expiry alerts
Command Pattern – Used for logging admin actions
State Pattern – Used to represent credit status
Repository Pattern – Used for data management