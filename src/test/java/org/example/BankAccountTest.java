package org.example;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount bankAccount;

    @BeforeEach
    void setup() {
        bankAccount = new BankAccount(420, "CJ", 69);
    }

    @Test
    void depositValidAmount() {
        bankAccount.deposit(42000);
        assertEquals(42069, bankAccount.getAvailableBalance());
    }

    @Test
    void depositInvalidAmountZero() {
        bankAccount.deposit(0);
        assertEquals(69, bankAccount.getAvailableBalance());
    }

    @Test
    void depositInvalidAmountNegative() {
        bankAccount.deposit(-1);
        assertEquals(69, bankAccount.getAvailableBalance());
    }

    @Test
    void withdrawValidAmount() {
        bankAccount.withdraw(34);
        assertEquals(35, bankAccount.getAvailableBalance());
    }

    @Test
    void withdrawInvalidAmountZero() {
        bankAccount.withdraw(0);
        assertEquals(69, bankAccount.getAvailableBalance());
    }

    @Test
    void withdrawInvalidAmountNegative() {
        bankAccount.withdraw(-1);
        assertEquals(69, bankAccount.getAvailableBalance());
    }

    @Test
    void withdrawInvalidAmountExceedsBalance() {
        bankAccount.withdraw(70);
        assertEquals(69, bankAccount.getAvailableBalance());
    }

    @Test
    void testGetAccountNumber() {
        assertEquals(420, bankAccount.getAccountNumber());
    }

    @Test
    void testCreateBankAccountWithoutDeposit() {
        BankAccount bankAccountWithNoDeposit = new BankAccount(101, "CJ");
        assertEquals(101, bankAccountWithNoDeposit.getAccountNumber());
        assertEquals("CJ", bankAccountWithNoDeposit.getAccountHolderName());
        assertEquals(0, bankAccountWithNoDeposit.getAvailableBalance());
    }

    @Test
    void testDisplayInfo() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

        bankAccount.displayInfo();
        System.setOut(originalOut);

        String displayInfoOutput = testOut.toString();

        assertTrue(displayInfoOutput.contains("Holder Name: CJ"));
        assertTrue(displayInfoOutput.contains("Available Balance: 69"));
    }
}