package week3_day01_List;

import GameRoles.Hero;
import GameRoles.Mage;
import GameRoles.Skill;
import GameRoles.Warrior;

import java.util.ArrayList;
import java.util.List;

public class DemoList {
    public static void main(String[] args) {
        List<Hero> list = new ArrayList<>();
        list.add(new Warrior("亚瑟"));
        list.add(new Mage("妲己"));
        for(Hero h : list){
            h.attack();
            if(h instanceof Skill){
                Skill m = (Skill) h;
                m.useSkill();
            }
        }
        findHero(list, "妲己");
        removeHero(list, "亚瑟");

        System.out.println("删除后：");
        for (Hero h : list) {
            h.attack();
        }
    }
    public static void findHero(List<Hero> list,String name){
        for(Hero h : list){
            if(h.getName().equals(name)){
                System.out.println("找到了"+name);
                return;
            }
        }
        System.out.println("没找到"+name);
    }
    public static void removeHero(List<Hero> list,String name){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().equals(name)){
                list.remove(i);
                System.out.println("删除"+name);
                return;
            }
        }
        System.out.println("没有"+name);
    }
    public static void updateHeroName(List<Hero> list, String oldName, String newName) {
        // 1. 遍历找要修改的英雄
        for (Hero h : list) {
            if (h.getName().equals(oldName)) {
                // 2. 找到 → setName 修改
                h.setName(newName);
                System.out.println("修改成功：" + oldName + " → " + newName);
                return;
            }
        }
        // 3. 没找到
        System.out.println("不存在：" + oldName);
    }
}
