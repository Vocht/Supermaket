package items;

import java.math.BigDecimal;

public abstract class SupermarketItem {
    abstract public BigDecimal getPrice();

    public abstract ItemType getItemType();
}
