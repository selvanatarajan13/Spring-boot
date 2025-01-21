create table if not exists `members`(
	`username` varchar(50) not null,
    `password` varchar(50) not null,
    `enabled` tinyint not null,
    
    primary key(`username`)
) engine = InnoDB default charset = latin1;

insert into members values("steve","{noop}fun1234",1), ("mark","{noop}fun1234",1),("elon","{noop}fun1234",1);

create table if not exists `roles`(
	`username` varchar(50) not null,
    `authority` varchar(50) not null,
    
    unique key `authorities_idx_1` (`username`,`authority`),
    constraint `authorities_ibfk_1`
    
    foreign key(`username`)
    references `members` (`username`)
) engine=InnoDB default charset=latin1;

insert into roles values("steve","ROLE_EMPLOYEE"),
("mark","ROLE_EMPLOYEE"),
("mark","ROLE_MANAGER"),
("elon","ROLE_ADMIN"),
("elon","ROLE_MANAGER"),
("elon","ROLE_EMPLOYEE");