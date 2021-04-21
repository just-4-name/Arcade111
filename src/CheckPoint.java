import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CheckPoint {
    int x;
    int y;
    BufferedImage img;

    public CheckPoint(int x, int y) throws IOException {
        this.x = x;
        this.y = y;
        this.img = ImageIO.read(Main.class.getResourceAsStream("check_point.png"));;
    }

    public void draw(Graphics g, int heroX, int heroY){
        int dx = heroX-500;
        int dy = heroY-300;
        g.drawImage(img, x - dx, y - dy,null);
    }
}
