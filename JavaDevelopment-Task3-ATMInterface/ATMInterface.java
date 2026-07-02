import java.util.Scanner;

public class ATMInterface {

    static Scanner sc = new Scanner(System.in);

    static int pin = 1234;
    static double balance = 10000.0;
    static String[] statement = new String[20];
    static int count = 0;

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println("        SMART ATM BANKING SYSTEM");
        System.out.println("=======================================");

        if (!login()) {
            System.out.println("\nAccount Locked.");
            return;
        }

        int choice;

        do {
            System.out.println("\n========== ATM MENU ==========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Fast Cash");
            System.out.println("5. Mini Statement");
            System.out.println("6. Change PIN");
            System.out.println("7. Exit");
            System.out.println("==============================");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    fastCash();
                    break;

                case 5:
                    miniStatement();
                    break;

                case 6:
                    changePin();
                    break;

                case 7:
                    System.out.println("\nThank you for using Smart ATM.");
                    System.out.println("Have a Nice Day!");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 7);
    }

    static boolean login() {

        int attempts = 3;

        while (attempts > 0) {

            System.out.print("Enter 4-digit PIN: ");
            int enteredPin = sc.nextInt();

            if (enteredPin == pin) {
                System.out.println("\nLogin Successful!");
                return true;
            } else {
                attempts--;
                System.out.println("Wrong PIN.");
                System.out.println("Attempts Left: " + attempts);
            }
        }

        return false;
    }

    static void checkBalance() {
        System.out.println("\nCurrent Balance: ₹" + balance);
    }

    static void deposit() {

        System.out.print("Enter Deposit Amount: ₹");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid Amount.");
            return;
        }

        balance += amount;

        addTransaction("Deposited ₹" + amount);

        System.out.println("Deposit Successful.");
        System.out.println("Updated Balance: ₹" + balance);
    }

    static void withdraw() {

        System.out.print("Enter Withdrawal Amount: ₹");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid Amount.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient Balance.");
        } else {

            balance -= amount;

            addTransaction("Withdrawn ₹" + amount);

            System.out.println("Transaction Successful.");
            System.out.println("Remaining Balance: ₹" + balance);
        }
    }

    static void fastCash() {

        System.out.println("\n------ FAST CASH ------");
        System.out.println("1. ₹500");
        System.out.println("2. ₹1000");
        System.out.println("3. ₹2000");
        System.out.println("4. ₹5000");
        System.out.print("Choose Option: ");

        int option = sc.nextInt();

        int amount = 0;

        switch (option) {
            case 1:
                amount = 500;
                break;
            case 2:
                amount = 1000;
                break;
            case 3:
                amount = 2000;
                break;
            case 4:
                amount = 5000;
                break;
            default:
                System.out.println("Invalid Option.");
                return;
        }

        if (amount > balance) {
            System.out.println("Insufficient Balance.");
        } else {
            balance -= amount;

            addTransaction("Fast Cash ₹" + amount);

            System.out.println("Please Collect Your Cash.");
            System.out.println("Remaining Balance: ₹" + balance);
        }
    }

    static void miniStatement() {

        System.out.println("\n------ MINI STATEMENT ------");

        if (count == 0) {
            System.out.println("No Transactions Yet.");
        } else {

            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + ". " + statement[i]);
            }
        }

        System.out.println("Current Balance: ₹" + balance);
    }

    static void changePin() {

        System.out.print("Enter Current PIN: ");
        int current = sc.nextInt();

        if (current == pin) {

            System.out.print("Enter New 4-digit PIN: ");
            pin = sc.nextInt();

            System.out.println("PIN Changed Successfully.");

        } else {
            System.out.println("Incorrect Current PIN.");
        }
    }

    static void addTransaction(String transaction) {

        if (count < statement.length) {
            statement[count] = transaction;
            count++;
        }
    }
}
