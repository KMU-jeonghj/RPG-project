package RPG_project.character;

//Enemy 부모 클래스

public class Enemy extends Gangster{

    protected int credReward; //자식 클래스가 접근 가능하도록 protected 지정

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
}
