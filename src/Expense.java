import java.time.LocalDate;

public class Expense 
{
    protected LocalDate date;
    protected String name;
    protected Float amount;
    
    public Expense() {}
    
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
