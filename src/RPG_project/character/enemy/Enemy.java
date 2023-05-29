

package RPG_project.character.enemy;

//Enemy 부모 클래스

import RPG_project.character.*;


public class Enemy extends Gangster {

    protected int credReward; //자식 클래스가 접근 가능하도록 protected 지정
    protected int moneyReward;
    protected int resist; //설득도 변수, 100에서 0이되면 설득
    protected int gangReward;

    public Enemy(String name, int gangCnt, int power, int def) {
        super(name);
        this.gangCnt = this.fullGangCnt = gangCnt;
        this.power = power;
        this.def = def;
        this.gangReward = (int) (0.8 * this.fullGangCnt); // gangCnt 보상 초기화
        this.recovery = this.fullGangCnt/4;
    }

    public void setCredReward(int credReward) {
        this.credReward = credReward;
    }

    public void gainResist(int resist) {
        this.resist += resist;
        if (this.resist > 100) this.resist = 100;
    }

    public void loseResist(int resist) {
        this.resist -= resist;
        if (this.resist < 0) this.resist = 0;
    }

    public int getCredReward() {
        return credReward;
    }

    public int getMoneyReward() {
        return moneyReward;
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

    @Override
    public void attacked(Gangster gang, Hero hero) {
        super.attacked(gang, hero);
        giveReward((NightGang) gang, hero);

    }

    public void giveReward(NightGang nightGang, Hero hero) {
        if (isGangZero()) {//Enemy의 gangCnt가 0이면
            System.out.printf("%s를 쓰러뜨렸다!\n", this.name);
            System.out.printf("신뢰도 증가!\n신뢰도: %d(+%d)\n", nightGang.getCredibility(), this.credReward);
            nightGang.gainCredibility(this.credReward); //타입변환
            System.out.printf("%s의 자금 입수!\n돈: %d(+%d)\n", this.name, hero.getMoney(), this.moneyReward);
            hero.gainMoney(this.moneyReward);
            System.out.printf("조직원 수 증가!\n조직원: %d(+%d)\n", nightGang.getFullGangCnt(), this.gangReward);
            nightGang.gainFullGangCnt(this.gangReward);
        }
    }
}
