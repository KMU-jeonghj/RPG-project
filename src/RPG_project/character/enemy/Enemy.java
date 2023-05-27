

package RPG_project.character.enemy;

//Enemy 부모 클래스

import RPG_project.character.*;


public class Enemy extends Gangster {

    protected int credReward; //자식 클래스가 접근 가능하도록 protected 지정
    protected int moneyReward;

    public Enemy(String name, int gangCnt, int power, int def) {
        super(name);
        this.gangCnt = this.fullGangCnt = gangCnt;
        this.power = power;
        this.def = def;
    }

    public void setCredReward(int credReward) {
        this.credReward = credReward;
    }

    public int getCredReward() {
        return credReward;
    }

    public int enemySkill() {
        return 0;
    }// 자식클래스에서 오버라이딩


    @Override
    public double attack(Hero hero)
    {
        double damage = (int)(power * getGangRate()) + enemySkill();

        return damage;//데미지 리턴
    }
}
