package lab7;
import java.util.Random;
import java.util.Arrays;

import lab7.Card.Suit;

/**
 * Class representing a standard 52-card deck of playing
 * cards from which cards can be selected at random.
 */
public class Deck
{
  /**
   * The cards comprising this deck.
   */
  private Card[] cards;
  
  /**
   * The random number generator to use for selecting cards.
   */
  private Random rand;
  
  /**
   * Constructs a new deck with a default random number generator.
   */
  public Deck()
  {
    rand = new Random();
    init();
  }

  /**
   * Constructs a new deck with the given random number generator.
   */
  public Deck(Random givenGenerator)
  {
    rand = givenGenerator;
	init();
  }
  
  /**
   * Returns a new array containing k elements selected
   * at random from this deck.
   */
  public Card[] select(int k)
  {
    // TODO
	  int max = 52;
	  Random rand = new Random();
	  for(int i = 0; i < k; i++)
	  {
		  int random = rand.nextInt(max);
		  Card temp = cards[random];
		  cards[random] = cards[cards.length-1];
		  cards[cards.length-1] = temp;
		  max--;
	  }
	  Card[] selection = new Card[k];
	  int j = 0;
	  for(int i = cards.length-k; i< cards.length; i ++)
	  {
		  selection[j] = cards[i];
		  j++;
	  }
    return selection;
  }
  
  /**
   * Initializes a new deck of 52 cards.
   */
  private void init()
  {
    cards = new Card[52];
    int index = 0;
    for (int rank = 1; rank <= 13; ++rank)
    {
      cards[index] = new Card(rank, Suit.CLUBS);
      index += 1;
      cards[index] = new Card(rank, Suit.DIAMONDS);
      index += 1;
      cards[index] = new Card(rank, Suit.HEARTS);
      index += 1;
      cards[index] = new Card(rank, Suit.SPADES);
      index += 1;
    }

  }
}
