package week2_day06_OOP.BookSystem;

public class Test {
    public static void main(String[] args) {
        Book b1 = new EBook();
        b1.type();
//        if(b1 instanceof EBook){
//            EBook b = (EBook) b1;
//            b.read();
//        }
        if(b1 instanceof Readable){
            Readable r = (Readable) b1;
            r.read();
        }
        if(b1 instanceof Downloadable){
            Downloadable d = (Downloadable) b1;
            d.download();
        }
        Book b2 = new PaperBook();
        b2.type();
    }
}
