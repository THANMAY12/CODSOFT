package Codesoft;
import java.util.*;
class BankAccount {
    double balance;
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! Amount deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount. Please try again.");
        }
    }
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! Amount withdrawn: " + amount);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient balance! Unable to withdraw.");
        } else {
            System.out.println("Invalid withdrawal amount. Please try again.");
        }
        return false;
    }
}
class ATM {
    private BankAccount account;
    public ATM(BankAccount account) {
        this.account = account;
    }
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("ATM Menu:");
            System.out.println("1. Check Bank Balance");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Exit");
            System.out.print("Choose an option:");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    withdraw(withdrawalAmount);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice.Select a valid option.");
            }
        }
        scanner.close();
    }
    public void checkBalance() {
        System.out.println("Your current balance is Rupees " + account.getBalance());
    }
    public void deposit(double amount) {
        account.deposit(amount);
    }
    public void withdraw(double amount) {
        account.withdraw(amount);
    }
}
public class ATMSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00);
        ATM atm = new ATM(account);
        atm.showMenu();
    }
}