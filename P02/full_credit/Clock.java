
public class Clock
{
    int hour;
    int minute;
    int second;
    
    //constructor
    public Clock(int hour, int minute, int second)
    {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    
    @Override
    public String toString()
    {
        return addZero(hour) + ":" + addZero(minute) + ":" + addZero(second);
    }
    
    private String addZero(int i)
    {
        String twoDigits = Integer.toString(i);
        if (twoDigits.length() == 1)
        {
            return "0"+twoDigits;
        }
        return twoDigits;
    }
}
