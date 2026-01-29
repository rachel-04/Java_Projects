package coe318.lab6;

public class Main {
    public static void main(String[] args) {
        // Normal nodes
        Node n0 = new Node();
        Node n1 = new Node();
        Node n2 = new Node();

        // Valid resistor
        try {
            Resistor r1 = new Resistor(10.0, n0, n1); 
            System.out.println("r1 created: " + r1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating r1: " + e.getMessage());
        }

        // Negative resistance
        try {
            Resistor r2 = new Resistor(-5.0, n1, n2); 
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating r2 (negative resistance): " + e.getMessage());
        }

        // Zero resistance
        try {
            Resistor r3 = new Resistor(0.0, n0, n2); 
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating r3 (zero resistance): " + e.getMessage());
        }

        // Null node
        try {
            Resistor r4 = new Resistor(20.0, n0, null); 
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating r4 (null node): " + e.getMessage());
        }

        // Same node on both ends(short circuit)
        try {
            Resistor r5 = new Resistor(15.0, n1, n1); 
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating r5 (same node): " + e.getMessage());
        }

        // Another valid resistor (same nodes but reverse order)
        try {
            Resistor r6 = new Resistor(25.0, n1, n0); 
            System.out.println("r6 created: " + r6);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating r6: " + e.getMessage());
        }

        // Print final circuit state
        System.out.println("\n=== Final Circuit ===");
        System.out.print(Circuit.getInstance());
    }
}
