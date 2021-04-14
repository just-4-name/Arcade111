import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

// width 80/ height 110
public class Hero {
    BufferedImage img_r;
    BufferedImage img_l;
    BufferedImage img_jump_r;
    BufferedImage img_jump_l;
    Animation heroGoRight;
    Animation heroGoLeft;
    ArrayList<Door> doors;
    ArrayList<MovingBlock> movingBlocks;
    int isCarrying = -1;
    int checkPointX = 400;
    int checkPointY = 590;
    public Hero(Animation heroGoRight, Animation heroGoLeft, ArrayList<Door> doors, ArrayList<MovingBlock> movingBlocks) throws IOException {
        this.doors = doors;
        this.movingBlocks = movingBlocks;
        this.heroGoRight = heroGoRight;
        this.heroGoLeft = heroGoLeft;
        this.img_r = ImageIO.read(new File("D:\\IdeaProjects\\Arcade\\src\\player_stand_right.png"));
        this.img_l = ImageIO.read(new File("D:\\IdeaProjects\\Arcade\\src\\player_stand_left.png"));
        this.img_jump_r = ImageIO.read(new File("D:\\IdeaProjects\\Arcade\\src\\player_jump_right.png"));
        this.img_jump_l = ImageIO.read(new File("D:\\IdeaProjects\\Arcade\\src\\player_jump_left.png"));
    }

    public boolean isMoving = false;
    public double x = 400;
    public double y = 590;
//    public double x = 500;
//    public double y = 4890;
    public boolean isOnFloor = true;
    public double vy = 0;
    public double v = 0.5;

    public void draw(Graphics g) {
        //g.fillOval(400, 400, 30, 50);
        //g.drawImage(this.img,400,400,30,50,null);
        if(isOnFloor && !isMoving) {
            if (v > 0) g.drawImage(this.img_r, 500, 300, null);
            else g.drawImage(this.img_l, 500, 300, null);
        }else if (!isOnFloor){
            if (v > 0) g.drawImage(this.img_jump_r, 500, 300, null);
            else g.drawImage(this.img_jump_l, 500, 300, null);
        }else{
            if(v>0){
                heroGoRight.draw(g,500, 300);
            }else{
                heroGoLeft.draw(g,(int)500,300);
            }
        }
    }

    public void checkIfInDoor(){
        for(int i=0;i<doors.size();++i){
            if(this.x>=doors.get(i).x1 && this.x<=doors.get(i).x1+150 && this.y+110 == doors.get(i).y1 + 150){
                this.x = doors.get(i).x2;
                this.y = doors.get(i).y2+150-110;
            }else if(this.x>=doors.get(i).x2 && this.x<=doors.get(i).x2+150 && this.y+110 == doors.get(i).y2 + 150){
                this.x = doors.get(i).x1;
                this.y = doors.get(i).y1+150-110;
            }
        }
    }


    public void checkIfNearBox(){
        if(isCarrying!=-1) {
            isCarrying = -1;
            return;
        }
        for(int i=0;i<movingBlocks.size();++i){
            MovingBlock cur = movingBlocks.get(i);
            if(y+110 == cur.y + 100){
                if(x<cur.x && x>cur.x-250){
                    x = cur.x-80;
                    isCarrying = i;
                    return;
                }if(x>cur.x && x<cur.x+250){
                    x = cur.x;
                    isCarrying = i;
                    return;
                }
            }
        }
    }
}
