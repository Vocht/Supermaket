package items;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SupermarketItemTest {
    @Test
    void superMarketItem_shouldHaveAType() {
        var apple = new Apple();
        var orange = new Orange();
        var milk = new Milk();

        assertEquals(ItemType.FRUIT, apple.getItemType());
        assertEquals(ItemType.FRUIT, orange.getItemType());
        assertEquals(ItemType.DAIRY, milk.getItemType());
    }
}