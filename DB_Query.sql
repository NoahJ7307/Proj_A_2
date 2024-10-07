create database projadb;
use projadb;

create user`projauser`@`%` identified by '1234'; 
grant all privileges on projadb.* to `projauser`@`%`;

show tables;