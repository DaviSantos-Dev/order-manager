CREATE DATABASE IF NOT EXISTS Order_Manager
default character set utf8mb4
default collate utf8mb4_general_ci;

use Order_Manager;

Create TABLE IF NOT EXISTS clients(
Id int auto_increment not null,
Name varchar (30) not null,
Email varchar(99) not null,
Password varchar(255) not null,
Client_Type varchar(20) not null,
primary key (Id)
) default charset utf8mb4;

CREATE TABLE IF NOT EXISTS products(
Id int auto_increment not null,
Name varchar (30) not null,
Price decimal(15,2) unsigned not null,
quantity int unsigned default 0,
status varchar(20),
primary key (id)
)default charset utf8mb4;

CREATE TABLE IF NOT EXISTS orders(
Id int auto_increment not null,
Client_Id int not null,
Order_Status varchar (20) not null,
primary key (id),
foreign key (Client_Id) references clients(id)
) default charset utf8mb4;

CREATE TABLE IF NOT EXISTS Order_Item(
Id int auto_increment not null,
Order_Id int not null,
Product_Id int not null,
quantity int unsigned not null,
price decimal(15,2) unsigned not null,
primary key (id),
foreign key (Order_Id) references orders(Id),
foreign key (Product_Id) references products(Id)
)default charset utf8mb4;
