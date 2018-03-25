/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccountjob;

/**
 *
 * @author Phil Brosgol <phil.brosgol at gmail.com>
 */
public class BankAccountJob implements Runnable{
    
    private BankAccount account = new BankAccount(100);
    
    public static void main(String[] args) {
        BankAccountJob job = new BankAccountJob();
        Thread terrence = new Thread(job);
        Thread philip = new Thread(job);
        terrence.setName("Terrence");
        philip.setName("Philip");
        terrence.start();
        philip.start();
    }
    
    @Override
    public void run(){
        //attempt to withdraw cash 10 times
        for (int i = 1; i <= 10; i++) {
            makeWithdrawal(10);
            if (account.getBalance() < 0){
                System.out.println("OVERDRAWN!!! NICKEL AND DIMED TO DEATH!!!");
            }
        }
    }
    
    public synchronized void makeWithdrawal(int amount){
        // check if there's enough balance in the account
        // if there is, take a nap and then withdraw the cash
        if (account.getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() + " is about to withdraw.");
            try {
                System.out.println(Thread.currentThread().getName() + " is taking a nap...");
                Thread.sleep(500);
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " woke up.");
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " withdraws cash. " + account.getBalance() + " left in account.");
        } else {
            System.out.println("Sorry, there's not enough cash for " + Thread.currentThread().getName() + ".");
        }
    }
    
}

class BankAccount {
    private int balance;
    
    BankAccount(int amount){
        balance = amount;
    }
    
    public int getBalance(){
        return balance;
    }
    
    public void withdraw(int amount){
        balance = balance - amount;
    }
}
