package items;

import java.math.BigDecimal;

public class Orange extends Fruit {
    @Override
    public BigDecimal getPrice() {
        return new BigDecimal("0.5");
    }
}
