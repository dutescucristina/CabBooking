create database if not exists my_training_db;
use my_training_db;
create table booking(id int primary key auto_increment, email varchar(255), location_id int, type_of_cab int);
create table location(id int primary key auto_increment, from_location varchar(100), to_location varchar(100), price int);
  
  INSERT INTO location (from_location, to_location, price)
VALUES
('Constanta', 'Bucuresti', 200),
('Constanta', 'Iasi', 600),
('Bucuresti', 'Brasov', 100),
('Bucuresti', 'Iasi', 500);
