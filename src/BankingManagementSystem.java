import java.util.Scanner;

public class BankingManagementSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Variables
        String accountNumber = "1001001";
        String name = "Dip Narayan Chowdhury";
        int pin = 1234;
        double balance = 10000;

        int choice;
        boolean login = false;

        // Login
        System.out.println("================================");
        System.out.println("        WELCOME TO DNC BANK");
        System.out.println("================================");

        System.out.print("Enter Account Number: ");
        String inputAccount = scanner.nextLine();

        System.out.print("Enter PIN: ");
        int inputPin = scanner.nextInt();

        if (inputAccount.equals(accountNumber) && inputPin == pin) {

            login = true;

            System.out.println();
            System.out.println("Login Successful!");
            System.out.println("Welcome " + name);

            // Banking Menu
            while (login) {

                System.out.println();
                displayMenu();

                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {

                    case 1:

                        displayAccountDetails(accountNumber, name, balance);

                        break;

                    case 2:

                        displayBalance(balance);

                        break;

                    case 3:

                        System.out.print("Enter deposit amount: ");
                        double deposit = scanner.nextDouble();

                        if (deposit > 0) {

                            balance = calculateBalanceAfterDeposit(balance, deposit);

                            System.out.println("Deposit Successful!");
                            System.out.println("New Balance: " + balance);

                        } else {

                            System.out.println("Invalid amount.");

                        }

                        break;

                    case 4:

                        System.out.print("Enter withdrawal amount: ");
                        double withdraw = scanner.nextDouble();

                        if (withdraw > 0 && withdraw <= balance) {

                            balance = calculateBalanceAfterWithdraw(balance, withdraw);
                            System.out.println("Withdrawn Successful!");
                            System.out.println("New Balance: " + balance);

                        } else {

                            System.out.println("Invalid amount or insufficient balance.");

                        }

                        break;

                    case 5:

                        System.out.println("You have been logged out.");

                        login = false;

                        break;

                    default:

                        System.out.println("Invalid choice.");

                }
            }

        } else {

            System.out.println();
            System.out.println("Invalid Account Number or PIN.");

        }

        System.out.println();
        System.out.println("Thank you for using DNC Bank.");

        scanner.close();
    }
    private static void displayMenu() {
        System.out.println("================================");
        System.out.println("          BANKING MENU");
        System.out.println("================================");
        System.out.println("1. Account Details");
        System.out.println("2. Check Balance");
        System.out.println("3. Deposit Money");
        System.out.println("4. Withdraw Money");
        System.out.println("5. Logout");
        System.out.println("================================");
    }
    private static void displayAccountDetails(String accountNumber, String name, double balance) {
        System.out.println();
        System.out.println("====== ACCOUNT DETAILS ======");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Name           : " + name);
        System.out.println("Balance        : " + balance);
    }
    private static void displayBalance(double balanceToDisplay) {
        System.out.println();
        System.out.println("Current Balance: " + balanceToDisplay);
    }
    private static double calculateBalanceAfterDeposit(double currentBalance, double depositAmount) {
        currentBalance = currentBalance + depositAmount;

        return currentBalance;
    }
    private static double calculateBalanceAfterWithdraw(double currentBalance, double withdrawnAmount) {
        currentBalance = currentBalance - withdrawnAmount;

        return currentBalance;
    }

}