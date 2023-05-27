package RPG_project.character.enemy;

import java.util.Random;

public class Jangeogui extends Enemy{

    Random rand = new Random();

    public Jangeogui() {
        super("장어구이", 70 , 70, 55);
        this.credReward = 100;
    }
    @Override
    public int enemySkill() { //Enemy에 있는 enemySkill을 오버라이드
        System.out.print("장어구이 패거리 : ");
        int enemySkillNum = rand.nextInt(3);
        int damage = 0;
        switch(enemySkillNum) {
            case 0:
                System.out.println("[장어 꼬리로 후려치기 시전]");
                damage = 20;
            case 1:
                System.out.println("[단단한 장어 가시로 찌르기 시전]");
                damage = 25;
            case 2:
                System.out.println("[장어 먹고 튼튼해진 몸으로 기본 공격 시전]");
                damage = 19;
        }
        return damage;
    }
}
