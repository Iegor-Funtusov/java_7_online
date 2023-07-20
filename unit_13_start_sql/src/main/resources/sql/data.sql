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

SET @row_index := -1;

SELECT AVG(subq.salary) as median_value
FROM (
         SELECT @row_index:=@row_index + 1 AS row_index, salary
         FROM employees
         ORDER BY salary
     ) AS subq
WHERE subq.row_index
          IN (FLOOR(@row_index / 2) , CEIL(@row_index / 2));