class Bank {
    private ArrayList<Customer> customers;
    public Bank() {
        this.customers = new ArrayList<>();
    }
    public void addCustomer(Customer customer) {
        if (customer != null) {
            customers.add(customer);
        } else {
            System.out.println("Cannot add a null customer.");
        }
    }
    public ArrayList<Customer> getCustomers() {
        return new ArrayList<>(customers); 
    }
    public void transferFunds(Customer customer, int fromAccountIndex, int toAccountIndex, double amount) {
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }
        Account fromAccount = customer.getAccount(fromAccountIndex);
        Account toAccount = customer.getAccount(toAccountIndex);
        if (fromAccount != null && toAccount != null) {
            if (fromAccount.withdraw(amount)) {
                toAccount.deposit(amount);
                System.out.println("Transferred " + amount + " from account " + fromAccountIndex +
                        " to account " + toAccountIndex);
            } else {
                System.out.println("Transfer failed due to insufficient funds.");
            }
        }
    }
}