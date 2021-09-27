package items;

import java.math.BigDecimal;

public class Milk extends Dairy {
    @Override
    public BigDecimal getPrice() {
        return new BigDecimal("0.8");
    }
}
