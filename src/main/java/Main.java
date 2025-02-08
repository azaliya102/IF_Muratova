import Cars.models.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Car> carList = new ArrayList<>();
        carList.add(new Toyota(2010, "Automatic", "Camry", "A123BC", "Gasoline", "Black", true));
        carList.add(new Toyota(2005, "Manual", "Corolla", "B234CD", "Gasoline", "Green", false));
        carList.add(new Suzuki(2012, "Automatic", "Swift", "C345DE", "Gasoline", "Red", false));
        carList.add(new Ford(2000, "Manual", "Focus", "D456EF", "Diesel", "Blue"));
        carList.add(new BMW(2020, "Automatic", "X5", "E567FG", "Gasoline", "Green"));
        carList.add(new Ford(2007, "Automatic", "Mustang", "G789HI", "Gasoline", "Black"));
        carList.add(new Suzuki(2003, "Manual", "Grand Vitara", "H890IJ", "Gasoline", "Green", true));
        carList.add(new BMW(2019, "Automatic", "M5", "I901JK", "Gasoline", "Silver"));
        carList.add(new Mercedes(2016, "Automatic", "C-Class", "J234LM", "Diesel", "White"));
        carList.add(new Mercedes(2018, "Automatic", "E-Class", "L456OP", "Gasoline", "Black"));

        printModernCars(carList);
        changeGreenCarsToRed(carList);
        printCarsByBrand(carList, "Toyota");
    }

    public static void printModernCars(List<Car> cars) {
        for (Car car : cars) {
            if (car.getManufactureYear() > 2006) {
                System.out.println(car.retrieveDetails());
            } else {
                System.out.println("Устаревший авто: " + car.getBrand() + " " + car.getManufactureYear());
            }
        }
    }

    public static void changeGreenCarsToRed(List<Car> cars) {
        for (Car car : cars) {
            if (car.getPaint().equalsIgnoreCase("Green")) {
                car.changeColor("Red");
            }
        }
    }

    public static void printCarsByBrand(List<Car> cars, String brand) {
        System.out.println("\nАвтомобили марки " + brand + ":");
        for (Car car : cars) {
            if (car.getBrand().equalsIgnoreCase(brand)) {
                System.out.println(car.retrieveDetails());
            }
        }
    }
}