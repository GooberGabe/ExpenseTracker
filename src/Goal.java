import java.time.LocalDate;

public class Goal 
{
    private LocalDate startDate;
    private LocalDate endDate;
    private float threshold;
    
    public Goal(LocalDate _startDate, LocalDate _endDate, float _threshold)
    {
        startDate = _startDate;
        endDate = _endDate;
        threshold = _threshold;
    }
    
    public LocalDate getStartDate()
    {
        return startDate;
    }
    
    public LocalDate getEndDate()
    {
        return endDate;
    }
    
    public float getThreshold()
    {
        return threshold;
    }
}
