create database userapp;
use userappdb;


create table users
(
id integer auto_increment primary key,
username varchar(100) not null,
email varchar(50) not null unique,
country varchar(50) not null,
passwd varchar(20) not null
);
