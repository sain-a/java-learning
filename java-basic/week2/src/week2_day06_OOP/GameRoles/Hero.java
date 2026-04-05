package week2_day06_OOP.GameRoles;

abstract class Hero {
    protected String name;
    public Hero(String name){
        this.name = name;
    }
    public abstract void attack();
    public void show(){
        System.out.println("英雄："+name);
    }
}
