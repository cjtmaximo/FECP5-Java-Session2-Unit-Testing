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
        System.out.printf("%s's new balance is %.2f.\n", this.getAccountHolderName(), this.getAvailableBalance());
    }

    public void withdraw(int withdraw) {
        if (withdraw > this.availableBalance) {
            System.out.println("You cannot withdraw more than you have.");
            return;
        }

        if (withdraw <= 0) {
            System.out.println("You cannot withdraw 0 or a negative amount");
            return;
        }

        this.availableBalance -= withdraw;
        System.out.printf("%s's new balance is %.2f.\n", this.getAccountHolderName(), this.getAvailableBalance());
    }

    public void displayInfo() {
        System.out.printf("Holder Name: %s\n", this.accountHolderName);
        System.out.printf("Available Balance: %.2f\n", this.availableBalance);
    }

}
