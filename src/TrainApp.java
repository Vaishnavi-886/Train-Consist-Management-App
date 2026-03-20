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

        // UC3: Display all bogies
        System.out.println("Train consist:");
        for(String bogie : consist) {
            System.out.println(bogie);
        }
    }
}