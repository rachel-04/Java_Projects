package coe318.lab7;

import java.util.ArrayList;

public class Circuit {
    private static Circuit instance = null;
    private ArrayList<Resistor> resistors = new ArrayList<>();
    private ArrayList<VoltageSource> voltageSources = new ArrayList<>();

    private Circuit() {}  

    public static Circuit getInstance() {
        if (instance == null) {
            instance = new Circuit();
        }
        return instance;
    }

    public void addResistor(Resistor r) {
        resistors.add(r);
    }

    public void addVoltageSource(VoltageSource v) {
        voltageSources.add(v);
    }

    public void spice() {
        for (int i = 0; i < voltageSources.size(); i++) {
            VoltageSource vs = voltageSources.get(i);
            System.out.printf("V%d %d %d DC %.1f%n", i + 1, vs.getNode1(), vs.getNode2(), vs.getVoltage());
        }
        for (int i = 0; i < resistors.size(); i++) {
            Resistor r = resistors.get(i);
            System.out.printf("R%d %d %d %.2f%n", i + 1, r.getNode1(), r.getNode2(), r.getResistance());
        }
    }
}
