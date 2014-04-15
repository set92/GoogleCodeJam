package com.tobalsa.QualificationRound2014;

/**
 * Created by set92 on 12/04/2014.

 * Problem
 Recently you went to a magic show. You were very impressed by one of the tricks, so you decided to try to figure out
 the secret behind it!

 The magician starts by arranging 16 cards in a square grid: 4 rows of cards, with 4 cards in each row. Each card has
 a different number from 1 to 16 written on the side that is showing. Next, the magician asks a volunteer to choose a
 card, and to tell him which row that card is in.

 Finally, the magician arranges the 16 cards in a square grid again, possibly in a different order. Once again, he asks
 the volunteer which row her card is in. With only the answers to these two questions, the magician then correctly
 determines which card the volunteer chose. Amazing, right?

 You decide to write a program to help you understand the magician's technique. The program will be given the two
 arrangements of the cards, and the volunteer's answers to the two questions: the row number of the selected card
 in the first arrangement, and the row number of the selected card in the second arrangement. The rows are numbered
 1 to 4 from top to bottom.

 Your program should determine which card the volunteer chose; or if there is more than one card the volunteer
 might have chosen (the magician did a bad job); or if there's no card consistent with the volunteer's answers
 (the volunteer cheated).

 * Solving this problem
 Usually, Google Code Jam problems have 1 Small input and 1 Large input. This problem has only 1 Small input.
 Once you have solved the Small input, you have finished solving this problem.

 * Input
 The first line of the input gives the number of test cases, T. T test cases follow. Each test case starts with a line
 containing an integer: the answer to the first question. The next 4 lines represent the first arrangement of the cards:
 each contains 4 integers, separated by a single space. The next line contains the answer to the second question, and
 the following four lines contain the second arrangement in the same format.

 * Output
 For each test case, output one line containing "Case #x: y", where x is the test case number (starting from 1).
 If there is a single card the volunteer could have chosen, y should be the number on the card. If there are multiple
 cards the volunteer could have chosen, y should be "Bad magician!", without the quotes.If there are no cards consistent
 with the volunteer's answers, y should be "Volunteer cheated!", without the quotes. The text needs to be exactly right,
 so consider copying/pasting it from here.

 * Limits
 1 ≤ T ≤ 100.
 1 ≤ both answers ≤ 4.
 Each number from 1 to 16 will appear exactly once in each arrangement.

 * Sample

 ** Input

 3
 2
 1 2 3 4
 5 6 7 8
 9 10 11 12
 13 14 15 16
 3
 1 2 5 4
 3 11 6 15
 9 10 7 12
 13 14 8 16
 2
 1 2 3 4
 5 6 7 8
 9 10 11 12
 13 14 15 16
 2
 1 2 3 4
 5 6 7 8
 9 10 11 12
 13 14 15 16
 2
 1 2 3 4
 5 6 7 8
 9 10 11 12
 13 14 15 16
 3
 1 2 3 4
 5 6 7 8
 9 10 11 12
 13 14 15 16

 ** Output

 Case #1: 7
 Case #2: Bad magician!
 Case #3: Volunteer cheated!
 */
public class MagicTrick {
    int[][] cards = new int[4][4];
    int [] possibleCards = new int[4];
    int [] possibleCards2 = new int[4];
    private int numberCases = 0, rowCard = 0, userCard, times = 0;
    private String userInputMod;
    private boolean flagSecondTime;

    public void enter(String userInput){
        numberCases = Integer.parseInt(userInput.substring(0, userInput.indexOf("\n")));
        times = numberCases * 2;
        numberCases=1;
        //IMPORTANTE: indexOf("/"+1) es ir a la segunda vez que aparezca "/", indexOf("/")+1) es ir a la primera vez
        //que aparezca / y sumarle uno a su posicion
        userInputMod = userInput.substring(userInput.indexOf("\n")+1);

        while(times!=0) {
            rowCard = Integer.parseInt(userInputMod.substring(0, userInputMod.indexOf("\n"))) - 1;
            userInputMod = userInputMod.substring(userInputMod.indexOf("\n") + 1);
            fillCards(userInputMod);
            cardsPossibles(rowCard, cards);

            cleanCards();

            //Un poco sucio tal vez pero es para que solo se active la segunda vez cada 2 veces y no tod el rato
            if (flagSecondTime==false){
                flagSecondTime = true;
            }else{flagSecondTime = false;}

            times--;
        }
       // showCards();
    }

    private void cardsPossibles(int rowCard, int[][] cards) {
        int pos = 0,cont=1;
        for (int j = 0; j < cards.length; j++) {
            if (flagSecondTime == true ){
                possibleCards2[pos] = cards[rowCard][j];
            }else possibleCards[pos] = cards[rowCard][j];
            pos++;
        }
        if (flagSecondTime == true){
            userCard = compareArrays(possibleCards, possibleCards2);
            switch (userCard){
                case 98: System.out.println("Case #"+numberCases+": "+"Bad Magician!");numberCases++;break;
                case 99: System.out.println("Case #"+numberCases+": "+"Volunteer cheated!");numberCases++;break;

                default: System.out.println("Case #"+numberCases+": "+userCard);numberCases++;break;

            }


        }
    }

    private int compareArrays(int[] possibleCards, int[] possibleCards2) {
        int cont=0, card=0;
        for (int i = 0; i < possibleCards.length; i++) {
            for (int j = 0; j < possibleCards2.length; j++) {
                if (possibleCards[i] == possibleCards2[j]){
                    cont++;
                    card = possibleCards[i];
                }
            }
        }
        if (cont == 1){
            return card;
        }else if (cont >= 2){
            return 98;
        }else if( cont == 0){
            return 99;
        }
        return 0;
    }

    private void fillCards(String userInput){
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards[i].length; j++) {

                if (userInput.indexOf("\n") < 3){
                    cards[i][j] = Integer.parseInt(userInput.substring(0,userInput.indexOf("\n")));
                    userInput = userInput.substring(userInput.indexOf("\n") + 1);
                }else{
                    cards[i][j] = Integer.parseInt(userInput.substring(0,userInput.indexOf(" ")));
                    userInput = userInput.substring(userInput.indexOf(" ")+1);
                }

            }
        }
        this.userInputMod = userInput;
    }

    private void cleanCards(){
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards[0].length; j++) {
                cards[i][j] = 0;
            }
        }
    }
}


