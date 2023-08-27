import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: Rs " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: Rs " + amount);
            return true;
        } else {
            System.out.println("Invalid withdrawal or insufficient balance.");
            return false;
        }
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void withdraw(double amount) {
        if (userAccount.withdraw(amount)) {
            System.out.println("Remaining Balance: Rs " + userAccount.getBalance());
        }
    }

    public void deposit(double amount) {
        userAccount.deposit(amount);
        System.out.println("Remaining Balance: Rs " + userAccount.getBalance());
    }

    public void checkBalance() {
        System.out.println("Current Balance: Rs " + userAccount.getBalance());
    }

    private boolean isValidAmount(double amount) {
        return amount > 0;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter withdrawal amount: Rs ");
                double amount = scanner.nextDouble();
                if (isValidAmount(amount)) {
                    withdraw(amount);
                } else {
                    System.out.println("Invalid amount.");
                }
            } else if (choice == 2) {
                System.out.print("Enter deposit amount: Rs ");
                double amount = scanner.nextDouble();
                if (isValidAmount(amount)) {
                    deposit(amount);
                } else {
                    System.out.println("Invalid amount.");
                }
            } else if (choice == 3) {
                checkBalance();
            } else if (choice == 4) {
                System.out.println("Exiting. Thank you!");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);
        atm.displayMenu();
    }
}
