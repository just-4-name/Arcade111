import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Ring {
    public int x;
    public int y;
    public int r;
    public int x1;
    public int y1;
    public double timer;
    BufferedImage img = ImageIO.read(Main.class.getResourceAsStream("Circular_saw_blade (1).png"));

    public Ring (int x, int y, int r) throws IOException {
        this.x = x;
        this.y = y;
        this.r = r;
    }


    public void draw(Graphics g, int heroX, int heroY){
        x1 = x + (int) (r * Math.cos(timer));
        y1 = y + (int) (r * Math.sin(timer));
        int x2 = x + (int)((r-30)*Math.cos(timer));
        int y2 = y + (int)((r-30)*Math.sin(timer));
        int dx = heroX - 500;
        int dy = heroY - 300;
        Color c = g.getColor();
        Color c1 = new Color(106, 99, 98);
        g.setColor(c1);
        g.drawLine(x-dx,y-dy,x1-dx,y1-dy);
        g.fillRect(x2-dx-50,y2-dy-50,100,100);
        g.drawImage(img,x2-dx-75,y2-dy-75,150,150,null);
        g.setColor(c);
    }
    public boolean isIntersect(double x3,double y3, double x4, double y4){
        double x2 = x +  (r * Math.cos(timer));
        double y2 = y +  (r * Math.sin(timer));

        double denominator=(y4-y3)*(x-x2)-(x4-x3)*(y-y2);
        if (denominator == 0){
            if ( (x*y2-x2*y)*(x4-x3) - (x3*y4-x4*y3)*(x2-x) == 0 && (x*y2-x2*y)*(y4-y3) - (x3*y4-x4*y3)*(y2-y) == 0)  return true;
            else return false;
        }
        else{
            double numerator_a=(x4-x2)*(y4-y3)-(x4-x3)*(y4-y2);
            double numerator_b=(x-x2)*(y4-y2)-(x4-x2)*(y-y2);
            double Ua=numerator_a/denominator;
            double Ub=numerator_b/denominator;
            if (Ua >=0 && Ua <=1 && Ub >=0 && Ub <=1)  return true;
            else     return false;
        }

    }
}
