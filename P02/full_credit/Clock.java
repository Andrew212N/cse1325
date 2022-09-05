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
        return hour + ":" + minute + ":" + second;
    }
}
