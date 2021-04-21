import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Lava {
    public int x;
    public int y;
    public int len;
    public int height;
    public int type;
    public BufferedImage img;

    public Lava(int x, int y, int len, int height, int type) throws IOException {
        this.x = x;
        this.y = y;
        this.len = len;
        this.height = height;
        if (type == 0) this.img = ImageIO.read(Main.class.getResourceAsStream("spikes_top.png"));
        if (type == 1) this.img = ImageIO.read(Main.class.getResourceAsStream("cactus1.png"));
        if (type == 2) this.img = ImageIO.read(Main.class.getResourceAsStream("cactus2.png"));
        if (type == 3) this.img = ImageIO.read(Main.class.getResourceAsStream("cactus3.png"));
    }

    public void draw(Graphics g, int heroX, int heroY) {
        int dx = heroX - 500;
        int dy = heroY - 300;
        g.drawImage(img, x - dx, y - dy, len, height, null);
    }
}
