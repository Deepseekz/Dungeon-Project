package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class TileManager {
    GamePanel gamePanel;
    public Tile[] tiles;
    public int[][] mapTileNumbers;

    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        tiles = new Tile[10];
        mapTileNumbers = new int[gamePanel.maxScreenCol][gamePanel.maxScreenRow];

        getTilesImage();
        loadMapTileNumbers("basic");

    }

    // Loads the room tile numbers from a text file located in the resources/rooms folder
    public void loadMapTileNumbers(String mapName) {
        try {
            FileReader fileReader = new FileReader("resources/maps/" + mapName + ".txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int column = 0;
            int row = 0;

            while (column < gamePanel.maxScreenCol && row < gamePanel.maxScreenRow) {
                String line = bufferedReader.readLine();
                while (column < gamePanel.maxScreenCol) {
                    String[] tileNumbers = line.split(" ");

                    int tileNumber = Integer.parseInt(tileNumbers[column]);

                    mapTileNumbers[column][row] = tileNumber;
                    column++;
                }
                if (column == gamePanel.maxScreenCol) {
                    column = 0;
                    row++;
                }
            }
            bufferedReader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getTilesImage() {
        try {
            tiles[0] = new Tile();
            tiles[0].texture = ImageIO.read(new File("resources/tiles/grass.png"));
            tiles[1] = new Tile();
            tiles[1].texture = ImageIO.read(new File("resources/tiles/bush.png"));
            tiles[1].isSolid = true;
            tiles[2] = new Tile();
            tiles[2].texture = ImageIO.read(new File("resources/tiles/slab.png"));
            tiles[3] = new Tile();
            tiles[3].texture = ImageIO.read(new File("resources/tiles/wall.png"));
            tiles[3].isSolid = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void render(Graphics2D graphics2D) {

        int column = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (column < gamePanel.maxScreenCol && row < gamePanel.maxScreenRow) {

            int tileNumber = mapTileNumbers[column][row];

            graphics2D.drawImage(tiles[tileNumber].texture, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
            column++;
            x += gamePanel.tileSize;
            if (column == gamePanel.maxScreenCol) {
                column = 0;
                x = 0;
                row++;
                y += gamePanel.tileSize;
            }
        }
    }


}