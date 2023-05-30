package RPG_project.character.enemy;

import java.util.Random;

public class Chungcheong extends Enemy{

    Random rand = new Random();

    public Chungcheong() {
        super("충청도 아삭한 사과", 140 , 130);
        this.credReward = 180; this.moneyReward = 20000;
    }
    @Override
    public int enemySkill() { //Enemy에 있는 enemySkill을 오버라이드
        System.out.print("충청도 아삭한 사과 패거리 : ");
        int enemySkillNum = rand.nextInt(3);
        int damage = 0;
        switch(enemySkillNum) {
            case 0:
                System.out.println("[단단한 사과 던지기 시전]");
                damage = 45;
                break;
            case 1:
                System.out.println("[과도 휘두르기 시전]");
                damage = 50;
                break;
            case 2:
                System.out.println("[사과 먹고 건강해진 몸으로 기본 공격 시전]");
                damage = 40;
                break;
        }
        return damage;
    }
}
