import java.util.*;

public class TrainManagementApp {

    private List<String> bogies = new ArrayList<>();

    // UC15: Add bogie
    public void addBogie(String id) {
        bogies.add(id);
        System.out.println("Bogie added: " + id);
    }

    // UC16: Display bogies
    public void displayBogies() {
        if (bogies.isEmpty()) {
            System.out.println("No bogies available.");
            return;
        }

        System.out.println("Bogie List:");
        for (String b : bogies) {
            System.out.println(b);
        }
    }

    // UC17: Remove bogie
    public void removeBogie(String id) {
        if (bogies.remove(id)) {
            System.out.println("Bogie removed: " + id);
        } else {
            System.out.println("Bogie not found.");
        }
    }

    // UC18: Linear Search
    public boolean linearSearch(String key) {
        if (bogies.isEmpty()) {
            throw new IllegalStateException("No bogies available for search.");
        }

        for (String b : bogies) {
            if (b.equals(key)) {
                return true;
            }
        }
        return false;
    }

    // UC19 + UC20: Binary Search with Exception Handling
    public boolean binarySearch(String key) {
        if (bogies.isEmpty()) {
            throw new IllegalStateException("No bogies available for search.");
        }

        // Convert to array and sort
        String[] arr = bogies.toArray(new String[0]);
        Arrays.sort(arr);

        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int result = key.compareTo(arr[mid]);

            if (result == 0) return true;
            else if (result < 0) high = mid - 1;
            else low = mid + 1;
        }

        return false;
    }

    // Main Menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TrainManagementApp app = new TrainManagementApp();

        while (true) {
            System.out.println("\n--- Train Management System ---");
            System.out.println("1. Add Bogie");
            System.out.println("2. Display Bogies");
            System.out.println("3. Remove Bogie");
            System.out.println("4. Linear Search");
            System.out.println("5. Binary Search");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Bogie ID: ");
                        app.addBogie(sc.nextLine());
                        break;

                    case 2:
                        app.displayBogies();
                        break;

                    case 3:
                        System.out.print("Enter Bogie ID to remove: ");
                        app.removeBogie(sc.nextLine());
                        break;

                    case 4:
                        System.out.print("Enter Bogie ID to search: ");
                        boolean found1 = app.linearSearch(sc.nextLine());
                        System.out.println(found1 ? "Found" : "Not Found");
                        break;

                    case 5:
                        System.out.print("Enter Bogie ID to search: ");
                        boolean found2 = app.binarySearch(sc.nextLine());
                        System.out.println(found2 ? "Found" : "Not Found");
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}