select *
from score 
join student on score.student_id = student.id 
join course on score.course_id = course.id;

select student.name, course.course_name, score.score
from score
join student on score.student_id = student.id
join course on score.course_id = course.id;

select student.name, student.age from student;

select student.name, score.score
from score 
join student on score.student_id = student.id 
where score.score > 90;

select course.course_name, score.score
from student
join score on student.id = score.student_id 
join course on course.id = score.course_id 
where student.name = '张三';

select student.name, score.score
from student
join score on score.student_id = student.id;

select student.name, score.score
from student 
left join score on student.id = score.student_id;

select student.name, course.course_name, score.score
from score 
join student on student.id = score.student_id 
join course on course.id = score.course_id;

-- 查所有课程名称+分数
select course.course_name, score.score
from course
left join score on  score.course_id = course.id;
-- 查所有有成绩的课程名称+分数
select course.course_name, score.score
from course 
join score on score.course_id = course.id;
-- 查所有课程（包括没人选的）+分数
select course.course_name, score.score
from course 
left join score on score.course_id = course.id;
-- 查李四的所有课程+分数
select course.course_name, score.score
from student 
left join score on student.id = score.student_id
join course on score.student_id  = course.id
where student.name = '李四';
-- 查没有成绩的学生(只显示名字)
select student.name
from student
left join score on student.id = score.student_id 
where score.student_id is null;
-- 查：既选了课，但成绩小于60（不及格）的学生
select student.name
from student 
join score on student.id = score.student_id 
where score.score < 60;

-- 子查询
-- 查有成绩的学生名字
select student.name -- name
from student 
where id in(
	select student_id
	from score 
	where score is not null -- 可删除这句
);
-- 查不及格学生的名字
select student.name
from student 
where id in(
	select student_id
	from score 
	where score <60
);
-- 查选了Java课程的学生名字
select student.name
from student 
where id in(
	select student_id
	from score
	where course_id in(
		select id 
		from course 
		where course.course_name = 'Java'
	)
);