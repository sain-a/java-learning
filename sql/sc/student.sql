create table student(
	id INT primary key auto_increment,
	name VARCHAR(50),
	age INT
);
insert into student(name,age) VALUES('张三',20);

create table score(
	id INT primary key auto_increment,
	student_id INT,
	course_id INT,
	score DECIMAL(5,2)
);

create table course( 
	id INT primary key auto_increment,
	course_name VARCHAR(50)
);

insert into course (course_name) VALUES('Java');

insert into score (student_id,course_id,score)
VALUES(1,1,95);

select * from score;

select * from student;

insert into student(name,age) VALUES('李四',22);

insert into course (course_name) values ('MySQL');

select * from student;
select * from course;
select * from score;

select * from student;
select * from student where age > 20;
select name from student;
select count(*) from student;