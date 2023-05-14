package RPG_project.character;

//Enemy 부모 클래스

public class Enemy extends Gangster{

    protected int credReward;

    public Enemy(String name) {
        super(name);
    }

    public void setCredReward(int credReward) {
        this.credReward = credReward;
    }

    public int getCredReward() {
        return credReward;
    }

    public int enemySkill() {
        return 0;
    }
}
