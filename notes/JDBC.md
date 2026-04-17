# 第一章 基础

## 一、引言

### 1.1数据的存储

```
开发Java程序时，数据都是存储在内存中，属于临时存储，当程序停止或启动时，内存中的数据就丢失了，为了解决数据的长期存储问题，有如下解决方案：
	1.数据通过I/O流技术，存储在本地磁盘中，解决了持久化问题，但没有结构和	   逻辑，不方便管理和维护。
	2.通过关系型数据库，将数据按照特定的格式交由数据库管理系统维护。关系型	  数据库是通过库和表分割不同的数据，表中数据存储方式时行和列，区分相同	  格式不同值的数据。
```

### 1.2 数据的操作

```
数据存储在数据库，仅仅解决了我们数据库存储的问题，但当我们程序运行时，需要读取数据，以及对数据做增删改的操作，该如何通过Java程序对数据库中的数据做增删改查呢？
```

##  二、JDBC

### 2.1 JDBC的概念

```
1.JDBC：Java Database Connectivity，意为Java数据库连接。
2.JDBC：是Java提供的一组独立于任何数据库管理系统的API。
3.java提供接口规范，由各个1数据库厂商提供接口的实现，厂商提供的实现类封装   成jar文件，也就是数据库驱动jar包
```

### 2.2 JDBC的核心组成

```
接口规范：
	制定了Java程序连接各种数据库的统一接口规范
	接口存储在java.sql和javax.sql包下
实现规范：
	接口规范的实现交给各个数据库厂商自己实现
	厂商将实现内容和过程封装成jar文件，程序员只需将jar文件引入到项目中集成即可，就可以开发调用
```

## 三、核心API理解

### 3.1 注册驱动

```java
Class.forName("com.mysql.cj.jdbc.Driver");
```

```
1.在Java中，当使用JDBC连接数据库时，需要加载数据库特定的驱动程序，以便与数据库进行通信，加载驱动程序的目的是为了注册驱动程序，使得JDBC API 能够识别并于特定的数据库进行交互。
2.从JDK6开始，不再需要显示调用Class.forName()来加载JDBC驱动程序，只要在类路径中集成了对应的jar文件，会自动在初始化时注册驱动程序
```

### 3.2 Connection

```
1.Connection接口是JDBC API的重要接口，用于建立与数据库的通信通道，换而言之，Connection不为空，则代表一次数据库连接。
2.在建立连接时，需要指定数据库URL、用户名、密码参数。
	URL：jdbc:mysql://localhost:3306/study
		 jdbc:mysql://IP地址:端口号/数据库名称?参数键值对1&参数键值对2
3.Connection接口还负责管理事务，Connection接口提供了commit和rollback方法，用于提交事务和回滚事务。
4.可以创建Statement对象，用于执行SQL语句并于数据库交互。
5.在使用JDBC技术时，必须要先获取Connection对象，在使用完毕后，要释放资源，避免占用浪费及泄露。
```

### 3.3 Statement

```
1.Statement接口用于执行SQL语句并于数据库进行交互，它是JDBC API中的一个重要接口。通过Statement的对象，可以向数据库发送SQL语句并获取执行结果
2.结果可以是一个或多个结果
	增删改：受影响行数单个结果。
	查询：单行单列、多行多列、单行多列等结果。
3.但是Statement接口在执行SQL语句时，会产生SQL注入攻击问题：
	当使用Statement执行动态构建的SQL查询时，往往需要将查询条件与SQL语句拼接在一起，直接将参数和SQL语句一并生成，让SQL的查询条件始终为true得到结果。
```

```
动态输入：
 System.out.println("请输入学生姓名：");
 Scanner sc = new Scanner(System.in);
 String sname = sc.nextLine();

String sql = "SELECT * FROM student WHERE name = '"+sname+"'";
正常情况：SELECT * FROM student WHERE name = '张三'
SQL注入：输入：' OR '1'='1
		结果：SELECT * FROM student WHERE name = '' OR '1'='1'
		绕过验证，查询所有数据
```

### 3.4 PreparedStatement

```
1.PreparedStatement是Statement接口的子接口，用于执行 预编译 的SQL查询
	作用：
	预编译SQL语句:在创建PreparedStatement时，就会预编译SQL语句，也就是SQL语句以及固定。
	防止SQL注入：PreparedStatement 支持参数化查询，将数据作为参数传递到SQL语句中，采用?占位符的方式，将传入的参数用一堆单引号包裹起来''，无论传递什么都作为值。有效防止传入关键字或值导致SQL注入问题。
	性能提升：PreparedStatement是预编译SQL语句，同一SQL语句多次执行的情况下，可以复用，不必每次重新编译和解析
2.都是基于PreparedStatement进行实现，更安全、效率更高。
```

### 3.5 ResultSet

```
1.ResultSet是JDBC API 中的一个接口，用于表示从数据库中 执行查询语句所返回的结果集，它提供了一种用于遍历和访问查询结果的方式。
2.遍历结果：ResultSet可以使用next()方法将游标移动到结果集的下一行，逐行遍历数据库查询的结果，返回值为boolean类型，true代表有下一行结果，false代表没有。
3.获取单列结果：可以通过getXxx的方法获取单列的数据，该方法为重载方法，支持索引和列名获取。
```

## 四、基于PreparedStatement实现CRUD

```

```

