import java.util.*;

public class Hand implements Queue{
  private LinkedList<Card> hand;

  public Hand(){
    hand = new LinkedList<Card>();
  }


//methods
public int size(){
  return hand.size();
}

public void add(Object x){
  hand.addLast((Card) x);
}

public void shuffle()
{
     Collections.shuffle(hand);//if "blank" is your instance field
     System.out.println("Time to Shuffle!");
}


public void clear(){
  hand.clear();
}

public boolean isEmpty(){
  return hand.isEmpty();
}

public Card peekFront(){
  return hand.peekFirst();
}

public Card remove(){
  return hand.remove();
}

public String toString(){
  return "card count: "+hand.size();
}


}