public class CarDemo {

    // Car class defined inside same file
    static class Car {
        // Attributes
        String make;
        String model;
        int year;

        // Constructor
        Car(String make, String model, int year) {
            this.make  = make;
            this.model = model;
            this.year  = year;
        }

        // Method
        void displayDetails() {
            System.out.println("-------------------------------");
            System.out.println("Make  : " + make);
            System.out.println("Model : " + model);
            System.out.println("Year  : " + year);
            System.out.println("-------------------------------");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Car Class and Objects ===\n");

        // Create objects
        Car car1 = new Car("Toyota", "Camry",   2022);
        Car car2 = new Car("Honda",  "Civic",   2021);
        Car car3 = new Car("Ford",   "Mustang", 2023);

        // Call method on each object
        car1.displayDetails();
        car2.displayDetails();
        car3.displayDetails();
    }
}