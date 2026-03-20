import java.util.*;

public class TrainApp {
    public static void main(String[] args) {
        // UC1: Initialize Train
        System.out.println("=== Train Consist Management App ===");

        List<String> consist = new ArrayList<>();

        System.out.println("Train consist initialized.");
        System.out.println("Initial bogie count: " + consist.size());

        // UC2: Add Passenger Bogies
        consist.add("Sleeper");
        consist.add("AC Chair");
        consist.add("First Class");

        System.out.println("After adding bogies:");
        System.out.println("Total bogies: " + consist.size());

        System.out.println("Train consist:");
        for(String bogie : consist) {
            System.out.println(bogie);
        }
        // UC3: Track Unique Bogie IDs using HashSet

        Set<String> bogieIds = new HashSet<>();

        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG102"); // duplicate

        System.out.println("Unique Bogie IDs:");
        for(String id : bogieIds) {
            System.out.println(id);
        }
        // UC4: Maintain ordered train consist using LinkedList

        LinkedList<String> train = new LinkedList<>();

// Add bogies
        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add("Cargo");
        train.add("Guard");

// Insert Pantry Car at position 2
        train.add(2, "Pantry");

// Remove first and last bogie
        train.removeFirst();
        train.removeLast();

// Display final train consist
        System.out.println("Final Train Consist:");
        for(String bogie : train) {
            System.out.println(bogie);
        }
    }
}