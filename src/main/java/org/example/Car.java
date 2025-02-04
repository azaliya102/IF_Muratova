package org.example;

public abstract class Car {
    private int manufactureYear;
    private String gearbox;
    private String model;
    private String licensePlate;
    private String brand;
    private String fuel;
    private String paint;

    public Car(int manufactureYear, String gearbox, String model, String licensePlate, String brand, String fuel, String paint) {
        this.manufactureYear = manufactureYear;
        this.gearbox = gearbox;
        this.model = model;
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.fuel = fuel;
        this.paint = paint;
    }

    public Car() {
    }

    public abstract String displayInfo();

    public String getPaint() {
        return this.paint;
    }

    public void setPaint(String paint) {
        this.paint = paint;
    }

    public void changeColor(String newColor) {
        System.out.println("Changing color from " + this.paint + " to " + newColor);
        this.paint = newColor;
        System.out.println("Color changed successfully!");
    }

    public int getManufactureYear() {
        return this.manufactureYear;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public String getFuel() {
        return fuel;
    }

    public String retrieveDetails() {
        StringBuilder details = new StringBuilder("Vehicle Details:");
        if (manufactureYear != 0) details.append("\n- Year: ").append(manufactureYear);
        if (gearbox != null) details.append("\n- Gearbox: ").append(gearbox);
        if (model != null) details.append("\n- Model: ").append(model);
        if (licensePlate != null) details.append("\n- License Plate: ").append(licensePlate);
        if (brand != null) details.append("\n- Brand: ").append(brand);
        if (fuel != null) details.append("\n- Fuel: ").append(fuel);
        if (paint != null) details.append("\n- Paint: ").append(paint);
        return details.toString();
    }
}