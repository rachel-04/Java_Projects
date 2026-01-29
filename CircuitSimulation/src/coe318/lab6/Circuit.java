/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab6;

import java.util.ArrayList;

public class Circuit {
    private static Circuit instance = null;
    private ArrayList<Resistor> resistors;

    private Circuit() {
        resistors = new ArrayList<>();
    }

    public static Circuit getInstance() {
        if (instance == null) {
            instance = new Circuit();
        }
        return instance;
    }

    public void add(Resistor r) {
        resistors.add(r);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Resistor r : resistors) {
            sb.append(r).append("\n");
        }
        return sb.toString();
    }
}
