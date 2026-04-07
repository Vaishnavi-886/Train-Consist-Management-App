import java.util.*;
import java.util.stream.*;

// Bogie Class
class Bogie {
    String name;
    int capacity;
    String type;

    Bogie(String name, int capacity, String type) {
        this.name = name;
        this.capacity = capacity;
        this.type = type;
    }
}

// Main Class
public class TrainConsistManagementApp {

    // UC7 - Sort by Capacity
    static void sortByCapacity(List<Bogie> list) {
        list.sort(Comparator.comparingInt(b -> b.capacity));
        System.out.println("\nSorted by Capacity:");
        list.forEach(b -> System.out.println(b.name + " - " + b.capacity));
    }

    // UC8 - Filter Passenger Bogies
    static void filterPassengerBogies(List<Bogie> list) {
        System.out.println("\nPassenger Bogies:");
        list.stream()
                .filter(b -> b.type.equalsIgnoreCase("Passenger"))
                .forEach(b -> System.out.println(b.name + " - " + b.capacity));
    }

    // UC9 - Group by Type
    static void groupBogiesByType(List<Bogie> list) {
        System.out.println("\nGrouped by Type:");
        Map<String, List<Bogie>> map =
                list.stream().collect(Collectors.groupingBy(b -> b.type));

        map.forEach((type, bogies) -> {
            System.out.println(type + ":");
            bogies.forEach(b -> System.out.println("  " + b.name));
        });
    }

    // UC10 - Count by Type
    static void countBogiesByType(List<Bogie> list) {
        System.out.println("\nCount by Type:");
        Map<String, Long> count =
                list.stream().collect(Collectors.groupingBy(b -> b.type, Collectors.counting()));

        System.out.println(count);
    }

    // UC11 - Max Capacity
    static void findMaxCapacity(List<Bogie> list) {
        System.out.println("\nMax Capacity Bogie:");
        Bogie max = list.stream()
                .max(Comparator.comparingInt(b -> b.capacity))
                .orElse(null);

        if (max != null)
            System.out.println(max.name + " - " + max.capacity);
    }

    // UC12 - Total Capacity
    static void totalCapacity(List<Bogie> list) {
        int total = list.stream().mapToInt(b -> b.capacity).sum();
        System.out.println("\nTotal Capacity: " + total);
    }

    // UC13 - Sort by Name
    static void sortByName(List<Bogie> list) {
        System.out.println("\nSorted by Name:");
        list.sort(Comparator.comparing(b -> b.name));
        list.forEach(b -> System.out.println(b.name));
    }

    // UC14 - Unique Types
    static void uniqueTypes(List<Bogie> list) {
        System.out.println("\nUnique Bogie Types:");
        list.stream()
                .map(b -> b.type)
                .distinct()
                .forEach(System.out::println);
    }

    // MAIN METHOD
    public static void main(String[] args) {

        List<Bogie> list = new ArrayList<>();

        // Sample Data
        list.add(new Bogie("Sleeper", 72, "Passenger"));
        list.add(new Bogie("AC Chair", 56, "Passenger"));
        list.add(new Bogie("First Class", 40, "Passenger"));
        list.add(new Bogie("Goods Tank", 0, "Goods"));

        // Calling all UCs
        sortByCapacity(list);        // UC7
        filterPassengerBogies(list); // UC8
        groupBogiesByType(list);     // UC9
        countBogiesByType(list);     // UC10
        findMaxCapacity(list);       // UC11
        totalCapacity(list);         // UC12
        sortByName(list);            // UC13
        uniqueTypes(list);           // UC14
    }
}