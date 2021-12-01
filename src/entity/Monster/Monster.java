package entity.Monster;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Monster extends Entity {
    public int health;
    public int damage;
    public boolean isDead;

    public Monster(GamePanel gamePanel) {
        super(gamePanel);
    }

    public void isDead(){
        if(health <= 0){
            isDead = true;
        }
    }

    public abstract void render(Graphics2D g2);
}
