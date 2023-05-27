package RPG_project.character.enemy;

import java.util.Random;

public class Jeonjubibim extends Enemy{

    Random rand = new Random();

    public Jeonjubibim() {
        super("전주비빔", 60, 55, 65); //이름, 조직원수, 공격력, 방어력
        this.credReward = 90;
        this.moneyReward = 150;
    }
    @Override
    public int enemySkill() {
        System.out.print("전주비빔 패거리 : ");
        int enemySkillNum = rand.nextInt(3);
        int damage = 0;
        switch (enemySkillNum) {
            case 0:
                System.out.println("[눈알에 고추장 뿌리기 시전]");
                damage = 18;
            case 1:
                System.out.println("[강력하게 비비기 시전]");
                damage = 22;
            case 2:
                System.out.println("[환상의 팀워크로 단체 공격 시전]");
                damage = 17;
        }
        return damage;
    }
}
