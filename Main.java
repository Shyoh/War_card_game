import java.util.*;
class Main {
  public static void main(String[] args) {
    Hand player = new Hand();
    Hand computer = new Hand();

    for(int i = 0;i<10;i++){
      player.add(dealCard());
      computer.add(dealCard());
    }

    compareCards(player,computer);
    getInput(player,computer);
  }

  public static void compareCards(Hand player, Hand computer){
    int result = player.peekFront().compareTo(computer.peekFront());

    if(player.peekFront().equals(computer.peekFront())){
      ArrayList<Card> addCards = new ArrayList<Card>();
      System.out.println("It's War!");

    for(int i =0;i<3;i++){
      addCards.add(player.remove());
      addCards.add(computer.remove());
    }
    if(player.peekFront().compareTo(computer.peekFront()) <0){
      printResult(computer, player.remove(), computer.remove());
      addNewCards(computer,addCards);
      System.out.println("Computer wins!");
      getInput(player,computer);  
    }else if(player.peekFront().compareTo(computer.peekFront()) >0){
      printResult(player, player.remove(), computer.remove());
      addNewCards(player, addCards);
      System.out.println("You win!");
      getInput(player,computer);
    }else{
      System.out.println("It's war");
      for(int i = 0;i<3;i++){
        addCards.add(player.remove());
        addCards.add(computer.remove());
      }
      if(player.peekFront().compareTo(computer.peekFront())<0){
        printResult(computer,player.remove(),computer.remove());
        addNewCards(computer, addCards);
        System.out.println("Computer wins!");
        getInput(player, computer);
      }else if(player.peekFront().compareTo(computer.peekFront())>0){
        printResult(player,player.remove(),computer.remove());
        addNewCards(player, addCards);
        System.out.println("You win!");
        getInput(player,computer);
      }
    }
  }else if(result<0){
      printResult(computer, player.remove(),computer.remove());
      System.out.println("Computer wins!");
  }else{
      printResult(player, player.remove(),computer.remove());
      System.out.println("You win!");
  }

}

  public static void getInput(Hand player, Hand computer){
    Scanner in = new Scanner(System.in);

    System.out.println("Your "+player);
    System.out.println("Computer "+computer);

    if(player.isEmpty()){
      System.out.println("Computer is the winner!");
      System.exit(0);
    }else if(computer.isEmpty()){
      System.out.println("You are the winner!");
      System.exit(0);
    }

    System.out.println("Ready to play again (y/n)");
    String text = in.nextLine();

    if(text.equals("y")){
      compareCards(player,computer);
      getInput(player, computer);
    }else{
      in.close();
    }
  }

  public static void addNewCards(Hand winner, ArrayList<Card> list){
    for(Card card : list){
      winner.add(card);
    }
  }

  public static void printResult(Hand winner, Card card1, Card card2){
    System.out.println("Your card is: "+card1);
    System.out.println("The computer's card is: "+card2);

    winner.add(card1);
    winner.add(card2);
  }

  public static Card dealCard() {
    Card temp = null;
    String[] names = { "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King",
        "Ace" };
    int num = (int) (Math.random() * 52);

    while (Card.getDeck()[num] == true) {
      num = (int) (Math.random() * 52);
    }

    switch (num / 13) {
      case 0:
        temp = new Card(names[num % 13], "Clubs", num + 2);
        break;
      case 1:
        temp = new Card(names[num % 13], "Diamonds", num + 2 - 13);
        break;
      case 2:
        temp = new Card(names[num % 13], "Hearts", num + 2 - 26);
        break;
      case 3:
        temp = new Card(names[num % 13], "Spades", num + 2 - 39);
        break;
    }
    Card.addToDeck(temp);
    return temp;
  }// end of dealCard method
}