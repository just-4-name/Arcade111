import java.util.ArrayList;

public class World {
    ArrayList<Ring> rings;
    ArrayList<Prize> prizes;
    Hero hero;
    public double timer = 0;
    MainFrame mainFrame;
    ArrayList<StativeEnemy> enemies;
    ArrayList<Platform> platforms;
    static double G = 0.01;
    long t1 = System.currentTimeMillis();
    long t2;
    ArrayList<Animation> animations;
    ArrayList<StativeEnemy> deleted = new ArrayList<>();
    long begin = System.currentTimeMillis();
    ArrayList<Door> doors;
    ArrayList<Prize> deletedPrizes = new ArrayList<>();
    ArrayList<CheckPoint> deletedCheckPoints = new ArrayList<>();
    ArrayList<MovingBlock> movingBlocks;
    ArrayList<Fireball> fireballs;
    ArrayList<Lava> lava;
    ArrayList<CheckPoint> checkPoints;

    public World(MainFrame mainFrame, Hero hero, ArrayList<Platform> platforms, ArrayList<StativeEnemy> enemies,
                 ArrayList<Ring> rings, ArrayList<Animation> animations, ArrayList<Door> doors, ArrayList<Prize> prizes,
                 ArrayList<MovingBlock> movingBlocks, ArrayList<Fireball> fireballs, ArrayList<Lava> lava,
                 ArrayList<CheckPoint> checkPoints) {
        this.fireballs = fireballs;
        this.checkPoints = checkPoints;
        this.lava = lava;
        this.movingBlocks = movingBlocks;
        this.prizes = prizes;
        this.doors = doors;
        this.mainFrame = mainFrame;
        this.animations = animations;
        this.hero = hero;
        this.rings = rings;
        this.enemies = enemies;
        this.platforms = platforms;
    }

    public void update(double dt, long dt1) {
        if (!mainFrame.programIsRunning) return;
        for (int i = 0; i < animations.size(); ++i) {
            animations.get(i).update(dt1);
        }
        t2 = System.currentTimeMillis();
        this.timer += 0.0025;
        this.timer %= 2 * Math.PI;
        for (int i = 0; i < rings.size(); ++i) {
            rings.get(i).timer = this.timer;
        }
        hero.vy -= G * dt;
        if (!hero.isOnFloor) hero.y -= hero.vy * dt - G * dt * dt;
        if (!hero.isOnFloor && hero.v >= 0) {
            hero.x += 0.5 * dt;
        } else if (!hero.isOnFloor && hero.v < 0) {
            hero.x -= 0.5 * dt;
        } else if (hero.isMoving) {
            hero.x += hero.v * dt;
        }
        for (int i = 0; i < enemies.size(); ++i) {
            StativeEnemy cur = enemies.get(i);
            cur.x += dt * cur.speed;
            if (cur.x > cur.right || cur.x < cur.left) {
                cur.speed *= -1;
            }
        }
        for (int i = 0; i < fireballs.size(); ++i) {
            fireballs.get(i).change += dt * 0.5;
            if (Math.abs(fireballs.get(i).change) >= fireballs.get(i).interval) {
                fireballs.get(i).change = 0;
            }
        }

    }


    public void check() {
        if(hero.x>14200 && hero.y == -2610) mainFrame.isWin = true;
        if (mainFrame.startFromLastCheckPoint) {
            return;
        }
        for (int i = 0; i < checkPoints.size(); ++i) {
            if (hero.y + 110 == checkPoints.get(i).y + 70 && hero.x + 40 >= checkPoints.get(i).x && hero.x + 40 <= checkPoints.get(i).x + checkPoints.get(i).img.getWidth()) {
                hero.checkPointX = (int) hero.x;
                hero.checkPointY = (int) hero.y;
                deletedCheckPoints.add(checkPoints.get(i));
                checkPoints.remove(i);
            }
        }int l = 0, r = lava.size();
        while (r - l > 1) {
            int m = (l + r) / 2;
            if (lava.get(m).x <= hero.x) {
                l = m;
            } else {
                r = m;
            }
        }
        for (int i = Math.max(0,l-7); i < Math.min(lava.size(),l+7); ++i) {
            if (hero.y + 90 > lava.get(i).y && hero.y < lava.get(i).y + lava.get(i).height - 20 && hero.x + 80 - 20 >= lava.get(i).x && hero.x + 20 <= lava.get(i).x + lava.get(i).len) {
                mainFrame.lifeCounter--;
                if (mainFrame.lifeCounter <= 0) mainFrame.gameOver = true;
                mainFrame.startFromLastCheckPoint = true;
                return;
            }
        }
        for (int i = 0; i < fireballs.size(); ++i) {
            Fireball f = fireballs.get(i);
            if (!(hero.y + 110 > f.y + 20 && hero.y < f.y + 80)) continue;
            if (f.direction > 0) {
                for (int j = f.left + (int) f.change; j < f.right; j += f.interval) {
                    if (j + 80 > hero.x && hero.x + 60 > j) {
                        mainFrame.lifeCounter--;
                        if (mainFrame.lifeCounter <= 0) mainFrame.gameOver = true;
                        mainFrame.startFromLastCheckPoint = true;
                        return;
                    }
                }
            } else {
                for (int j = f.right - (int) f.change; j > f.left; j -= f.interval) {
                    if (j + 80 > hero.x && hero.x + 60 > j) {
                        mainFrame.lifeCounter--;
                        if (mainFrame.lifeCounter <= 0) mainFrame.gameOver = true;
                        mainFrame.startFromLastCheckPoint = true;
                        return;
                    }
                }
            }
        }
        if (!mainFrame.programIsRunning) return;
        l = 0; r = prizes.size();
        while (r - l > 1) {
            int m = (l + r) / 2;
            if (prizes.get(m).x <= hero.x + 40) {
                l = m;
            } else {
                r = m;
            }
        }
        for (int i = Math.max(0, l - 10); i < Math.min(l + 10, prizes.size()); ++i) {
            if (hero.x + 80 >= prizes.get(i).x && hero.x <= prizes.get(i).x + prizes.get(i).img.getWidth()
                    && hero.y + 110 >= prizes.get(i).y && hero.y <= prizes.get(i).y + prizes.get(i).img.getHeight()) {
                if (prizes.get(i).type == 0) mainFrame.score++;
                if (prizes.get(i).type == 1) mainFrame.lifeCounter++;
                deletedPrizes.add(prizes.get(i));
                prizes.remove(i);
            }
        }
        long curTime = System.currentTimeMillis();
        //curTime - begin > 30000 ||
        if (mainFrame.updateEnemies) {
            mainFrame.updateEnemies = false;
            begin = curTime;
            while (!deleted.isEmpty()) {
                enemies.add(deleted.get(0));
                deleted.remove(0);
            }
        }
        if (mainFrame.updatePrizes) {
            mainFrame.updatePrizes = false;
            while (!deletedPrizes.isEmpty()) {
                prizes.add(deletedPrizes.get(0));
                deletedPrizes.remove(0);
            }
            prizes.sort(((o1, o2) -> Integer.compare(o1.x, o2.x)));
        }
        if (mainFrame.updateCheckPoints) {
            mainFrame.updateCheckPoints = false;
            while (!deletedCheckPoints.isEmpty()) {
                checkPoints.add(deletedCheckPoints.get(0));
                deletedCheckPoints.remove(0);
            }
        }
        boolean flag = false;
        //System.out.println(t1+ " " + t2);

        for (int i = 0; i < platforms.size(); i++) {
            int bottom = platforms.get(i).y + platforms.get(i).height;
            if (hero.isOnFloor && hero.y + 110 >= bottom &&
                    hero.y < bottom && hero.x >= platforms.get(i).x &&
                    hero.x + 80 <= platforms.get(i).x + platforms.get(i).length) {
                if (hero.x < platforms.get(i).x + platforms.get(i).length / 2) hero.x = platforms.get(i).x - 90;
                else hero.x = platforms.get(i).x + platforms.get(i).length + 10;
            }
            if (hero.y + 110 >= platforms.get(i).y && platforms.get(i).y + platforms.get(i).height >= hero.y && hero.x + 60 >= platforms.get(i).x && hero.x + 20 <= platforms.get(i).x + platforms.get(i).length) {
                if (hero.y + 110 >= platforms.get(i).y + 40) {
                    if (!hero.isOnFloor) {
                        hero.vy = -1;
                        hero.isOnFloor = false;
                    }
                } else {
                    hero.isOnFloor = true;
                    flag = true;
                    hero.y = platforms.get(i).y - 110;
                }
                //System.out.println("bad");
            }
        }
        if (hero.isCarrying != -1) {
            MovingBlock block = movingBlocks.get(hero.isCarrying);
            if (hero.v > 0) block.x = (int) hero.x + 85;
            else block.x = (int) hero.x - 105;
            if (block.x > block.right + 5) {
                block.x = block.right;
                //hero.isCarrying = -1;
                hero.x = block.x - 90;
            }
            if (block.x < block.left - 5) {
                block.x = block.left;
                hero.x = block.x + 110;
                //hero.isCarrying = -1;
            }
        } else {
            for (int i = 0; i < movingBlocks.size(); i++) {
                int bottom = movingBlocks.get(i).y + 100;
                if (hero.isOnFloor && hero.y + 110 >= bottom &&
                        hero.y < bottom && hero.x >= movingBlocks.get(i).x &&
                        hero.x + 80 <= movingBlocks.get(i).x + 100) {
                    if (hero.v > 0) hero.x = movingBlocks.get(i).x - 90;
                    else hero.x = movingBlocks.get(i).x + 100 + 10;
                }
                if (hero.y + 110 >= movingBlocks.get(i).y && movingBlocks.get(i).y + 100 >= hero.y && hero.x + 60 >= movingBlocks.get(i).x && hero.x + 20 <= movingBlocks.get(i).x + 100) {
                    if (hero.y + 110 >= movingBlocks.get(i).y + 40) {
                        if (!hero.isOnFloor) {
                            hero.vy = -1;
                            hero.isOnFloor = false;
                        }
                    } else {
                        hero.isOnFloor = true;
                        flag = true;
                        hero.y = movingBlocks.get(i).y - 110;
                    }
                    //System.out.println("bad");
                }
            }
        }
        if (!flag) {
            hero.isOnFloor = false;
        }
        if (hero.isCarrying != -1 && hero.isMoving == true) {
            MovingBlock block = movingBlocks.get(hero.isCarrying);
            for (int i = 0; i < enemies.size(); ++i) {
                StativeEnemy cur = enemies.get(i);
                if (cur.y + 110 != block.y + 100) continue;
                if (block.x + 100 >= cur.x && block.x <= cur.x + 80) {
                    deleted.add(cur);
                    enemies.remove(i);
                }
            }
        }
        for (int i = 0; i < enemies.size(); ++i) {
            StativeEnemy cur = enemies.get(i);
            if ((hero.isMoving == false || hero.isCarrying == -1) && cur.index != -1) {
                MovingBlock m = movingBlocks.get(cur.index);
                if (cur.x + 80 > m.x && cur.x < m.x + 100) {
                    enemies.get(i).speed *= -1;
                    enemies.get(i).x += enemies.get(i).speed * 10;
                    //System.exit(0);
                }
            }
            if ((int) hero.y + 110 >= cur.y && (int) hero.y <= cur.y + 110 && hero.x + 60 >= cur.x && hero.x + 20 <= cur.x + 80) {
                if (hero.y + 110 <= cur.y + 105 && hero.vy < 0) {
                    deleted.add(enemies.get(i));
                    enemies.remove(i);
                    hero.vy = 0.5;
                    mainFrame.cnt++;
                } else {
                    mainFrame.lifeCounter--;
                    if (mainFrame.lifeCounter <= 0) mainFrame.gameOver = true;
                    mainFrame.startFromLastCheckPoint = true;
                    mainFrame.programIsRunning = false;
                    return;
                }
            }
        }
        if (Math.abs(t2 - t1) > 5) {
            t1 = t2;
            for (int i = 0; i < rings.size(); ++i) {
                Ring cur = rings.get(i);
                if (Math.abs(hero.x - cur.x) > cur.r) continue;
                if (cur.isIntersect(hero.x, hero.y, hero.x + 80, hero.y) ||
                        cur.isIntersect(hero.x, hero.y, hero.x, hero.y + 110)
                        || cur.isIntersect(hero.x, hero.y + 110, hero.x + 80, hero.y + 110) ||
                        cur.isIntersect(hero.x + 80, hero.y, hero.x + 80, hero.y + 110)) {
                    mainFrame.lifeCounter--;
                    if (mainFrame.lifeCounter <= 0) mainFrame.gameOver = true;
                    mainFrame.startFromLastCheckPoint = true;
                    mainFrame.programIsRunning = false;
                    return;
                }
            }
        }

    }


}
