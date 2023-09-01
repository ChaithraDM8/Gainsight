package Day6.multithreadingAssignment;

import java.util.concurrent.Semaphore;

public class Transactions {
    Semaphore checkBalance = new Semaphore(0);
    Semaphore modifyBalance = new Semaphore(1);
    public void transact(BankAccount acc, double amount, char ttype){
        try{
            modifyBalance.acquire();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        if(ttype=='D' || ttype=='d')
        acc.setBalanceAmount(acc.getBalanceAmount()+amount);
        else if(ttype=='W' || ttype=='w'){
            acc.setBalanceAmount(acc.getBalanceAmount()-amount);


        }
        checkBalance.release();
    }
    public void checkBalance(BankAccount acc)
    {
        try
        {
            checkBalance.acquire();
        }
        catch(InterruptedException ex)
        {
            ex.printStackTrace();
        }
        System.out.println(acc.getBalanceAmount());
        modifyBalance.release();
    }
}
class ModifyBalanceThread implements Runnable{
    BankAccount acc;
    Transactions trans;
    double amount;
    Thread t;
    public ModifyBalanceThread(BankAccount acc,Transactions trans,double amount){
        this.acc=acc;
        this.amount=amount;
        this.trans=trans;
        t=new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        trans.transact(acc,amount,'w');
        System.out.println(acc.getBalanceAmount()+ "balance is modified");
    }
}
class CheckBalanceThread implements Runnable{

    BankAccount acc;
    Transactions trans;

    Thread t;
    public CheckBalanceThread(BankAccount acc, Transactions trans) {
        this.acc=acc;
        this.trans=trans;
        t=new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        trans.checkBalance(acc);
        System.out.println(acc.getBalanceAmount()+" R E A D");
    }
}
