package items;

import java.math.BigDecimal;

public class Apple extends Fruit {
    @Override
    public BigDecimal getPrice() {
        return new BigDecimal("0.4");
    }
}
