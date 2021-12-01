package inventory;

import item.Item;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Item getItem(int index) {
        return items.get(index);
    }

    public int getItemCount() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }

    public void swapItems(int index1, int index2) {
        Item temp = items.get(index1);
        items.set(index1, items.get(index2));
        items.set(index2, temp);
    }

    public void swapItems(Item item1, Item item2) {
        int index1 = items.indexOf(item1);
        int index2 = items.indexOf(item2);
        swapItems(index1, index2);
    }

    public boolean contains(Item item) {
        return items.contains(item);
    }
}
