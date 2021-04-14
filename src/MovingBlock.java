import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MovingBlock {
    public int x;
    public int y;
    public int left;
    public int right;
    BufferedImage img;

    public MovingBlock(int x, int y, int left, int right, BufferedImage img) throws IOException {
        this.x = x;
        this.y = y;
        this.x = left + 150;
        this.left = left;
        this.right = right;
        this.img = img;
    }

    public void draw (Graphics g, int heroX, int heroY){
        int dx = heroX-500;
        int dy = heroY-300;
        g.drawImage(img,x-dx,y-dy,100,100,null);
    }
}
