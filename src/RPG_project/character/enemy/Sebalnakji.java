package RPG_project.character.enemy;

import java.util.Random;

public class Sebalnakji extends Enemy{

    Random rand = new Random();

    public Sebalnakji() {
        super("세발낙지",30, 20);
        this.credReward = 45;
        this.moneyReward = 8000;
    }
    @Override
    public int enemySkill() { //Enemy에 있는 enemySkill을 오버라이드
        System.out.print("세발낙지 패거리 : ");
        int enemySkillNum = rand.nextInt(3);
        int damage = 0;
        switch(enemySkillNum) {
            case 0:
                System.out.println("[연속 3회 날라차기 시전]");
                damage = 7;
                break;
            case 1:
                System.out.println("[달라붙기 시전]");
                damage = 5;
                break;
            case 2:
                System.out.println("[먹물 대포 시전]");
                damage = 6;
        }
        return damage;
    }


}