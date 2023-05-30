package RPG_project.character.enemy;

import java.util.Random;

public class Gwanganri extends Enemy implements BossEnemy{

    Random rand = new Random();

    public Gwanganri() {
        super("부산 광안리", 170 , 140);
        this.credReward = 200; this.moneyReward = 24000;
    }
    @Override
    public int enemySkill() { //Enemy에 있는 enemySkill을 오버라이드
        System.out.print("부산 광안리 패거리 : ");
        int enemySkillNum = rand.nextInt(3);
        int damage = 0;
        switch(enemySkillNum) {
            case 0:
                System.out.println("[강력한 바다 갈매기와 협동 공격 시전]");
                damage = 55;
                break;
            case 1:
                System.out.println("[열정으로 기선제압 시전]");
                damage = 60;
                break;
            case 2:
                System.out.println("[국밥 뚝배기 던지기 시전]");
                damage = 50;
                break;
        }
        return damage;
    }
}
