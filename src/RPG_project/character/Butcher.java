package RPG_project.character;

public class Butcher extends Job{

    //필드멤버
    //----------------------------------------------
    private int knifePower; //칼을 날카롭게 갈기
    private int meatPower; //고기 분신 만들기
    //---------------------------------------------

    //생성자
    //------------------------------------------------
    public Butcher() {
        super();
        this.jobName = "정육점 사장";
        //this.jobYear = 1;
        this.knifePower = 30;
        this.meatPower = 5;
    }
    //-----------------------------------------------------


    //설정자
    //-------------------------------------------------------
    public void setKnifePower(int knifePower) {
        this.knifePower = knifePower;
    }

    public void gainKnifePower(int knifePower) {
        this.knifePower += knifePower;
    }

    public void setMeatPower(int meatPower) {
        this.meatPower = meatPower;
    }

    public void gainMeatPower(int meatPower) {
        this.meatPower += meatPower;
        if (this.meatPower > 70) {
            this.meatPower = 70;
            System.out.println("최대스킬파워에 도달했습니다.\n고기만듦새(회피확률) : 70%");
        }
    }


    //접근자
    //-----------------------------------------------------

    public int getknifePower() {
        return knifePower;
    }

    public int getmeatPower() {
        return meatPower;
    }

    //------------------------------------------------------

    //업무 메소드
    public void sharpKnife(Hero hero) {
        int hpMinus = 10;
        System.out.println("\n칼을 갑니다\n");

        int result = (int) (30 * hero.getTiredrate());
        int wage = (int) (3000 * hero.getTiredrate());
        System.out.printf("\n업무 완료\n 칼의 날카로움 : %d(+%d)\n 월급 : %d(+%d)\n",
                knifePower, result, hero.getMoney(), wage);
        System.out.printf("HP : %d(-%d)/%d\n",hero.getHp(), hpMinus, hero.getFullHp());
        knifePower += result; //업무능력치 상승
        hero.gainMoney(wage); // 월급
        hero.loseHp(hpMinus); //피로도 상승
    }
    public void meatEgo(Hero hero) {
        int hpMinus = 15;
        System.out.println("\n고기 분신을 만들고 있습니다.\n");
        int result = (int) (10 * hero.getTiredrate());
        int wage = (int) (5000 * hero.getTiredrate());
        System.out.printf("\n업무 완료\n 고기 분신 만듦새 : %d(+%d)\n 월급 : %d(+%d)\n",
                meatPower, result, hero.getMoney(), wage);
        System.out.printf("HP : %d(-%d)/%d\n",hero.getHp(), hpMinus, hero.getFullHp());
        meatPower += result;
        hero.gainMoney(wage);
        hero.loseHp(hpMinus);
    }

    public void welcomeCustom(Hero hero) {
        int hpMinus = 10;
        System.out.println("\n손님은 왕, 어서오세요!\n");
        int wage = (int) (15000 * hero.getTiredrate());
        System.out.printf("\n미소로 손님 맞이하기 완료!\n 수입이 3배로 증가!\n 월급 : %d(+%d)\n", hero.getMoney(), wage);
        System.out.printf("HP : %d(-%d)/%d\n",hero.getHp(), hpMinus, hero.getFullHp());
        hero.gainMoney(wage);
        hero.loseHp(hpMinus);
    }

    @Override
    public void work(Hero hero) {
        System.out.println("\n업무를 선택하세요\n");
        System.out.println("\t1. 칼 갈기 - (날카로운 칼날 ↑ , 돈 ↑)");
        System.out.println("\t2. 고기 분신 만들기 - (고기 분신의 만듦새 ↑ , 돈 ↑)");
        System.out.println("\t3. 손님 맞이하기 - (매출 3배 증가)\n");

        String num = input.nextLine(); //숫자가 아니라 문자열을 입력하는 경우 고려
        switch (num) {
            case "1" -> sharpKnife(hero);
            case "2" -> meatEgo(hero);
            case "3" -> welcomeCustom(hero);
            default -> {
                System.out.println("올바른 값을 입력해 주세요.");
                work(hero);//재귀 사용
            }
        }
    }

    //스킬 메소드
    public int knifeAttack() {
        int mul = 1;
        int mpMinus = 25;
        if (mp - mpMinus < 0) {
            System.out.println("mp가 부족합니다.");
            return skill();
        }
        else {
            System.out.printf("MP : %d(-%d)/%d\n", mp, mpMinus, fullMp);
            loseMp(mpMinus);//mp감소
            return (int)(knifePower * 0.6);
        }
    }

    public int meatEgo() {
        return -1;
    }
    //Stage에 설전 메소드로 연결
    @Override
    public int skill() {
        System.out.println("\n스킬 선택\n");
        System.out.println("\t1. 기본공격");
        System.out.println("\t2. 날카로운 칼로 베기 공격");
        System.out.println("\t3. 고기 분신 만들어 혼란 주기\n");

        String skillNum = input.nextLine();
        int skillDamage = switch (skillNum) {
            case "1" -> 0;
            case "2" -> knifeAttack();
            case "3" -> meatEgo();
            default -> {
                System.out.println("올바른 값을 입력해 주세요");
                yield skill(); //재귀
            }
        };
        return skillDamage;
    }
}
