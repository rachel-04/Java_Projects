/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */package coe318.lab6;

public class Resistor {
    private static int resistorCount = 1;
    private int id;
    private double resistance;
    private Node node1, node2;

    public Resistor(double resistance, Node node1, Node node2) {
        if (resistance <= 0) {
            throw new IllegalArgumentException("Resistance must be positive.");
        }
        if (node1 == null || node2 == null || node1 == node2) {
            throw new IllegalArgumentException("Invalid node connections.");
        }

        this.id = resistorCount++;
        this.resistance = resistance;
        this.node1 = node1;
        this.node2 = node2;

        Circuit.getInstance().add(this); 
    }

    public Node[] getNodes() {
        return new Node[]{node1, node2};
    }

    @Override
    public String toString() {
        return "R" + id + " " + node1 + " " + node2 + " " + resistance;
    }
}
