package main;

import entity.Entity;

import java.util.Arrays;

public class CollisionHandler {

    GamePanel gamePanel;

    public CollisionHandler(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void checkTile(Entity entity) {
        int left = entity.hitbox.x;
        int right = entity.hitbox.x + entity.hitbox.width;
        int top = entity.hitbox.y;
        int bottom = entity.hitbox.y + entity.hitbox.height;

        int tileLeft = left / gamePanel.tileSize;
        int tileTop = top / gamePanel.tileSize;
        int tileRight = right / gamePanel.tileSize;
        int tileBottom = bottom / gamePanel.tileSize;

        int tileNum1, tileNum2;

        switch (entity.cardinalDirection) {
            case "up":
                tileTop = (top - entity.speed) / gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNumbers[tileLeft][tileTop];
                tileNum2 = gamePanel.tileManager.mapTileNumbers[tileRight][tileTop];
                if (gamePanel.tileManager.tiles[tileNum1].isSolid || gamePanel.tileManager.tiles[tileNum2].isSolid) {
                    entity.isColliding = true;
                }
                break;
            case "down":
                tileBottom = (bottom + entity.speed) / gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNumbers[tileLeft][tileBottom];
                tileNum2 = gamePanel.tileManager.mapTileNumbers[tileRight][tileBottom];
                if (gamePanel.tileManager.tiles[tileNum1].isSolid || gamePanel.tileManager.tiles[tileNum2].isSolid) {
                    entity.isColliding = true;
                }
                break;
            case "left":
                tileLeft = (left - entity.speed) / gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNumbers[tileLeft][tileTop];
                tileNum2 = gamePanel.tileManager.mapTileNumbers[tileLeft][tileBottom];
                if (gamePanel.tileManager.tiles[tileNum1].isSolid || gamePanel.tileManager.tiles[tileNum2].isSolid) {
                    entity.isColliding = true;
                }
                break;
            case "right":
                tileRight = (right + entity.speed) / gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNumbers[tileRight][tileTop];
                tileNum2 = gamePanel.tileManager.mapTileNumbers[tileRight][tileBottom];
                if (gamePanel.tileManager.tiles[tileNum1].isSolid || gamePanel.tileManager.tiles[tileNum2].isSolid) {
                    entity.isColliding = true;
                }
                break;
        }
    }


}
