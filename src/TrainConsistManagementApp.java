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

public class TrainConsistManagementApp {

    // UC10 - Count Bogies by Type
    static void countBogiesByType(List<Bogie> list) {
        Map<String, Long> count =
                list.stream()
                        .collect(Collectors.groupingBy(b -> b.type, Collectors.counting()));

        System.out.println("Count by Type:");
        System.out.println(count);
    }

    // UC11 - Find Max Capacity Bogie
    static void findMaxCapacity(List<Bogie> list) {
        Bogie max = list.stream()
                .max(Comparator.comparingInt(b -> b.capacity))
                .orElse(null);

        System.out.println("\nMax Capacity Bogie:");
        if (max != null)
            System.out.println(max.name + " - " + max.capacity);
    }

    // UC12 - Total Capacity
    static void totalCapacity(List<Bogie> list) {
        int total = list.stream()
                .mapToInt(b -> b.capacity)
                .sum();

        System.out.println("\nTotal Capacity: " + total);
    }

    // UC13 - Sort Bogies by Name
    static void sortByName(List<Bogie> list) {
        list.sort(Comparator.comparing(b -> b.name));

        System.out.println("\nSorted by Name:");
        list.forEach(b -> System.out.println(b.name));
    }

    // UC14 - Unique Bogie Types
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

        // UC10 → UC14 Calls
        countBogiesByType(list);
        findMaxCapacity(list);
        totalCapacity(list);
        sortByName(list);
        uniqueTypes(list);
    }
}