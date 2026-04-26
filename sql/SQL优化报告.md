# SQL优化报告（索引 + EXPLAIN + 慢SQL分析）

---

## 一、实验目的

通过实际操作与分析，掌握：

* SQL 为什么会慢
* 索引的作用与使用方法
* 使用 EXPLAIN 分析 SQL 执行计划
* 常见索引失效场景
* 基本 SQL 优化思路

---

## 二、实验环境

* 数据库：MySQL
* 表：student、score
* 工具：DBeaver / DataGrip

---

## 三、核心理论

### 1. SQL 为什么会慢

SQL 性能问题的本质：

```text
扫描的数据太多
```

* 无索引 → 全表扫描（慢）
* 有索引 → 快速定位（快）

---

### 2. 索引（Index）

索引相当于数据库的“目录”：

```text
提高查询效率，减少扫描行数
```

创建索引：

```sql
CREATE INDEX idx_name ON student(name);
```

---

### 3. EXPLAIN（执行计划分析）

用于分析 SQL 的执行方式：

```sql
EXPLAIN SELECT * FROM student WHERE name = '张三';
```

重点字段：

| 字段   | 含义        |
| ---- | --------- |
| type | 查询方式（最重要） |
| key  | 使用的索引     |
| rows | 扫描行数      |

---

### 4. type 性能等级

```text
const > ref > range > index > ALL
```

| type  | 含义       |
| ----- | -------- |
| const | 主键查询     |
| ref   | 普通索引     |
| range | 范围查询     |
| ALL   | 全表扫描（最差） |

---

## 四、实验过程

---

### 实验1：主键查询

```sql
EXPLAIN SELECT * FROM student WHERE id = 1;
```

结果：

```text
type = const
```

结论：

```text
主键自带索引，查询效率最高
```

---

### 实验2：无索引查询

```sql
EXPLAIN SELECT * FROM student WHERE name = '张三';
```

结果：

```text
type = ALL
key  = NULL
```

结论：

```text
未使用索引 → 全表扫描 → 性能较差
```

---

### 实验3：添加索引优化

```sql
CREATE INDEX idx_name ON student(name);
```

再次执行：

```sql
EXPLAIN SELECT * FROM student WHERE name = '张三';
```

结果：

```text
type = ref
key  = idx_name
```

结论：

```text
成功使用索引，查询效率提升
```

---

### 实验4：索引失效（运算）

```sql
EXPLAIN SELECT * FROM student WHERE age + 1 = 21;
```

结果：

```text
type = ALL
key  = NULL
```

结论：

```text
对索引列进行运算 → 索引失效
```

---

### 实验5：LIKE 查询优化

```sql
EXPLAIN SELECT * FROM student WHERE name LIKE '张%';
```

结果：

```text
type = range
key  = idx_name
```

---

```sql
EXPLAIN SELECT * FROM student WHERE name LIKE '%张';
```

结果：

```text
type = ALL
key  = NULL
```

结论：

```text
LIKE 'xxx%' 可以使用索引
LIKE '%xxx' 无法使用索引
```

原因：

```text
索引必须从左侧开始匹配（最左匹配原则）
```

---

### 实验6：联合索引

```sql
CREATE INDEX idx_name_age ON student(name, age);
```

---

查询：

```sql
EXPLAIN SELECT * FROM student WHERE name = '张三' AND age = 20;
```

结论：

```text
联合索引可以同时匹配多个条件
```

---

查询：

```sql
EXPLAIN SELECT * FROM student WHERE age = 20;
```

结果：

```text
type = ALL
```

结论：

```text
跳过最左列 → 索引失效
```

---

### 实验7：覆盖索引

```sql
SELECT name FROM student WHERE name = '张三';
```

结论：

```text
无需回表，查询更快（覆盖索引）
```

---

```sql
SELECT * FROM student WHERE name = '张三';
```

结论：

```text
需要回表，性能略低
```

---

## 五、SQL优化总结

---

### 1. 优化核心原则

```text
减少扫描行数
减少回表次数
```

---

### 2. 常见优化手段

* 为查询条件字段建立索引
* 使用联合索引优化多条件查询
* 使用覆盖索引减少回表
* 避免索引失效写法

---

### 3. 常见索引失效情况

* 对索引列进行运算
* 使用函数
* LIKE 前缀为 %
* 跳过联合索引最左列

---

### 4. 索引设计原则

* 常用于 WHERE 的字段优先建索引
* JOIN 关联字段必须建索引
* 避免冗余索引
* 根据业务设计联合索引

---

## 六、结论

通过本次实验，掌握了：

* 使用 EXPLAIN 分析 SQL 执行计划
* 判断 SQL 是否走索引
* 理解索引失效的原因
* 掌握基本 SQL 优化思路

为后续数据库性能优化与实际项目开发打下基础。

---
