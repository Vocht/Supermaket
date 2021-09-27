package items;

public abstract class Dairy extends SupermarketItem {
    @Override
    public ItemType getItemType() {
        return ItemType.DAIRY;
    }
}
