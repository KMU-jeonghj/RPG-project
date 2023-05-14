package RPG_project.character;

public class Gangster {

    //필드멤버
    //------------------------------------------
    protected String name;

    protected int gangCnt, fullGangCnt, power, def;

    //생성자
    //-------------------------------------
    public Gangster(String name) {
        this.name = name;
    }
    //--------------------------------------

    //설정자
    //----------------------------------------

    public void setGangCnt(int gangCnt) {
        this.gangCnt = gangCnt;
    }

    public void setFullGangCnt(int fullGangCnt) {
        this.fullGangCnt = fullGangCnt;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setDef(int def) {
        this.def = def;
    }
    //----------------------------------------

    //접근자
    //--------------------------------------

    public String getName() {
        return name;
    }

    public int getGangCnt() {
        return gangCnt;
    }

    public int getFullGangCnt() {
        return fullGangCnt;
    }

    public int getPower() {
        return power;
    }

    public int getDef() {
        return def;
    }
    //----------------------------------------

    public double getGangrate() {
        return  (gangCnt/fullGangCnt);
    }

    public boolean isDown() {
        return (this.gangCnt == 0);
    }

    public int attack() {
        int damage = (int)(power * getGangrate());
        return damage;
    }

    public void attacked(Gangster gang) {
        int damage = gang.attack() - (int)(def * getGangrate());
        gangCnt -= damage;
        if (gangCnt < 0) gangCnt = 0;
    }
}
