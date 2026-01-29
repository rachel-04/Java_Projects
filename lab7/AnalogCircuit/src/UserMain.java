package coe318.lab7;

import java.util.Scanner;

public class UserMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("end")) {
                System.out.println("All Done");
                break;
            } else if (input.equals("spice")) {
                Circuit.getInstance().spice();
            } else if (input.startsWith("r")) {
                String[] tokens = input.split(" ");
                int n1 = Integer.parseInt(tokens[1]);
                int n2 = Integer.parseInt(tokens[2]);
                double r = Double.parseDouble(tokens[3]);
                Resistor resistor = new Resistor(n1, n2, r);
                Circuit.getInstance().addResistor(resistor);
            } else if (input.startsWith("v")) {
                String[] tokens = input.split(" ");
                int n1 = Integer.parseInt(tokens[1]);
                int n2 = Integer.parseInt(tokens[2]);
                double v = Double.parseDouble(tokens[3]);
                VoltageSource vs = new VoltageSource(n1, n2, v);
                Circuit.getInstance().addVoltageSource(vs);
            }
        }
    }
}
