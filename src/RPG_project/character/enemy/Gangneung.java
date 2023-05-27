package RPG_project.character.enemy;

import RPG_project.character.Hero;

import java.util.Random;

public class Gangneung extends Enemy implements NegoEnemy{

    Random rand = new Random();

    public Gangneung() {
        super("강릉 바다뷰", 140 , 160, 110);
        this.credReward = 170; this.moneyReward = 220;
        this.resist = 100;
    }
    @Override
    public int enemySkill() { //Enemy에 있는 enemySkill을 오버라이드
        System.out.print("강릉 바다뷰 패거리 : ");
        int enemySkillNum = rand.nextInt(3);
        int damage = 0;
        switch(enemySkillNum) {
            case 0:
                System.out.println("[바닷물 대포 시전]");
                damage = 47;
            case 1:
                System.out.println("[갓잡은 해산물 던지기 시전]");
                damage = 52;
            case 2:
                System.out.println("[강릉 모래 흩뿌리기 시전]");
                damage = 44;
        }
        return damage;
    }


    @Override
    public void debate(Hero hero) {

    }
}
