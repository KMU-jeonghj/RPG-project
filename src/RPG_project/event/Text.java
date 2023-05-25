package RPG_project.event;

import java.util.Random;
import java.util.Scanner;

public class Text {
    Random rand = new Random();
    Scanner input = new Scanner(System.in);
    private String[][] chatScript = {
            {" : 한 순간의 선택이 인생을 좌우하지..." , " : 신중하게 선택하게, 자네의 깡패 삶이 바뀌게 될 테야"},
            {": 상대 패거리의 이름을 보고 특성을 파악해보게.", " : 공략하기 쉬워질 거야..."},
            {": 아직도 돈만 벌 생각을 하는 겐가?", " : 조직원의 신뢰를 얻어보려 노력해보게. 도움이 될 거야..."},
            {": 체력(hp)관리를 확실히 해야 할 거야.", " : 업무를 확실히 하지 않으면 월급이 삭감될테니..."},
            {": 나의 정체가 궁금하다고?", " : ... 오늘은 이만 가보도록 하지."},
            {": 낮동안 업무를 착실히 수행하게.", " : 관련된 능력이 향상될 거야..."},
            {": 조직을 이루는 건 첫째도, 둘째도 신뢰야..."},
            {": 두목의 얼굴을 아직 본 적이 없다고...?", " : 아무것도 아닐세..."},
            {": 예를 들어... 자네의 영업능력이 높아질수록...", " : 상대 패거리를 설득해 공격을 멈출 수도 있겠지..."},
            {": 계급이 높아질수록 상대할 수 있는 패거리도 강해지네."},
            {": 특정 년도가 된다면 특별한 일이 발생하는 법.", " : 신중하게 선택하게..."},
            {": 업무를 수행하면 관련된 기술을 더 잘 쓰게 될 거야."},
            {": ... 자네를 보고 있으면 내 어릴 적이 떠올라.", " : 나도 한때는..."},
            {": 모든 업무를 적당히 분배해서 수행하도록..."},
            {": 밤에 쉬는 것도 나쁘지 않지.", " : 다음 날 업무도 중요하니..."}
    };

    private String speaker1 = "정체불명의 노인";

    public String[][] getChatScript() {
        return chatScript;
    }

    public String getSpeaker1() {
        return speaker1;
    }

    public void printText(String[] text, String speaker) {
        System.out.println("╭╼|═══════════════════════════════════════════════════════════════════════════════════════════|╾╮");
        for (String s : text) {//향상된 for문
            System.out.println(speaker + s);
            input.nextLine(); //enter 키 입력 후 다음 대사 출력
        }
        System.out.println("╰╼|═══════════════════════════════════════════════════════════════════════════════════════════|╾╯");
    }

    public void printTextRand(String[][] text, String speaker) {
        int i = rand.nextInt(15);
        printText(text[i], speaker);
    }

}

