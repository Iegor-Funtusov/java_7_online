-- create
insert into departments values (default, 'JAVA');
insert into departments values (default, 'JS');
insert into departments values (default, 'PYTHON');

insert into employees values (default, 'qq', 'qqq', 20);
insert into employees values (default, 'ww', 'www', 25);
insert into employees values (default, 'ee', 'eee', 28);
insert into employees values (default, 'rr', 'rrr', 38);

insert into dep_emp value (1, 1);
insert into dep_emp value (1, 2);

-- update
update employees set first_name = 'fsf', last_name = 'dfsafsa', age = 10 where id = 1;

-- delete
delete from employees where id = 1;


-- read
select * from employees;
select * from employees where id = 12;

SET @row_index := -1;

SELECT AVG(subq.salary) as median_value
FROM (
         SELECT @row_index:=@row_index + 1 AS row_index, salary
         FROM employees
         ORDER BY salary
     ) AS subq
WHERE subq.row_index
          IN (FLOOR(@row_index / 2) , CEIL(@row_index / 2));



start transaction;
insert into transactions values (default, 1, 2, 10);
update emp_balances set sum = 90 where emp_id = 1;
update emp_balances set sum = 110 where emp_id = 2;
commit;
rollback work ;

set transaction isolation level READ UNCOMMITTED;
set transaction isolation level READ COMMITTED;
set transaction isolation level repeatable read ;
set transaction isolation level serializable ;
update emp_balances set sum = sum + 10 where emp_id = 1;
update emp_balances set sum = sum + 20 where emp_id = 1;

# lock tables emp_balances READ ;


#datatable
select count(*) from employees where first_name like '%1' and age > 30 order by id desc limit 10,10;
