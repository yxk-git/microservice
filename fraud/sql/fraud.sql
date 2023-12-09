create database fraud;

create table fraud (
                       id bigint auto_increment primary key ,
                       customer_id bigint,
                       is_fraudster boolean,
                       create_at datetime
);