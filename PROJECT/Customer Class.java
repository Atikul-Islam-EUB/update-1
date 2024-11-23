class Customer {
    private ArrayList<Account> accounts;
    public Customer() {
        this.accounts = new ArrayList<>();
    }
    public void addAccount(Account account) {
        if (account != null) {
            accounts.add(account);
        } else {
            System.out.println("Cannot add a null account.");
        }
    }
    public ArrayList<Account> getAccounts() {
        return new ArrayList<>(accounts); 
    }
    public Account getAccount(int index) {
        if (index >= 0 && index < accounts.size()) {
            return accounts.get(index);
        } else {
            System.out.println("Invalid account index.");
            return null;
        }
    }
}