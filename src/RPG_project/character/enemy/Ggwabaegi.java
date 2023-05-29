package RPG_project.character.enemy;

import java.util.Random;

public class Ggwabaegi extends Enemy{

    Random rand = new Random();

    public Ggwabaegi() {
        super("꽈배기",35, 25); //이름, 조직원수, 공격력, 방어력
        this.credReward = 45;
        this.moneyReward = 8100;
    }
    @Override
    public int enemySkill() { //Enemy에 있는 enemySkill을 오버라이드
        System.out.print("꽈배기 패거리 : ");
        int enemySkillNum = rand.nextInt(3);
        int damage = 0;
        switch(enemySkillNum) {
            case 0:
                System.out.println("[단단한 꽈배기로 후려치기 시전]");
                damage = 8;
            case 1:
                System.out.println("[꽈배기 반죽으로 목 조르기 시전]");
                damage = 5;
            case 2:
                System.out.println("[설탕 뿌리기 시전]");
                damage = 7;
        }
        return damage;
    }


}
