package com.pluralsight;

public class Main {
    public static void main(String[] args) {

        BankAccount.setInterestRate(0.07);

        BankAccount acct1 = new BankAccount("12","MAtt", 10000);
        BankAccount acct2 = new BankAccount("12","MAtt", 100900);
        BankAccount acct3 = new BankAccount("12","MAtt", 109000);
        BankAccount acct4 = new BankAccount("12","MAtt", 1099000);
        BankAccount acct5 = new BankAccount("12","MAtt", 10099900);

        acct1.deposit(10);


    }
}