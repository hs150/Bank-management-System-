import java.util.HashMap;
import java.util.Scanner;

class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private int passWord;

    public Account(String accountNumber, String accountHolderName, int passWord) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.passWord = passWord;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public int getPassWord() {
        return passWord;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

class BankingSystem {
    private HashMap<String, Account> accounts;

    public BankingSystem() {
        accounts = new HashMap<>();
    }

    public void createAccount(String accountNumber, String accountHolderName, int passWord) {
        if (!accounts.containsKey(accountNumber)) {
            Account newAccount = new Account(accountNumber, accountHolderName, passWord);
            accounts.put(accountNumber, newAccount);
            System.out.println("Account created successfully for " + accountHolderName);
        } else {
            System.out.println("Account with this number already exists.");
        }
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}
