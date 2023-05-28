package RPG_project;

import javax.sound.sampled.LineUnavailableException;

//메인 클래스
public class Main {
    public static void main(String[] args) throws LineUnavailableException, InterruptedException {
        Game game = new Game();
        game.process();

    }
}
