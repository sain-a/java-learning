# Maven多模块学生管理系统总结.md

---

## 一、项目目标

将原本的单体学生管理系统，改造为：

```text
多模块 + 分层架构 + Maven管理依赖
```

实现：

* JDBC + HikariCP 连接池
* DAO + Service 分层
* Maven 父子模块结构

---

## 二、项目结构

```text
student-system-parent
├── pom.xml（父项目）
├── student-pojo
│   └── Student.java
├── student-dao
│   ├── JDBCUtils.java
│   ├── StudentDao.java
│   ├── StudentDaoImpl.java
│   └── hikari.properties
├── student-service
│   ├── StudentService.java
│   └── StudentServiceImpl.java
└── student-app
    └── StudentSystemApp.java
```

---

## 三、模块职责划分

### 1. student-pojo

```text
实体层（数据模型）
```

* 存放实体类：Student
* 不依赖其他模块

---

### 2. student-dao

```text
数据访问层（DAO）
```

负责：

* JDBC操作
* 数据库连接（HikariCP）
* SQL执行

包含：

* JDBCUtils（连接池工具类）
* StudentDao（接口）
* StudentDaoImpl（实现类）
* hikari.properties（配置文件）

---

### 3. student-service

```text
业务逻辑层（Service）
```

负责：

* 业务处理
* 调用 DAO 层

包含：

* StudentService
* StudentServiceImpl

---

### 4. student-app

```text
应用层（入口）
```

负责：

* 控制台交互
* 调用 Service 层

包含：

* StudentSystemApp（main方法）

---

## 四、模块依赖关系

```text
student-app
   ↓
student-service
   ↓
student-dao
   ↓
student-pojo
```

说明：

* app 只依赖 service
* service 依赖 dao 和 pojo
* dao 依赖 pojo
* pojo 无依赖

---

## 五、父项目作用

父项目（student-system-parent）：

```text
不写代码，只做管理
```

主要功能：

### 1. 管理模块

```xml
<modules>
    <module>student-pojo</module>
    <module>student-dao</module>
    <module>student-service</module>
    <module>student-app</module>
</modules>
```

---

### 2. 统一管理依赖版本

```xml
<dependencyManagement>
    <dependencies>

        <!-- MySQL驱动 -->
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <version>8.0.33</version>
        </dependency>

        <!-- 连接池 -->
        <dependency>
            <groupId>com.zaxxer</groupId>
            <artifactId>HikariCP</artifactId>
            <version>5.0.1</version>
        </dependency>

    </dependencies>
</dependencyManagement>
```

---

## 六、子模块使用依赖

子模块中写：

```xml
<dependencies>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
    </dependency>

    <dependency>
        <groupId>com.zaxxer</groupId>
        <artifactId>HikariCP</artifactId>
    </dependency>
</dependencies>
```

特点：

```text
✔ 不需要写 version
✔ 由父项目统一控制
```

---

## 七、配置文件问题（重点坑🔥）

问题：

```text
hikari.properties 读取失败（InputStream = null）
```

原因：

```text
资源文件不在当前运行模块的 classpath
```

---

### 解决方案

将配置文件放到：

```text
student-app/src/main/resources
```

或者确保：

```text
student-dao 被正确作为依赖加载
```

---

## 八、关键知识点总结

---

### 1. 父项目 vs 子模块

| 类型  | 作用      |
| --- | ------- |
| 父项目 | 管版本、管模块 |
| 子模块 | 写代码     |

---

### 2. dependency vs dependencyManagement

| 标签                   | 作用   |
| -------------------- | ---- |
| dependencies         | 引入依赖 |
| dependencyManagement | 管理版本 |

---

### 3. 多模块优势

```text
✔ 分层清晰
✔ 依赖统一管理
✔ 方便扩展
✔ 接近真实企业项目结构
```

---

### 4. 项目架构思想

```text
Controller（app）
↓
Service
↓
DAO
↓
Database
```

---

## 九、常见问题总结

---

### ❌ 问题1：依赖报错

原因：

```text
子模块没有写 dependency
或没有继承父项目
```

---

### ❌ 问题2：资源文件找不到

原因：

```text
resources 没进入运行模块
```

---

### ❌ 问题3：父项目有 src

```text
错误！父项目不应该写代码
```

---

## 十、总结

本项目完成了从：

```text
单体项目
→ Maven项目
→ 多模块项目
→ 分层架构
```

的完整升级。

掌握了：

```text
✔ Maven父子模块结构
✔ 依赖管理
✔ JDBC + 连接池
✔ 分层设计
```

---

## 十一、下一步方向

```text
1. 使用 MyBatis 替代 JDBC
2. 使用 SpringBoot 管理项目
3. 扩展多表业务（课程、成绩）
```

---
