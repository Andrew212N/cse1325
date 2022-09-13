public class PrintDeck
{
    public static void main(String args[])
    {
        Deck deck = new Deck();
        while(deck.isEmpty() != true)
            deck.deal();
        System.out.println(" ");
    }
}
