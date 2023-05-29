package RPG_project.character;

import RPG_project.character.enemy.*;
import RPG_project.item.*;

import java.util.Scanner;



public class Stage {
    Scanner input = new Scanner(System.in);



//적 패거리 객체들
    //----------------------------------------------------------

    //목포
    private Sebalnakji sebalnakji = new Sebalnakji();
    private Ggwabaegi ggwabaegi = new Ggwabaegi();
    private Gomtang gomtang = new Gomtang();

    //전라도
    private Jeonjubibim jeonjubibim = new Jeonjubibim();
    private  Ggomak ggomak = new Ggomak();
    private Jangeogui jangeogui = new Jangeogui();

    //지방권
    private Chungcheong chungcheong = new Chungcheong();
    private Gangneung gangneung = new Gangneung();
    private Gwanganri gwanganri = new Gwanganri();

    //수도권
    private GyeonggiSouth gyeonggiSouth = new GyeonggiSouth();
    private GyeonggiNorth gyeonggiNorth = new GyeonggiNorth();
    private Namsan namsan = new Namsan();


    //적패거리 접근자들
    //------------------------------------------

    public Sebalnakji getSebalnakji() {
        return sebalnakji;
    }

    public Ggwabaegi getGgwabaegi() {
        return ggwabaegi;
    }

    public Gomtang getGomtang() {
        return gomtang;
    }

    public Jeonjubibim getJeonjubibim() {
        return jeonjubibim;
    }

    public Ggomak getGgomak() {
        return ggomak;
    }

    public Jangeogui getJangeogui() {
        return jangeogui;
    }

    public Chungcheong getChungcheong() {
        return chungcheong;
    }

    public Gangneung getGangneung() {
        return gangneung;
    }

    public Gwanganri getGwanganri() {
        return gwanganri;
    }

    public GyeonggiSouth getGyeonggiSouth() {
        return gyeonggiSouth;
    }

    public GyeonggiNorth getGyeonggiNorth() {
        return gyeonggiNorth;
    }

    public Namsan getNamsan() {
        return namsan;
    }
    //--------------------------------------------------------------------

    private Enemy[] stageMokpo = {new Enemy("목포", 0, 0, 0),
            sebalnakji, ggwabaegi, gomtang};
    private Enemy[] stageJeonra = {new Enemy("전라도", 0, 0, 0),
        jeonjubibim, ggomak, jangeogui};
    private Enemy[] stageCountry = {new Enemy("지방권", 0, 0, 0),
    chungcheong, gangneung, gwanganri};
    private Enemy[] stageCapital = {new Enemy("수도권", 0,0, 0),
    gyeonggiSouth, gyeonggiNorth, namsan};


    private int ei = 1;
    private int si = 1;
    private Enemy[][] stageArr = {null, stageMokpo, stageJeonra, stageCountry, stageCapital};

    private Enemy enemyNow = stageArr[si][ei]; //현재 싸우고 있는 적 패거리
    private String enemyNowName = enemyNow.getName();

    private Enemy[] stageNow = stageArr[si]; //현재 싸우고 있는 스테이지
    private String stageName = stageNow[0].getName();

    //객체배열 인덱스 한칸 옮기는 메소드, 중요!
    public void plusEi(NightGang nightGang, Hero hero) {
        if (isBoss() && this.si == 4) {
            System.out.println("all stages cleared");
        }
        else if (isBoss()) {
            System.out.println("다음 스테이지로..");
            this.ei = 1;
            this.si++;
            nightGang.rankUp(hero);
            setStageNow();
            setEnemyNow();
        }
        else {
            this.ei++;
            setStageNow();
            setEnemyNow();
        }

        //재설정

    }


    public void setEnemyNow() {
        this.enemyNow = this.stageArr[this.si][this.ei];
        System.out.printf("다음 적패거리: %s\n", enemyNow.getName());
    }

    public void setStageNow() {
        this.stageNow = this.stageArr[this.si];
        System.out.printf("다음 스테이지: %s\n", stageNow[0].getName());
    }


    public Enemy getEnemyNow() {
        return enemyNow;
    }

    public Enemy[] getStageNow() {
        return stageNow;
    }

    public String getStageName() {
        return stageName;
    }

    public String getEnemyNowName() {
        return enemyNowName;
    }

    //Enemy 객체 생성해서 여기에 배열로 저장
    //스테이지 카운트 변수
    //전투 메소드

    //-----------------------------------------------------------------------
    public void checkNego(Hero hero, Gangster nightGang, Inventory inventory) {//논쟁 메소드, 회유 이벤트시
        if (isSalary(hero) && isNego()) {
            System.out.printf("%s : 모두 싸움을 멈춰 줘!!!\n\n", hero.getName());
            input.nextLine();
            System.out.println("\n순간, 모두의 이목이 집중된다.\n");
            input.nextLine();
            System.out.printf("\n%s의 두목 : 무슨 말을 하려는거지...?\n\n", enemyNow.getName());
            input.nextLine();
            System.out.printf("%s : 잠시만... 내 말을 들어줘!\n\n", hero.getName());
            input.nextLine();

            ((NegoEnemy) enemyNow).debate(hero, (NightGang) nightGang); //논쟁 시작
        }

        else if (isNego()) {
            System.out.println("영업사원을 선택헸을 때 실행가능합니다.");
            battleActChoice(hero, nightGang, inventory, false);
        }

        else if (isSalary(hero)) {
            System.out.println("회유 가능한 패거리가 아닙니다.");
            battleActChoice(hero, nightGang, inventory, false);
        }

        else {
            System.out.println("영업 사원이 아니고, 회유가능한 패거리가 아닙니다");
            battleActChoice(hero, nightGang, inventory, false);
        }
    }

    public boolean isDown(Hero hero, NightGang nightGang) {
        return(nightGang.isGangZero() || hero.isHpZero());
    }

    //1.세력확장 -> 1. 싸운다
    public void battle(Hero hero, Gangster enemy, Gangster nightGang, Inventory inventory) {

        while(true) {
            boolean esc; //초기화
             esc = battleActChoice(hero, nightGang, inventory, false); // 1. 싸운다 2. 아이템 3. 설득(영입사원일시) 4.도망간다(큰 피해입고 생존, 신뢰도 감소)
            if (esc) break; // 도망치다 선택시 종료
            showBattleStat(hero, this.enemyNow, nightGang);

            System.out.printf("%s 공격\n", nightGang.getName());
            this.enemyNow.attacked(nightGang, hero);
            showBattleStat(hero, this.enemyNow, nightGang);
            if (this.enemyNow.isGangZero()) {
                plusEi((NightGang) nightGang, hero); //다음 단계 패거리 포인팅
                if (this.enemyNow instanceof Namsan) {
                    this.namsan.finalAfter(); //남산 파이널 대사
                }
                break;
            }

            System.out.printf("%s 공격\n", this.enemyNow.getName());
            nightGang.attacked(this.enemyNow, hero);
            showBattleStat(hero, this.enemyNow, nightGang);
            //주인공 측 쓰러짐
            if (isDown(hero, (NightGang) nightGang)) {
                if(nightGang.isGangZero())
                    System.out.println("조직원이 전부 쓰러졌습니다..");
                if(hero.isHpZero())
                    System.out.printf("%s 는 쓰러졌습니다..\n", hero.getName());

                break;
            }
        }
    }
    
    public boolean isSalary(Hero hero) { //영업사원 인지?
        return (hero.getJobNow() instanceof Salary);
    } //영업사원 인지?
    public boolean isNego() {
        return (enemyNow instanceof NegoEnemy);
    }

    public boolean isBoss() {
        return (enemyNow instanceof BossEnemy);
    }

    public boolean battleActChoice(Hero hero, Gangster nightGang,Inventory inventory, boolean esc) {
        System.out.println("\n행동을 선택하세요!\n");
        System.out.println("\t1. 싸운다");
        System.out.println("\t2. 인벤토리");
        System.out.println("\t3. 회유 (조건부)");
        System.out.println("\t4. 도망간다 (패거리 수와 주인공 체력에 큰 피해를 입습니다. 신뢰도도 감소합니다.)\n");

        String s = input.nextLine(); //숫자가 아니라 문자열을 입력하는 경우 고려
        switch (s) {
            case "1" -> {
                esc = false; // 그대로 전투 진행
            }
            case "2" -> {
                inventory.useItem(hero, (NightGang) nightGang);
                //함수 값 esc에 할당해 주기
                esc = battleActChoice(hero, nightGang, inventory, esc);//아이템 사용 후 다시 선택
            }
            case "3" -> checkNego(hero, nightGang, inventory); //회유 조건 체크

            case "4" -> {
                esc = true;
                //메세지 출력 추가
                System.out.printf("HP : %d -> %d\n", hero.getHp(), (int)(hero.getHp()*0.7));
                System.out.printf("돈 : %d -> %d\n", hero.getMoney(), (int)(hero.getMoney()*0.7));
                System.out.printf("조직원 수 : %d -> %d\n", nightGang.getGangCnt(),(int) (nightGang.getGangCnt() * 0.7));
                System.out.println("도망쳤습니다");
                //피해입는 실행문 추가
                hero.setHp((int)(hero.getHp() * 0.7));//hp 감소
                hero.setMoney((int) (hero.getMoney() * 0.7));// 돈 감소
                nightGang.setGangCnt((int) (nightGang.getGangCnt() * 0.7));// 조직원 감소
            } 
            default -> { //잘못 입력시
                System.out.println("올바른 값을 입력해 주세요.");
                esc = battleActChoice(hero, nightGang, inventory, esc);//재귀 사용
            }
        }
        return esc;
    }

    public void showBattleStat(Hero hero, Gangster enemy, Gangster nightGang) {
        System.out.println("\n---------------------------------------------------\n");
        System.out.printf("\t\t\t%s | GANG[%d / %d]\n",enemy.getName(), enemy.getGangCnt(), enemy.getFullGangCnt());
        System.out.println("\n---------------------------------------------------\n");
        System.out.printf("%s | GANG[%d / %d]\t%s | HP [%d / %d] MP [%d / %d]\n\n",
                nightGang.getName(), nightGang.getGangCnt(), nightGang.getFullGangCnt(),
                hero.getName(), hero.getHp(), hero.getFullHp(),hero.getJobNow().getMp(), hero.getJobNow().getFullMp());
    }
}
