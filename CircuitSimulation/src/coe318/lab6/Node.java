/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab6;

public class Node {
    private static int nodeCount = 0; 
    private int id;

    public Node() {
        this.id = nodeCount++; // Assign and increment unique ID
    }

    @Override
    public String toString() {
        return Integer.toString(id); 
    }

    public int getId() {
        return id;
    }
}

