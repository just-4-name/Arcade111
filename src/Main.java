//1200,800
//lava shipi karta raznie platformi


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ArrayList<CheckPoint> checkPoints = new ArrayList<>();
        ArrayList<Door> doors = new ArrayList<>();
        ArrayList<Fireball> fireballs = new ArrayList<>();
        ArrayList<Object> objects = new ArrayList<>();

        BufferedImage dessertStoneImg = ImageIO.read(new File("D:\\IdeaProjects\\Arcade\\src\\dessertStone.png"));
        BufferedImage dessertBush1Img = ImageIO.read(new File("D:\\IdeaProjects\\Arcade\\src\\bush1.png"));
        BufferedImage dessertBush2Img = ImageIO.read(new File("D:\\IdeaProjects\\Arcade\\src\\bush2.png"));
        BufferedImage arrowRightImg = ImageIO.read(new File("D:\\IdeaProjects\\Arcade\\src\\Arrow_Right.png"));
        BufferedImage dessertTreeImg = ImageIO.read(new File("D:\\IdeaProjects\\Arcade\\src\\dessertTree.png"));
        BufferedImage dessertGrass1Img = ImageIO.read(new File("D:\\IdeaProjects\\Arcade\\src\\dessertGrass1.png"));
        BufferedImage dessertGrass2Img = ImageIO.read(new File("D:\\IdeaProjects\\Arcade\\src\\dessertGrass2.png"));
        BufferedImage skeletonImg = ImageIO.read(new File("D:\\IdeaProjects\\Arcade\\src\\Skeleton.png"));
        BufferedImage dessertBoxImg = ImageIO.read(new File("D:\\IdeaProjects\\Arcade\\src\\dessertBox.png"));

        BufferedImage dessertPlatformLong = ImageIO.read(new File("D:\\IdeaProjects\\Arcade\\src\\dessertPlatform1000.png"));
        BufferedImage dessertPlatformLeft = ImageIO.read(new File("D:\\IdeaProjects\\Arcade\\src\\dessertPlatformLeft.png"));
        BufferedImage dessertPlatformRight = ImageIO.read(new File("D:\\IdeaProjects\\Arcade\\src\\dessertPlatformRight.png"));
        BufferedImage dessertPlatformMiddle = ImageIO.read(new File("D:\\IdeaProjects\\Arcade\\src\\dessertPlatformMiddle.png"));

        objects.add(new Object(600,630,70,70,arrowRightImg));
        objects.add(new Object(50,440,310,260,dessertTreeImg));
        objects.add(new Object(820,400,100,50,dessertGrass1Img));
        objects.add(new Object(950,400,100,50,dessertGrass1Img));
        objects.add(new Object(980,400,100,50,dessertGrass1Img));
        objects.add(new Object(500,150,150,50,skeletonImg));
        objects.add(new Object(275,155,90,45,dessertGrass2Img));
        objects.add(new Object(310,150,100,50,dessertGrass2Img));
        objects.add(new Object(1650,450,100,50,dessertGrass1Img));
        objects.add(new Object(1900,450,100,50,dessertGrass1Img));
        objects.add(new Object(2900,400,165,100,dessertBush1Img));
        objects.add(new Object(3400,465,70,35,dessertGrass2Img));
        objects.add(new Object(3320,465,70,35,dessertGrass2Img));
        objects.add(new Object(3290,465,70,35,dessertGrass2Img));
        objects.add(new Object(3800,-1580,100,50,dessertGrass1Img));
        objects.add(new Object(4700,-1960,310,260,dessertTreeImg));
        objects.add(new Object(5200,-1750,150,50,skeletonImg));
        objects.add(new Object(4650,-1750,100,50,dessertGrass1Img));
        objects.add(new Object(5400,-1750,100,50,dessertGrass1Img));
        objects.add(new Object(5450,-1750,100,50,dessertGrass1Img));
        objects.add(new Object(6500,-2400,165,100,dessertBush2Img));
        objects.add(new Object(6900,-2400,165,100,dessertBush2Img));
        objects.add(new Object(7000,-2400,165,100,dessertBush2Img));
        objects.add(new Object(7900,-2400,165,100,dessertBush2Img));
        objects.add(new Object(8650,-2600,160,100,dessertBush2Img));
        objects.add(new Object(9900,-2600,160,100,dessertBush2Img));
        objects.add(new Object(9000,-2550,100,50,dessertGrass2Img));
        objects.add(new Object(9030,-2550,100,50,dessertGrass2Img));
        objects.add(new Object(10250,-2400,200,100,dessertStoneImg));
        objects.add(new Object(10800,-2400,160,100,dessertBush2Img));
        objects.add(new Object(12130,-3350,100,50,dessertGrass1Img));



        //List of Fireballs
        fireballs.add(new Fireball(-2400,-1,5000,15000,1500));


        ArrayList<Lava> lava = new ArrayList<>();

        lava.add(new Lava(13300, 3650, 100,50,0));
        lava.add(new Lava(11600, 4950, 100,50,0));
        lava.add(new Lava(10600, 4950, 100,50,0));
        lava.add(new Lava(15100, 1950, 100,50,0));
        lava.add(new Lava(15350, 1950, 100,50,0));
        lava.add(new Lava(15600, 1950, 100,50,0));
        lava.add(new Lava(860,655,70,45,2));
        lava.add(new Lava(900,640,90,60,2));
        lava.add(new Lava(400,100,100,100,1));
        lava.add(new Lava(2200,600,100,100,3));
        lava.add(new Lava(4000,-1630,100,100,3));
        lava.add(new Lava(3600,-1630,100,100,1));
        lava.add(new Lava(7600,-2400,100,100,1));
        lava.add(new Lava(8200,-2400,100,100,1));
        lava.add(new Lava(9200,-2400,100,100,3));
        lava.add(new Lava(9400,-2400,100,100,3));
        lava.add(new Lava(9500,-2345,70,45,2));
        lava.add(new Lava(8900,-2345,70,45,2));
        lava.add(new Lava(9000,-2345,70,45,2));
        lava.add(new Lava(9120,-2345,70,45,2));
        lava.add(new Lava(8740,-2345,70,45,2));
        lava.add(new Lava(8840,-2345,70,45,2));
        lava.add(new Lava(8610,-2345,70,45,2));
        lava.add(new Lava(9700,-2345,70,45,2));
        lava.add(new Lava(9730,-2345,70,45,2));
        lava.add(new Lava(9900,-2345,70,45,2));
        lava.add(new Lava(9950,-2345,70,45,2));
        lava.add(new Lava(10000,-2345,70,45,2));
        lava.add(new Lava(12300,-3400,100,100,1));
        for(int i=11000;i<=13300;i+=100) lava.add(new Lava(i,-2360,90,60,2));





        // list of checkPoints
        checkPoints.add(new CheckPoint(2510, 430));
        checkPoints.add(new CheckPoint(5850,-1970));
        checkPoints.add(new CheckPoint(10000,-2570));

        ArrayList<Prize> prizes = new ArrayList<>();
        BufferedImage[] heroRight = new BufferedImage[2];
        BufferedImage[] heroLeft = new BufferedImage[2];
        BufferedImage[] zombieRight = new BufferedImage[2];
        BufferedImage[] zombieLeft = new BufferedImage[2];
        zombieRight[0] = ImageIO.read(new File("D:\\IdeaProjects\\Arcade\\src\\zombie_walk1_right.png"));
        zombieRight[1] = ImageIO.read(new File("D:\\IdeaProjects\\Arcade\\src\\zombie_walk2_right.png"));
        zombieLeft[0] = ImageIO.read(new File("D:\\IdeaProjects\\Arcade\\src\\zombie_walk1_left.png"));
        zombieLeft[1] = ImageIO.read(new File("D:\\IdeaProjects\\Arcade\\src\\zombie_walk2_left.png"));

        heroRight[0] = ImageIO.read(new File("D:\\IdeaProjects\\Arcade\\src\\player_walk_right.png"));
        heroRight[1] = ImageIO.read(new File("D:\\IdeaProjects\\Arcade\\src\\player_walk1_right.png"));
        heroLeft[0] = ImageIO.read(new File("D:\\IdeaProjects\\Arcade\\src\\player_walk_left.png"));
        heroLeft[1] = ImageIO.read(new File("D:\\IdeaProjects\\Arcade\\src\\player_walk1_left.png"));

        Animation heroGoRight = new Animation(heroRight, 900000);
        Animation heroGoLeft = new Animation(heroLeft, 900000);
        Animation zombieGoRight = new Animation(zombieRight, 1000000);
        Animation zombieGoLeft = new Animation(zombieLeft, 1000000);

        ArrayList<Animation> animations = new ArrayList<Animation>();

        animations.add(heroGoRight);
        animations.add(heroGoLeft);
        animations.add(zombieGoLeft);
        animations.add(zombieGoRight);


        ArrayList<Ring> rings = new ArrayList<Ring>();


        //listOfRings
        rings.add(new Ring(2220, 260, 220));
        rings.add(new Ring(5300,-2050,300));
        rings.add(new Ring(12950,-3450,300));


        ArrayList<MovingBlock> movingBlocks = new ArrayList<>();

        movingBlocks.add(new MovingBlock(3700, 20, 3700, 4450, dessertBoxImg));


        Hero hero = new Hero(heroGoRight, heroGoLeft, doors, movingBlocks);
        ArrayList<Platform> platforms = new ArrayList<Platform>();


        //List of Doors
        doors.add(new Door(8900,-2650,9650,-2650));
        doors.add(new Door(11100,-2650,13000,-2650));



        //ListOfPlatforms

        platforms.add(new Platform(800, 450, 100, 100, dessertPlatformLeft));
        platforms.add(new Platform(899, 450, 100, 100, dessertPlatformMiddle));
        platforms.add(new Platform(998, 450, 100, 100, dessertPlatformRight));

        platforms.add(new Platform(-99, 700, 100, 100, dessertPlatformLeft));
        platforms.add(new Platform(0, 700, 1000, 100, dessertPlatformLong));
        platforms.add(new Platform(999, 700, 1000, 100, dessertPlatformLong));
        platforms.add(new Platform(1998, 700, 1000, 100, dessertPlatformLong));
        platforms.add(new Platform(2997, 700, 1000, 100, dessertPlatformLong));

        platforms.add(new Platform(1600,500,100,100,dessertPlatformLeft));
        platforms.add(new Platform(1699,500,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(1798,500,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(1897,500,100,100,dessertPlatformRight));


        platforms.add(new Platform(200, 200, 100, 100, dessertPlatformLeft));
        platforms.add(new Platform(299, 200, 100, 100, dessertPlatformMiddle));
        platforms.add(new Platform(398, 200, 100, 100, dessertPlatformMiddle));
        platforms.add(new Platform(497, 200, 100, 100, dessertPlatformMiddle));
        platforms.add(new Platform(596, 200, 100, 100, dessertPlatformRight));

        platforms.add(new Platform(2170,190,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(2500, 500, 1000, 100, dessertPlatformLong));
        platforms.add(new Platform(2750, 320, 100 ,100, dessertPlatformMiddle));
        platforms.add(new Platform(3050, 220, 100, 100, dessertPlatformMiddle));
        platforms.add(new Platform(3350, 120, 100, 100, dessertPlatformMiddle));
        platforms.add(new Platform(3750, 120, 1000, 100, dessertPlatformLong));
        platforms.add(new Platform(3651,120,100,100,dessertPlatformLeft));
        platforms.add(new Platform(4749,120,100,100,dessertPlatformRight));
        platforms.add(new Platform(4400,-280,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(4200,-530,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(4400,-780,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(4200,-1030,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(4400,-1280,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(4199,-1530,100,100,dessertPlatformRight));
        platforms.add(new Platform(3200,-1530,1000,100,dessertPlatformLong));
        platforms.add(new Platform(3101,-1530,100,100,dessertPlatformLeft));
        platforms.add(new Platform(4402,-1700,100,100,dessertPlatformLeft));
        platforms.add(new Platform(4501,-1700,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(4600,-1700,1000,100,dessertPlatformLong));
        platforms.add(new Platform(5599,-1700,100,100,dessertPlatformRight));
        platforms.add(new Platform(5151, -2100, 100, 100, dessertPlatformLeft));
        platforms.add(new Platform(5250, -2100, 100, 100, dessertPlatformMiddle));
        platforms.add(new Platform(5349, -2100, 100, 100, dessertPlatformRight));
        platforms.add(new Platform(5800,-1900,100,100,dessertPlatformLeft));
        platforms.add(new Platform(5899,-1900,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(5998,-1900,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(6097,-1900,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(6196,-1900,100,100,dessertPlatformRight));
        platforms.add(new Platform(5950,-1999,100,100,dessertBoxImg));
        platforms.add(new Platform(6049,-1999,100,100,dessertBoxImg));
        platforms.add(new Platform(6148,-1999,100,100,dessertBoxImg));
        platforms.add(new Platform(6020,-2098,100,100,dessertBoxImg));
        platforms.add(new Platform(6119,-2098,100,100,dessertBoxImg));
        platforms.add(new Platform(6401,-2300,100,100,dessertPlatformLeft));
        platforms.add(new Platform(6500,-2300,1000,100,dessertPlatformLong));
        platforms.add(new Platform(7499,-2300,1000,100,dessertPlatformLong));
        platforms.add(new Platform(8498,-2300,1000,100,dessertPlatformLong));
        platforms.add(new Platform(9497,-2300,1000,100,dessertPlatformLong));
        platforms.add(new Platform(10496,-2300,1000,100,dessertPlatformLong));
        platforms.add(new Platform(11495,-2300,1000,100,dessertPlatformLong));
        platforms.add(new Platform(12494,-2300,1000,100,dessertPlatformLong));
        platforms.add(new Platform(13493,-2300,1000,100,dessertPlatformLong));
        platforms.add(new Platform(14492,-2300,100,100,dessertPlatformRight));
        platforms.add(new Platform(8603,-2500,100,100,dessertPlatformLeft));
        platforms.add(new Platform(8702,-2500,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(8801,-2500,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(8900,-2500,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(8999,-2500,100,100,dessertPlatformRight));
        platforms.add(new Platform(9603,-2500,100,100,dessertPlatformLeft));
        platforms.add(new Platform(9702,-2500,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(9801,-2500,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(9900,-2500,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(9999,-2500,100,100,dessertPlatformRight));
        platforms.add(new Platform(11000,-2500,100,100,dessertPlatformLeft));
        platforms.add(new Platform(11099,-2500,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(11198,-2500,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(11297,-2500,100,100,dessertPlatformRight));
        platforms.add(new Platform(11500,-2700,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(11700,-2900,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(11900,-3100,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(12100,-3300,100,100,dessertPlatformLeft));
        platforms.add(new Platform(12199,-3300,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(12298,-3300,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(12397,-3300,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(12496,-3300,100,100,dessertPlatformRight));
        platforms.add(new Platform(12600,-3100,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(12700,-2900,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(12800,-2700,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(12900,-2500,100,100,dessertPlatformLeft));
        platforms.add(new Platform(12999,-2500,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(13098,-2500,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(13197,-2500,100,100,dessertPlatformMiddle));
        platforms.add(new Platform(13296,-2500,100,100,dessertPlatformRight));
        platforms.add(new Platform(12900,-3500,100,100,dessertPlatformMiddle));






        ArrayList<StativeEnemy> enemies = new ArrayList<StativeEnemy>();


        //ListOfEnemies


        enemies.add(new StativeEnemy(590, 1100, 1400, 0.1, zombieGoRight, zombieGoLeft, -1));
        enemies.add(new StativeEnemy(590, 1600, 1900, 0.14, zombieGoRight, zombieGoLeft, -1));
        enemies.add(new StativeEnemy(390, 1600, 1900, 0.1, zombieGoRight, zombieGoLeft, -1));
        enemies.add(new StativeEnemy(-1640, 3200, 3500, 0.1, zombieGoRight, zombieGoLeft, -1));
        enemies.add(new StativeEnemy(10, 4000, 4200, 0.1, zombieGoRight, zombieGoLeft, -1));
        enemies.add(new StativeEnemy(10, 4300, 4400, 0.1, zombieGoRight, zombieGoLeft, -1));
        enemies.add(new StativeEnemy(-1810, 4700, 5200, 0.1, zombieGoRight, zombieGoLeft, -1));
        enemies.add(new StativeEnemy(-2410,6700,7200,0.1,zombieGoRight,zombieGoLeft,-1));
        enemies.add(new StativeEnemy(-2410,10300,10800,0.1,zombieGoRight,zombieGoLeft,-1));


        for (int i = 0; i < enemies.size(); ++i) {
            StativeEnemy cur = enemies.get(i);
            for (int j = 0; j < movingBlocks.size(); ++j) {
                MovingBlock m = movingBlocks.get(j);
                if (cur.y + 110 == m.y + 100 && Math.abs(m.x - cur.x) < 2000) {
                    enemies.get(i).index = j;
                    break;
                }
            }
        }

        prizes.add(new Prize(230,140, 0));
        prizes.add(new Prize(3150,-1600, 1));
        prizes.add(new Prize(3200,-40,0));
        prizes.add(new Prize(11910,-3170,0));
        prizes.add(new Prize(12500,-3370,1));



        boolean programIsRunning = false;
        prizes.sort(((o1, o2) -> Integer.compare(o1.x, o2.x)));
        lava.sort(((o1, o2) -> Integer.compare(o1.x, o2.x)));
        MainFrame mainFrame = new MainFrame(hero, platforms, enemies, rings, doors, prizes, movingBlocks, fireballs, lava, checkPoints,objects);
        World world = new World(mainFrame, hero, platforms, enemies, rings, animations, doors, prizes, movingBlocks, fireballs, lava, checkPoints);


        int flyTime = 0;

        while (true) {
            if(mainFrame.programIsRunning) {
                if (hero.isOnFloor == false) flyTime++;
                else flyTime = 0;
            }
            if(flyTime>2000){
                mainFrame.lifeCounter--;
                if(mainFrame.lifeCounter<=0) mainFrame.gameOver = true;
                mainFrame.startFromLastCheckPoint = true;
                flyTime = 0;
            }
            world.check();
            world.update(1, 10000);
            Thread.sleep(0,10 );
            if (mainFrame.j) {
                mainFrame.j = false;
                hero.isOnFloor = false;
                hero.vy = 2.4;
            }
            mainFrame.repaint();
        }
    }
}
