create table department(dept_no int, dept_name varchar(30), dept_location text, primary key(dept_no));
create table employee(emp_no int primary key, emp_name varchar(30), emp_age int check(emp_age>=18), 
                      emp_gender char(1) check(emp_gender='M' or emp_gender='F'), 
                      dept_no int,foreign key(dept_no) references department(dept_no));
alter table employee add constraint delete_cascade foreign key(dept_no)references department(dept_no) on delete cascade;
