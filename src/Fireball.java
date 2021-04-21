import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Fireball {
    public int interval;
    public double change;
    public int y;
    public int direction;
    public int right;
    public int left;
    BufferedImage img = ImageIO.read(Main.class.getResourceAsStream("Fireball.png"));

    public Fireball(int y, int direction, int left, int right, int interval) throws IOException {
        this.y = y;
        this.direction = direction;
        this.left = left;
        this.right = right;
        this.interval = interval;
    }


    public void draw(Graphics g, int heroX, int heroY){
        int dx = heroX - 500;
        int dy = heroY - 300;
        if(direction>0) {
            for (int i = left + (int) change; i < right; i += interval) {
                g.drawImage(img,i - dx, y - dy, 100, 100,null);
            }
        }else{
            for (int i = right - (int) change; i > left; i -= interval) {
                g.drawImage(img,i - dx, y - dy, 100, 100,null);
            }
        }
    }
}
