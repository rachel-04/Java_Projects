/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab3;

/**
 *
 * @author rachelclement
 */
public class CounterTry {
    public static void main(String[] args) {
        
        Counter hundreds = new Counter(10, null);       // leftmost
        Counter tens = new Counter(10, hundreds);       // middle
        Counter ones = new Counter(10, tens);           // rightmost

        for (int i = 0; i < 120; i++) {
            System.out.println(hundreds + " " + tens + " " + ones + " = " + ones.getCount());
            ones.increment();
        }
    }
}
