// Task 5: Bank Account Simulation
// Java Developer Internship

import java.util.*;

// Base Account class
class Account {
    protected String accountHolder;
    protected double balance;
    protected List<String> transactionHistory;

    public Account(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: " + initialBalance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount + ", New Balance: " + balance);
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Deposit amount must be greater than zero.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount + ", New Balance: " + balance);
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void showTransactionHistory() {
        System.out.println("--- Transaction History ---");
        for (String record : transactionHistory) {
            System.out.println(record);
        }
    }
}

// Savings Account (Inheritance Example)
class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountHolder, double initialBalance, double interestRate) {
        super(accountHolder, initialBalance);
        this.interestRate = interestRate;
    }

    // Method Overriding
    @Override
    public void withdraw(double amount) {
        if (balance - amount < 500) {
            System.out.println("Savings Account must maintain minimum balance of 500.");
        } else {
            super.withdraw(amount);
        }
    }

    public void addInterest() {
        double interest = balance * interestRate / 100;
        deposit(interest);
        transactionHistory.add("Interest added: " + interest);
    }
}

// Main Program
public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        Account account = new SavingsAccount(name, 1000, 5.0); // initial balance = 1000, 5% interest
        boolean running = true;

        while (running) {
            System.out.println("\n=== Bank Account Menu ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Add Interest (Savings Only)");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        double dep = sc.nextDouble();
                        account.deposit(dep);
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double wd = sc.nextDouble();
                        account.withdraw(wd);
                        break;
                    case 3:
                        System.out.println("Current Balance: " + account.getBalance());
                        break;
                    case 4:
                        account.showTransactionHistory();
                        break;
                    case 5:
                        if (account instanceof SavingsAccount) {
                            ((SavingsAccount) account).addInterest();
                        }
                        break;
                    case 6:
                        running = false;
                        System.out.println("Exiting. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); // clear invalid input
            }
        }

        sc.close();
    }
}
