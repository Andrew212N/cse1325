import java.util.Stack;
import java.util.Collections;

public class Deck
{
    private Stack<Card> deck = new Stack<Card>();
    
    public Deck()
    {
        for(int i = 0; i<9; i++)
        {
            Rank rank = new Rank(i);
            for(int j = 0; j<3; j++)
            {
                Card card = new Card(rank, Suit.values()[j]);
                deck.push(card);
            }
        }
        shuffle();
    }
    
    public void shuffle()
    {
        Collections.shuffle(deck);
    }
    
    public boolean isEmpty()
    {
        if(deck.size()<=0)
            return true;
        else
            return false;
    }    
    
    public void deal()
    {
        if(deck.isEmpty())
            System.out.println("There are currently no cards in the deck");
        else
            System.out.print(deck.pop().toString() + " ");
    }
}
