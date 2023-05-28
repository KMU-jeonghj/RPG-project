package RPG_project.item;
//Item 클래스
public class Item {
    protected String name, info;
    protected int hp, mp, price, cnt, no;
    protected double gang;

    public Item(String name, int hp, int mp, double gang, int price, int no, String info) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.gang = gang;
        this.price = price;
        this.no = no;
        this.info = info;
        this.cnt = 0;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public void gainCnt(int cnt) {
        this.cnt += cnt;
    }

    public void loseCnt(int cnt) {
        this.cnt -= cnt;
        if (cnt < 0) this.cnt = 0;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public double getGang() {
        return gang;
    }

    public int getPrice() {
        return price;
    }

    public int getCnt() {
        return cnt;
    }

    public int getNo() {
        return no;
    }

    public void printInfo() {
        System.out.println(this.info);
    }

    public boolean isHp() {
        return (this.hp != 0);
    }

    public boolean isMp() {
        return (this.mp != 0);
    }

    public boolean isGang() {
        return (this.gang != 0.0);
    }
}
