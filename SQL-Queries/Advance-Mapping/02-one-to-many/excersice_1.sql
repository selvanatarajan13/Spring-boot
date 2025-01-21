-- create a new database

create database if not exists `demo_sql`;

-- if you want to delete the table ,
-- drop database `demo_sql`;

-- first we will select the db before create the table in db using use keyword to select the db
use `demo_sql`;


-- create tables
create table if not exists `Person` (
	`PersonId` int not null,
    `first_name` varchar(60) default null,
    `last_name` varchar(60) default null,
    `Address` varchar(68) default null,
    `city` varchar(68) default null
);

-- if you want create the another table and copying some fields on existing table, then
create table if not exists `copy_table` as select `first_name` , `last_name` from `Person`;

-- we can be also alter the table like adding column, remove column, change column name etc, see one by one
-- 1.Add new column
alter table `copy_table` add column dob date;

-- 2. Add new column on id
alter table `copy_table` add column id int;

-- 3. add primary key
alter table `copy_table` add primary key(`id`);

-- 4. modify the id
alter table `copy_table` auto_increment=100;

-- 5. change the column name and datatype
alter table `copy_table` rename column `dob` to `email`;

alter table `copy_table` modify column `email` varchar(60);

-- insert values
insert into `copy_table`(id,first_name,last_name,email) values(101,"Mahendran","S","mahend@gmail.com"),(102,"Selva","S","selva@gmail.com");
