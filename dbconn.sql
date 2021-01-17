create database if not exists jeeps;
drop table if exists jeeps;
create table jeeps (
  jeep_id int(10) not null auto_increment,
  name varchar(100) null,
   primary key(jeep_id)
);