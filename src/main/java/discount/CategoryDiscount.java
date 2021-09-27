package discount;

import items.ItemType;
import items.SupermarketItem;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class CategoryDiscount extends Discount {
    private final ItemType itemType;

    public CategoryDiscount(int discountPercentage, ItemType itemType) {
        super(discountPercentage);
        this.itemType = itemType;
    }

    @Override
    public BigDecimal applyDiscount(List<SupermarketItem> items) {
        var discountedItems = items.stream()
                .filter(item -> item.getItemType() == itemType)
                .map(SupermarketItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .multiply(new BigDecimal(discountPercentage).setScale(1, RoundingMode.HALF_EVEN))
                .divide(new BigDecimal(100), RoundingMode.HALF_EVEN);

        var undiscountedItems = items.stream()
                .filter(item -> item.getItemType() != itemType)
                .map(SupermarketItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return discountedItems.add(undiscountedItems);
    }
}
