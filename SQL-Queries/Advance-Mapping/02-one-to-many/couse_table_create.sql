create table if not exists `course`(
	`id` int(11) not null auto_increment,
    `title` varchar(168) default null,
    `instructor_id` int(11) default null,
    
    primary key(`id`),
    
    unique key `TITLE_UNIQUE` (`title`),
    
    constraint `FK_INSTRUCTOR` foreign key(`instructor_id`)
    references `instructor` (`id`)
) engine=InnoDB auto_increment=1 default charset=latin1;
