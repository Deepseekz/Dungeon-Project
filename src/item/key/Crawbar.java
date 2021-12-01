package item.key;

import item.Item;

import javax.imageio.ImageIO;
import java.io.File;

public class Crawbar extends Item {

    public Crawbar() {
        name = "Key";
        try {
            texture = ImageIO.read(new File("resources/items/crawbar.png"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
