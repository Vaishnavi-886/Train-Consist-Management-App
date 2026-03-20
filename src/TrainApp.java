import java.util.*;

public class TrainApp {
    public static void main(String[] args) {

        // ================= UC1 =================
        System.out.println("=== Train Consist Management App ===");

        List<String> consist = new ArrayList<>();

        System.out.println("Train consist initialized.");
        System.out.println("Initial bogie count: " + consist.size());


        // ================= UC2 =================
        consist.add("Sleeper");
        consist.add("AC Chair");
        consist.add("First Class");

        System.out.println("\nAfter adding bogies:");
        System.out.println("Total bogies: " + consist.size());


        // ================= UC3 =================
        Set<String> bogieIds = new HashSet<>();

        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG102"); // duplicate

        System.out.println("\nUnique Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }


        // ================= UC4 =================
        LinkedList<String> train = new LinkedList<>();

        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add("Cargo");
        train.add("Guard");

        train.add(2, "Pantry"); // insert

        train.removeFirst(); // remove first
        train.removeLast();  // remove last

        System.out.println("\nFinal Train Consist (LinkedList):");
        for (String bogie : train) {
            System.out.println(bogie);
        }


        // ================= UC5 =================
        LinkedHashSet<String> formation = new LinkedHashSet<>();

        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper"); // duplicate

        System.out.println("\nTrain Formation (LinkedHashSet):");
        for (String bogie : formation) {
            System.out.println(bogie);
        }


        // ================= UC6 =================
        HashMap<String, Integer> capacityMap = new HashMap<>();

        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 60);
        capacityMap.put("First Class", 40);
        capacityMap.put("Cargo", 100);

        System.out.println("\nBogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}