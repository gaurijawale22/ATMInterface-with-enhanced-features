public abstract class Account {
    protected String accountNumber;
    protected double balance;
    protected List<Transaction> transactions;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        transactions = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    // Other Account methods...
}
