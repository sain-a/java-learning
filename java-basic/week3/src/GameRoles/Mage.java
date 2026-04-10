package GameRoles;

public class Mage extends Hero implements Skill{
    public Mage(String name){
        super(name);
    }
    @Override
    public void attack(){
        System.out.println(name+"放技能");
    }
    @Override
    public void useSkill(){
        System.out.println(name+"使用技能");
    }
}
