package org.example;

public class Mercedes extends Car {

    public Mercedes(int year, String gearbox, String model, String number, String fuel, String color) {
        super(year, gearbox, model, number, "Mercedes", fuel, color);
    }

    public void autoPark() {
        System.out.println("Scanning for parking spots... Parking assist engaged!");
    }

    @Override
    public String displayInfo() {
        return retrieveDetails();
    }
}