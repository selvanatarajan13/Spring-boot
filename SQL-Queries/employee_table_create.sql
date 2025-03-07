create table `employees` (
	`id` int not null auto_increment,
    `first_name` varchar(50) default null,
    `last_name` varchar(50) default null,
    `email` varchar(50) default null,
    primary key(`id`)
) engine = InnoDB auto_increment = 1 default charset=latin1;