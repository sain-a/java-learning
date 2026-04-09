package week2_day06_OOP.GameRoles;

public abstract class Hero {
    protected String name;
    public Hero(String name){
        this.name = name;
    }
    public String getName(){return name;}
    public abstract void attack();
    public void show(){
        System.out.println("英雄："+name);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hero)) return false;

        Hero hero = (Hero) o;
        return this.name.equals(hero.name);
    }
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
