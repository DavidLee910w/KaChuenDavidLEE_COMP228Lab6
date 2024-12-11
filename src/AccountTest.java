import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {
    public static void main(String[] args) {
        // Create an account with an initial balance
        Account account = new Account(1000.0);

        // Create a list of transaction tasks
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(account, "deposit", 360.0));
        transactions.add(new Transaction(account, "withdraw", 400.0));
        transactions.add(new Transaction(account, "deposit", 720.0));
        transactions.add(new Transaction(account, "withdraw", 600.0));
        transactions.add(new Transaction(account, "withdraw", 550.0));

        // Create an ExecutorService with a fixed thread pool
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Execute all transaction tasks
        for (Transaction transaction : transactions) {
            executor.execute(transaction);
        }

        // Shutdown the executor
        executor.shutdown();
        while (!executor.isTerminated()) {
            // Wait for all tasks to finish
        }

        // Print final account balance
        System.out.println("Final Account Balance: " + account.getBalance());
    }
}