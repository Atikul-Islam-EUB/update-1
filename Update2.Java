import java.util.ArrayList;
class Account {
    protected double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}
class SavingsAccount extends Account {
    public SavingsAccount(double balance) {
        super(balance);
    }
}
class CheckingAccount extends Account {
    public CheckingAccount(double balance) {
        super(balance); 
    }
}

class Customer {
    private ArrayList<Account> accounts;

    public Customer() {
        this.accounts = new ArrayList<>();
    }
    public void addAccount(Account account) {
        accounts.add(account);
    }
    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}
class Bank {
    private ArrayList<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}

public class Main {
    public static void main(String[] args) {
        Bank myBank = new Bank();
        
        Customer customer1 = new Customer();
        
        SavingsAccount savingsAccount = new SavingsAccount(1000);
        CheckingAccount checkingAccount = new CheckingAccount(500);

        customer1.addAccount(savingsAccount);
        customer1.addAccount(checkingAccount);
        
        myBank.addCustomer(customer1);
        
        System.out.println("Bank has " + myBank.getCustomers().size() + " customer(s).");
        System.out.println("Customer 1 has " + customer1.getAccounts().size() + " account(s).");
    }
}
