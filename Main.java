import java.util.ArrayList;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ServiceRecord> records = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n--- VEHICLE SERVICE MANAGEMENT ---");
            System.out.println("1. Add Service Record");
            System.out.println("2. View All Records");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch(choice) {
                case 1:
                    System.out.print("Enter Owner Name: ");
                    String owner = sc.nextLine();

                    System.out.print("Enter Vehicle Number: ");
                    String number = sc.nextLine();

                    System.out.print("Enter Vehicle Type: ");
                    String type = sc.nextLine();

                    System.out.print("Enter Service Name: ");
                    String sName = sc.nextLine();

                    System.out.print("Enter Service Cost: ");
                    double cost = sc.nextDouble();
                    sc.nextLine(); // clear buffer

                    System.out.print("Enter Service Date (DD-MM-YYYY): ");
                    String date = sc.nextLine();

                    Vehicle v = new Vehicle(owner, number, type);
                    Service s = new Service(sName, cost);
                    ServiceRecord record = new ServiceRecord(v, s, date);

                    records.add(record);
                    System.out.println("Service record added successfully!");
                    break;

                case 2:
                    if(records.isEmpty()) {
                        System.out.println("No service records found.");
                    } else {
                        for(ServiceRecord r : records) {
                            r.showRecord();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while(choice != 3);

        sc.close();
    }
}
