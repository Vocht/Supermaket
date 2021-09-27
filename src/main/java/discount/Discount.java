package discount;

import items.SupermarketItem;

import java.math.BigDecimal;
import java.util.List;

public abstract class Discount {
    protected final int discountPercentage;

    public Discount(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public abstract BigDecimal applyDiscount(List<SupermarketItem> items);
}
