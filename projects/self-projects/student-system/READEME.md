# 学生管理系统（JDBC + 连接池）

## 一、项目简介

本项目是一个基于 **Java + JDBC + HikariCP连接池** 实现的控制台学生管理系统，实现了对学生信息的基础管理功能，包括增删改查（CRUD）。

通过本项目，完整实践了 JDBC 编程、连接池使用、分层设计（DAO + Service）以及基础的ORM思想。

---

## 二、技术栈

* Java
* JDBC
* MySQL
* HikariCP（连接池）
* DBeaver（数据库工具）

---

## 三、项目结构

```text
src/main/java
├── app                 // 控制台入口（用户交互）
├── service             // 业务逻辑层
│   └── impl
├── dao                 // 数据访问层接口
│   └── impl
├── pojo                // 实体类（Student）
└── util                // 工具类（JDBCUtils）
```

---

## 四、分层说明

### 1. App层（控制台层）

* 负责与用户交互
* 接收输入、输出结果
* 不处理业务逻辑、不直接操作数据库

### 2. Service层（业务层）

* 负责业务逻辑处理
* 参数校验（如姓名不能为空、年龄合法性）
* 调用DAO层完成数据库操作

### 3. DAO层（数据访问层）

* 负责数据库的增删改查
* 使用 PreparedStatement 执行SQL
* 不包含业务判断

### 4. Util层（工具类）

* 封装连接池
* 提供获取数据库连接的方法

---

## 五、数据库设计

### 表：student

| 字段   | 类型      | 说明    |
| ---- | ------- | ----- |
| id   | int     | 主键，自增 |
| name | varchar | 学生姓名  |
| age  | int     | 学生年龄  |

---

## 六、功能说明

系统支持以下功能：

1. 查询所有学生
2. 根据ID查询学生
3. 新增学生
4. 修改学生信息
5. 删除学生

---

## 七、核心技术点

### 1. PreparedStatement

* 使用占位符 `?`
* 防止SQL注入
* 提高执行效率（预编译）

---

### 2. 连接池（HikariCP）

通过连接池优化数据库连接：

```text
传统方式：每次创建/销毁连接（开销大）
连接池：复用连接（性能更高）
```

使用方式：

```java
Connection connection = dataSource.getConnection();
```

---

### 3. try-with-resources

自动关闭资源：

```java
try (
    Connection conn = ...
    PreparedStatement ps = ...
    ResultSet rs = ...
) {
    // 使用资源
}
```

避免资源泄漏问题。

---

### 4. ORM思想（基础）

将数据库数据映射为 Java 对象：

```text
数据库 → ResultSet → Student对象
```

---

## 八、项目亮点

* 使用 **连接池提升性能**
* 使用 **PreparedStatement 防止SQL注入**
* 使用 **try-with-resources 自动释放资源**
* 实现 **DAO + Service 分层结构**
* 完整实现 **CRUD业务流程**

---

## 九、运行步骤

1. 创建数据库 `study_sql`
2. 创建表 `student`
3. 修改 `hikari.properties` 中数据库配置
4. 运行 `StudentSystemApp` 主类

---

## 十、后续优化方向

* 增加课程（course）表
* 增加成绩（score）表
* 实现多表查询（JOIN）
* 增加 Service 层事务控制
* 升级为 Spring Boot 项目
* 接入 MyBatis / JPA

---

## 十一、总结

本项目是一个完整的 JDBC 入门实践，通过从零实现学生管理系统，掌握了：

* JDBC开发流程
* 连接池原理与使用
* 分层设计思想
* 基础后端开发能力

为后续学习 Spring Boot、MyBatis 等框架打下了坚实基础。
