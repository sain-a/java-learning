# 1.MySQL基础语法

```mysql
1.查询(SELECT)：
	基本写法：
		SELECT * FROM 表名;
		例：SELECT * FROM student ->查student表里所有数据
	查某个字段：
		SELECT name FROM stuent; ->只看name
		SELECT name,age FROM student WHERE age>18;
2.条件筛选(WHERE):
	用来筛选数据：
		SELECT * FROM student WHERE age > 20; ->查年龄大于20的人
3.插入(INSERT)：
	往表里加数据：
		INSERT INTO student(name,age) VALUES('张三'，20)；
4.修改：
	改数据：
		UPDATE student SET age = 21 WHERE id = 1; ->把 id=1 的人年龄改成21
5.删除(DELETE)：
	删除数据：
		DELETE FROM student WHERE id = 1;
6.聚合函数：
	SELECT COUNT(*) FROM student;   -- 总人数
	SELECT AVG(age) FROM student;   -- 平均年龄
	SELECT MAX(age) FROM student;   -- 最大年龄
	SELECT MIN(age) FROM student;   -- 最小年龄
```

```
1.约束
	PRIMARY KEY 主键
	FOREIGN KEY 外键（选课系统必用）
	NOT NULL 非空
	UNIQUE 唯一
2.多表查询
	student 学生表
	course 课程表
	sc 选课表（sid 关联学生，cid 关联课程）
```

```mysql
JOIN查询
SELECT *
FROM score                  → 从关系表开始
JOIN student               → 连接学生表
ON student_id = id         → 通过id对应

JOIN course                → 再连接课程表
ON course_id = id          → 再对应

SELECT s.name,c.cname 
FROM student s
JOIN sc ON s.id=sc.sid
JOIN course c ON c.id=sc.cid
WHERE s.id=1;

注意：
1. FROM 决定“从哪里开始查”
2. WHERE 决定“筛选条件”
3. 条件在哪张表 → FROM优先选哪张表
```

## 1.1 join查询

```mysql
INNER JOIN = 只保留“能匹配上的数据” ->有才留
SELECT *
FROM student
JOIN score ON student.id = score.student_id;
1. 拿 student 第一行（张三）
2. 去 score 找 student_id = 1 ✔ 找到
3. 拼成一行
4. 拿 student 第二行（李四）
5. 去 score 找 student_id = 2 ❌ 没有
6. 丢弃

LEFT JOIN = 左表全部保留 + 右表匹配 ->左全留
SELECT *
FROM student-左表
LEFT JOIN score-右表 ON student.id = score.student_id;
1. 张三 → 匹配成功 → 保留
2. 李四 → 没匹配 → 也保留（score为NULL）
```

```mysql
注意：
1.查没有xxx的数据，通常套路：
	from 主表
	left join 关联表
	where 关联表.某字段 is null；
2.判断null，只有 is null/ is not null
3.查“没有关系的数据” → 看 id（外键）是不是 NULL
  查“数据本身为空” → 看字段是不是 NULL
  
没有直接关系的表之间不能直接连接，必须通过中间表或外键建立关联关系，否则会产生错误结果或无意义的数据。
```

## 1.2 子查询

```mysql
子查询：在一个SQL里面，再套一个SQL
SELECT *
FROM student
WHERE id IN (
    SELECT student_id
    FROM score
    WHERE score < 60
);
先查出不及格的学生 id
再去 student 表里找这些学生

IN子查询
SELECT *
FROM 表A
WHERE 字段 IN (			先查B → 再拿结果去A筛选
    SELECT 字段
    FROM 表B
);
多层子查询：student → score → course
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
```

