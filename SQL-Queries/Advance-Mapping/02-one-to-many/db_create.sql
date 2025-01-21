drop schema if exists `hb-02-one-to-many`;

create schema if not exists `hb-02-one-to-many`;

use `hb-02-one-to-many`;

-- Disable the foreign key check table
set FOREIGN_KEY_CHECKS = 0;

create table if not exists `instructor_detail` (
	`id` int(11) not null auto_increment,
    `youtube_channel` varchar(128) default null,
    `hobby` varchar(50) default null,
    
    primary key(`id`)
) engine=InnoDB auto_increment=1 default charset=latin1;


create table if not exists `instructor` (
	`id` int(11) not null auto_increment,
    `first_name` varchar(50) default null,
    `last_name` varchar(50) default null,
    `email` varchar(50) default null,
    `instructor_detail_id` int(11) default null,
    
    primary key(`id`),
    
    key `FK_DETAIL_idx` (`instructor_detail_id`) ,
    constraint `FK_DETAIL` foreign key(`instructor_detail_id`) 
    references `instructor_detail` (`id`)
    on delete no action on update no action
) engine=InnoDB auto_increment=1 default charset=latin1;

