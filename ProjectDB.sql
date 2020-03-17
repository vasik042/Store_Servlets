-- DROP DATABASE ProjectBD; 

CREATE DATABASE ProjectBD;

USE ProjectBD;

CREATE TABLE user(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	password varchar(30) not null,
    email varchar(30) not null unique,
    first_name varchar(30) not null,
    second_name varchar(30) not null
);

insert into user (first_name, second_name, email, password)
value("lol", "fenol", "11@11", "1111");

select * from user;

