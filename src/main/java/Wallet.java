import java.math.BigDecimal;

public class Wallet {
    private BigDecimal balance;

    public Wallet(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void addBalance(BigDecimal value) {
        balance = balance.add(value);
    }

    public void reduceBalance(BigDecimal value) {
        balance = balance.subtract(value);
    }
}
