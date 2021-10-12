# lab3

## Task:
- The task is performed on the basis of the designed database model
lab.roboti No1.</br></br>
- For this model, the structure should be re-analyzed
Database to ensure the 3rd normal form, availability</br></br>
all Primary Key.</br></br>
- To implement a database, write a script to create it in the kernel
MySQL, which must meet the following criteria:</br></br>
❖ SQL-script can be run several times in a row and at
this should not result in errors due to existing ones
database elements. That is, appropriate must be provided
DROP for tables and IF EXISTS to create a database.</br></br>
❖ For each table it is necessary to carry out filling with data on
10-15 INSERT, while predicting the correct
data insertion procedure.</br></br>
❖ Create at least 2 additional indexes for tables,
according to the preliminary analysis of the data structure.

## hOW tO rUn ?
  - First of all you must have a prescribed path of git and mysql in your environment variables
  - NEXT STEP ↓</br>
  - clone my repository:
  ```
  git clone https://github.com/Wectro20/DataBases.git
  ```
  - switch to lab3 branch:
  ```
  git checkout lab3
  ```
  - open 1st cmd and write this command
   ```
   mysqld --console
   ```
  - then open new cmd and write this ↓
   ```
   mysql -u root -p
   ```
  - then enter your password to mysql
  - write 
   ```
   source (here must be your path to lab3.sql)
   ```
  - next step ↓
   ```
   source (here must be your path to populatelab3.sql)
   ```
  - my congratulations you all succeeded (͠≖ ͜ʖ͠≖)👌
