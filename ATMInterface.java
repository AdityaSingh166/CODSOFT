import java.util.Scanner;

interface ATM {
    void displayBalance();
    void deposit();
    void withdraw();
}

class Bank implements ATM {
    private double balance;

    public Bank(double initialBalance) {
        this.balance = initialBalance;
    }

    
    public void displayBalance() {
        System.out.println("Your account balance is: ₹" + balance);
    }

   
    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the deposit amount: ₹");
        double amount = scanner.nextDouble();
        balance += amount;
        System.out.println("Deposit successful. New balance: ₹" + balance);
    }

   
    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the withdrawal amount: ₹");
        double amount = scanner.nextDouble();
        
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: ₹" + balance);
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Bank account = new Bank(1000.0);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("ATM Interface");
            System.out.println("1. Display Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    account.displayBalance();
                    break;
                case 2:
                    account.deposit();
                    break;
                case 3:
                    account.withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
