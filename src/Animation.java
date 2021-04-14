import java.awt.*;
import java.awt.image.BufferedImage;

public class Animation {
    public BufferedImage[] frames;

    public long timePerFrame;
    public long playingTime;

    public Animation (BufferedImage[] frames, long timePerFrame){
        this.frames = frames;
        this.timePerFrame = timePerFrame;
        this.playingTime = 0;
    }

    public void update(long dt) {
        long totalAnimationTime = timePerFrame * frames.length;
        playingTime = (playingTime + dt) % totalAnimationTime;
    }

    public void draw(Graphics g, int x, int y) {
        int i = (int) (playingTime / timePerFrame);
        BufferedImage currentFrame = frames[i];
        g.drawImage(currentFrame, x, y, null);
    }
}
