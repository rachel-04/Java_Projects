/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab3;

/**
 *
 * @author rachelclement
 */
public class Counter {
    private int digit;
    private int modulus;
    private Counter left;

    public Counter(int modulus, Counter left) {
        this.modulus = modulus;
        this.left = left;
        this.digit = 0;
    }

    public int getCount() {
        if (left == null) {
            return digit;
        } else {
            return digit + modulus * left.getCount();
        }
    }

    public void increment() {
        digit++;
        if (digit == modulus) {
            digit = 0;
            if (left != null) {
                left.increment();
            }
        }
    }

    @Override
    public String toString() {
        return "" + digit;
    }
}
