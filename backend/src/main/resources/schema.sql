drop table if exists cars CASCADE;
create table cars 
(
id bigint not null auto_increment, 
make varchar(255), 
model varchar(255), 
colour varchar(255), 
reg varchar(255), 
primary key (id)
);