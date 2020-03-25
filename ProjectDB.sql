drop database projectbd;
Use projectbd;

select * from user;

drop table product;
drop table user;

CREATE TABLE user(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	password varchar(30),
    email varchar(30) not null unique,
    first_name varchar(30),
    second_name varchar(30) default "secondNmae!!!"
);

insert into user (first_name, second_name, email, password)
value("lol", "fenol", "11@11", "1111");

create table product (
	id int primary key auto_increment,
	product_name varchar (40) not null unique,
    product_description varchar (200) default "No description",
    price double (7, 2) not null
);

select * from product;

select * from user;

INSERT INTO product (product_name, product_description, price)
VALUES ("?", "?", "?");

INSERT INTO product (product_name, price)
VALUES ("?", "?");