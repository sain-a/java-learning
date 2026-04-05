package week2_day06_OOP.GameRoles;

public class Warrior extends Hero{
    public Warrior(String name){
        super(name);
    }
    @Override
    public void attack(){
        System.out.println(name+"砍人");
    }
}
