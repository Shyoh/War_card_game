public class Card{
  //instance fields:
  private static boolean[] deck = new boolean[52];
  private String rank;
  private String suit;
	private int pointValue;


  //constructors:
  public Card(String cardRank, String cardSuit, int cardPointValue){
    rank = cardRank;
    suit = cardSuit;
    pointValue = cardPointValue;
  }


  //methods:
  public String getSuit() {
		return suit;
   }

	public String getRank() {
		return rank;
	}

  
	public int getPointValue() {
		return pointValue;
	}

  public void setSuit(String s){
    suit = s;
  }

  public void setRank(String r){
    rank = r;
  }

  public void setPointValue(int p){
    pointValue = p;
  }

   public static boolean[] getDeck(){
     return deck;
   }

  public int compareTo(Card other){
    return this.getPointValue() - other.getPointValue();
  }

  public boolean equals(Card other){
    return this.getPointValue() == other.getPointValue();
  }

   public static void addToDeck(Card c1)
  {
    if(c1.suit.equals("Clubs"))
      deck[c1.pointValue-2] = true;
    else if (c1.suit.equals("Diamonds"))
      deck[c1.pointValue-2 + 13] = true;
    else if (c1.suit.equals("Hearts"))
      deck[c1.pointValue-2 + 26] = true;
    else 
      deck[c1.pointValue-2 + 39] = true;
  }
  
  public String toString() {
		return rank + " of " + suit + " (point value = " + pointValue + ")";
	}
}