import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Platform {
    public int x;
    public int y;
    public int length;
    public int height;
    BufferedImage img;


    public Platform(int x, int y, int length, int height, BufferedImage img) throws IOException {
        this.img = img;
        this.x = x;
        this.y = y;
        this.length = length;
        this.height = height;
    }

    public void draw(Graphics g, int heroX, int heroY) {
        int dx = heroX - 500;
        int dy = heroY - 300;
        //g.fillRect(x - dx, y - dy, length, height);
        g.drawImage(img,x - dx, y - dy, length, height,null);
    }
}
