import java.util.Stack;
import java.util.Collections;

public class Deck
{
    private Stack<Card> deck;
    
    public Stack()
    {
        for(int i = 0; i<3; i++)
        {
            for(int j = 0; j<maxRank; j++)
            {
                deck.push(new Card(Rank[j], Suit[i]);
            }
        }
        shuffle();
    }
    
    public void shuffle()
    {
        Collections.shuffle(deck);
    }
}
