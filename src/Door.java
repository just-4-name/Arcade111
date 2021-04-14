//150,150

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Door {
    public int x1;
    public int y1;
    public int x2;
    public int y2;
    BufferedImage doorImg;


    public Door(int x1,int y1,int x2,int y2) throws IOException {
        this.doorImg = ImageIO.read(new File("D:\\IdeaProjects\\Arcade\\src\\doorImage.png"));
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }


    public void draw (Graphics g, int heroX, int heroY){
        int dx = heroX - 500;
        int dy = heroY - 300;
        g.drawImage(doorImg,x1-dx,y1-dy,150,150,null);
        g.drawImage(doorImg,x2-dx,y2-dy,150,150,null);
    }
}
