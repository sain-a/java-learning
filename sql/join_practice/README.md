# 第4周 Day2 多表查询（JOIN）练习总结

## 1. 今日学习目标

- 掌握 INNER JOIN 和 LEFT JOIN
- 理解多表之间的连接关系
- 学会通过外键连接表
- 掌握子查询（IN）
- 理解 JOIN 的执行过程

---

## 2. JOIN 基础总结

### 2.1 INNER JOIN

SELECT *
FROM student
JOIN score ON student.id = score.student_id;

含义： 只保留“能够匹配成功”的数据。

### 2.2 LEFT JOIN
SELECT *
FROM student
LEFT JOIN score ON student.id = score.student_id;

含义： 保留左表全部数据，右表匹配不到则为 NULL。

### 2.3 核心区别
类型	说明
INNER JOIN	有匹配才保留
LEFT JOIN	左表全部保留
## 3. 多表关系

本项目中三张表关系：

student ↔ score ↔ course
student.id = score.student_id
course.id = score.course_id

score 表作为中间关系表。

## 4. JOIN 使用规范
### 4.1 必须通过外键连接
-- 正确
student.id = score.student_id

-- 错误
student.id = score.course_id
### 4.2 多表查询必须写表名
SELECT student.name, score.score

避免字段歧义（ambiguous column）。

## 5. 子查询总结
### 5.1 IN 子查询
SELECT name
FROM student
WHERE id IN (
    SELECT student_id FROM score
);

含义： 先查子查询，再用结果筛选外层数据。

### 5.2 多层子查询
SELECT name
FROM student
WHERE id IN (
    SELECT student_id
    FROM score
    WHERE course_id IN (
        SELECT id FROM course WHERE course_name = 'Java'
    )
);
## 6. NULL 判断
错误写法：
WHERE score = NULL
正确写法：
WHERE score IS NULL
WHERE score IS NOT NULL
## 7. 常见查询套路
### 7.1 查没有数据的记录
SELECT student.name
FROM student
LEFT JOIN score ON student.id = score.student_id
WHERE score.student_id IS NULL;
### 7.2 查有数据的记录
SELECT student.name
FROM student
JOIN score ON student.id = score.student_id;
### 7.3 查条件数据
SELECT student.name
FROM student
JOIN score ON student.id = score.student_id
WHERE score.score < 60;
## 8. 今日收获
理解 JOIN 本质是“拼接表”
理解外键的重要性
能独立写多表查询
掌握 NULL 判断
掌握子查询基本用法