import discount.Discount;
import items.SupermarketItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingCart {
    private final List<SupermarketItem> items;
    private final List<Discount> discounts;

    public ShoppingCart() {
        items = new ArrayList<>();
        discounts = new ArrayList<>();
    }

    public void addItem(SupermarketItem item) {
        items.add(item);
    }

    public List<SupermarketItem> getItems() {
        return items;
    }

    public BigDecimal getTotalPrice() {
        return items.stream()
                .map(SupermarketItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getDiscountedPrice() {
        return discounts.stream()
                .map(discount -> discount.applyDiscount(items))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void addItems(SupermarketItem... items) {
        this.items.addAll(Arrays.stream(items).toList());
    }

    public void emptyCart() {
        items.clear();
    }

    public void addDiscount(Discount discount) {
        discounts.add(discount);
    }
}
