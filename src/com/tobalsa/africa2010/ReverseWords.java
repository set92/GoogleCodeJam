package com.tobalsa.africa2010;

import java.util.ArrayList;

/**
 * Created by set92 on 09/04/2014.
 * Problem: Given a list of space separated words, reverse the order of the words. Each line of text contains L letters
 * and W words. A line will only consist of letters and space characters. There will be exactly one space character
 * between each pair of consecutive words.
 */
public class ReverseWords {
    ArrayList al = new ArrayList();
    int numCases = 0;
    String phrases;

    public void enter(String userInput){
      numCases = Integer.parseInt(userInput.substring(0, userInput.indexOf(" ")));
      phrases = userInput.substring(userInput.indexOf(" "+1));
      cutLines(phrases);

    }

    private void cutLines(String phrases){
      while (numCases !=0){
          for (int i = 0; i <= 0; i++) {
              al.set(i, phrases.substring(0, phrases.indexOf(" ")));
              phrases = phrases.substring(phrases.indexOf(" "+1));
              System.out.println(phrases+"_______"+al.get(i));
          }

          numCases--;
      }
    }

    private void reverseWords(String line){

    }

//    public void getWords(String userInput){
//        for (int i = userInput.indexOf("\r\n"); i != -1; userInput.indexOf("\r\n"+1)) {
//            al.add(cont, userInput.substring(0,userInput.indexOf("\r\n")));
//            userInput = userInput.substring(userInput.indexOf("\r\n")+1);
//            System.out.println(al.get(cont));
//            cont++;
//        }
//        System.out.println(al.get(0));
//    }
//
//    private void cases() {
//        System.out.println(al.get(0));
//    }

}

//int index = userInput.indexOf("\n");
//al.add(userInput.substring(0,index));
//        userInput = userInput.substring(index+1);
//        if (userInput.indexOf(" ")==-1){
//        al.add(userInput.substring(0));
//        cases();
//        }
//        return getWords(userInput);