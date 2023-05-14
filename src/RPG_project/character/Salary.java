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
        this.normalPower = 10;
        this.casePower = 5;
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

    //접근자
    //-----------------------------------------------------

    public int getCasePower() {
        return casePower;
    }

    public int getSalesPower() {
        return salesPower;
    }

    //------------------------------------------------------

    public void makePaper(Hero hero) {
        System.out.println("\n서류를 작성합니다\n");//피로도에 따라 다른 메세지 출력 기능도 생각해보기

        int result = (int) (70 * hero.getTiredrate());
        int wage = (int) (5000 * hero.getTiredrate());
        System.out.printf("\n업무 완료\n 서류가방 무게 : %d(+%d)\n 월급 : %d(+%d)\n", casePower, result, hero.getMoney(), wage);
        casePower += result; //업무능력치 상승
        hero.gainMoney(wage); // 월급
        hero.loseHp(10); //피로도 상승
    }
    public void meetClient(Hero hero) {
        System.out.println("\n거래처 직원을 설득하고 있습니다.\n");
        int result = (int) (120 * hero.getTiredrate());
        int wage = (int) (3000 * hero.getTiredrate());
        System.out.printf("\n업무 완료\n 영업능력 : %d(+%d)\n 월급 : %d(+%d)\n", salesPower, result, hero.getMoney(), wage);
        salesPower += result;
        hero.gainMoney(wage);
        hero.loseHp(25);
    }
    public void exercise(Hero hero) {
        System.out.println("\n오늘은 하체!\n"); //랜덤 출력 기능?
        int result = (int) (100 * hero.getTiredrate());
        System.out.printf("\n업무 완료\n 영업능력 : %d(+%d)\n", normalPower, result);
        normalPower += result;
        hero.loseHp(15);
    }

    @Override
    public void work(Hero hero) {
        System.out.println("\n업무를 선택하세요\n");
        System.out.println("\t1. 서류작성 - (서류가방 무게 ↑ , 돈 ↑)");
        System.out.println("\t2. 영업현장 나가기 - (영업능력 ↑ , 돈 ↑)");
        System.out.println("\t3. 몰래 운동하기 - (공격력 ↑)\n");
        String num = input.next();
        switch (num) {
            case "1" -> makePaper(hero);
            case "2" -> meetClient(hero);
            case "3" -> exercise(hero);
            default -> System.out.println("올바른 값을 입력해 주세요.");
        }
    }

    @Override
    public int skill() {
        return 0;

    }
}
