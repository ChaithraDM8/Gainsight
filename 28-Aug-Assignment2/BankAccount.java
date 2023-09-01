package Day6.multithreadingAssignment;

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
