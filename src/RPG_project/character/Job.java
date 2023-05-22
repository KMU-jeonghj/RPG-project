package RPG_project.character;

import java.util.Scanner;

public abstract class Job {
    protected Scanner input = new Scanner(System.in);
    protected String jobName;//자식 클래스가 접근 가능하도록 protected 지정

    //protected int jobYear; //특정 직업을 선택한 턴만큼 늘어나는 변수, 고유능력 상승시 가중치로 사용될 수도 있을 것 같아 적어봤습니다.
    //mp로 변경
    protected static int mp;
    protected  static int fullMp = mp = 100;

    public void setMp(int mp) {
        this.mp = mp;
    }

    public void loseMp(int mp) {
        this.mp -= mp;
        if (this.mp < 0) this.mp = 0;
    }

    public void gainMp(int mp) {
        this.mp += mp;
        if(this.mp > this.fullMp) this.mp = this.fullMp;
    }

    public void fillMp() {
        this.mp = this.fullMp;
    }

    public void zeroMp() {
        this.mp = 0;
    }

    public static int getMp() {
        return mp;
    }

    public static int getFullMp() {
        return fullMp;
    }

    public String getJobName() {
        return jobName;
    }

    public abstract void work(Hero hero);

    public abstract int skill();


    //mp 등의 제한 필요
    //->기초 공격을 없애고 mp 늘리는 걸로 가야할듯



}
