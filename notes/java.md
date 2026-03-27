# 第一章Java基础
## 1.1.1基本数据类型
### 整数类型：
```java
    //byte:8位
    byte b = 10;
    //short:16位
    short s=10;
    //int:32位
    int i =10;
    //long:64位
    long lon = 10;
```
### 浮点类型：
```java
    //默认情况下：小数点的数据会被识别为精度较高的双精度double类型
    //float:单精度浮点类型,数据需要使用F(f)结尾
    float f = 1.0;//(x)
    float f = 1.0f;
    //double:双精度浮点类型
    double d = 2.0;
```
### 字符类型：
    char c = 'A';
### 布尔类型
    //true,false,标志判断条件是否成立
    boolean bln = true;
### 数据类型转换
```java
    //byte->short->int->long->float->double
    byte b = 10;
    short s = b;
    int i = s;
    double d=f;
    //...范围小的数据可以直接转换为范围大的
    int i = d(x);
    int i = (int)d;//()强制转换
```
## 1.1.2基本数据类型与包装类
    //包装类就是把基本类型的数据包装成对象
         包装类：把基本类型变成对象,才能放进集合（比如 ArrayList）、做 null 判断、调用方法
    | 基本数据类型 | 包装类      | 占用字节 |
    | ----------- | ----------- | -------- | 
    | byte        | Byte        | 1        |
    | short       | Short       | 2        |    基本类型的数据包装成对象方案
    | int         | Integer     | 4        |    public Integer(int value):已过时
    | long        | Long        | 8        |    public static Integer valueOf(int i)
    | float       | Float       | 4        |
    | double      | Double      | 8        |
    | char        | Character   | 2        |
    | boolean     | Boolean     | 1        |
    包装类的其他常见操作  "123"-->123 123-->"123"
        可以把基本数据类型转换为字符串类型。
        public static String toString(double d)
        public String toString()
        可以把字符串类型的数值转换为数值本身对应的数据类型
```java
    public class Test{
        public static void main(String[] args){
            //获取Integer类型的对象
            //public Integer(int value)
            Integer i1 = new Integer(value,100);
            System.out.println(i1);//100
            //public static Integer valueOf(int i)
            Integer i2 = Integer.valueOf(100);
            System.out.println(i2);//100
            //自动装箱：基本数据类型可以自动转换为对应的包装类型
            //Integer i3 = Integer.valueof(100);
            Integer i3 = 100;
            //自动拆箱：包装类型可以自动转换为对应的基本数据类型
            //int num = i3.intValue();
            int num = i3;
            
            //基本类型-->字符串类型
            int num = 100;
            //方式1：数值+"" 原因：字符串参与加法操作，加法起到的是拼接作用，拼接之后是一个新的字符串
            String s1 = num+"";//"100"
            //方式2: Integer类：public static String toString(int i)
            String s2 = Integer.toString(num);//"100"
            //方式3： Integer类：public String toString
            Integer i = num;
            String s3 = i.toString();//"100"
            //方式4：String类：public static String valveOf(int i)
            String s4 = String.valueOf(num);
            
            //字符串类-->基本数据类型
            //注意：字符串中必须是数字字符
            String s = "123";
            //方式1：Integer类：public static int parseInt(String s)
            int i1 = Integer.parseInt(s);
            System.out.println(i1);//123
            //方式2：Integer类：public static Integer valuOf(String s)
            int i2 = Integer.valueOf(s);//自动拆箱
        }
    }
```
## 1.1.3引用数据类型
    //可被引用的数据类型
### 类：
### 接口：
### 数组：
### 枚举：
### 特殊类型值：null
## 1.2流程控制
### 1.2.1 if-else条件判断
### 1.2.2 switch分支语句
```java
    public class SwitchDemo {
        public static void main(String[] args) {
            int num = 2;
                switch (num) {
                case 1:
                    System.out.println("星期一");
                    break;
                case 2:
                    System.out.println("星期二");
                    break;
                case 3:
                    System.out.println("星期三");
                    break;
                default:
                    System.out.println("输入无效");
        }
    }
}
```
### 1.2.3 三元运算符
    关系表达式?表达式1:表达式2；
    true->执行表达式1    false->执行表达式2
### 1.2.4 ==与equals区别
#### 基本类型
    int a=10,b=10;
    System.out.println(a==b)//true
#### 引用类型
    String s1 = new String("abc");
    String s2 = new String("abc");
    System.out.println(s1==s2);//false
    System.out.println(s1.equals(s2));//true
#### 区别
    ==     -> 比地址（是不是同一个对象）
    equals -> 比内容（值是否一样）
    Java有字符串常量池优化：
    String s1 = "abc",s2 = "abc";
    System.out.println(s1==s2);//true
























