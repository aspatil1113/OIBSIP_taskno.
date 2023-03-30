import java.util.Scanner;
//creating class
public class ATMinterface {
    private static Scanner sc = new Scanner(System.in);
    private static int Balance = 10000; //initial balance
    private static String[] transactions = new String[10];
    private static int transactionIndex = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to the ATM");
        System.out.print("Enter your PIN: ");
        String userPin = sc.nextLine();
        if (authenticate(userPin)) {
            System.out.println("Authentication successful");
            showMenu();
        } else {
            System.out.println("Authentication failed");
        }
    }

    private static boolean authenticate(String userPin) {
        // Perform authentication logic here
        return true;
    }

    private static void showMenu() {
        System.out.println("Please select an option:");
        System.out.println("1. Transactions History");
        System.out.println("2. Balance");
        System.out.println("3. withdraw");
        System.out.println("4. deposit");
        System.out.println("5. transfer");
        System.out.println("6. Quit");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline character

        //implementation of switch case
        switch (choice) {
            case 1:
                showTransactionsHistory();  //for displaying transaction history
                break;
            case 2:
                Balance();   //to check balance
                break;
            case 3:
                withdraw();    //withdraw
                break;
            case 4:
                deposit();   //deposit
                break;
            case 5:
                transfer();    //transfer
                break;
            case 6:
                System.out.println("Thank you for using the ATM");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        if (choice != 5) {
            showMenu();
        }
    }

    //transactions history
    private static void showTransactionsHistory() {
        System.out.println("Transactions History:");
        for (String transaction : transactions) {
            if (transaction != null) {
                System.out.println(transaction);
            }
        }
    }
    //balance
    private static void Balance()
    {
        System.out.println("Current Balance : " + Balance);
    }

    //withdraw
    private static void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        int amount = sc.nextInt();
        sc.nextLine(); // Consume newline character
        if (amount > Balance) {
            System.out.println("Insufficient balance");
        } else {
            Balance -= amount;
            transactions[transactionIndex++] = "Withdrawal: $" + amount;
            System.out.println("Withdrawal successful");
        }
    }
    //deposit
    private static void deposit() {
        System.out.print("Enter amount to deposit: ");
        int amount = sc.nextInt();
        sc.nextLine(); // Consume newline character
        Balance += amount;
        transactions[transactionIndex++] = "Deposit: $" + amount;
        System.out.println("Deposit successful");
    }
     //tansfer
    private static void transfer() {
        System.out.print("Enter recipient's account number: ");
        String recipient = sc.nextLine();
        System.out.print("Enter amount to transfer: ");
        int amount = sc.nextInt();
        sc.nextLine(); // Consume newline character
        if (amount > Balance) {
            System.out.println("Insufficient balance");
        }
        else {
            Balance -= amount;
            transactions[transactionIndex++] = "Transfer to " + recipient + ": $" + amount;
            System.out.println("Transfer successful");
        }
    }
}
