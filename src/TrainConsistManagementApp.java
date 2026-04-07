import java.util.*;

class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}

public class TrainConsistManagementApp {

    // UC7 Method
    static void sortBogiesByCapacity(List<Bogie> bogieList) {
        bogieList.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("Bogies Sorted by Capacity:\n");
        for (Bogie b : bogieList) {
            System.out.println(b.name + " - Capacity: " + b.capacity);
        }
    }

    public static void main(String[] args) {

        List<Bogie> bogieList = new ArrayList<>();

        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 40));

        sortBogiesByCapacity(bogieList); // calling UC7
    }
}