import items.Apple;
import items.Orange;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SupermarketTest {
    private Supermarket supermarket;

    @BeforeEach
    void setUp() {
        supermarket = new Supermarket();
    }

    @Test
    void supermarket_shouldInit() {
        assertNotEquals(null, supermarket);
    }

    @Test
    void supermarket_shouldHaveAShoppingCart() {
        assertEquals(ShoppingCart.class, supermarket.getShoppingCart().getClass());
    }

    @Test
    void supermarket_shouldAddItemToShoppingCart() {
        supermarket.addToCart(new Orange());
        assertEquals(Orange.class, supermarket.getShoppingCart().getItems().get(0).getClass());
    }

    @Test
    void supermarket_shouldAddItemsToShoppingCart() {
        supermarket.addToCart(new Orange(), new Apple());
        assertEquals(Orange.class, supermarket.getShoppingCart().getItems().get(0).getClass());
        assertEquals(Apple.class, supermarket.getShoppingCart().getItems().get(1).getClass());
    }

    @Test
    void supermarket_shouldHaveACheckout() {
        var wallet = new Wallet(BigDecimal.TEN);
        assertEquals(BigDecimal.TEN, wallet.getBalance());
        supermarket.addToCart(new Orange(), new Apple());
        supermarket.checkOut(wallet);
        assertEquals(new BigDecimal("9.1"), wallet.getBalance());
    }
}