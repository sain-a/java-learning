# 第4周 Day3 JDBC入门 & SQL注入总结

## 1. 今日学习目标

- 学习 JDBC 基础
- 掌握 Connection、Statement 的使用
- 使用 Java 执行 SQL 查询
- 理解 SQL 注入原理
- 学习防止 SQL 注入的方法（PreparedStatement）

---

## 2. 什么是 JDBC

JDBC（Java Database Connectivity）是 Java 提供的一套操作数据库的接口规范。

通过 JDBC，Java 程序可以：

- 连接数据库
- 执行 SQL 语句
- 获取查询结果

---

## 3. JDBC 核心对象

### 3.1 Connection

    作用：建立 Java 和数据库之间的连接

    Connection conn = DriverManager.getConnection(url, user, password);

    理解：相当于“登录数据库”

### 3.2 Statement

    作用：执行 SQL 语句

    Statement stmt = conn.createStatement();

    理解：相当于“输入 SQL 命令的工具”

### 3.3 ResultSet

    作用：保存查询结果

    ResultSet rs = stmt.executeQuery("SELECT * FROM student");

    理解：相当于“查询结果表”

## 4. JDBC 执行流程
### 1. 建立连接（Connection）
### 2. 创建执行对象（Statement）
### 3. 执行SQL（executeQuery / executeUpdate）
### 4. 处理结果（ResultSet）
### 5. 关闭资源
## 5.基本查询示例
    Connection conn = DriverManager.getConnection(url, user, password);
    Statement stmt = conn.createStatement();

    ResultSet rs = stmt.executeQuery("SELECT * FROM student");

    while (rs.next()) {
        System.out.println(rs.getString("name"));
    }

    rs.close();
    stmt.close();
    conn.close();
## 6. SQL注入原理
### 6.1 什么是 SQL 注入

    SQL 注入是指攻击者通过输入特殊字符串，使程序拼接出恶意 SQL，从而改变原有逻辑。

### 6.2 漏洞代码示例
    String name = "' OR '1'='1";
    String sql = "SELECT * FROM student WHERE name = '" + name + "'";
### 6.3 实际执行SQL
    SELECT * FROM student WHERE name = '' OR '1'='1'
### 6.4 攻击结果
    返回所有数据（绕过验证）
##  7. SQL注入攻击思路
### 1. 找到用户输入点（登录框、搜索框）
### 2. 构造SQL片段（如 ' OR '1'='1）
### 3. 拼接进SQL语句
### 4. 改变SQL逻辑