package week2_day03_abstract;

public class ShapeSystem {
    public static void main(String[] args){
        Shape s1 =new Circle(2);
        System.out.println(s1.area()) ;
        Shape s2 = new Rectangle(2,2);
        System.out.println(s2.area()) ;
    }
}
abstract class Shape {
    public abstract double area();
}
class Circle extends Shape{
    private double radius;
    public Circle(double radius){
        this.radius=radius;
    }
    @Override
    public double area() {
        return Math.PI*radius*radius;
    }
}
class Rectangle extends Shape{
    private double length;
    private double width;
    public  Rectangle(double length,double width){
        this.length = length;
        this.width = width;
    }
    @Override
    public double area(){
        return length*width;
    }
}
