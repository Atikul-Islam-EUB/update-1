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
        System.out.println("\n--- Banking Operations ---");
        System.out.println("Depositing into savings account:");
        savingsAccount.deposit(200);
        System.out.println("Withdrawing from checking account:");
        checkingAccount.withdraw(100);
        System.out.println("Transferring funds from savings to checking account:");
        myBank.transferFunds(customer1, 0, 1, 300);
        System.out.println("\nFinal Balances:");
        System.out.println("Savings account balance: " + savingsAccount.getBalance());
        System.out.println("Checking account balance: " + checkingAccount.getBalance());
    }
}
