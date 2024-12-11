public class Transaction implements Runnable {
    private Account account;
    private String transactionType;
    private double amount;

    public Transaction(Account account, String transactionType, double amount) {
        this.account = account;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    @Override
    public void run() {
        if (transactionType.equalsIgnoreCase("deposit")) {
            account.deposit(amount);
        } else if (transactionType.equalsIgnoreCase("withdraw")) {
            account.withdraw(amount);
        }
    }
}