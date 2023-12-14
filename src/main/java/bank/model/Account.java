package bank.model;

public class Account {
    private static int count = 1;
    private int accountNo;
    private int id;
    private String name;
    private String accountType;
    private int balance;

    public Account(int accountNo, String name, String accountType, int balance) {
        this.id = count++;
        this.accountNo = accountNo;
        this.name = name;
        this.accountType = accountType;
        this.balance = balance;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public String toString() {
        return "Account: " + id + "\nAccount number: "+ accountNo +"\nName: " + name + "\nAccount Type: " + accountType + "\nBalance: " + balance + "\n";
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
