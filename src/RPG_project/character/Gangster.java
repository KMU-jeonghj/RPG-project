package RPG_project.character;

public class Gangster {

    //필드멤버
    //------------------------------------------
    protected String name; //자식 클래스가 접근 가능하도록 protected 지정

    protected int gangCnt, fullGangCnt, power, def;

    protected double weight = (double)4/5;
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
        if (this.gangCnt < 0) this.gangCnt = 0;
    }

    public void gainGangCnt(int gangCnt) {
        this.gangCnt += gangCnt;
        if (this.gangCnt > this.fullGangCnt) this.gangCnt = this.fullGangCnt;
    }

    public void fillGangCnt() {
        this.gangCnt = this.fullGangCnt;
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
    //----------------------------------------

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
    //-------------------------------------------

    public double getGangRate() {
        return  ((double)gangCnt/fullGangCnt);
    }

    public boolean isZeroGang() {
        return (this.gangCnt == 0);
    }

    public double attack(Hero hero) { //NightGang에서 오버라이딩 (스킬 추가)

        double damage = (this.power * getGangRate());
        return damage;
    }

    public void attacked(Gangster gang, Hero hero) {
        double damage;
        double given = gang.attack(hero);
        System.out.printf("보낸 데미지 %.1f\n", given);
        System.out.printf("방어 %.1f\n", (weight * def * getGangRate()));
        damage = given - (weight * def * getGangRate());

        if (damage <= 0)  {
            damage = 0;
            System.out.println("MISS!");
        }

        //debug
        System.out.printf("받은 데미지 %.1f\n" ,damage);
        gangCnt -= damage;
        if (gangCnt < 0) gangCnt = 0;
        gangCnt = (int)gangCnt;
    }
}
