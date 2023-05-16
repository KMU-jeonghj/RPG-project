package RPG_project.character;

public class Gangster {

    //필드멤버
    //------------------------------------------
    protected String name; //자식 클래스가 접근 가능하도록 protected 지정

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

    public void loseGangCnt(int gangCnt) {
        this.gangCnt -= gangCnt;
    }

    public void gainGangCnt(int gangCnt) {
        this.gangCnt += gangCnt;
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

    public double getGangRate() {
        return  (gangCnt/fullGangCnt);
    }

    public boolean isZeroGang() {
        return (this.gangCnt == 0);
    }

    public int attack(Hero hero) { //NightGang에서 오버라이딩 (스킬 추가)
        int damage = (int)(power * getGangRate());
        return damage;
    }

    public void attacked(Gangster gang, Hero hero) {
        int damage;
        if (gang.attack(hero) < (int)(def * getGangRate())) damage = 0; //방어력이 상대 공격보다 클때 미스처리
        else
            damage = gang.attack(hero) - (int)(def * getGangRate());
        gangCnt -= damage;
        if (gangCnt < 0) gangCnt = 0;
    }
}
