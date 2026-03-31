package week2_day02_polymorphic;

public class Instanceof {
    public static void main(String[]args){
        Dog dog = new Dog();//Animal animal = new Dog()
        method(dog);
        Cat cat = new Cat();
        method(cat);
    }
    public static void method(Animal animal){
        /*
        animal.eat();
        这里会出现类型转换异常（ClassCastException)
        原因：当调用method，传递cat对象是，animal代表的就是cat对象
            此时我们将代表cat对象的animal强转成了dog
            此时等号左右两边类型不一致,所以出现类型转换异常

        Dog dog = (Dog) animal;
        dog.lookDoor();
        */
        if(animal instanceof Dog){
            Dog dog = (Dog) animal;
            dog.eat();
            dog.lookDoor();
        }
    }
}
