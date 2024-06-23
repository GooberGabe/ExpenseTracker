import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ExpenseManager 
{
    private ArrayList<Expense> expenses = new ArrayList<>();
    private ArrayList<Goal> goals = new ArrayList<>();
    
    public void addExpense(Expense expense) 
    {
        expenses.add(expense);
    }
    
    public void viewExpenses()
    {
        System.out.println("Expenses:\n");
        for (Expense expense : expenses) {
            System.out.println(expense.toString());
        }
    }
    
    public void addSpendingGoal(Goal goal)
    {
        goals.add(goal);
    }
    
    public void checkGoalProgress()
    {

        LocalDate today = LocalDate.now();
        
        int i = 0;
        for (Goal currentGoal : goals) {
            if (today.isAfter(currentGoal.getStartDate())) {

                continue;
            }
            i++;

            ArrayList<Expense> relevantExpenses = (ArrayList<Expense>) expenses.stream()
                    .filter(e -> !e.getDate().isBefore(currentGoal.getStartDate())
                            && !e.getDate().isAfter(currentGoal.getEndDate()))
                    .collect(Collectors.toList());

            double totalSpent = relevantExpenses.stream()
                    .mapToDouble(Expense::getAmount)
                    .sum();

            double remainingBudget = currentGoal.getThreshold() - totalSpent;
            long daysLeft = today.until(currentGoal.getEndDate()).getDays();

            System.out.println("\nGoal #"+i);
            System.out.printf("Total spent: $%.2f%n", totalSpent);
            System.out.printf("Remaining budget: $%.2f%n", remainingBudget);
            System.out.printf("Days left: %d%n", daysLeft);

            if (totalSpent > currentGoal.getThreshold()) {
                System.out.println("You've exceeded this spending goal!");
            } else {
                double dailyBudget = remainingBudget / daysLeft;
                System.out.printf("To stay within your goal, limit your spending to $%.2f per day.%n", dailyBudget);
            }
        }
    }
}
