import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayOptions() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            displayOptions();
            System.out.print("Select an option (1/2/3/4): ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    withdraw();
                    break;
                case "2":
                    deposit();
                    break;
                case "3":
                    checkBalance();
                    break;
                case "4":
                    System.out.println("Thank you for using the ATM!");
                    return;
                default:
                    System.out.println("Invalid option. Please select again.");
            }
        }
    }

    public void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: ");
        double amount = sc.nextDouble();

        if (account.withdraw(amount)) {
            System.out.printf("Withdrawal of $%.2f successful.%n", amount);
        } else {
            System.out.println("Withdrawal failed. Insufficient balance or invalid amount.");
        }
    }

    public void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the amount to deposit: ");
        double amount = sc.nextDouble();

        if (account.deposit(amount)) {
            System.out.printf("Deposit of $%.2f successful.%n", amount);
        } else {
            System.out.println("Deposit failed. Please enter a valid amount.");
        }
    }

    public void checkBalance() {
        double balance = account.checkBalance();
        System.out.printf("Your account balance is $%.2f%n", balance);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your initial account balance: ");
        double initialBalance = sc.nextDouble();

        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}
