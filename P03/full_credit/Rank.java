public class Rank
{
    public static final int minRank = 0;
    public static final int maxRank = 9;
    public int rank;
    
    public Rank(rank)
    {
        this.rank = rank;
    }
    
    @Override
    public String toString()
    {
        String str = String.valueOf(rank);
        return str;
    }
