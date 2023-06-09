package RPG_project.character;

public class Actor extends Job{

    //필드멤버
    //----------------------------------------------
    private int stuntPower;
    private int actingPower;
    //---------------------------------------------

    //생성자
    //------------------------------------------------
    public Actor() {
        super();
        this.jobName = "연기파 배우";
        //this.jobYear = 1;
        this.stuntPower = 15;
        this.actingPower = 5;
    }
    //-----------------------------------------------------


    //설정자
    //-------------------------------------------------------
    public void setStuntPower(int stuntPower) {
        this.stuntPower = stuntPower;
    }

    public void setActingPower(int actingPower) {
        this.actingPower = actingPower;
    }

    public void gainStuntPower(int stuntPower) {
        this.stuntPower += stuntPower;
    }

    public void gainActingPower(int actingPower) {
        this.actingPower += actingPower;
        if (this.actingPower > 70) {
            this.actingPower = 70;
            System.out.println("최대스킬파워에 도달했습니다.\n연기력(회피확률) : 70%");
        }
    }

    //접근자
    //-----------------------------------------------------

    public int getStuntPower() {
        return stuntPower;
    }

    public int getActiingPower() {
        return actingPower;
    }

    //------------------------------------------------------

    //업무 메소드
    public void studyAct(Hero hero) {
        int hpMinus = 10;
        System.out.println("\n연기 학원에 다녀옵니다.\n");

        int result1 = (int) (20 * hero.getTiredrate()); //mp 회복량
        if (result1 + mp > fullMp) {
            result1 =  result1 - fullMp;
        }
        int result2 = (int) (5 * hero.getTiredrate());
        System.out.printf("\n업무 완료\n 연기력 : %d(+%d)\nmp : %d(+%d)/%d\n", actingPower, result2, mp, result1, fullMp);
        System.out.printf("HP : %d(-%d)/%d\n",hero.getHp(), hpMinus, hero.getFullHp());
        actingPower += result2; //업무능력치 상승
        gainMp(result1);
        hero.loseHp(hpMinus); //피로도 상승
    }
    public void takeMovie(Hero hero) {
        int hpMinus = 15;
        System.out.println("\n액션 영화를 촬영합니다.\n");
        int result = (int) (120 * hero.getTiredrate());
        int wage = (int) (5000 * hero.getTiredrate());
        System.out.printf("\n업무 완료\n 스턴트맨의 능력 : %d(+%d)\n 월급 : %d(+%d)\n",
                stuntPower, result, hero.getMoney(), wage);
        System.out.printf("HP : %d(-%d)/%d\n",hero.getHp(), hpMinus, hero.getFullHp());
        stuntPower += result;
        hero.gainMoney(wage);
        hero.loseHp(hpMinus);
    }

    //mp 회복 커맨드
    public void extra(Hero hero) {
        int hpMinus = 10;
        int result = (int) (10 * hero.getTiredrate());
        int wage = (int) (4000 * hero.getTiredrate());
        System.out.println("\n단역도 메소드 연기로!\n");
        System.out.printf("\n촬영 완료\n 연기력 : %d(+%d)\n 월급 : %d(+%d)\n",
                actingPower, result, hero.getMoney(), wage);
        System.out.printf("HP : %d(-%d)/%d\n",hero.getHp(), hpMinus, hero.getFullHp());
        gainActingPower(result);
        hero.gainMoney(wage);
        hero.loseHp(hpMinus);
    }

    @Override
    public void work(Hero hero) {
        System.out.println("\n업무를 선택하세요\n");
        System.out.println("\t1. 연기학원 다녀오기 - (연기력↑, mp회복)"); //mp회복, 3번으로
        System.out.println("\t2. 액션영화 촬영하기 - (액션숙련 ↑ , 돈 ↑)");
        System.out.println("\t3. 단역 알바 뛰기 - (연기력 ↑ , 돈 ↑)\n"); //->눈물연기 회피기

        String num = input.nextLine(); //숫자가 아니라 문자열을 입력하는 경우 고려
        switch (num) {
            case "1" -> studyAct(hero);
            case "2" -> takeMovie(hero);
            case "3" -> extra(hero);
            default -> {
                System.out.println("올바른 값을 입력해 주세요.");
                work(hero);//재귀 사용
            }
        }
    }

    //스킬 메소드
    public int stuntAttack() {
        int mul = 1;
        int mpMinus = 25;
        if (mp - mpMinus < 0) {
            System.out.println("mp가 부족합니다.");
            return skill();
        }
        else {
            System.out.printf("MP : %d(-%d)/%d\n", mp, mpMinus, fullMp);
            loseMp(mpMinus);//mp감소
            return (int)(stuntPower * 0.8);
        }
    }

    public int actingTear() {
        return -2;
    }

    @Override
    public int skill() {
        System.out.println("\n스킬 선택\n");
        System.out.println("\t1. 기본공격");
        System.out.println("\t2. 스턴트맨의 대리 싸움");
        System.out.println("\t3. 눈물연기하기\n");

        String skillNum = input.nextLine();
        int skillDamage = switch (skillNum) {
            case "1" -> 0;
            case "2" -> stuntAttack();
            case "3" -> actingTear();
            default -> {
                System.out.println("올바른 값을 입력해 주세요");
                yield skill(); //재귀
            }
        };
        return skillDamage;
    }
}
