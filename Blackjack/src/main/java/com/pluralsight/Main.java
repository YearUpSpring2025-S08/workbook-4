package com.pluralsight;

public class Main {

    private static Console console = new Console();

    public static void main(String[] args) {

        String firstPlayerName = console.promptForString("Enter the name of the first player: ");
        String secondPlayerName = console.promptForString("Enter the name of the second player: ");

        Deck d = new Deck();
        d.shuffle();

        Hand h1 = new Hand(firstPlayerName);
        Hand h2 = new Hand(secondPlayerName);


        for(int i = 0 ; i < 2 ; i++){
            Card c;
            c = d.deal();
            c.flip();
            h1.deal(c);

            //h1.deal(d.deal());
            c = d.deal();
            c.flip();
            h2.deal(c);
        }

        display(h1);
        display(h2);

    }

    public static void display(Card c){
        if(c.getSuit().equalsIgnoreCase("Hearts") || c.getSuit().equalsIgnoreCase("Diamonds") ){
            System.out.println(ColorCodes.RED + c.getValue() + " " + c.getSuit() + ColorCodes.RESET );
        }
        else{
            System.out.println(c.getValue() + " " + c.getSuit());
        }

    }

    public static void display(Hand hand){
        System.out.println(hand.getPlayerName() +" has the follow cards:");
        for(Card card: hand.getCards()){
            display(card);
        }
        System.out.println("Together they have the value of " + hand.getValue());
    }




}