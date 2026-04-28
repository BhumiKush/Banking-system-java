
import java.util.Scanner;

class BankAccount {
    String name;
    double balance;

    void createAccount(Scanner sc) {
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        balance = 0;
        System.out.println("Account created successfully for " + name);
    }

    void deposit(Scanner sc) {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        balance += amount;
        System.out.println("Amount deposited successfully.");
    }

    void withdraw(Scanner sc) {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Amount withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    void checkBalance() {
        System.out.println("Current balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount();

        boolean running = true;
        boolean accountCreated = false;

        while (running) {
            System.out.println("\n----- Banking System -----");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline
//!accountCreated &&
            // CLEAN CHECK (only once, before switch)
            if (!accountCreated && choice != 1 && choice != 5) {
                System.out.println("Please create account first.");
                continue;
            }

            switch (choice) {
                case 1:
                    account.createAccount(sc);
                    accountCreated = true;
                    break;
                case 2:
                    account.deposit(sc);
                    break;
                case 3:
                    account.withdraw(sc);
                    break;
                case 4:
                    account.checkBalance();
                    break;
                case 5:
                    running = false;
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}

