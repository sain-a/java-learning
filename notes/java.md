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
### 1.3 循环结构
#### 1.3.1 for循环
#### 1.3.2 while循环
#### 1.3.3 break/continue
    break 直接结束循环；
    continue 跳过本次；
### 1.4 数组与方法
#### 1.4.1 一维数组、二维数组定义与使用
    数组一旦创建长度不可修改
##### 一维数组
    // 格式1：声明+初始化（推荐，简洁）
    int[] arr1 = {1, 2, 3, 4, 5};
    // 格式2：声明数组，指定长度，后续赋值（默认初始化：int为0，String为null）
    int[] arr2 = new int[5]; // 长度为5，元素默认是0
    // 格式3：声明与初始化分开（不推荐，冗余）
    int[] arr3;
    arr3 = new int[]{10, 20, 30};
##### 二维数组
    // 格式1：声明+初始化（推荐，不规则数组也适用）
    int[][] arr1 = {{1,2}, {3,4,5}, {6}};

    // 格式2：指定行数和列数，后续赋值（默认初始化）
    int[][] arr2 = new int[3][2]; // 3行2列，所有元素默认0
    arr2[0][0] = 1; // 给第1行第1列赋值
    arr2[1][1] = 2;

    // 格式3：先指定行数，列数后续确定（不规则数组）
    int[][] arr3 = new int[3][];
    arr3[0] = new int[2]; // 第1行2列
    arr3[1] = new int[3]; // 第2行3列
#### 1.4.2 方法定义、参数、返回值
        修饰符 返回值类型 方法名(参数列表) {
            // 方法体：要执行的代码
            return 返回值; // 有返回值时必须写，无返回值可省略
        }
#### 1.4.3 参数传递：值传递理解
```java
    public class Test {
        public static void main(String[] args) {
            int a = 10;
            change(a);
            System.out.println(a); // ?
            int[] arr = {1, 2, 3};
            changeArr(arr);
            System.out.println(arr[0]); // ?
        }
        public static void change(int x) {
            x = 100;
        }
        public static void changeArr(int[] arr) {
            arr[0] = 999;
        }
    }
```
    a=10,arr[0]=999
##### 基本类型
        main:
        a=10
        调用 change(a)    change:     x = a 的拷贝 = 10
                                      x = 100(只改副本)
        main里的a：不变
##### 数组
         main:
         arr->指向[1,2,3]
         调用 changeArr(arr)  changeArr:   arr = 地址的拷贝（指向同一个数组）
                                           arr[0] = 999->改的是同一块内存
# 第二章 面向对象
## 2.1 类与对象、封装
### 2.1.1 类与对象的定义
```java
public class Main {
    public static void main(String[] args) {
        //类：结构体，里面包含了属性（特征）和方法（行为） 会有很多对象
        //TODO class(类)
        /*
        类的语法基本结构
        class ：关键字（全是小写）
        类名：类的名称，标识符，遵循规则，类首字母大写
        class 类名{
            特征（属性），
            功能（方法）
        }
        
        //对象：类的实例化（具象化）
        创建对象的语法：
        new ： 关键字，表示创建一个具体的对象
        变量的类型就是对象的类型
        对象是将内存地址赋值给了变量，使用变量其实引用了内存中的对象，所以称之为引用变量
        而变量的类型称之为引用数据类型
        new 类名（）；
        
        //特殊对象：空对象（null）,没有引用的对象，称之为空对象，关键字对象
        //所有引用类型变量的默认值就是null
        */
        //问题：做一道菜，红烧排骨
        //类：菜， 对象：红烧排骨
        //TODO 1. 先声明类
        //TODO 2. 创建对象
        //TODO 3. 声明属性，所谓的属性就是类中的变量
        //        变量类型  变量名称 = 变量值
        //        属性类型  属性名称 = 属性值
        //TODO 4. 声明方法
        //        void 方法名（参数）{功能代码}
        //TODO 5. 执行方法
        //        对象.属性
        //        对象.方法名（）
        
        //引用数据类型
        Cooking c = new Cooking();
        c.name = "红烧排骨";
        c.food = "排骨";
        c.execute();//？烹饪排骨
    }
}
class Cooking{
    //特征（属性）
    //名字
    String name;
    //菜的类型
    String type = "红烧";
    //食材
    String food;
    //佐料
    String relish = "大料";
    
    //TODO 执行
    void execute(){
        System.out.println("烹饪"+food);
    }
}
```
    
### 2.1.2 成员变量、成员方法
#### 成员变量
        成员变量就是属性
        属性类型 属性名称 = 属性值
        如果在声明属性的同时初始化赋值，那么所有对象的属性就完全相同
        //默认初始化
        //byete,short,int,long=>0
        //float,double=>0.0
        //boolean flg = false
        //char = 空字符
        //引用数据类型 => null

        //变量的作用域非常小，只在当前大括号内有效
        //属性不仅在当前类有效，而且可以随着对象在其他地方使用
        //变量使用前必须初始化，属性不用，JVM会帮助我们自动完成初始化
#### 成员方法
        //方法调用方式：对象.方法名（）
###### 方法参数
            参数个数，类型，顺序需相匹配
            当参数个数不相同，但类型相同时，可采用持续的参数语法声明：可变参数
                void test(String...name){}
                如果可变参数中还含有其他参数，要把可变参数放在最后
                    void test(int age,String...name)
##### 方法参数-传值方式
```java
//java中方法参数传递为值传递
//基本数据类型：数值
//引用数据类型：引用地址
//1
public class Main{
    public static void main(String[] args){
        int i = 10;
        test(i);
        System.out.println(i);//10
    }
    public  static void test(int i){
        i = i + 10;
    }
}
//2
public class Main{
    public static void main(String[] args){
        String s = "abc";
        test(s);
        System.out.println(s);//abc
    }
    public  static void test(String s){
        s = s + 10;
    }
}
//3
public class Main{
    public static void main(String[] args){
        User user = new User();
        user.name = "zhangsan";
        System.out.println(user.name);//
    }
    public  static void test(User user){
        user.name="lisi";
    }
}
class User{
    String name;
}
```
### 2.1.3 封装： private + get/set
#### 封装的定义
        把成员变量私有化，外面不能随便看、改，若想访问必须通过提供的公开方法
#### 为什么要封装
        保护数据，控制读写权限，代码更安全
#### 怎么做封装
        1.成员变量用private修饰
        2.提供public的getXxx()方法：用来获取值
        3.提供public的setXxx()方法：用来设置值
        //构造方法
            如果不写构造方法，Java会默认提供一个无参构造
            一旦写了构造方法，默认无参构造就不会再提供
            对象属性有默认值，但通常需要手动赋值  
            调用构造方法时，必须匹配参数列表 
            一般建议：无参 + 有参构造都写
    
























