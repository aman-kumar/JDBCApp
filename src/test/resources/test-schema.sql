create table Book 
  (bookId varchar(20) not null, 
  name varchar(25) not null,
  author varchar(25),
  publication varchar(25), 
  description varchar(50), 
  noOfCopies integer, 
  primary key (bookId));