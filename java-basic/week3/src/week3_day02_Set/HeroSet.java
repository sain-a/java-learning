package week3_day02_Set;

import GameRoles.Hero;
import GameRoles.Mage;
import GameRoles.Warrior;

import java.util.HashSet;
import java.util.Set;

public class HeroSet {
    public static void main(String[] args) {
        Set<Hero> set = new HashSet<>();
        set.add(new Warrior("亚瑟"));
        set.add(new Mage("妲己"));
        set.add(new Mage("妲己"));
        System.out.println(set.size());
        for(Hero h : set){
            h.attack();
        }
        System.out.println(set.contains(new Warrior("亚瑟")));
    }
}
