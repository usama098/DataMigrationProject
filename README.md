# DataMigrationProject
SecondVErsion

### What is the project about?

As part of the training with Sparta Global, we  were assigned the task of reading a CSV file and writing it to a SQL database. The CSV file contained a employee details, one a sample of 10,000 entries, the other being 65,000 rows long.

MySQL Workbench and Server were used to monitor and run the database locally, hence the use of the icon.

###  MVC Architecture

We adopted an MVC (model view controller) architecture for this project, to organise the packages and program In an easy to understand for other to interpret.

Take for example the controller package, which contains the CSVReader and EmployeeManager classes: both act as intermediaries between the model and view packages, processing the data and then outputting in a presentable manner.

We also created start and util packages for classes that did not fit within the other three packages (start for classes starting the program, util for utility classes used throughout the project).

### Multithreading

One of the requirements our trainer wanted was for the application to use multiple threads. We achieved this by reading in a portion of the CSV file), then writing it to the database. Depending on how many threads the user specifies would determine the size of each portion of records was written in one go e.g. if writing the sample file containing 10k rows using 5 threads, then approximately 2000 would be written at a time (not accounting for duplicates).

We also incorporated batching into our program, whereby instead of only executing one query at a time, they could be added to a batch and ran all at once. Both batching and threading could be toggled by the user (inputting 0 threads and a boolean for batching), something I utilised when carrying out performance tests.

### Performance

We conducted performance testing using parametrized tests using junit params. We created a CSV of a variety of number of threads, as both batched and not batched. There is currently a bug in the testing that causes performances to be wildly inaccurate, this being related to threads and the nature in which the test calls upon the program.

### DAO & DTO

In order to interact with the database, We created a Data Access Object, containing methods to create a table and insert into it, as well as selecting and printing it out.

A Data Transfer Object was used to store the data from the CSV file in a compatible format for the database, something espeically important for the Date field.

