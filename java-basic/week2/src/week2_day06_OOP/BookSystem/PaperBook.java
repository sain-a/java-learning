package week2_day06_OOP.BookSystem;

public class PaperBook extends Book implements Readable{
    @Override
    public void type(){
        System.out.println("我是纸质书");
    }
    @Override
    public void read(){
        System.out.println("纸质书能被读");
    }
}
