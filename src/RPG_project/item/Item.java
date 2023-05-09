package RPG_project.item;
//Item 클래스
public class Item {
    private String name;
    private int hp, def, price, cnt;

    public Item(String name, int hp, int def, int price) {
        this.name = name;
        this.hp = hp;
        this.def = def;
        this.price = price;
        cnt = 0;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getDef() {
        return def;
    }

    public int getPrice() {
        return price;
    }

    public int getCnt() {
        return cnt;
    }
}
