JDBC

```mysql
1.什么是JDBC？
	Java操作数据库的一套工具
	JDBC = 让Java能执行SQL
	
	JDBC 是 Java 提供的一套操作数据库的接口规范，不同数据库通过驱动实现	   这个规范，Java程序通过 JDBC 来连接数据库并执行SQL。
2.JDBC在干什么？
	a.连接数据库
	b.执行sql		mysql-connector-j👉 是 MySQL 官方写的：让 Java 					能连接 MySQL 的工具
	c.获取结果		<dependency> Maven帮我下载这个jar包
	d.关闭资源		Maven下载依赖的地方pom.xml
3.什么是jar包？
	JAR包 = 别人写好的代码(工具包)
```

```
Maven：负责下载依赖（比如MySQL驱动）

JDBC：是Java提供的一套规范，用来操作数据库

驱动（mysql-connector-j）：是真正实现JDBC、负责连接MySQL的工具

完整流程：
Maven 下载驱动
      ↓
驱动实现 JDBC
      ↓
Java通过 JDBC 使用驱动
      ↓
连接数据库
```

Maven

```mysql
1.Maven是什么？
	Maven = 帮你管理"依赖(jar包)"的工具
	你			Maven
	想用功能	  想用库
	搜 App	    写 dependency
	点下载   	   自动下载
	自动安装	  自动导入

2.为什么需要Maven？
	没有 Maven 时，如果你要用 MySQL：
		去网上找 jar 包
		下载
		手动导入 IDEA
		还要处理版本问题
	有Maven 后，你只要写：
		<dependency>
    		<groupId>com.mysql</groupId>
    		<artifactId>mysql-connector-j</artifactId>
    		<version>8.0.33</version>
		</dependency>
	Maven 自动帮你：
		下载jar包
		放到本地仓库
		加到项目里
		解决依赖关系
3.什么是依赖？
	写的mysql-connector-j就叫：依赖（dependency）
	意思是：我的项目"依赖"这个库才能运行
4.Maven的3个核心概念
	① pom.xml：项目说明书
		它里面写：
			项目名字
			版本
			依赖（最重要）
	② dependency（依赖）
		就是：你要用的库
		比如：MySQL驱动，Spring，MyBatis
	③ 仓库（Repository）
		存 jar 包的地方
		类型		  含义
		本地仓库	你电脑
		远程仓库	Maven中央仓库
		镜像仓库	阿里云

```

