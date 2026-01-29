/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab7;

public class VoltageSource {
    private int node1, node2;
    private double voltage;

    public VoltageSource(int node1, int node2, double voltage) {
        this.node1 = node1;
        this.node2 = node2;
        this.voltage = voltage;
    }

    public int getNode1() {
        return node1;
    }

    public int getNode2() {
        return node2;
    }

    public double getVoltage() {
        return voltage;
    }
}
