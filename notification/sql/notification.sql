create database notification;

create table notification (
                       id bigint auto_increment primary key,
                       customer_id bigint,
                       fraud_id bigint,
                       is_fraudster boolean,
                       create_at datetime
);