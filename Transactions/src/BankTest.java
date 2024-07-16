package src;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankTest {

    private Bank bank;

    @BeforeEach
    public void setUp() {
        bank = new Bank();
        bank.createAccount("123456789", 100000);
        bank.createAccount("987654321", 50000);
    }

    @Test
    public void testTransferWithinLimit() {
        bank.transfer("123456789", "987654321", 20000);
        assertEquals(80000, bank.getBalance("123456789"));
        assertEquals(70000, bank.getBalance("987654321"));
    }

    @Test
    public void testTransferAboveLimitAndFraud() {
        bank = new Bank() {
            @Override
            public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount) {
                return true;
            }
        };

        bank.createAccount("123456789", 100000);
        bank.createAccount("987654321", 50000);

        bank.transfer("123456789", "987654321", 70000);

        assertEquals(0, bank.getBalance("123456789"));
        assertEquals(0, bank.getBalance("987654321"));
    }

    public void testTransferExceedingLimit() {
        Bank bank = new Bank();
        bank.createAccount("123456789", 100000);
        bank.createAccount("987654321", 50000);

        assertThrows(IllegalArgumentException.class, () -> {
            bank.transfer("987654321", "123456789", 60000);
        });

        assertTrue(bank.getBalance("123456789") == 100000);
        assertTrue(bank.getBalance("987654321") == 50000);
    }

    @Test
    public void testTransferInvalidAccount() {
        assertThrows(IllegalArgumentException.class, () -> {
            bank.transfer("123456789", "000000000", 20000);
        });
    }

    @Test
    public void testTransferSameAccount() {
        assertThrows(IllegalArgumentException.class, () -> {
            bank.transfer("123456789", "123456789", 20000);
        });
    }
}
