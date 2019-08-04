CREATE TABLE users (
  id bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  username varchar(100) NOT NULL,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) DEFAULT NULL
);
