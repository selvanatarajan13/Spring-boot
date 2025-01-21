show databases;
use `hb-01-one-to-one`;
show tables;

-- Inner Join
-- select * from `instructor` inner join `instructor_detail` on `instructor`.`instructor_detail_id` = `instructor_detail`.`id`; 

-- Full outer join
-- select * from `instructor` FULL OUTER join `instructor_detail` on
select * from `instructor_detail`;

-- alter table `instructor` drop foreign key `instrutor_detail_id`;
-- truncate table `instructor_detail`;

-- ALTER TABLE instructor
-- DROP FOREIGN KEY FK_DETAIL;

alter table `instructor` add constraint `FK_DETAIL` foreign key(`instructor_detail_id`)
references `instructor_detail`(`id`);