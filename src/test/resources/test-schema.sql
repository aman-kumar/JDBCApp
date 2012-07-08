create table Book 
  (bookId varchar(20) not null, 
  name varchar(25) not null,
  author varchar(25),
  publication varchar(25), 
  description varchar(50), 
  noOfCopies integer, 
  primary key (bookId));
  
  create table Student
  (studentId varchar(25) not null,
  firstName varchar(25),
  lastName varchar(25),
  address varchar(50),
  phoneNumber integer,
  email varchar(50),
  primary key(studentId));
  
  create table BookRecord
  (bookRecordId varchar(25) not null,
  bookId varchar(20) not null,
status varchar(20),
studentId varchar(20),
 primary key(bookRecordId),
 foreign key(bookId) references Book(bookId)
);