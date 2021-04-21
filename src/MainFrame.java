import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static java.awt.event.KeyEvent.VK_ESCAPE;

public class MainFrame extends JFrame implements KeyListener, MouseListener {
    int cnt;
    int score;
    int lifeCounter;
    boolean startFromLastCheckPoint = false;
    boolean updateEnemies = false;
    boolean updatePrizes = false;
    boolean updateCheckPoints = false;
    boolean isWin = false;
    ArrayList<Object> objects;
    BufferedImage backGroundImg = ImageIO.read(new File("D:\\IdeaProjects\\Arcade\\src\\backGroundRock.png"));
    ArrayList<Ring> rings;
    ArrayList<CheckPoint> checkPoints;
    ArrayList<Platform> platforms;
    ArrayList<StativeEnemy> enemies;
    Hero hero;
    boolean j = false;
    ArrayList<Door> doors;
    boolean programIsRunning = false;

    boolean gameOver = false;
    ArrayList<Prize> prizes;
    public ArrayList<MovingBlock> movingBlocks;
    public ArrayList<Fireball> fireballs;
    public ArrayList<Lava> lava;
    BufferedImage heartFull;


    public MainFrame(Hero hero, ArrayList<Platform> platforms,ArrayList<StativeEnemy> enemies, ArrayList<Ring> rings,
                     ArrayList<Door> doors,ArrayList<Prize> prizes,ArrayList<MovingBlock> movingBlocks,
                     ArrayList<Fireball> fireballs, ArrayList<Lava> lava, ArrayList<CheckPoint> checkPoints,
                     ArrayList<Object> objects) throws IOException {
        this.objects = objects;
        this.heartFull = ImageIO.read(new File("D:\\IdeaProjects\\Arcade\\src\\heartFull.png"));
        this.fireballs = fireballs;
        this.doors = doors;
        this.lifeCounter = 5;
        this.prizes = prizes;
        this.checkPoints = checkPoints;
        this.movingBlocks = movingBlocks;
        Color c = new Color(161, 205, 212);
        this.setBackground(c);
        this.cnt = 0;
        this.score = 0;
        this.rings = rings;
        this.enemies = enemies;
        this.hero = hero;
        this.platforms = platforms;
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.lava = lava;

    }

    @Override
    public void paint(Graphics g) {
        BufferedImage img = null;
        BufferStrategy bufferStrategy = getBufferStrategy();
        if (bufferStrategy == null) {
            createBufferStrategy(2);
            bufferStrategy = getBufferStrategy();
        }
        g = bufferStrategy.getDrawGraphics();
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        Font font = new Font("Segoe Print", Font.BOLD, 20);

        g.setFont(font);

        if(startFromLastCheckPoint){
            hero.x = hero.checkPointX;
            hero.y = hero.checkPointY;
            hero.isOnFloor = true;
            hero.isMoving = false;
            hero.v = Math.abs(hero.v);
            isWin = false;
            updateEnemies = true;
            programIsRunning = true;
            hero.isCarrying = -1;
            for(int i = 0;i<movingBlocks.size();++i){
                movingBlocks.get(i).x = movingBlocks.get(i).left + 150;
            }
            startFromLastCheckPoint = false;
        }
        if(!programIsRunning && !gameOver){
            Color c = new Color(219, 184, 133);
            this.setBackground(c);
            g.setColor(Color.BLACK);
            //g.drawImage(woodImg,0,0,this.getWidth(),this.getHeight(),null);
            g.drawString("NEW GAME",600,300);
            g.drawString("RESUME",600,350);
            g.drawString("EXIT",600,400);
        }
        else if (gameOver || isWin){
            Color c = new Color(219, 184, 133);
            this.setBackground(c);
            g.setColor(Color.BLACK);
            //g.drawImage(woodImg,0,0,this.getWidth(),this.getHeight(),null);
            if (gameOver) g.drawString("GAME OVER!",600,300);
            else g.drawString("WELL DONE!",600,300);
            g.drawString("YOUR AMOUNT OF KILLS: " + cnt,600,350) ;
            g.drawString("YOUR SCORE: " + score,600,400);
            g.drawString("NEW GAME",600,450);
            g.drawString("EXIT", 600,500);
        }
        else{
            Color c = new Color(192, 216, 220);
            //Color c = new Color(219, 184, 133);
            this.setBackground(c);

            if(hero.x<9900){
                //g.drawImage(backGroundImg,0,0,this.getWidth(),this.getHeight(),null);
            }else if(hero.x<30000){

            }
            Color col = new Color(206, 174, 116);
            g.setColor(col);
            Graphics2D g2d = (Graphics2D) g;
            BasicStroke stroke = new BasicStroke(20);
            g2d.setStroke(stroke);
            //g.drawImage(imgg, 0,0,1200,800,null);
            for(int i=0;i<objects.size();++i){
                objects.get(i).draw(g,(int)hero.x, (int)hero.y);
            }
            for (int i = 0; i < platforms.size(); ++i) {
                platforms.get(i).draw(g, (int) hero.x, (int) hero.y);
            }
            for(int i=0;i<movingBlocks.size();++i){
                movingBlocks.get(i).draw(g,(int)hero.x, (int)hero.y);
            }
            for(int i=0;i<lava.size();++i){
                lava.get(i).draw(g,(int)hero.x, (int)hero.y);
            }
            for(int i=0;i<enemies.size();++i){
                StativeEnemy cur = enemies.get(i);
                cur.draw(g,(int)hero.x, (int)hero.y);
            }
            for(int i=0;i<rings.size();++i){
                rings.get(i).draw(g,(int)hero.x,(int)hero.y);
            }
            for(int i=0;i<doors.size();++i){
                doors.get(i).draw(g,(int)hero.x, (int)hero.y);
            }
            for(int i=0;i<prizes.size();++i){
                prizes.get(i).draw(g, (int)hero.x, (int)hero.y);
            }
            for(int i=0;i<checkPoints.size();++i){
                checkPoints.get(i).draw(g, (int)hero.x, (int)hero.y);
            }
            for(int i=0;i<fireballs.size();++i){
                fireballs.get(i).draw(g, (int)hero.x, (int)hero.y);
            }
            hero.draw(g);
            g.setColor(Color.BLACK);
            g.fillRect(1140,50,10,30);
            g.fillRect(1160,50,10,30);
            for(int i=0;i<lifeCounter;++i){
                g.drawImage(heartFull,20 + i*30,40, 25, 25,null);
            }
            g.drawString("kills: " + cnt,20,90);
            g.drawString("score: " + score,20,105);
        }

        g.dispose();
        bufferStrategy.show();
    }

    @Override
    public void keyPressed(KeyEvent e) {


        char c = e.getKeyChar();
        if (c == 'a' || c == 'A' || c == 'ф' || c == 'Ф') {
            hero.v = -Math.abs(hero.v);
            hero.isMoving = true;
        }
        if (c == 'd' || c == 'D' || c == 'в' || c == 'В') {
            hero.v = Math.abs(hero.v);
            hero.isMoving = true;
        }
        if (c == ' ' && hero.isOnFloor && hero.isCarrying == -1) {
            j = true;
            hero.y--;
            hero.vy = 2.4;
            hero.isOnFloor = false;
        }if(c == 'f' || c == 'F' || c == 'а' || c == 'А'){
            hero.checkIfInDoor();
        }if(c == 'e' || c == 'E' || c == 'у' || c == 'У'){
            hero.checkIfNearBox();
        }if(c == VK_ESCAPE){
            if(programIsRunning) programIsRunning = false;
            else if(!gameOver) programIsRunning = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        char c = e.getKeyChar();
        if((c == 'd' || c=='D' || c=='в' || c == 'В') && hero.v>0){
            hero.isMoving = false;
        }if((c == 'a' || c == 'A' || c == 'ф' || c == 'Ф') && hero.v<0){
            hero.isMoving = false;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        //System.out.println(x + " " + y);

        if(!programIsRunning && !gameOver && !isWin){
            if(x>=600 && x<=720 && y>=280 && y<=300){
                hero.x = 400;
                hero.y = 590;
                hero.isOnFloor = true;
                hero.isMoving = false;
                hero.v = Math.abs(hero.v);
                cnt = 0;
                updateEnemies = true;
                updatePrizes = true;
                updateCheckPoints = true;
                score = 0;
                isWin = false;
                programIsRunning = true;
                hero.isCarrying = -1;
                lifeCounter = 5;
                startFromLastCheckPoint = false;
                hero.checkPointX = 400;
                hero.checkPointY = 590;
                for(int i = 0;i<movingBlocks.size();++i){
                    movingBlocks.get(i).x = movingBlocks.get(i).left + 150;
                }
            }if(x>=600 && x<=700 && y >= 330 && y <= 350){
                programIsRunning = true;
            }if(x>=600 && x<=650 && y>= 380 && y<=400){
                System.exit(0);
            }
        }
        else if (gameOver || isWin){
            if(x>=600 && x<=720 && y>=430 && y<=450){
                hero.x = 400;
                hero.y = 590;
                isWin = false;
                hero.isOnFloor = true;
                updatePrizes = true;
                lifeCounter = 5;
                hero.isMoving = false;
                hero.v = Math.abs(hero.v);
                cnt = 0;
                gameOver = false;
                updateEnemies = true;
                updateCheckPoints = true;
                hero.isCarrying = -1;
                startFromLastCheckPoint = false;
                hero.checkPointX = 400;
                hero.checkPointY = 590;
                for(int i = 0;i<movingBlocks.size();++i){
                    movingBlocks.get(i).x = movingBlocks.get(i).left + 150;
                }
                score = 0;
                programIsRunning = true;
            }if(x>=600 && x<=650 && y>= 480 && y<=500){
                System.exit(0);
            }
        }
        else{
            if(x>=1140 && x<=1170 && y>=50 && y<=80){
                programIsRunning = false;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
