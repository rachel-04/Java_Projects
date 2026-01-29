/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab7;

public class Resistor {
    private int node1, node2;
    private double resistance;

    public Resistor(int node1, int node2, double resistance) {
        if (resistance <= 0) {
            throw new IllegalArgumentException("Resistance must be greater than zero.");
        }
        if (node1 == node2) {
            throw new IllegalArgumentException("A resistor cannot connect a node to itself.");
        }

        this.node1 = node1;
        this.node2 = node2;
        this.resistance = resistance;
    }

    public int getNode1() {
        return node1;
    }

    public int getNode2() {
        return node2;
    }

    public double getResistance() {
        return resistance;
    }
}