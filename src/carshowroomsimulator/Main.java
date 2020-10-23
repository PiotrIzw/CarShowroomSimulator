package carshowroomsimulator;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Vehicle car1 = new Vehicle("Fiat", "Uno", ItemCondition.NEW, 40000.0, 2020, 180, 1.6, 1);
        Vehicle car2 = new Vehicle("Mercedes", "W213", ItemCondition.USED, 20000.0, 2005, 180000, 2.6, 1);
        Vehicle car3 = new Vehicle("Toyota", "Supra", ItemCondition.DAMAGED, 30000.0, 2000, 65000, 4.2, 1);
        Vehicle car4 = new Vehicle("Ford", "Focus", ItemCondition.USED, 3000.0, 2000, 365000, 1.4, 1);
        Vehicle car5 = new Vehicle("Opel", "Corsa", ItemCondition.USED, 900.0, 1995, 155000, 1.2, 1);
        //Vehicle car6 = new Vehicle("Scoda", "Felicia", ItemCondition.DAMAGED, 30000.0, 2000, 65000, 4.2, 1);


        CarShowroomContainer showrooms = new CarShowroomContainer(new HashMap<>());

        CarShowroom carShowroom1 = showrooms.addCenter("Cars Showroom 1", 5);
        CarShowroom carShowroom2 = showrooms.addCenter("Cars Showroom 2", 4);
        CarShowroom carShowroom3 = showrooms.addCenter("Cars Showroom 3", 8);

        carShowroom1.addProduct(car1);
        carShowroom1.addProduct(car2);
        carShowroom1.addProduct(car3);
        carShowroom1.addProduct(car4);
        carShowroom1.addProduct(car5);

        carShowroom2.addProduct(car1);
        carShowroom2.addProduct(car1);
        carShowroom2.addProduct(car1);
        carShowroom2.addProduct(car5);
        carShowroom2.addProduct(car4);

        carShowroom3.addProduct(car1);
        carShowroom3.addProduct(car2);
        carShowroom3.addProduct(car3);
        carShowroom3.addProduct(car4);
        carShowroom3.addProduct(car5);


        System.out.println("Summary of: " + carShowroom2.getShowroomName());
        carShowroom2.summary();
        System.out.println("Max Showroom 2 Capacity is: " + carShowroom2.getMaxShowroomCapacity());
        System.out.println("Brands of cars in Showroom 2");

        for (Vehicle vehicles : carShowroom2.getCarList()) {
            System.out.print(vehicles.getBrand() + ", ");
        }

        System.out.println(System.lineSeparator() + System.lineSeparator() + "Car of biggest amount in stock: ");
        carShowroom2.max().print();
        System.out.println("Searching Car of Brand Opel:");
        carShowroom2.search("Opel").print();
        System.out.println("Searching Car Starting from Letters: Mer");
        carShowroom3.searchPartial("Mer").print();
        System.out.println("Sorting by amount descending:");
        for (Vehicle v : carShowroom2.sortByAmount()) {
            System.out.println(v.getAmount());
        }
        System.out.println("Sorting by name: ");
        for (Vehicle v : carShowroom2.sortByName()) {
            System.out.println(v.getBrand());
        }
        System.out.println("Cars of condition: DAMAGED: " + carShowroom1.countByCondition(ItemCondition.DAMAGED));
        System.out.println("Getting product and changing amount in stock.");
        carShowroom2.getProduct(car1);
        System.out.println("Deleting product");
        carShowroom2.removeProduct(car5);
        System.out.println("Sorting by amount descending:");
        for (Vehicle v : carShowroom2.sortByAmount()) {
            System.out.println(v.getAmount());
        }
        System.out.println("Deleting Cars Showroom 2");
        showrooms.removeCenter("Cars Showroom 2");
        showrooms.summary();
        System.out.println("Finding empty showroom");

        carShowroom3.removeProduct(car1);
        carShowroom3.removeProduct(car2);
        carShowroom3.removeProduct(car3);
        carShowroom3.removeProduct(car4);
        carShowroom3.removeProduct(car5);

        for (CarShowroom s : showrooms.findEmpty()) {
            System.out.println(s.getShowroomName());
        }

    }
}
