drop table if exists employee_tbl;

create table employee_tbl (
    id int not null AUTO_INCREMENT,
    name varchar(30) not null,
    gender char(2) null,
    birthday datetime null,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8;

insert into employee_tbl(name, gender, birthday) values ('lily', '女', '1992-11-21');
insert into employee_tbl(name, gender, birthday) values ('lucy', '女', '1988-12-22');
insert into employee_tbl(name, gender, birthday) values ('jacky', '男', '1985-08-25');
insert into employee_tbl(name, gender, birthday) values ('keven', '男', '1983-05-12');
insert into employee_tbl(name, gender, birthday) values ('poly', '女', '1997-10-02');


drop procedure if exists get_employees_sp;
CREATE procedure get_employees_sp()
BEGIN
    select * from employee_tbl;
END
;

call get_employees_sp;