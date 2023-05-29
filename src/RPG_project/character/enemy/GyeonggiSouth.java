package RPG_project.character.enemy;

import java.util.Random;

public class GyeonggiSouth extends Enemy{
    Random rand = new Random();

    public GyeonggiSouth() {
        super("경기도 남부 연합", 370 , 330);
        this.credReward = 380; this.moneyReward = 40000;
    }

    @Override
    public int enemySkill() {
        System.out.print("경기도 남부 연합 : ");

        int enemySkillNum = rand.nextInt(6);

        int damage = 0;
        switch(enemySkillNum) {
            case 0:
                System.out.println("[용인시 에버랜드 패거리의 공격 시전]");
                damage = 90;
            case 1:
                System.out.println("[의왕시 톨게이트 패거리의 불법점령으로 인한 교통 체증 시전]");
                System.out.println("교통 체증으로 인한 스트레스는 hp를 감소시킵니다. ");
                damage = 100;
            case 2:
                System.out.println("[수원 왕갈비 패거리의 달콤한 양념 공격 시전]");
                damage = 115;
            case 3:
                System.out.println("[하남시 스타필드 패거리의 복합 공격 시전]");
                damage = 125;
            case 4:
                System.out.println("[김포시 공항 패거리의 공중 공격 시전]");
                damage = 130;
            case 5:
                System.out.println("[평택시 스키 패거리의 스키날로 베기 시전]");
        }
        return damage;
    }
}
