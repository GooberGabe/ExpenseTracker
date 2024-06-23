import java.time.LocalDate;

public class Expense 
{
    private final LocalDate date;
    private final String name;
    private final Float amount;
    
    public Expense(LocalDate _date, String _name, Float _amount)
    {
        date = _date;
        name = _name;
        amount = _amount;
    }
    
    public LocalDate getDate()
    {
        return date;
    }

    public Float getAmount() 
    {
        return amount;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String toString()
    {
        return getDate().toString()+": "+getName()+", $"+getAmount().toString();
    }
    
    
}
