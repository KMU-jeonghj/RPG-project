package RPG_project.character;
//Hero 부모 클래스
import java.util.Scanner;


public class Hero {
    public Scanner input = new Scanner(System.in); // Scanner 객체 생성

    private String name;
    private int hp, fullHp, money;

    private Job jobType;
    Job[] jobArr;

    public Hero(String name) {
        this.name = name;
        this.fullHp = this.hp = 100;
        this.money = 0;
    }

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

    public void gainHp(int hp) {
        this.hp += hp;
    }

    public void loseHp(int hp) {
        this.hp -= hp;
    }

    public void zeroHp() { //hp를 0으로 만드는 메소드
        this.hp = 0;
    }

    public void gainMoney(int money) {
        this.money += money;
    }

    public void loseMoney(int money) {
        this.money -= money;
    }

    public double getTiredness() { //피로도를 현재 hp의 비율로 표현
        if (this.hp == 0) return 0;
        else return hp / fullHp;
    }


}
