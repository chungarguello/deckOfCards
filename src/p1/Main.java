package p1;

import java.lang.reflect.Array;

/*
Card Shuffle
Demo Program
Chungsing Arguello
jan 21 16
Version .01
*/
public class Main {

    public static void main(String[] args) {
        int[] deck = new int[52];
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        int[][] playerCard =  new int [4][13];
        boolean [][][] sortHands = new boolean [4][4][13];

        initialize(deck);
        shuffle(deck);
        //dealHands(playerCard, deck, suits, ranks);
        sortHand(sortHands, deck, suits, ranks);
    }

    //Initialize the card
    public static void initialize(int[] cards) {

        for (int i = 0; i < cards.length; i++)
            cards[i] = i;
    }
         //shuffle the cards
        public static void shuffle(int[] cardShuffle) {

            for (int i = 0; i < cardShuffle.length; i++) {
                // generate an index randomly
                int index = (int) (Math.random() * cardShuffle.length);
                cardShuffle[i] = cardShuffle[index];
            }
        }

   public static boolean sortHand(boolean[][][] sort, int[] cards, String[] cardSuit, String[] cardRank){
            int suit;
            int rank;

       for(int i = 0 ; i < 4; i++){
            for( int j = 0; j < 4; j++){
                for(int h = 0; h < 13; h++){
                    if(i == 0){
                         suit = cards[h] / 13;
                         rank = cards[h] % 13;
                    }
                    else if(i == 1){
                        suit = cards[h + 13] / 13;
                        rank = cards[h + 13] % 13;
                    }
                    else if(i == 2){
                        suit = cards[h + 26] / 13;
                         rank = cards[h + 26] % 13;
                    }
                    else{
                        suit = cards[h + 39] / 13;
                        rank = cards[h + 39] % 13;
                    }
                    sort[i][suit][rank] = true;
                }
            }
           System.out.println("\n");
        }


       for(int i = 0 ; i < 4; i++){
           for( int j = 0; j < 4; j++){
               for(int h = 0; h < 13; h++){
                   if (sort[i][j][h]) {
                       if (i == 0) {
                           System.out.println("CHung's card " + cardRank[h] + " " + cardSuit[j]);
                       } else if (i == 1) {
                           System.out.println("John's card " + cardRank[h] + " " + cardSuit[j]);
                       } else if (i == 2) {
                           System.out.println("Erick's card " + cardRank[h] + " " + cardSuit[j]);
                       } else if (i == 3) {
                           System.out.println("Robert's card " + cardRank[h] + " " + cardSuit[j]);
                       }
                   }
               }
           }
           System.out.println();
       }
            return true;
    }
}
