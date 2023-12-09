create database customer;
create table customer
(
    id         bigint auto_increment
        primary key,
    first_name varchar(20) null,
    last_name  varchar(20) null,
    email      varchar(30) null
);