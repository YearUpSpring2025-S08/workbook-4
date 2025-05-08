package com.pluralsight;

public class Main {

    private static Console console = new Console();

    public static void main(String[] args) {

        String firstPlayerName = console.promptForString("Enter the name of the first player: ");
        String secondPlayerName = console.promptForString("Enter the name of the second player: ");

        Deck d = new Deck();
        d.shuffle();

        Player p1 = new Player(firstPlayerName);
        p1.setHand(new Hand());

        Player p2 = new Player(secondPlayerName);
        p2.setHand(new Hand());


       // Hand h1 = new Hand(firstPlayerName);
      //  Hand h2 = new Hand(secondPlayerName);


        for(int i = 0 ; i < 2 ; i++){
            Card c;
            c = d.deal();
            c.flip();
            p1.getHand().deal(c);

            //h1.deal(d.deal());
            c = d.deal();
            c.flip();
            p2.getHand().deal(c);
        }

        display(p1);
        display(p2);

    }

    public static void display(Card c){
        if(c.getSuit().equalsIgnoreCase("Hearts") || c.getSuit().equalsIgnoreCase("Diamonds") ){
            System.out.println(ColorCodes.RED + c.getValue() + " " + c.getSuit() + ColorCodes.RESET );
        }
        else{
            System.out.println(c.getValue() + " " + c.getSuit());
        }

    }

    public static void display(Player player){
        System.out.println(player.getPlayerName() +" has the follow cards:");
        for(Card card: player.getHand().getCards()){
            display(card);
        }
        System.out.println("Together they have the value of " + player.getHand().getValue());
    }




}