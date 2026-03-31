package week2_day02_polymorphic;

public class TestPolymorphism {
    public static void main(String[]args) {
        Animal animal = new Dog();
        animal.eat();
//        animal.lookDoor();//多态不能调用子类特有
        //向下转型
        Dog dog =(Dog) animal;
        dog.eat();
        dog.lookDoor();
    }
}
