import java.util.Scanner;

// Base class for Deposits
class Deposit {
    protected String depositorName;
    protected double principal;
    protected double rateOfInterest;
    protected int duration; // Duration in months

    public Deposit(String depositorName, double principal, double rateOfInterest, int duration) {
        this.depositorName = depositorName;
        this.principal = principal;
        this.rateOfInterest = rateOfInterest;
        this.duration = duration;
    }

    public void displayDetails() {
        System.out.println("Depositor Name: " + depositorName);
        System.out.println("Principal Amount: " + principal);
        System.out.println("Rate of Interest: " + rateOfInterest + "%");
        System.out.println("Duration: " + duration + " months");
    }

    public double calculateInterest() {
        return 0; // To be overridden by derived classes
    }
}

// Derived class for Fixed Deposit
class FixedDeposit extends Deposit {
    public FixedDeposit(String depositorName, double principal, double rateOfInterest, int duration) {
        super(depositorName, principal, rateOfInterest, duration);
    }

    @Override
    public double calculateInterest() {
        return (principal * rateOfInterest * duration) / (12 * 100);
    }
}

// Derived class for Recurring Deposit
class RecurringDeposit extends Deposit {
    private double monthlyInstallment;

    public RecurringDeposit(String depositorName, double monthlyInstallment, double rateOfInterest, int duration) {
        super(depositorName, 0, rateOfInterest, duration);
        this.monthlyInstallment = monthlyInstallment;
    }

    @Override
    public double calculateInterest() {
        double totalAmount = 0;
        for (int i = 0; i < duration; i++) {
            totalAmount += monthlyInstallment * (1 + (rateOfInterest / 100) * ((duration - i) / 12.0));
        }
        return totalAmount - (monthlyInstallment * duration);
    }

    @Override
    public void displayDetails() {
        System.out.println("Depositor Name: " + depositorName);
        System.out.println("Monthly Installment: " + monthlyInstallment);
        System.out.println("Rate of Interest: " + rateOfInterest + "%");
        System.out.println("Duration: " + duration + " months");
    }
}

// Main class
public class DepositCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Deposit Type:");
        System.out.println("1. Fixed Deposit (FD)");
        System.out.println("2. Recurring Deposit (RD)");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter Depositor Name: ");
                String fdName = sc.nextLine();
                System.out.print("Enter Principal Amount: ");
                double fdPrincipal = sc.nextDouble();
                System.out.print("Enter Rate of Interest (in %): ");
                double fdRate = sc.nextDouble();
                System.out.print("Enter Duration (in months): ");
                int fdDuration = sc.nextInt();

                FixedDeposit fd = new FixedDeposit(fdName, fdPrincipal, fdRate, fdDuration);
                fd.displayDetails();
                System.out.printf("Calculated Interest: %.2f\n", fd.calculateInterest());
                break;

            case 2:
                System.out.print("Enter Depositor Name: ");
                String rdName = sc.nextLine();
                System.out.print("Enter Monthly Installment: ");
                double rdInstallment = sc.nextDouble();
                System.out.print("Enter Rate of Interest (in %): ");
                double rdRate = sc.nextDouble();
                System.out.print("Enter Duration (in months): ");
                int rdDuration = sc.nextInt();

                RecurringDeposit rd = new RecurringDeposit(rdName, rdInstallment, rdRate, rdDuration);
                rd.displayDetails();
                System.out.printf("Calculated Interest: %.2f\n", rd.calculateInterest());
                break;

            default:
                System.out.println("Invalid choice. Please choose either 1 or 2.");
        }

        sc.close();
    }
} 