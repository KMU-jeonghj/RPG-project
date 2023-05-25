package RPG_project.character;

public class Salary extends Job{

    //필드멤버
    //----------------------------------------------
    private int casePower;
    private int salesPower;
    //---------------------------------------------

    //생성자
    //------------------------------------------------
    public Salary() {
        super();
        this.jobName = "영업사원";
        //this.jobYear = 1;
        this.casePower = 30;
        this.salesPower = 5;
    }
    //-----------------------------------------------------


    //설정자
    //-------------------------------------------------------
    public void setCasePower(int casePower) {
        this.casePower = casePower;
    }

    public void setSalesPower(int salesPower) {
        this.salesPower = salesPower;
    }

    public void gainCasePower(int casePower) {
        this.casePower += casePower;
    }

    public void gainSalesPower(int salesPower) {
        this.salesPower += salesPower;
    }

    //접근자
    //-----------------------------------------------------

    public int getCasePower() {
        return casePower;
    }

    public int getSalesPower() {
        return salesPower;
    }

    //------------------------------------------------------

    //업무 메소드
    public void makePaper(Hero hero) {
        int hpMinus = 10;
        System.out.println("\n서류를 작성합니다\n");//피로도에 따라 다른 메세지 출력 기능도 생각해보기

        int result = (int) (30 * hero.getTiredrate());
        int wage = (int) (3000 * hero.getTiredrate());
        System.out.printf("\n업무 완료\n 서류가방 무게 : %d(+%d)\n 월급 : %d(+%d)\n",
                casePower, result, hero.getMoney(), wage);
        System.out.printf("HP : %d(-%d)/%d\n",hero.getHp(), hpMinus, hero.getFullHp());
        casePower += result; //업무능력치 상승
        hero.gainMoney(wage); // 월급
        hero.loseHp(hpMinus); //피로도 상승
    }
    public void meetClient(Hero hero) {
        int hpMinus = 15;
        System.out.println("\n거래처 직원을 설득하고 있습니다.\n");
        int result = (int) (120 * hero.getTiredrate());
        int wage = (int) (5000 * hero.getTiredrate());
        System.out.printf("\n업무 완료\n 영업능력 : %d(+%d)\n 월급 : %d(+%d)\n",
                salesPower, result, hero.getMoney(), wage);
        System.out.printf("HP : %d(-%d)/%d\n",hero.getHp(), hpMinus, hero.getFullHp());
        salesPower += result;
        hero.gainMoney(wage);
        hero.loseHp(hpMinus);
    }

    //mp 회복 커맨드
    public void exercise(Hero hero) {
        int hpMinus = 10;
        System.out.println("\n오늘은 하체!\n"); //랜덤 출력 기능?
        int result = (int) (30 * hero.getTiredrate());
        if (result + mp > fullMp) {
            result =  result - fullMp;
        }
        System.out.printf("\n오늘 운동 완료!\n mp : %d(+%d)/%d\n", mp, result, fullMp);
        System.out.printf("HP : %d(-%d)/%d\n",hero.getHp(), hpMinus, hero.getFullHp());
        gainMp(result);
        hero.loseHp(hpMinus);
    }

    @Override
    public void work(Hero hero) {
        System.out.println("\n업무를 선택하세요\n");
        System.out.println("\t1. 서류작성 - (서류가방 무게 ↑ , 돈 ↑)");
        System.out.println("\t2. 영업현장 나가기 - (영업능력 ↑ , 돈 ↑)");
        System.out.println("\t3. 몰래 운동하기 - (mp 회복)\n");

        String num = input.nextLine(); //숫자가 아니라 문자열을 입력하는 경우 고려
        switch (num) {
            case "1" -> makePaper(hero);
            case "2" -> meetClient(hero);
            case "3" -> exercise(hero);
            default -> {
                System.out.println("올바른 값을 입력해 주세요.");
                work(hero);//재귀 사용
            }
        }
    }

    //스킬 메소드
    public int edgeAttack() {
        int mul = 1;
        int mpMinus = 25;
        if (mp - mpMinus < 0) {
            System.out.println("mp가 부족합니다.");
            return skill();
        }
        else {
            System.out.printf("MP : %d(-%d)/%d\n", mp, mpMinus, fullMp);
            loseMp(mpMinus);//mp감소
            return (int)(casePower * 0.6);
        }
    }

    public int persuade() {
        return 0;
    }
    //Stage에 설전 메소드로 연결
    @Override
    public int skill() {
        System.out.println("\n스킬 선택\n");
        System.out.println("\t1. 기본공격");
        System.out.println("\t2. 서류가방 모서리 공격");
        //System.out.println("\t3. 회유하기\n");

        String skillNum = input.nextLine();
        int skillDamage = switch (skillNum) {
            case "1" -> 0;
            case "2" -> edgeAttack();
            //case "3" -> persuade();
            default -> {
                System.out.println("올바른 값을 입력해 주세요");
                yield skill(); //재귀
            }
        };
        return skillDamage;
    }
    //스킬 레벨업
}
