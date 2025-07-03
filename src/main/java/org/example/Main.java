package org.example;

import java.util.*;

public class Main {
    public static void createAccount(ArrayList<BankAccount> bankAccounts, int accountNumber, String holderName, int initialDepositAmount) {
        if (initialDepositAmount < 0) {
            System.out.println("Initial deposit amount must not be negative.");
            return;
        }

        BankAccount newBankAccount = new BankAccount(accountNumber, holderName, initialDepositAmount);
        bankAccounts.add(newBankAccount);

        System.out.println("Account created successfully!");
    }

    public static void viewAllAccounts(ArrayList<BankAccount> bankAccounts) {
        if (bankAccounts.isEmpty()) {
            System.out.println("There are currently no existing bank accounts.");
            return;
        }

        System.out.println("=== All Accounts ===");

        for(BankAccount bankAccount: bankAccounts) {
            bankAccount.displayInfo();
        }
    }

    public static void checkBalance(ArrayList<BankAccount> bankAccounts, int accountNumber) {
        for (BankAccount bankAccount: bankAccounts) {
            if (bankAccount.getAccountNumber() == accountNumber) {
                System.out.printf("%s's balance is %.2f.\n", bankAccount.getAccountHolderName(), bankAccount.getAvailableBalance());
                return;
            }
        }

        System.out.println("Account number does not exist.");
    }

    public static void depositToAccount(ArrayList<BankAccount> bankAccounts, int accountNumber, int depositAmount) {
        for (BankAccount bankAccount: bankAccounts) {
            if (bankAccount.getAccountNumber() == accountNumber) {
                bankAccount.deposit(depositAmount);
                return;
            }
        }

        System.out.println("Account number does not exist.");
    }

    public static void withdrawFromAccount(ArrayList<BankAccount> bankAccounts, int accountNumber, int withdrawAmount) {
        for (BankAccount bankAccount: bankAccounts) {
            if (bankAccount.getAccountNumber() == accountNumber) {
                bankAccount.withdraw(withdrawAmount);
                return;
            }
        }

        System.out.println("Account number does not exist.");
    }

    public static void main(String[] args) {
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean isExit = false;

        do {
            System.out.println("=== Bank Menu ===");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Check Balance");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Exit");

            System.out.print("Enter choice (1-5): ");
            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    int accountNumber = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Holder Name: ");
                    String holderName = scanner.nextLine();

                    System.out.print("Initial deposit? (yes/no): ");
                    String isInitialDeposit = scanner.nextLine();

                    int initialDepositAmount = 0;
                    if (isInitialDeposit.equals("yes")) {
                        System.out.print("Enter initial deposit amount: ");
                        initialDepositAmount = scanner.nextInt();
                        scanner.nextLine();
                    }

                    BankAccount newBankAccount = new BankAccount(accountNumber, holderName, initialDepositAmount);
                    createAccount(bankAccounts, accountNumber, holderName, initialDepositAmount);
                    break;
                case 2:
                    viewAllAccounts(bankAccounts);
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    int accountNumberForCheckBalance = scanner.nextInt();

                    checkBalance(bankAccounts, accountNumberForCheckBalance);
                    break;
                case 4:
                    System.out.print("Enter Account Number: ");
                    int accountNumberForDeposit = scanner.nextInt();

                    System.out.print("Enter deposit amount: ");
                    int depositAmount = scanner.nextInt();
                    scanner.nextLine();

                    depositToAccount(bankAccounts, accountNumberForDeposit, depositAmount);
                    break;
                case 5:
                    System.out.print("Enter Account Number: ");
                    int accountNumberForWithdraw = scanner.nextInt();

                    System.out.print("Enter withdraw amount: ");
                    int withdrawAmount = scanner.nextInt();

                    withdrawFromAccount(bankAccounts, accountNumberForWithdraw, withdrawAmount);
                    break;
                default:
                    isExit = true;
                    break;
            }

            if (isExit) {
                break;
            }

            System.out.print("\n");
            System.out.print("Would you like to return to the menu? (yes/no): ");
            String wantsToExit = scanner.nextLine();

            if (wantsToExit.equals("no")) {
                isExit = true;
            }

            System.out.print("\n");
        } while (!isExit);
    }
}