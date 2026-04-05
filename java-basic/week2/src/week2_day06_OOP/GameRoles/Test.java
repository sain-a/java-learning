package week2_day06_OOP.GameRoles;

public class Test {
    public static void main(String[] args) {
        Hero h1 = new Warrior("亚瑟");
        Hero h2 = new Mage("妲己");
        h1.show();
        h1.attack();
        h2.show();
        h2.attack();
        if(h2 instanceof Mage){
            Mage h3 = (Mage) h2;
            h3.useSkill();
        }

    }
}
