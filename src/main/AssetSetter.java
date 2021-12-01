package main;

import item.Item;
import item.door.Door;
import item.key.Crawbar;

public class AssetSetter {
    GamePanel gamePanel;

    public AssetSetter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void setObject(){
        gamePanel.items[0] = new Crawbar();
        gamePanel.items[0].x = 24*gamePanel.tileSize;
        gamePanel.items[0].y = 3*gamePanel.tileSize;
        gamePanel.items[1] = new Door();
        gamePanel.items[1].x = 29*gamePanel.tileSize;
        gamePanel.items[1].y = 6*gamePanel.tileSize;
    }
}
