package Day6.multithreadingAssignment;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        BankAccount acc=new BankAccount ("12345", "active", new Date(), 1000);
        Transactions trans=new Transactions();
        CheckBalanceThread CBT = new CheckBalanceThread(acc,trans);
        ModifyBalanceThread MBT=new ModifyBalanceThread(acc,trans,600);
 try{
     CBT.t.join();
     MBT.t.join();
 } catch (InterruptedException e) {
     throw new RuntimeException(e);
 }
    }
}
