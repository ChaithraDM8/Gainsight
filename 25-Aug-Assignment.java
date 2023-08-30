
import java.util.Date;

public class BankAccount {
    private String accountNumber;
   private String accountStatus;
   private Date openDate;
   private double balanceAmount;
   BankAccount(){};

    public BankAccount(String accountNumber, String accountStatus, Date openDate, double balanceAmount) {
        this.accountNumber = accountNumber;
        this.accountStatus = accountStatus;
        this.openDate = openDate;
        this.balanceAmount = balanceAmount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountStatus='" + accountStatus + '\'' +
                ", openDate=" + openDate +
                ", balanceAmount=" + balanceAmount +
                '}';
    }
}
public class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException(String s){super(s);}
}
public class Transaction {

   public static void deposit(BankAccount account, double amount) {
        double addAmount = checkBalance(account) + amount;
        account.setBalanceAmount(addAmount);
    }

public static void withdrawn(BankAccount account, double amount) {
        double balance = checkBalance(account);
        if (balance >= amount)
            account.setBalanceAmount(balance - amount);
        else throw new InsufficientBalanceException("your existing amount is not sufficient:" + amount);
    }

     public static double checkBalance(BankAccount account) {
        return account.getBalanceAmount();
    }

    public static void main(String[] args) throws InterruptedException {
       Transaction transaction = new Transaction();
      BankAccount acc=new BankAccount("12345", "active", new Date(), 1000));
       transaction.deposit(acc, 1000);
      transaction.withdrawn(acc, 500);
       transaction.checkBalance(acc);
            System.out.println("ReadBalanceThread" + " " +acc.getBalanceAmount());
