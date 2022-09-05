public class ClockBonus
{
    int hour;
    int minute;
    int second;
    
    //constructor
    public ClockBonus(int hour, int minute, int second)
    {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        rationalize();
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
    
    private void rationalize()
    {
        int secCounter = 0;
        while(second > 59)
        {
            second -= 60;
            secCounter++;
        }
        minute += secCounter;
        
        int minuteCounter = 0;
        while(minute > 59)
        {
            minute -= 60;
            minuteCounter++;
        }
        hour += minuteCounter;
        
        if(hour > 23)
        {
            hour = 0;
        }
    }
}
