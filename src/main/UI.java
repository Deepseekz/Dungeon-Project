package main;

import java.awt.*;

public class UI {
    GamePanel gamePanel;

    public UI(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void render(Graphics2D g2) {
        g2.setFont(new Font("Arial", Font.PLAIN, 20));
        /*g2.setColor(Color.BLACK);
        g2.fill(new Rectangle(0, 0, 200, 45));*/

        g2.setColor(Color.WHITE);
        g2.drawString("PV: " + gamePanel.player.health + "/" + gamePanel.player.maxHealth, 10, 20);
        g2.drawString("Weapon: " + gamePanel.player.inventory.getItem(0).name, 10, 40);

    }
}
