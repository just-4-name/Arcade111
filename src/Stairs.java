import java.awt.*;
import java.awt.image.BufferedImage;

public class Stairs {
    public int x;
    public int y;
    public int length;
    public int height;
    BufferedImage img;


    public Stairs(int x, int y){
        this.x = x;
        this.y = y;
    }


    public boolean checkIfNearStairs(int heroX, int heroY){
        if(Math.abs(heroX - x)<=150 && heroY == y+height){
            return true;
        }return false;
    }

    public void draw(Graphics g, int heroX, int heroY){
        int dx = heroX - 700;
        int dy = heroY - 400;
        g.drawImage(img,x - dx,y - dy,null);
    }
}
