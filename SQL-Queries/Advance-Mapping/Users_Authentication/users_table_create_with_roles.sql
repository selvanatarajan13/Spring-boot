-- create a database
create database if not exists `users_credential`;

-- define which db is use
use `users_credential`;

-- Disable the foreign key check table
set FOREIGN_KEY_CHECKS = 0;

-- create tables such as users and roles
create table if not exists `users`(
	`id` int not null auto_increment,
    `first_name` varchar(50) default null,
    `last_name` varchar(50) default null,
    `email` varchar(50) default null,
    `password` varchar(68) default null,
    `enabled` tinyint not null,
    
    primary key(`id`)
) engine=InnoDB auto_increment=101 default charset=latin1;

-- add new column in the users table
alter table `users` add column 

-- insert the values into the users
insert into `users`(first_name,last_name,email,password,enabled) values("George","David","georged@gmail.com","{bcrypt}$2a$12$Y64UFhgk7o9NWLDt.isHMuP6AzgFzdFpDDrMcZLoDTH5PkQ771p3S",1),
("Tom","hanks","tom@gmail.com","{bcrypt}$2a$12$Y64UFhgk7o9NWLDt.isHMuP6AzgFzdFpDDrMcZLoDTH5PkQ771p3S",1),
("Mahend","S","mahend@gmail.com","{bcrypt}$2a$12$Y64UFhgk7o9NWLDt.isHMuP6AzgFzdFpDDrMcZLoDTH5PkQ771p3S",1);

create table if not exists `authority_roles` (
	`id` int not null auto_increment,
	`email` varchar(50) not null,
    `authorities` varchar(50) not null,
    
    primary key(`id`)
) engine=InnoDB auto_increment=200 default charset=latin1;


-- insert the values into the roles
insert into `authority_roles` values("georged@gmail.com","ROLE_EMPLOYEE"), ("tom@gmail.com","ROLE_EMPLOYEE"), ("tom@gmail.com","ROLE_MANAGER"),
("mahen@gmail.com","ROLE_ADMIN"),("mahen@gmail.com","ROLE_MANAGER"),("mahen@gmail.com","ROLE_EMPLOYEE");

