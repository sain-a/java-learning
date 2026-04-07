package week2_day06_OOP.BookSystem;

public class EBook extends Book implements Readable,Downloadable{
    @Override
    public void type(){
        System.out.println("我是电子书");
    }
    @Override
    public void read(){
        System.out.println("电子书能被读");
    }
    @Override
    public void download(){
        System.out.println("下载电子书");
    }
}
