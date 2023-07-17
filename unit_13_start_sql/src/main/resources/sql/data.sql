-- create
insert into departments values (default, 'JAVA');
insert into departments values (default, 'JS');
insert into departments values (default, 'PYTHON');

insert into employees values (default, 'qq', 'qqq', 20);
insert into employees values (default, 'ww', 'www', 25);
insert into employees values (default, 'ee', 'eee', 28);
insert into employees values (default, 'rr', 'rrr', 38);

-- update
update employees set first_name = 'fsf', last_name = 'dfsafsa', age = 10 where id = 1;

-- delete
delete from employees where id = 1;


-- read
select * from employees;
select * from employees where id = 12;

