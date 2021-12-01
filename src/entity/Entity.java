package entity;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {
    public GamePanel gamePanel;
    public int x, y;
    public int speed;
    public int animationSpeed;
    public String cardinalDirection;
    public int spriteCounter = 0;
    public int spriteNumber = 1;
    public Rectangle hitbox;
    public boolean isColliding = false;

    public Entity(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void update() {

    }
}
