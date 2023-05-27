package RPG_project.event;

import java.awt.Toolkit;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class Beep {
    public  float SAMPLE_RATE = 8000f;
    public  void tone(int hz, int msecs) throws LineUnavailableException {
        tone(hz, msecs, 1.0);
    }
    public  void tone(int hz, int msecs, double vol)
            throws LineUnavailableException {
        byte[] buf = new byte[1];
        AudioFormat af = new AudioFormat(SAMPLE_RATE, // sampleRate
                8, // sampleSizeInBits
                1, // channels
                true, // signed
                false); // bigEndian
        SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
        sdl.open(af);
        sdl.start();
        for (int i = 0; i < msecs * 8; i++) {
            double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;
            buf[0] = (byte) (Math.sin(angle) * 127.0 * vol);
            sdl.write(buf, 0, 1);
        }
        sdl.drain();
        sdl.stop();
        sdl.close();
    }

    public void playSong() throws LineUnavailableException, InterruptedException {
        Toolkit.getDefaultToolkit().beep();

        System.out.print("수");
        tone(466, 100, 0.5);
        System.out.print("요");
        tone(466, 100, 0.5);
        System.out.print("일");
        tone(466, 100, 0.5);
        System.out.print("엔 ");
        tone(466, 400, 0.5);
        System.out.print("빨");
        tone(440, 300, 0.5);
        System.out.print("간 ");
        tone(466, 200, 0.5);
        System.out.print("장");
        tone(440, 200, 0.5);
        System.out.print("미");
        tone(392, 200, 0.5);
        System.out.print("를~~ ");
        tone(349, 800, 0.5);
        System.out.print("우~");
        tone(294, 100, 0.5);
        System.out.println("~");
        tone(392, 800, 0.5);
        Thread.sleep(400);

        System.out.print("슬");
        tone(262, 100, 0.5);
        System.out.print("픈 ");
        tone(294, 100, 0.5);
        System.out.print("영");
        tone(311, 300, 0.5);
        System.out.print("화");
        tone(311, 100, 0.5);
        System.out.print("에");
        tone(311, 300, 0.5);
        System.out.print("서");
        tone(294, 100, 0.5);
        System.out.print("처");
        tone(262, 100, 0.5);
        tone(294, 100, 0.5);
        System.out.println("럼~~");
        tone(262, 600, 0.5);
        Thread.sleep(400);

        System.out.print("비");
        tone(349, 100, 0.5);
        System.out.print("내");
        tone(349, 100, 0.5);
        System.out.print("리");
        tone(392, 250, 0.5);
        System.out.print("는 ");
        tone(466, 100, 0.5);
        System.out.print("거");
        tone(466, 400, 0.5);
        System.out.print("리");
        tone(523, 250, 0.7);
        System.out.print("에");
        tone(587, 300, 0.9);
        System.out.println("서~~~~~");
        tone(523, 1000);
        Thread.sleep(600);

        System.out.print("무");
        tone(699, 300, 0.9);
        System.out.print("거");
        tone(699, 300, 0.9);
        System.out.print("운 ");
        tone(587, 300, 0.9);
        System.out.print("코");
        tone(784, 200, 0.9);
        System.out.print("트");
        tone(699, 100, 0.9);
        System.out.print("깃");
        tone(587, 200, 0.9);
        System.out.print("을 ");
        tone(523, 100, 0.9);
        tone(466, 200, 0.9);
        Thread.sleep(150);

        System.out.print("올");
        tone(523, 300, 0.7);
        System.out.print("려");
        tone(587, 200, 0.6);
        System.out.print("세");
        tone(523, 300, 0.5);
        System.out.print("우");
        tone(466, 150, 0.5);
        System.out.println("며~");
        tone(523, 600, 0.5);
        Thread.sleep(400);

        System.out.print("비");
        tone(392, 100, 0.5);
        System.out.print("오");
        tone(466, 100, 0.5);
        System.out.print("는 ");
        tone(523, 200, 0.5);
        System.out.print("수");
        tone(587, 300, 0.5);
        System.out.print("요");
        tone(523, 200, 0.5);
        System.out.print("일");
        tone(523, 100, 0.5);
        System.out.print("엔 ");
        tone(466, 300, 0.5);
        System.out.print("빨");
        tone(523, 200, 0.5);
        System.out.print("간 ");
        tone(554, 300, 0.5);
        System.out.print("장");
        tone(523, 300, 0.5);
        System.out.print("미");
        tone(466, 100, 0.5);
        System.out.println("를~~~~~~~");
        tone(466, 1000, 0.5);
    }
}
