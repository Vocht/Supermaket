package discount;

import items.SupermarketItem;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class GeneralDiscount extends Discount {
    public GeneralDiscount(int discountPercentage) {
        super(discountPercentage);
    }

    @Override
    public BigDecimal applyDiscount(List<SupermarketItem> items) {
        return items.stream()
                .map(SupermarketItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .multiply(new BigDecimal(discountPercentage).setScale(1, RoundingMode.HALF_EVEN))
                .divide(new BigDecimal(100), RoundingMode.HALF_EVEN);
    }
}
