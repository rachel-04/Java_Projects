package coe318.lab4;

public class Account {
    private String name;
    private int number;
    private double balance;

    public Account(String name, int number, double initialBalance) {
        this.name = name;
        this.number = number;
        this.balance = initialBalance;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    @Override
    public String toString() {
        return "(" + getName() + ", " + getNumber() + ", " + String.format("$%.2f", getBalance()) + ")";
    }
}
