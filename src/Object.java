import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Object{
    int x;
    int y;
    int width;
    int height;
    String type;
    BufferedImage img;
    public Object(int x, int y, int width, int height, BufferedImage img) throws IOException {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.img = img;
    }


    public void draw(Graphics g, int heroX, int heroY){
        int dx = heroX-500;
        int dy = heroY-300;
        g.drawImage(img, x-dx, y-dy, width, height, null);
    }
}
