package main;

import entity.Monster.Monster;
import entity.Monster.Monsters.NoFaceMonster;
import entity.Player.Player;
import item.Item;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    final int originalTileSize = 32; // in pixels
    final int scale = 1;

    public final int tileSize = originalTileSize * scale; // 32 pixels
    public final int maxScreenCol = 32;
    public final int maxScreenRow = 24;
    final int screenWidth = maxScreenCol * tileSize; // 768 pixels
    final int screenHeight = maxScreenRow * tileSize; // 576 pixels

    // FPS
    int fps = 60;

    TileManager tileManager = new TileManager(this);
    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;
    public CollisionHandler collisionHandler = new CollisionHandler(this);
    Player player = new Player(this, keyHandler);
    public Item[] items = new Item[10];
    public AssetSetter assetSetter = new AssetSetter(this);
    Monster[] monsters = new Monster[5];
    UI ui = new UI(this);


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setFocusable(true);
        this.setBackground(Color.BLACK);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void setupGame() {
        assetSetter.setObject();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
        NoFaceMonster noFaceMonster = new NoFaceMonster(this);
        noFaceMonster.setTarget(player);
        monsters[0] = noFaceMonster;
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += currentTime - lastTime;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        player.update();

        for (int i = 0; i < monsters.length; i++) {
            if (monsters[i] != null) {
                monsters[i].update();
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        tileManager.render(g2);

        player.render(g2);

        for (int i = 0; i < monsters.length; i++) {
            if (monsters[i] != null) {
                monsters[i].render(g2);
            }
        }

        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                items[i].render(g2, this);
            }
        }

        ui.render(g2);

        g2.dispose();
    }
}
