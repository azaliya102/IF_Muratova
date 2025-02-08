package Cars.models;

public class Suzuki extends Car {

    private boolean allWheelDrive;

    public Suzuki(int year, String gearbox, String model, String number, String fuel, String color, boolean allWheelDrive) {
        super(year, gearbox, model, number, "Suzuki", fuel, color);
        this.allWheelDrive = allWheelDrive;
    }

    public void toggleAllWheelDrive(boolean enable) {
        if (enable) {
            System.out.println("All-wheel drive activated.");
        } else {
            System.out.println("All-wheel drive deactivated.");
        }
    }

    @Override
    public String displayInfo() {
        return retrieveDetails() + "\n- All-Wheel Drive: " + (allWheelDrive ? "Enabled" : "Disabled");
    }
}