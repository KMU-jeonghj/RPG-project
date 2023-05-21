package RPG_project.character;
//Hero 부모 클래스
import java.util.Scanner;


public class Hero {


    //필드 멤버
    //--------------------------------------------------------------
    public Scanner input = new Scanner(System.in); // Scanner 객체 생성

    private String name;
    private int hp, fullHp, money;

    private Job jobType;
    Job[] jobArr;
//--------------------------------------------------------


    //생성자
    public Hero(String name) {
        this.name = name;
        this.fullHp = this.hp = 100;
        this.money = 0;
    }



    //설정자
    //-------------------------------------------------------------------------
    public void setFullHp(int fullHp) {
        this.fullHp = fullHp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void gainHp(int hp) {
        this.hp += hp;
        if (this.hp > this.fullHp) this.hp = this.fullHp;
    }

    public void loseHp(int hp) {
        this.hp -= hp;
        if (this.hp < 0) this.hp = 0;
    }

    public void zeroHp() { //hp를 0으로 만드는 메소드
        this.hp = 0;
    } // hp 0으로 전환

    public void gainMoney(int money) {
        this.money += money;
    }

    public void loseMoney(int money) {
        this.money -= money;
        if (this.money < 0) this.money = 0;
    }

    public void setJobType(Job jobType) {
        this.jobType = jobType;
    }

    //------------------------------------------------------------------


    //접근자
    //---------------------------------------------------------------------
    public String getName() {
        return name;
    }

    public int getFullHp() {
        return fullHp;
    }

    public int getHp() {
        return hp;
    }

    public int getMoney() {
        return money;
    }

    public Job getJobType() {
        return jobType;
    }
    //-----------------------------------------------------------------------


    public double getTiredrate() { //피로도를 현재 hp의 비율로 표현
        if (this.hp == 0) return 0;
        else return (double) hp / fullHp;
    }

    public boolean isZeroHp() {
        return (this.hp == 0);
    }


}
