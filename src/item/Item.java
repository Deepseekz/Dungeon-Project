package item;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Item {
    public BufferedImage texture;
    public String name;
    public int id;
    public boolean collision = false;
    public int x;
    public int y;

    public void render(Graphics2D g2, GamePanel gamePanel) {
        g2.drawImage(texture, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
    }
}


