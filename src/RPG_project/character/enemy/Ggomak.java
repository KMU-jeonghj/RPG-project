package RPG_project.character.enemy;

import java.util.Random;

public class Ggomak extends Enemy{

    Random rand = new Random();

    public Ggomak() {
        super("꼬막무침",65, 50, 70);
        this.credReward = 95;
    }
    @Override
    public int enemySkill() { //Enemy에 있는 enemySkill을 오버라이드
        System.out.print("꼬막무침 패거리 : ");
        int enemySkillNum = rand.nextInt(3);
        int damage = 0;
        switch(enemySkillNum) {
            case 0:
                System.out.println("[꼬막 던지기 시전]");
                damage = 17;
            case 1:
                System.out.println("[꼬막껍질로 꼬집기 시전]");
                damage = 22;
            case 2:
                System.out.println("[모래 씹히게 하기 시전]");
                damage = 18;
        }
        return damage;
    }
}
