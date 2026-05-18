import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    String name;
    double balance;

    BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display Accounts");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.next();
                    System.out.print("Enter initial balance: ");
                    double balance = sc.nextDouble();
                    accounts.add(new BankAccount(name, balance));
                    System.out.println("Account created!");
                    break;

                case 2:
                    System.out.print("Enter account index: ");
                    int dIndex = sc.nextInt();
                    if (dIndex < accounts.size()) {
                        System.out.print("Enter amount: ");
                        double dep = sc.nextDouble();
                        accounts.get(dIndex).deposit(dep);
                    } else {
                        System.out.println("Invalid account index");
                    }
                    break;

                case 3:
                    System.out.print("Enter account index: ");
                    int wIndex = sc.nextInt();
                    if (wIndex < accounts.size()) {
                        System.out.print("Enter amount: ");
                        double wit = sc.nextDouble();
                        accounts.get(wIndex).withdraw(wit);
                    } else {
                        System.out.println("Invalid account index");
                    }
                    break;

                case 4:
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts available");
                    } else {
                        for (int i = 0; i < accounts.size(); i++) {
                            System.out.println("\nAccount " + i + ":");
                            accounts.get(i).display();
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);

        sc.close();
    }
}