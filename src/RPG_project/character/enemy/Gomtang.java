package RPG_project.character.enemy;

import java.util.Random;

public class Gomtang extends Enemy implements BossEnemy {

    Random rand = new Random();

    public Gomtang() {
        super("곰탕", 30, 35, 25); //이름, 조직원수, 공격력, 방어력
        this.credReward = 45;
        this.moneyReward = 120;
    }

    @Override
    public int enemySkill() {
        System.out.print("곰탕 패거리 : ");
        int enemySkillNum = rand.nextInt(3);
        int damage = 0;
        switch (enemySkillNum) {
            case 0:
                System.out.println("[단단한 뚝배기로 후려치기 시전]");
                damage = 10;
            case 1:
                System.out.println("[뜨거운 국물 퍼붓기 시전]");
                damage = 7;
            case 2:
                System.out.println("[애완 곰의 대리 공격 시전]");
                damage = 15;
        }
        return damage;
    }
}