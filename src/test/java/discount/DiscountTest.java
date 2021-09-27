package discount;

import items.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscountTest {

    @Test
    void discount_shouldDiscountByPercentage() {
        var items = Arrays.asList(new Apple(), new Orange(), new Milk());
        var discount = new GeneralDiscount(50);
        assertEquals(items.stream()
                .map(SupermarketItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .multiply(new BigDecimal("0.5")), discount.applyDiscount(items));
    }

    @Test
    void discount_shouldHaveACategoryDiscount() {
        var items = Arrays.asList(new Apple(), new Orange(), new Milk());
        var discount = new CategoryDiscount(50, ItemType.FRUIT);
        assertEquals(new BigDecimal("1.25"), discount.applyDiscount(items));
    }
}