import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Prize {
    int x;
    int y;
    int type;
    BufferedImage img;
    public Prize(int x, int y, int type) throws IOException {
        this.x = x;
        this.type  = type;
        this.y = y;
        if (type == 0) this.img = ImageIO.read(new File("D:\\IdeaProjects\\Arcade\\src\\prize.png"));
        if(type == 1) this.img = ImageIO.read(new File("D:\\IdeaProjects\\Arcade\\src\\heartFull.png"));
    }



    public void draw(Graphics g, int heroX, int heroY){
        int dx = heroX - 500;
        int dy = heroY - 300;
        g.drawImage(img, x - dx, y - dy,null);
    }
}
