package Car.models;

import Car.Car;

public class BMW extends Car {

    public BMW(int year, String gearbox, String model, String number, String fuel, String color) {
        super(year, gearbox, model, number, "BMW", fuel, color);
    }

    public void activateSportMode() {
        System.out.println("Sport mode enabled!");
    }

    @Override
    public String displayInfo() {
        return retrieveDetails();
    }
}