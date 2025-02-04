package org.example;


public class Ford extends Car {

    public Ford(int year, String gearbox, String model, String number, String fuel, String color) {
        super(year, gearbox, model, number, "Ford", fuel, color);
    }

    public void towingAssist(int weight) {
        System.out.println(weight > 3000 ? "Warning: Overweight!" :
                "Towing mode activated. Stability and traction control adjusted.");
    }

    @Override
    public String displayInfo() {
        return retrieveDetails();
    }
}