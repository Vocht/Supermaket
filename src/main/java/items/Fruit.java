package items;

public abstract class Fruit extends SupermarketItem {
    @Override
    public ItemType getItemType() {
        return ItemType.FRUIT;
    }
}
