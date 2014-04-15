package com.tobalsa.QualificationRound2014;

import java.util.Random;

/**
 * Created by set92 on 12/04/2014.
 * Creado por set92 el 12/04/2014.
 */
public class MagicTrickMine {
    int[][] cards = new int[4][4];
    private int numberCases = 0, chooseCard = 0;
    Random rand = new Random();

    public void enter(int numberCases){
        this.numberCases = numberCases;
        System.out.println("Number of Cases: "+numberCases);
        fillCards();
        this.chooseCard = rand.nextInt(16)+1;
        System.out.println("Carta: "+chooseCard);
        int rowCardChosen = searchCard(chooseCard, cards);
        System.out.println("Row of your number: "+rowCardChosen);
        showCards();

        cleanCards();
        fillCards();
        rowCardChosen = searchCard(chooseCard,cards);
        System.out.println("Row of your number: "+rowCardChosen);
        showCards();


    }

    private void cleanCards(){
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards[0].length; j++) {
                cards[i][j] = 0;
            }
        }
    }
    private void fillCards(){
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards[0].length; j++) {
                int number = rand.nextInt(16)+1;
                while (isDuplicateNumbers(number,cards)){
                    number = rand.nextInt(16)+1;
                }
                cards[i][j] = number;
            }
        }

    }

    private void showCards(){
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards[i].length; j++) {
                System.out.print(cards[i][j]+" ");
            }
            System.out.println("");
        }
    }

    private int searchCard(int chooseCard, int[][] cards) {
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards[0].length; j++) {
                if (cards[i][j] == chooseCard) {
                    return i+1;
                }
            }
        }
        return 0;
    }

    private boolean isDuplicateNumbers(int number, int[][] array){
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards[0].length; j++) {
                if (cards[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }
}


