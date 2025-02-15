import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankingSystem bankingSystem = new BankingSystem();

        while (true) {
            System.out.println("\n--- Banking Management System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Log Out");
            System.out.println("Choose an option:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    String accountHolderName = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    int passWord = scanner.nextInt();
                    bankingSystem.createAccount(accountNumber, accountHolderName, passWord);
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextLine();
                    Account depositAccount = bankingSystem.getAccount(accountNumber);
                    if (depositAccount != null) {
                        System.out.print("Enter Password: ");
                        passWord = scanner.nextInt();
                        if (depositAccount.getPassWord() == passWord) {
                            System.out.print("Enter Amount to Deposit: ");
                            double depositAmount = scanner.nextDouble();
                            depositAccount.deposit(depositAmount);
                        } else {
                            System.out.println("Wrong Password.");
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextLine();
                    Account withdrawAccount = bankingSystem.getAccount(accountNumber);
                    if (withdrawAccount != null) {
                        System.out.print("Enter Password: ");
                        passWord = scanner.nextInt();
                        if (withdrawAccount.getPassWord() == passWord) {
                            System.out.print("Enter Amount to Withdraw: ");
                            double withdrawAmount = scanner.nextDouble();
                            withdrawAccount.withdraw(withdrawAmount);
                        } else {
                            System.out.println("Wrong Password.");
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextLine();
                    Account balanceAccount = bankingSystem.getAccount(accountNumber);
                    if (balanceAccount != null) {
                        System.out.print("Enter Password: ");
                        passWord = scanner.nextInt();
                        if (balanceAccount.getPassWord() == passWord) {
                            System.out.println("Current Balance: " + balanceAccount.getBalance());
                        } else {
                            System.out.println("Wrong Password.");
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
