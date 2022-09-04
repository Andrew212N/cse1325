public class Clock
{
    String hour;
    String minute;
    String second;
    
    //constructor
    public Clock(String hour, String minute, String second)
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
