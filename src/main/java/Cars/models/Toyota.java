package Cars.models;

public class Toyota extends Car {

    private boolean hybrid;

    public Toyota(int year, String gearbox, String model, String number, String fuel, String color, boolean hybrid) {
        super(year, gearbox, model, number, "Toyota", fuel, color);
        this.hybrid = hybrid;
    }

    public void checkHybridMode(int batteryLevel) {
        if (!hybrid) {
            System.out.println("This Toyota model is not a hybrid.");
            return;
        }
        System.out.println(batteryLevel > 50 ? "Running on electric mode." :
                batteryLevel > 10 ? "Hybrid mode active." :
                        "Battery low, switching to fuel.");
    }

    @Override
    public String displayInfo() {
        return retrieveDetails() + "\n- Hybrid: " + (hybrid ? "Yes" : "No");
    }
}