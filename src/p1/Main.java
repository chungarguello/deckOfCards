package p1;
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

        //Initialize the card
        for(int i = 0; i < deck.length; i++){
            deck[i] = i;
        }
        //shuffle the cards
        for (int i = 0; i < deck.length; i++){
            // generate an index randomly
            int index = (int)(Math.random() * deck.length);
            int temp = deck[i];
            deck[i] = deck[index];
            deck[index] = temp;
        }
        //Deal hand
        int[][] playerCard =  new int [4][13];

        for (int i = 0; i < 4; i ++){
            for(int j = 0; j < 13; j++) {
                if (i == 0)
                    playerCard[i][j] = deck[j];
                else if (i == 1)
                    playerCard[i][j] = deck[j+13];
                else if (i == 2)
                    playerCard[i][j] = deck[j+26];
                else if (i == 3)
                    playerCard[i][j] = deck[j+39];
            }
        }
        for (int i = 0; i < 4; i ++){
            for(int j = 0; j < 13; j++) {
                String suit = suits[playerCard[i][j] / 13];
                String rank = ranks[playerCard[i][j] % 13];
                if (i == 0)
                    System.out.println("Chung's card: " + rank + " " + suit);
                else if (i == 1)
                    System.out.println("John's card: " + rank + " " + suit);
                else if (i == 2)
                    System.out.println("Erick's card: " + rank + " " + suit);
                else if (i == 3)
                    System.out.println("Robert's card: " + rank + " " + suit);
            }
            System.out.println();
        }
    }
}
