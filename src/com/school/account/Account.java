/*
Design a class named Account that contains:

9. A method named getMonthlyInterestRate that returns the monthly interest rate.
10. A method named getMonthlyInterest that returns the monthly interest on the account.  Monthly interest is the balance times the monthly interest rate.  Note that interest rates are percentages (like 4.5%) so need to be divided by 100.

Requirements:
1. Put your Account class in its own Account.java file.
2. Use the word "this" in front of your instance variables.
3. Do some validating in setBalance and setAnnualInterestRate, not allowing values less than zero to be set.
4. Create a TestAccount.java file with a main that tests your Account.  This class should create an Account object with id 1122, balance of $20,000, and annual interest rate of 4.5%.  Withdraw $2,500 from the account, deposit $3,000 into the account.  Print the account balance, monthly interest and the date when the account was created.

Sample output:

Balance: $20500.00
Monthly interest: $76.88
Date created: Wed Oct 23 07:07:41 MDT 2019

Add comments to your program starting with your name at the top, then throughout your program to describe what you are doing.  Also be sure to indent consistently throughout your program to make it more readable.

Extra Credit: For 5 points of extra credit, get the user involved in your main.  Let the user enter the account id and balance, then let the user do some deposits and withdrawals.

Sample output:

1. Show balance
2. Deposit funds
3. Withdraw funds
4. Exit
Enter choice: 1
Balance: $0.00
Monthly interest: $0.00
Date created: Wed Oct 23 07:28:52 MDT 2019

1. Show balance
2. Deposit funds
3. Withdraw funds
4. Exit
Enter choice: 2
Enter amount to deposit: 3000

1. Show balance
2. Deposit funds
3. Withdraw funds
4. Exit
Enter choice: 1
Balance: $3000.00
Monthly interest: $11.25
Date created: Wed Oct 23 07:28:52 MDT 2019

1. Show balance
2. Deposit funds
3. Withdraw funds
4. Exit
Enter choice: 2
Enter amount to deposit: 1500

1. Show balance
2. Deposit funds
3. Withdraw funds
4. Exit
Enter choice: 1
Balance: $4500.00
Monthly interest: $16.88
Date created: Wed Oct 23 07:28:52 MDT 2019

1. Show balance
2. Deposit funds
3. Withdraw funds
4. Exit
Enter choice: 3
Enter amount to withdraw: 100

1. Show balance
2. Deposit funds
3. Withdraw funds
4. Exit
Enter choice: 1
Balance: $4400.00
Monthly interest: $16.50
Date created: Wed Oct 23 07:28:52 MDT 2019

1. Show balance
2. Deposit funds
3. Withdraw funds
4. Exit
Enter choice: 4
 */

package com.school.account;

import java.util.Date;

public class Account {
    private Integer id;
    private double balance;
    private double annualInterestRate;

    private Date dateCreated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    Account(){
        id = 0;
        balance = 0;
        dateCreated = new Date();
    }

    Account(Integer id, double balannce){
        id = id;
        balance = balance;
        dateCreated = new Date();
    }

    double getMonthlyInterestRate(){
        return getAnnualInterestRate()/12;
    }

    void withdraw(double amount){
        setBalance(getBalance() - amount);
    }

    void deposit(double amount){
        setBalance(getBalance() + amount);
    }


}
