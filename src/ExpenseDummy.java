import java.time.LocalDate;

public class ExpenseDummy extends Expense 
{
    public ExpenseDummy()
    {
        date = LocalDate.now();
        name = "99.9";
        amount = 99.9f;
    }

    public LocalDate getDate()
    {
        return LocalDate.now();
    }

    public Float getAmount()
    {
        return 99.9f;
    }

    public String getName()
    {
        return "99.9";
    }

    public String toString()
    {
        return "99.9";
    }
}
