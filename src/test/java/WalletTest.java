import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {
    private Wallet wallet;

    @BeforeEach
    void setUp() {
        wallet = new Wallet(BigDecimal.ZERO);
    }

    @Test
    void wallet_shouldHaveABalance() {
        assertEquals(BigDecimal.ZERO, wallet.getBalance());
    }

    @Test
    void wallet_shouldBeAbleToAddBalance() {
        assertEquals(BigDecimal.ZERO, wallet.getBalance());
        wallet.addBalance(new BigDecimal(10));
        assertEquals(BigDecimal.TEN, wallet.getBalance());
    }

    @Test
    void wallet_shouldBeAbleToReduceBalance() {
        wallet = new Wallet(new BigDecimal(10));
        assertEquals(new BigDecimal(10).longValue(), wallet.getBalance().longValue());
        wallet.reduceBalance(new BigDecimal(5));
        assertEquals(new BigDecimal(5), wallet.getBalance());
    }
}