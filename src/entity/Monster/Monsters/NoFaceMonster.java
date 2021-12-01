package entity.Monster.Monsters;

import entity.Monster.Monster;
import entity.Player.Player;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class NoFaceMonster extends Monster {
    public int damage;
    public BufferedImage monster;
    public Player player;
    public int timeUnseen;
    public float opacity;


    public NoFaceMonster(GamePanel gamePanel) {
        super(gamePanel);
        setDefaultValues();
        getPlayerImage();
    }

    public void setTarget(Player player) {
        this.player = player;
    }

    public void targetPlayer(){
        if(player.x < x){
            x -= speed;
        }
        if(player.x > x){
            x += speed;
        }
        if(player.y < y){
            y -= speed;
        }
        if(player.y > y){
            y += speed;
        }
    }

    public void isDead(){
        if(health <= 0){
            isDead = true;
        }
    }

    public void isWatched(){
        if(player.y > y && player.cardinalDirection == "up"){
            speed = 0;
            timeUnseen = 0;
        }
        else if(player.y < y && player.cardinalDirection == "down"){
            speed = 0;
            timeUnseen = 0;
        }
        else if(player.x > x && player.cardinalDirection == "left"){
            speed = 0;
            timeUnseen = 0;
        }
        else if(player.x < x && player.cardinalDirection == "right"){
            speed = 0;
            timeUnseen = 0;
        }
        else {
            opacity = 1f;
            timeUnseen += 1;
            speed = 1;
            if(timeUnseen > 200){
                speed = 2;
            }
            if(timeUnseen > 500){
                speed = 4;
            }
        }
    }

    private void setDefaultValues() {
        x = (int) (Math.random() * (gamePanel.getWidth() - 100));
        y = (int) (Math.random() * (gamePanel.getHeight() - 100));
        health = 10;
        damage = 1;
        speed = 1;
        opacity = 1f;
    }



    public void getPlayerImage() {
        try {
            monster = ImageIO.read(new File("resources/monsters/monster.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        isDead();
        isWatched();
        targetPlayer();
    }

    @Override
    public void render(Graphics2D g2) {
        System.out.println(x + " " + y);
        if (timeUnseen == 0) {
            if (opacity >= 0.2f)
                opacity -= 0.05f;
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (opacity)));
        }
        else {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
        }
        g2.drawImage(monster, x, y, null);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    }
}
