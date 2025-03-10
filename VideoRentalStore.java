import java.util.Scanner;

public class VideoRentalStore {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Define the maximum size of the inventory

        int maxSize = 100;

        // Declare arrays for inventory management

        String[] videoTitles = new String[maxSize];

        boolean[] isRented = new boolean[maxSize];

        int videoCount = 0;

        while (true) {

            System.out.println("\nVideo Rental Store Management System");

            System.out.println("1. Add New Video");

            System.out.println("2. Mark Video as Rented");

            System.out.println("3. Mark Video as Returned");

            System.out.println("4. Remove Video from Inventory");

            System.out.println("5. Display Inventory");

            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            sc.nextLine(); // Consume newline

            switch (choice) {

                case 1:

                    if (videoCount < maxSize) {

                        System.out.print("Enter video title: ");

                        videoTitles[videoCount] = sc.nextLine();

                        isRented[videoCount] = false; // Newly added videos are not rented

                        videoCount++;

                        System.out.println("Video added to inventory.");

                    } else {

                        System.out.println("Inventory is full. Cannot add more videos.");

                    }

                    break;

                case 2:

                    System.out.print("Enter video title to mark as rented: ");

                    String rentTitle = sc.nextLine();

                    boolean found = false;

                    for (int i = 0; i < videoCount; i++) {

                        if (videoTitles[i].equalsIgnoreCase(rentTitle) && !isRented[i]) {

                            isRented[i] = true;

                            System.out.println("Video marked as rented.");

                            found = true;

                            break;

                        }

                    }

                    if (!found) {

                        System.out.println("Video not found or already rented.");

                    }

                    break;

                case 3:

                    System.out.print("Enter video title to mark as returned: ");

                    String returnTitle = sc.nextLine();

                    found = false;

                    for (int i = 0; i < videoCount; i++) {

                        if (videoTitles[i].equalsIgnoreCase(returnTitle) && isRented[i]) {

                            isRented[i] = false;

                            System.out.println("Video marked as returned.");

                            found = true;

                            break;

                        }

                    }

                    if (!found) {

                        System.out.println("Video not found or not currently rented.");

                    }

                    break;

                case 4:

                    System.out.print("Enter video title to remove from inventory: ");

                    String removeTitle = sc.nextLine();

                    found = false;

                    for (int i = 0; i < videoCount; i++) {

                        if (videoTitles[i].equalsIgnoreCase(removeTitle)) {

                            // Shift the remaining videos to fill the gap

                            for (int j = i; j < videoCount - 1; j++) {

                                videoTitles[j] = videoTitles[j + 1];

                                isRented[j] = isRented[j + 1];

                            }

                            videoCount--;

                            System.out.println("Video removed from inventory.");

                            found = true;

                            break;

                        }

                    }

                    if (!found) {

                        System.out.println("Video not found in inventory.");

                    }

                    break;

                case 5:

                    System.out.println("\nCurrent Inventory:");

                    System.out.println("----------------------------------------");

                    System.out.printf("%-30s %-10s\n", "Video Title", "Status");

                    System.out.println("----------------------------------------");

                    for (int i = 0; i < videoCount; i++) {

                        String status = isRented[i] ? "Rented" : "Available";

                        System.out.printf("%-30s %-10s\n", videoTitles[i], status);

                    }

                    if (videoCount == 0) {

                        System.out.println("No videos in inventory.");

                    }

                    break;

                case 6:

                    System.out.println("Exiting the system. Goodbye!");

                    sc.close();

                    return;

                default:

                    System.out.println("Invalid choice. Please try again.");

            }

        }

    }

}
