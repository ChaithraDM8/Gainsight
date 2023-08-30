create table course (cno int primary key, cname varchar(30), cduration int);
create course_copy as select * from course;
alter table course add column cfee int, add column cstructure text;
alter table course drop column cfee, drop column cstructure;
alter table course rename column cno to cnum;
