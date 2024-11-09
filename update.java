import java.util.ArrayList;
class Account {
    double balance;
    Account(double balance) {
        this.balance = balance;
    }
}
class SavingsAccount extends Account {
    SavingsAccount(double balance) {
        super(balance);
    }
}
class CheckingAccount extends Account {
    CheckingAccount(double balance) {
        super(balance);
    }
}
class Customer {
    ArrayList<Account> accounts = new ArrayList<>();
    void addAccount(Account account) {
        accounts.add(account);
    }
}
class Bank {
    ArrayList<Customer> customers = new ArrayList<>();
    void addCustomer(Customer customer) {
        customers.add(customer);
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
    }
}
