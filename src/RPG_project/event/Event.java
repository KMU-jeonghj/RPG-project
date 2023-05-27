package RPG_project.event;

import java.util.Scanner; //혼선을 방지하기 위해 필요한 클래스마다 임포트
import RPG_project.character.*; //다른 패키지이므로 import
import RPG_project.character.enemy.*;

import javax.sound.sampled.LineUnavailableException;

/*
접근자 { getMoney(), getGangCnt() 등}
설정자 { setHp(int hp), gainHp(int hp), loseMoney(int money) 등}
을 이용한 멤버 접근 바랍니다.

각 클래스에 표기해놓았으니 다양한 기능이 있는 설정자들을 활용해주시기바랍니다.
(ex: gain, lose, zero, fill 등)
 */

public class Event {
    Scanner input = new Scanner(System.in); //스캐너 객체 생성
    private Beep wedRose = new Beep(); // Beep 객체 생성

    //----------------------------------------
    //필드
    int choice97, choice08;
    int choice13_1 = 0, choice13_2 = 0;
    //----------------------------------------


    //다른 클래스(Hero, Gangster)에 '접근'하기 위해 객체를 매개변수로 넣어준다.↓
    public void switchEvent(int year, Hero hero, Gangster gangster) throws LineUnavailableException, InterruptedException
    {
        switch(year) {
            case 1985:
                eventSong(hero); break;
            case 1990:
                eventWar(hero, gangster); break;
            case 1997:
                eventIMF(hero); break;
            case 2002:
                eventWordCup(hero); break;
            case 2008:
                eventChoiceLife(hero, gangster); break;
            case 2013:
                eventChoiceLife2(hero, gangster); break;
            case 2017:
                event97(hero, gangster); break;
            case 2023:
                ending(hero); break;
        }
    }

    public void eventSong(Hero hero) throws LineUnavailableException, InterruptedException {
        System.out.println("[1985년, " + hero.getName()+"의 애창곡 \"수요일엔 빨간 장미를\"이 발매됐다]");
        System.out.println("[노래 시작 : 소리 on 후 enter, 기다리기]"); input.nextLine();
        wedRose.playSong();
    }

    public void eventWar(Hero hero, Gangster gangster) {
        System.out.println("[1990년, 정부는 범죄와의 전쟁을 선포하였다]");
        input.nextLine();
        System.out.println("[지난 주에는 경쟁 조직 [붉은 손톱]의 두목이 경찰에 끌려갔다]");
        input.nextLine();
        System.out.println("...");
        input.nextLine();
        System.out.println("[조직 내 세력이 나뉘었다]");
        input.nextLine();

        System.out.println("[세력1 : 깡패로서 자존심을 굽힐 수 없습니다.]");
        System.out.println("[세력2 : 일단은 굽히고 훗날을 기약해야 합니다.]");
        input.nextLine();

        //입력받기
        System.out.print("[1 혹은 2를 입력하세요] 세력 ");
        int event90 = input.nextInt();
        int minusMoney;

        if (event90 == 1){
            //설정자 loseGangCnt 와 접근자 getGangCnt 사용
            gangster.loseGangCnt((int)(gangster.getGangCnt() * 0.3));//접근자와 설정자로 캡슐화된 멤버를 조작한다.
            System.out.println("[무리한 활동으로 인해 조직원의 30%가 수감되었습니다]");
            input.nextLine();
            System.out.println("현재 나의 조직원 수 :" + gangster.getGangCnt() + "명");
            input.nextLine();

            minusMoney = (int)(hero.getMoney() * 0.15);
            hero.loseMoney(minusMoney);
            System.out.println("[무리한 활동으로 인해 벌금 " + minusMoney + "이 부과되었습니다]");
            input.nextLine();
            System.out.println("현재 나의 재산 :" + hero.getMoney() + "원");
            input.nextLine();
        }
        else if(event90 == 2) {
            gangster.loseGangCnt((int)(gangster.getGangCnt()* 0.1));
            System.out.println("[당신의 유연한 대처로 조직원의 10%만이 수감되었습니다]");
            input.nextLine();
            System.out.println("현재 나의 조직원 수 :" + gangster.getGangCnt() + "명");
            input.nextLine();
        }
    }

    public void eventIMF(Hero hero) {
        System.out.println("[1997년 국가의 경제가 급격히 기울기 시작했다]");
        input.nextLine();
        System.out.println("[국가부도, " + hero.getName() + "은 이자를 걷을지 말지 고민중이다]");
        System.out.print("1. 걷는다\t2. 걷지 않는다  ");

        choice97 = input.nextInt();
        input.nextLine();

        if(choice97 == 1){
            System.out.println("["+ hero.getName() +"은 이자를 걷었다]");
            input.nextLine();
            System.out.println("[그런 " +hero.getName()+ "를 손가락질하는 이들이 생겨났다]");
            input.nextLine();

        } else if (choice97 == 2) {
            hero.loseMoney((int)(hero.getMoney() * 0.1));
            System.out.println("[" + hero.getName() +"의 재산이 10% 감소했다]");
            input.nextLine();
            System.out.println("[그런 " +hero.getName()+ "를 우러러보는 이들이 생겨났다]");
            System.out.println("현재 재산 :" + hero.getMoney() + "원");
        }
    }

    public void eventWordCup(Hero hero) {
        System.out.println("[2002년 6월, 한국과 @@@의 경기가 진행 중이다]\n"
                + "(@@@은 2002년 한국과 경기했던 나라 중 랜덤으로 결정됨)");
        input.nextLine();
        System.out.println("[한국과 @@@ 중 어느 곳에 재산을 걸 것인가?]");
        System.out.print("1. 한국 \t2. @@@\t3. 걸지 않는다: ");
        int choice02 = input.nextInt();

        if(choice02 == 1){
            System.out.println("[2002년 6월 22일 한국은 스페인을 꺾고 4강에 진출했다]");
            input.nextLine();
            System.out.println(hero.getName() +"의 재산이 10% 증가했다");

            hero.gainMoney((int)(hero.getMoney() * 0.1)); //10% 증가
            System.out.println("현재 재산 : " + hero.getMoney()+ "원");

        } else if (choice02 == 2) {
            System.out.println("[2002년 6월 22일 한국은 스페인을 꺾고 4강에 진출했다]");
            input.nextLine();
            System.out.println(hero.getName() +"의 재산이 5% 감소했다");
            hero.loseMoney((int)(hero.getMoney() * 0.05));
            System.out.println("현재 재산 : " + hero.getMoney()+ "원");
        } else if (choice02 == 3) {
            System.out.println("[2002년 6월 22일 한국은 스페인을 꺾고 4강에 진출했다]");
            input.nextLine();
        }
    }

    public void eventChoiceLife(Hero hero, Gangster gang) {
        System.out.println("[2008년, " + hero.getName() + "에게 뜻밖의 제안이 들어온다]\n"
                + "[깡패 인생을 좌우할 선택이니 신중하도록 하자]\n");
        input.nextLine();
        System.out.println("  ∧ ∧\r\n"
                + " (´･ω･)  =3\r\n"
                + " /　 ⌒ヽ\r\n"
                + "(人＿＿つ_つ");
        System.out.print("[제1야당 소속 국회의원 김의원]\n자네, 대통령 밑에서 일해볼 생각 없는가?"
                + "\n이번 대선 기간동안 내가 대통령이 되도록 일 좀 처리해주게...\n");
        input.nextLine();
        System.out.println("♪　∧,＿∧\r\n"
                + "　 　(´･ω･`) ))\r\n"
                + "　(( (　つ　ヽ、　♪\r\n"
                + "　　　〉 とノ　)))\r\n"
                + "　　（__ノ^(＿)");
        System.out.print("\n[국내 1위 엔터테인먼트 대표 이대표]\n2020년에 k-pop이 빌보드에 진출하기 위해 당신의 도움이 절실해요.\n");
        input.nextLine();
        System.out.println("　　∧＿∧\r\n"
                + "　（´・ω・)つ＿ ∧\r\n"
                + "　（つ　  / (・ω・｡)\r\n"
                + "　   しーＪ　 (nnノ)");
        System.out.println("\n[" + hero.getName() + "이 속한 조직 "+gang.getName()+"의 두목 박제일]");
        System.out.println("내 밑에 남아 조직 일에 충실하거라. 때가 되면 알게 될 것이다.");
        input.nextLine();
        System.out.println("1. 김의원\t2. 이대표\t3. 박제일");
        System.out.print("함께할 파트너를 선택하세요 : ");

        choice08 = input.nextInt();
        System.out.println("[2008년 한 해동안 당신은 파트너와 끈끈한 우정을 쌓으며 깡패 커리어를 써나갑니다]");
        input.nextLine();
    }

    public void eventChoiceLife2(Hero hero, Gangster gang) {
        if(choice08 == 3) {
            System.out.println("[2008년 조직 일에 충실하기로 결정한 당신에게 두 번째 선택의 순간이 찾아왔습니다.]");
            input.nextLine();
            System.out.println("[재선을 결심한 국회의원 김의원이 또 다시 파트너를 제안해옵니다]");
            input.nextLine();
            System.out.println("[2013년 아이돌 그룹 데뷔를 앞둔 엔터테인먼트 대표 이대표 또한 파트너를 제안해옵니다]");
            input.nextLine();
            System.out.print("1. 김의원\t 2. 이대표\t 3.박제일\t 선택 : ");
            choice13_1 = input.nextInt();
            input.nextLine();
            System.out.println("[2013년도 한 해동안 당신은 파트너와 끈끈한 우정을 쌓으며 깡패 커리어를 써나갑니다]");
            input.nextLine();
        }
        else {
            System.out.println("[2008년 두목 박제일에게 충실하기를 거부한 당신에게 두 번째 선택의 순간이 찾아왔습니다]");
            input.nextLine();
            System.out.println("두목 박제일: 지금 하는 일에서 손 떼고 조직 일 제대로 배워보자.");
            input.nextLine();
            System.out.print("1. 수락한다\t 2. 거절한다\t 선택 : ");
            choice13_2 = input.nextInt();
            System.out.println("[2013년도 한 해동안 당신은 파트너와 끈끈한 우정을 쌓으며 깡패 커리어를 써나갑니다]");
            input.nextLine();
        }
    }

    public void event97(Hero hero, Gangster gang) {
        if(choice97 == 1){
            hero.loseMoney((int)(hero.getMoney() * 0.05));
            System.out.println("["+ hero.getName() +"의 고객 중 한 명이 찾아왔다]\n"
                    + "[1997년 높은 이자를 걷었던 고객 중 하나가 현재" +hero.getName()+ "의 자금줄이었던 것이다]");
            input.nextLine();
            System.out.println("[1997년의 한 고객: 이런, 당신이 그였다니... 더 이상의 자금 거래는 없습니다.]");
            input.nextLine();
            System.out.println("[" + hero.getName() + "의 재산이 5% 감소했습니다]");
        } else if (choice97 == 2) {
            hero.gainMoney((int)(hero.getMoney() * 0.1));
            System.out.println("["+ hero.getName() +"의 고객 중 한 명이 찾아왔다]\n"
                    + "[1997년 이자를 걷지 않았던 한 고객은 현재 " +hero.getName()+ "의 큰 자금줄이었던 것이다]");
            input.nextLine();
            System.out.println("[1997년의 한 고객: \"이런, 당신이 그였다니... 그땐 정말 고마웠어요\"]");
            input.nextLine();
            System.out.println("[" + hero.getName() + "의 재산이 10% 증가했습니다]");
            input.nextLine();
        }
    }

    public void ending(Hero hero) throws InterruptedException{
        System.out.println("♡.          ★ 。* 。\r\n"
                + "° 。 ° ˛˚˛   _Π_____*。*˚\r\n"
                + "˚ ˛ •˛•˚ */______,/ ~＼˛\r\n"
                + "˚ ˛ •˛• ˚｜田  田｜門｜ ˚");
        System.out.println("[2023년의 어느 밤]"); input.nextLine();

        System.out.println("[거친 인생을 살아온 탓인지, 68세밖에 되지 않았지만 오늘 밤이 마지막이라는 사실을 " + hero.getName() +"은 직감한다]");
        input.nextLine();
        if((choice13_1 == 3 || choice13_1 == 2) && choice13_2 == 0) {
            System.out.println("[" + hero.getName()+ ": 그때 두목을 선택했더라면... 깡패로서 조금 더 당당할 수 있었을까...]");
            input.nextLine();
        }
        else if(choice13_1 == 0 && choice13_2 == 1) {
            System.out.println("[" + hero.getName() + ": 그 때 두목을 선택하길... 정말 잘했어...");
            input.nextLine();
        }
        System.out.println("●▅▇█▇▆▅▄▇");
        System.out.println("[침대에 누워 지난 날들을 되돌아봅니다.]"); input.nextLine();
        System.out.println("[두 눈이 스르륵 감깁니다.]"); input.nextLine();
        System.out.println("　　　 ＼｜／\r\n"
                + "~)　 －━◎━－　 (~\r\n"
                + "~⌒)　 ／｜＼　 ( ⌒\r\n"
                + "⌒ ⌒)   END　(⌒ ⌒\r\n"
                + "⌒　⌒ )　　( ⌒　⌒\r\n"
                + "-────―────-─\r\n"
                + "￣_-￣－￣－_￣_－￣_\r\n"
                + "-￣－_￣－_￣－_￣－￣\r\n"
                + "－￣_ -￣_－￣－_￣-￣\r\n"
                + "￣_-￣－￣－_￣－_￣‐");
    }

}
