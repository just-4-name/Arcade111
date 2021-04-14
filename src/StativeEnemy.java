//110, 80


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StativeEnemy {

    public double x;
    public int y;
    public int left;
    public int right;
    public double speed;
    boolean flag = true;
    public int index;
    Animation zombieGoLeft;
    Animation zombieGoRight;

    public StativeEnemy(int y,int left, int right, double speed,Animation zombieGoRight, Animation zombieGoLeft, int index) throws IOException {
        this.index = index;
        this.zombieGoLeft = zombieGoLeft;
        this.zombieGoRight = zombieGoRight;
        this.y =y;
        this.speed = speed;
        this.left = left;
        this.right = right;
        x = left;
    }

    public void draw(Graphics g, int heroX, int heroY){
        int dx = heroX - 500;
        int dy = heroY - 300;
        //g.fillRect((int)x-dx,y-dy,30,30);
        if(speed>0) zombieGoRight.draw(g,(int)x-dx, y-dy);
        else zombieGoLeft.draw(g,(int)x-dx, y-dy);
    }


}
