import java.util.ArrayList;
import java.util.Scanner;

abstract class Account {
    private String accountNumber;
    private String ownerName;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with initial balance: " + initialBalance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<String> getTransactionHistory() {
        return transactionHistory;
    }

    public abstract void deposit(double amount);

    public abstract boolean withdraw(double amount);

    protected void addTransaction(String transaction) {
        transactionHistory.add(transaction);
    }
}

class SavingsAccount extends Account {
    public SavingsAccount(String accountNumber, String ownerName, double initialBalance) {
        super(accountNumber, ownerName, initialBalance);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
            addTransaction("Deposited: " + amount + ", New Balance: " + getBalance());
        }
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            setBalance(getBalance() - amount);
            addTransaction("Withdrew: " + amount + ", New Balance: " + getBalance());
            return true;
        } else {
            return false;
        }
    }
}

class CheckingAccount extends Account {
    public CheckingAccount(String accountNumber, String ownerName, double initialBalance) {
        super(accountNumber, ownerName, initialBalance);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
            addTransaction("Deposited: " + amount + ", New Balance: " + getBalance());
        }
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            setBalance(getBalance() - amount);
            addTransaction("Withdrew: " + amount + ", New Balance: " + getBalance());
            return true;
        } else {
            return false;
        }
    }
}

class Bank {
    private ArrayList<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account findAccountByNumber(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        Bank myBank = new Bank();

        myBank.addAccount(new SavingsAccount("230321001", "Md. Atikul Islam", 1000.0));
        myBank.addAccount(new CheckingAccount("01631095127", "Md. Al-Jubair", 5000.0));
       Account account1 = myBank.findAccountByNumber("230321001");
        if (account1 != null) {
            account1.deposit(200);
            account1.withdraw(100);
        }
        Account account2 = myBank.findAccountByNumber("01631095127");
        if (account2 != null) {
            account2.deposit(1000);
            account2.withdraw(500);
            account2.deposit(2000);
            account2.withdraw(1000);
            account2.deposit(1500);
            account2.withdraw(750);
            account2.deposit(300);
            account2.withdraw(200);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number: ");
        String inputAccountNumber = scanner.nextLine();

        Account foundAccount = myBank.findAccountByNumber(inputAccountNumber);
        if (foundAccount != null) {
            System.out.println("\n--- Account Details ---");
            System.out.println("Account Number: " + foundAccount.getAccountNumber());
            System.out.println("Owner Name: " + foundAccount.getOwnerName());
            System.out.println("Current Balance: " + foundAccount.getBalance());
            System.out.println("\nTransaction History:");
            for (String transaction : foundAccount.getTransactionHistory()) {
                System.out.println(transaction);
            }
        } else {
            System.out.println("Account with number " + inputAccountNumber + " not found.");
        }

        scanner.close();
    }
}