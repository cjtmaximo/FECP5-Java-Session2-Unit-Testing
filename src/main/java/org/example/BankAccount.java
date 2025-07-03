package org.example;

public class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double availableBalance;

    public BankAccount(int accountNumber, String accountHolderName, double availableBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.availableBalance = availableBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void deposit(int deposit) {
        if (deposit <= 0) {
            System.out.println("The deposit must be greater than 0.");
            return;
        }

        this.availableBalance += deposit;
    }

    public void displayInfo() {

    }

}
