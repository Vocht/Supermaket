import discount.GeneralDiscount;
import items.Apple;
import items.Milk;
import items.Orange;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShoppingCartTest {
    private ShoppingCart shoppingCart;

    @BeforeEach
    void setUp() {
        shoppingCart = new ShoppingCart();
    }

    @Test
    void shoppingCart_shouldBeAbleToAddItems() {
        shoppingCart.addItem(new Orange());
        assertEquals(Orange.class, shoppingCart.getItems().get(0).getClass());
    }

    @Test
    void shoppingCart_shouldBeAbleToAddMultipleItems() {
        shoppingCart.addItems(new Orange(), new Apple());
        assertEquals(2, shoppingCart.getItems().size());
    }

    @Test
    void shoppingCart_shouldGiveTotalPrice() {
        shoppingCart.addItems(new Orange(), new Apple());
        assertEquals(new BigDecimal("0.9"), shoppingCart.getTotalPrice());
    }

    @Test
    void shoppingCart_shouldEmpty() {
        shoppingCart.addItems(new Orange(), new Apple());
        assertEquals(2, shoppingCart.getItems().size());
        shoppingCart.emptyCart();
        assertTrue(shoppingCart.getItems().isEmpty());
    }

    @Test
    void shoppingCart_shouldAllowDiscounts() {
        shoppingCart.addItems(new Apple(), new Orange(), new Milk());
        assertEquals(new BigDecimal("1.7"), shoppingCart.getTotalPrice());
        shoppingCart.addDiscount(new GeneralDiscount(50));
        assertEquals(new BigDecimal("0.85"), shoppingCart.getDiscountedPrice());
    }
}