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

### 4.1查询单行单列

```java
@Test
    public void testQuerySingleRowAndCol() throws SQLException {
        //1.注册驱动（可省略）
        //2.获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///study_sql", "root", "123456");

        //3.预编译sql语句，得到PreparedStatement对象
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) as count FROM student");

        //4.执行sql语句，获取结果
        ResultSet resultSet = preparedStatement.executeQuery();

        //5.处理结果
        while(resultSet.next()){
            int count = resultSet.getInt("count");
            System.out.println(count);
        }
        //6.释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
```

### 4.2 查询单行多列

```Java
  @Test
    public void testQuerySingleRow() throws SQLException {
        //1.注册驱动

        //2.获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///study_sql", "root", "123456");

        //3.预编译sql语句，获得PreparedStatement的对象
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student where id = ?");

        //4.为占位符赋值，执行，并接收结果
        preparedStatement.setInt(1,1);
        ResultSet resultSet = preparedStatement.executeQuery();

        //5.处理结果
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println(id+"\t"+name+"\t"+age);
        }

        //6.资源释放
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
```

### 4.3 查询多行多列

```java
@Test
    public void testQueryMoreRow() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql:///study_sql", "root", "123456");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student WHERE age > ?");
        //为占位符赋值，执行sql语句，接收结果
        preparedStatement.setInt(1, 5);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println(id+"\t"+name+"\t"+age);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
```

### 4.4 新增

```java
  @Test
    public void testInsert() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql:///study_sql", "root", "123456");

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student(name,age) VALUES(?,?)");

        preparedStatement.setString(1,"狗蛋");
        preparedStatement.setInt(2,29);

        int result = preparedStatement.executeUpdate();

        //根据受影响行数，做判断，得到成功或失败
        if(result>0){
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }
        preparedStatement.close();
        connection.close();
    }
```

### 4.5 修改

```java
@Test
    public void testUpdate() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql:///study_sql", "root", "123456");

        PreparedStatement preparedStatement = connection.prepareStatement("update student set age = ? where id = ?");

        preparedStatement.setInt(1,18);
        preparedStatement.setInt(2,1);

        int result = preparedStatement.executeUpdate();

        if(result>0){
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }
        preparedStatement.close();
        connection.close();
    }
```

### 4.6 删除

```java
@Test
    public void testDelete() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql:///study_sql","root","123456");

        PreparedStatement preparedStatement = connection.prepareStatement("delete from student where id =  ?");

        preparedStatement.setInt(1,4);

        int result = preparedStatement.executeUpdate();

        if(result > 0){
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }

        preparedStatement.close();
        connection.close();
    }
```

## 五、常见问题

### 5.1 资源管理

```
在使用JDBC的相关资源时，比如Connection、PrepareStatement、Result,使用完毕后，要及时关闭这些资源以释放数据库服务器资源和避免内存泄漏是很重要的。
```

### 5.2 SQL语句问题

```
java.SQLSyntaxErroException:SQL语句异常，一般有几种可能：
	1.SQL语句错误，建议SQL语句在SQL工具中测试后再复制到Java程序中
	2.连接数据库的UPL中，数据库名称编写错误
```

### 5.3 SQL语句未设置参数问题

```
java.SQLException:NO value specified for parameter 1
在使用预编译SQL语句时，如果有?占位符，要为每一个占位符赋值，否则报该错误
```

### 5.4 用户名或密码错误问题

```
连接数据库时，如果用户名或密码输入错误，也会报SQLException，容易混淆，但异常后面会有具体的原因描述	Access denied for user'root'@'localhhost'(using password: YES)
```

### 5.5 通信异常

```
在连接数据库的URL中，如果IP或端口写错了，会报如下异常
```

![image-20260417223957753](C:\Users\XYY19\AppData\Roaming\Typora\typora-user-images\image-20260417223957753.png)

# 第二章 进阶篇

## 六、JDBC扩展

### 6.1 实体类和ORM

```
1.在使用JDBC操作数据库时，我们会发现数据都是零散的，明明在数据库中是一行完整的数据，到了Java中变成了一个一个的变量，不利于维护和管理。而我们Java是面向对象的，一个表对应的是一个类，一行数据就对应的是Java中的一个对象，一个列对应的是对象的属性，所以我们要把数据存储在一个载体里，这个载体就是实体类。
2.ORM(Object Relational Mapping)思想，对象到关系数据库的映射，作用是在编程中，以面向对象的角度操作数据库中的数据，即一张表对应一个类，一行数据对应一个对象，一个列对应一个属性。
3.当下JDBC中这种过程我们称其为手动ORM，后续会学习ORM框架，比如MyBatis等
```

```
package com.study.advanced.pojo;

//类名就是数据库表的t_后面的单词全写
public class Student {
    private Integer studentId;
    private String studentName;
    private Integer studentAge;
	//省略get、set、无参、有参、toString方法
}
```

#### 封装

```java
单个封装：
    Student student = null;
	if(resultSet.next()){
            student = new Student();
            //为对象属性赋值
            student.setStudentId(resultSet.getInt("id"));
            student.setStudentName(resultSet.getString("name"));
            student.setStudentAge(resultSet.getInt("age"));
    }
```

```
封装集合：
	Student student = null;

    List<Student> studentList = new ArrayList<>();
        while(resultSet.next()){
 	       student = new Student();
 	       int id = resultSet.getInt("id");
 	       String name = resultSet.getString("name");
 	       int age = resultSet.getInt("age");

 	       student.setStudentId(id);
 	       student.setStudentName(name);
 	       student.setStudentAge(age);
 	       //将每次循环封装的一行的对象存储在集合里
 	       studentList.add(student);
 	  }
        studentList.forEach(student1 ->  System.out.println(student1));
```



### 6.2主键回显

```
1.在数据中，执行新增操作时，主键列为自动增长，可在表中直观看到，但在Java程序中，我们执行玩新增后，只能得到受影响行数，无法得知当前新增数据的主键值。在Java程序中获取数据库中插入新数据后的主键值，并赋值给Java对象，此操作为主键回显。
```

```java
@Test
    public  void testReturnPK() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql:///study_sql", "root", "123456");

        //预编译SQL语句,告知prepareStatement，返回新增数据的主键列值
        String sql = "INSERT INTO student(name,age) VALUES(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        //创建对象，将对象的属性值，天冲在?占位符上（ORM）
        Student student = new Student(null,"孙策",28);
        preparedStatement.setString(1,student.getStudentName());
        preparedStatement.setInt(2,student.getStudentAge());

        int result = preparedStatement.executeUpdate();
        ResultSet resultSet = null;
        if(result>0){
            System.out.println("成功");

            //获取当前新增数据的主键列，回显到Java中Student对象的studentId属性上
            //返回的主键值是一个单行单列的结果存储在ResultSet里
            resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()){
                int studentId = resultSet.getInt(1);
                student.setStudentId(studentId);
            }

            System.out.println(student);
        }else{
            System.out.println("失败");
        }

        if(resultSet!=null){
            resultSet.close();
        }
        preparedStatement.close();
        connection.close();
    }
```

### 6.3  批量操作

```
1.插入多条数据时，一条一条发送给数据库执行，效率低下。
2.通过批量操作，可提升多次操作效果
```

```java
 @Test
    public void testBatch() throws SQLException {
         //1.注册驱动
//     Class.forName("com.mysql.cj.jdbc.Driver");
         //2.获取连接
         Connection connection = DriverManager.getConnection("jdbc:mysql:///study_sql?rewriteBatchedStatements=ture", "root", "123456");

         //3.编写SQL语句
        /*
        TODO 注意：1.必须在连接数据库的URL后面追加?rewriteBatchedStatements=ture
                  2.新增SQL必须用VALUES，且语句最后不要追加;结束
                  3.调用addBatch方法，将SQL语句进行批量添加的操作
                  4.统一执行批量操作，调用executeBatch()
         */
         String sql = "INSERT INTO student(name,age) VALUES(?,?)";

         //4.创建预编译prepareStatement，传入SQL语句
         PreparedStatement preparedStatement = connection.prepareStatement(sql);

         //获取当前代码执行的时间毫秒值
         long start = System.currentTimeMillis();

         for (int i = 0; i < 10000; i++) {
             //5.为占位符赋值
             preparedStatement.setString(1, "张飞"+i);
             preparedStatement.setInt(2,24+i);
             preparedStatement.addBatch();
         }
         //执行批量操作
        preparedStatement.executeBatch();

         long end = System.currentTimeMillis();
         System.out.println("消耗时间："+(end-start));

         preparedStatement.close();
         connection.close();
     }
```

## 七、连接池

### 7.1 现有问题

```
1.每次操作数据库都要获取新连接，使用完毕后都要close释放，频繁的创建和销毁造成资源浪费。
2.连接的数量无法把控，对服务器来说压力巨大。
```

### 7.2 连接池

```
1.连接池就是数据库连接对象的缓冲区，通过陪吃，由连接池负责创建连接、管理连接、释放连接等操作。
2.预先创建数据库连接放入连接池，用户在请求时，通过池直接获取连接，使用完毕后，将连接放回池中，避免了频繁的创建和销毁，同时解决了创建的效率。
3.当池中无连接可用，且未达到上限时，连接池会新建连接。
4.池中连接达到上限，用户请求会等待，可以设置超时时间。
```

### 7.3 常见连接池

```
JDBC的数据库连接池使用javax.sql.DataSource接口进行规范，所有第三方连接池都是先此接口，自行添加具体实现！也就是说，所有连接池获取连接的和回收接连方法都一样，不同的只有性能和扩展功能！
	a.DBCP是Apache提供的数据库连接池，速度相对C3P0较快，但自身存在一些BUG
	b.C3P0是一个开源组织提供的一个数据库连接池，速度相对较慢，稳定性还可以
	c.Proxool是sourceforge下的一个开源项目数据库连接池，有监控链接池状态功能，稳定性较C3P0差一点
	d.Druid是阿里提供的数据库连接池，是集DBCP、C3P0、Prooxool优点于一身的数据库连接池，性能、扩展性、易用性都更好，功能更丰富
	e.Hikari是SpringBoot2.x之后内置的一款连接池，基于BoneCP(已经放弃维护)做了不少改进和优化，口号是快速、简单、可靠
```

### 7.4 Druid连接池使用

​	使用步骤：

​		引入jar包

​		编码

#### 硬编码方式(了解)

```
@Test
    public void testHardCodeDruid() throws Exception {
        /*
            硬编码：将连接池的配置信息和Java代码耦合在一起
            1.创建DruidDataSource连接池对象
            2.设置连接池的配置信息【必须|非必须】
            3.通过连接池获取连接对象
            4.回收连接【不是释放连接，而是将连接归还给连接池，给其他线程进行复用】
         */
        //1.创建DruidDataSource连接池对象
        DruidDataSource druidDataSource = new DruidDataSource();

        //2.设置连接池的配置信息【必须|非必须】
        //2.1 必须设置的配置
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql:///study_sql");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("123456");

        //2.2 非必须设置的配置
        druidDataSource.setInitialSize(10);
        druidDataSource.setMaxActive(20);

        //3.通过连接池获取对象
        DruidPooledConnection connection = druidDataSource.getConnection();
        System.out.println(connection);

        //基于连接池进行CRUD

        //4.回收连接
        connection.close();

    }
```

#### 软编码方式(推荐)

​	在项目目录下创建resource文件夹，标识该文件夹为资源目录，创建db.properties配置文件，将连接信息定义在该文件中

```java
# durid连接池需要的配置参数，key固定命名
driverClassName = com.mysql.cj.jdbc.Driver
userName = root
passWord = 123456
url = jdbc:mysql:///study_sql
```

```
@Test
    public void tesTResourcesDruid() throws Exception {
        //1.创建Properties集合，用于存储外部配置文件的key和value值
        Properties properties = new Properties();

        //2.读取外部配置文件，获取输入流，加载到Properties集合里
        InputStream inputStream = DruidTest.class.getClassLoader().getResourceAsStream("db.properties");
        properties.load(inputStream);

        //3.基于Properties集合构造DriverDataSource连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        //4.通过连接池获取连接对象
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        //5.开发CRUD

        //6.回收连接
        connection.close();
    }
```



### 7.5 Druid其他配置

### 7.6 HikariCP连接池使用

#### 硬编码方式

```
@Test
    public void testHardCodeHikari() throws SQLException {
        /*
            硬编码：将连接池的配置信息和Java代码耦合在一起
            1.创建HikariDataSource连接池对象
            2.设置连接池的配置信息【必须|非必须】
            3.通过连接池获取连接对象
            4.回收连接【不是释放连接，而是将连接归还给连接池，给其他线程进行复用】
         */

        //1.创建HikariDataSource连接池对象
        HikariDataSource hikariDataSource = new HikariDataSource();

        //2.设置连接池的配置信息【必须|非必须】
        //2.1必须
        hikariDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariDataSource.setJdbcUrl("jdbc:mysql:///study_sql");
        hikariDataSource.setUsername("root");
        hikariDataSource.setPassword("123456");

        //2.2非必须
        hikariDataSource.setMinimumIdle(10);
        hikariDataSource.setMaximumPoolSize(20);

        //3.通过连接池获取连接对象
        Connection connection = hikariDataSource.getConnection();
        System.out.println(connection);

        //4.回收连接
        connection.close();
    }
```

#### 软编码方式

​	在项目目录下创建resource文件夹，标识该文件夹为资源目录，创建hikari.properties配置文件，将连接信息定义在该文件中

```
driverClassName=com.mysql.cj.jdbc.Driver
jdbcUrl=jdbc:mysql:///study_sql
username=root
password=123456
minimumIdle=10
maximumPoolSize=20
```

```
@Test
    public void testResourcesHikari() throws Exception {
        //1.创建Properties集合，用于存储外部配置文件的key和value值
        Properties properties = new Properties();

        //2.读取外部配置文件，获取输入流，加载到Properties集合里
        InputStream inputStream = HikariTest.class.getClassLoader().getResourceAsStream("hikari.properties");
        properties.load(inputStream);

        //3.创建HikariConfig连接池配置对象，将Properties集合传进去
        HikariConfig hikariConfig = new HikariConfig(properties);

        //4.基于HikariConfig连接池配置对象，构建HikariDataSource
        HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);

        //5.获取连接
        Connection connection = hikariDataSource.getConnection();
        System.out.println(connection);

        //6.回收连接
        connection.close();
    }
    
```



### 7.7 HikariCP其他配置

























































