create table if not exists `review`(
	`id` int(11) not null auto_increment,
    `comment` varchar(128) default null,
    `course_id` int(11) default null,
    
    primary key(`id`),
    
    constraint `FK_COURSE` foreign key(`course_id`) 
    references `course`(`id`)
) engine=InnoDB auto_increment=1 default charset=latin1;