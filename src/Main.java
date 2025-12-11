import service.Account;
import service.AccountService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("=== I created a new Account object instead of injecting it in command line runner ===\n");
        System.out.println("=====================================================================================");
        // Create account
        AccountService account = new Account();

        // Perform transactions
        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);

        // Print statement
        System.out.println("\nPrinting the Statement of the Account :\n");
        account.printStatement();
    }
    }
