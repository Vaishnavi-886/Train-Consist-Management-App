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
    // UC15 - Average Capacity
    static void averageCapacity(List<Bogie> list) {
        double avg = list.stream()
                .mapToInt(b -> b.capacity)
                .average()
                .orElse(0);

        System.out.println("\nAverage Capacity: " + avg);
    }

    // UC16 - Get All Bogie Names
    static void getAllBogieNames(List<Bogie> list) {
        List<String> names = list.stream()
                .map(b -> b.name)
                .collect(Collectors.toList());

        System.out.println("\nBogie Names: " + names);
    }

    // UC17 - Check High Capacity (>70)
    static void checkHighCapacity(List<Bogie> list) {
        boolean exists = list.stream()
                .anyMatch(b -> b.capacity > 70);

        System.out.println("\nAny capacity > 70: " + exists);
    }

    // UC18 - Partition Passenger vs Goods
    static void partitionBogies(List<Bogie> list) {
        Map<Boolean, List<Bogie>> map =
                list.stream()
                        .collect(Collectors.partitioningBy(
                                b -> b.type.equalsIgnoreCase("Passenger")));

        System.out.println("\nPassenger Bogies:");
        map.get(true).forEach(b -> System.out.println(b.name));

        System.out.println("\nGoods Bogies:");
        map.get(false).forEach(b -> System.out.println(b.name));
    }

    // UC19 - Convert to Map (Name → Capacity)
    static void convertToMap(List<Bogie> list) {
        Map<String, Integer> map =
                list.stream()
                        .collect(Collectors.toMap(b -> b.name, b -> b.capacity));

        System.out.println("\nBogie Map: " + map);
    }

    // UC20 - Skip & Limit
    static void skipAndLimit(List<Bogie> list) {
        System.out.println("\nSkip 1, Limit 2:");

        list.stream()
                .skip(1)
                .limit(2)
                .forEach(b -> System.out.println(b.name + " - " + b.capacity));
    }
}