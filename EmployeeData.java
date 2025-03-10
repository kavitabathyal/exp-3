import java.util.Scanner;

public class EmployeeData {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Define the size of the arrays

        System.out.print("Enter the number of employees: ");

        int n = sc.nextInt();

        sc.nextLine(); // Consume the newline

        // Declare arrays for employee data

        int[] empId = new int[n];

        String[] depName = new String[n];

        String[] empDes = new String[n];

        String[] empName = new String[n];

        String[] dateJoin = new String[n];

        double[] basic = new double[n];

        double[] hra = new double[n];

        double[] it = new double[n];

        String[] desCodes = new String[n];

        // Input employee data

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details for Employee " + (i + 1) + ":");

            System.out.print("Employee ID: ");

            empId[i] = sc.nextInt();

            sc.nextLine(); // Consume the newline

            System.out.print("Department Name: ");

            depName[i] = sc.nextLine();

            System.out.print("Employee Designation: ");

            empDes[i] = sc.nextLine();

           System.out.print("Employee Name: ");

            empName[i] = sc.nextLine();

            System.out.print("Date of Joining (dd-mm-yyyy): ");

            dateJoin[i] = sc.nextLine();

            System.out.print("Basic Salary: ");

            basic[i] = sc.nextDouble();

            System.out.print("House Rent Allowance (HRA): ");

            hra[i] = sc.nextDouble();

            System.out.print("Income Tax (IT): ");

            it[i] = sc.nextDouble();

            sc.nextLine(); // Consume the newline

            System.out.print("Designation Code: ");

            desCodes[i] = sc.nextLine();

        }

        // Display the stored employee data

        System.out.println("\nEmployee Details:");

        System.out.println("---------------------------------------------------------");

        System.out.printf("%-10s %-15s %-15s %-15s %-15s %-10s %-10s %-10s %-10s\n",

                "EmpID", "Dept Name", "Designation", "Emp Name", "Join Date", "Basic", "HRA", "IT", "Des Code");

        System.out.println("---------------------------------------------------------");

        for (int i = 0; i < n; i++) {

            System.out.printf("%-10d %-15s %-15s %-15s %-15s %-10.2f %-10.2f %-10.2f %-10s\n",

                    empId[i], depName[i], empDes[i], empName[i], dateJoin[i], basic[i], hra[i], it[i], desCodes[i]);

        }

        sc.close();

    }

} 
