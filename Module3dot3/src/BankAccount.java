public class BankAccount {
    private static int accountamount = 0;
    private int accountnumber;
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
        accountnumber = ++accountamount;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        if ((balance - amount) <= 0) {
            balance = 0;
        } else {
            balance -= amount;
        }
    }

    public int getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountnumber;
    }

    public static int getTotalAccounts() {
        return accountamount;
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(2000);

        account1.deposit(500);
        account2.withdraw(800);

        System.out.println("Account " + account1.getAccountNumber() + " balance: " + account1.getBalance());
        System.out.println("Account " + account2.getAccountNumber() + " balance: " + account2.getBalance());

        System.out.println("Total number of accounts: " + BankAccount.getTotalAccounts());
    }
}
