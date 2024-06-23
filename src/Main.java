import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();

        boolean running = true;
        while (running) {
            System.out.println("\n--- Expense Tracker Menu ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Set Spending Goal");
            System.out.println("4. Check Goal Progress");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("What was purchased? ");
                    String name  = scanner.nextLine();
                    System.out.print("How much was spent? ");
                    float amount = scanner.nextFloat();
                    
                    LocalDate date = LocalDate.now();
                    
                    manager.addExpense(new Expense(date, name, amount));
                    System.out.println("Successfully added "+name+" to the expense tracker.");
                    break;
                case 2:
                    manager.viewExpenses();
                    break;
                case 3:
                    System.out.print("What is the start date of this goal? (yyyy-MM-dd) ");
                    String startDateLine  = scanner.nextLine();

                    System.out.print("What is the expiration date of this goal? (yyyy-MM-dd) ");
                    String endDateLine  = scanner.nextLine();

                    System.out.print("What is your spending threshold for this time period? ");
                    float threshold = scanner.nextFloat();
                    
                    //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                    //LocalDate startDate = LocalDate.parse(startDateLine, formatter);
                    //LocalDate endDate = LocalDate.parse(endDateLine, formatter);
                    LocalDate startDate = LocalDate.parse(startDateLine);
                    LocalDate endDate = LocalDate.parse(endDateLine);
                    System.out.println("Successfully added a new goal.");
                    manager.addSpendingGoal(new Goal(startDate, endDate, threshold));

                    break;
                case 4:
                    manager.checkGoalProgress();
                    break;
                case 5:
                    running = false;
                    System.out.println("Thank you for using Expense Tracker!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}