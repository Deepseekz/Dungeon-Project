package item.door;

import item.Item;

import javax.imageio.ImageIO;
import java.io.File;

public class Door extends Item {

    public Door() {
        name = "Door";
        try {
            texture = ImageIO.read(new File("resources/items/door.png"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
