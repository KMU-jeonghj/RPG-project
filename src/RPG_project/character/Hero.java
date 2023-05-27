package RPG_project.character;
//Hero 부모 클래스
import java.util.Scanner;


public class Hero {


    //필드 멤버
    //--------------------------------------------------------------
    Scanner input = new Scanner(System.in); // Scanner 객체 생성

    private String name;
    private int hp, fullHp, money;

    private Job jobNow; //현재직업


    private Salary salary = new Salary();
    private Butcher butcher = new Butcher();
    private Actor actor = new Actor();

    Job[] jobArr = {salary, butcher, actor};
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

    public void fillHp() {
        this.hp = this.fullHp;
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

    public void setJobNow(Job jobNow) {
        this.jobNow = jobNow;
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

    public Job getJobNow() {
        try {
            return jobNow;
        } catch (NullPointerException error) {
            System.out.println("직업 선택 메소드 불러오는중!!");
            choiceJob();
        }
        return getJobNow();
    }

    public Salary getSalary() {
        return salary;
    }

    //-----------------------------------------------------------------------


    public double getTiredrate() { //피로도를 현재 hp의 비율로 표현
        if (this.hp == 0) return 0;
        else return (double) hp / fullHp;
    }

    public boolean isHpZero() {
        return (this.hp == 0);
    }

    public void choiceJob() { //직업선택 메소드
        System.out.println("직업을 선택하세요");
        System.out.println("1. 영업사원");
        System.out.println("2. 정육점사장");
        System.out.println("3. 삼류배우");

        String s = input.next();
        switch (s) {
            case "1" -> this.jobNow = jobArr[0];
            case "2" -> this.jobNow = jobArr[1];
            case "3" -> this.jobNow = jobArr[2];
            default -> {
                System.out.println("올바른 값을 입력해 주세요.");
                choiceJob();
            }
        }
    }

}
