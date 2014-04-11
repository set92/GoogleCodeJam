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
    int cont=0;
    public void getWords(String userInput){
        for (int i = userInput.indexOf("\r\n"); i != -1; userInput.indexOf("\r\n"+1)) {
            al.add(cont, userInput.substring(0,userInput.indexOf("\r\n")));
            userInput = userInput.substring(userInput.indexOf("\r\n")+1);
            System.out.println(al.get(cont));
            cont++;
        }
        System.out.println(al.get(0));
    }

    private void cases() {
        System.out.println(al.get(0));
    }

}

//int index = userInput.indexOf("\n");
//al.add(userInput.substring(0,index));
//        userInput = userInput.substring(index+1);
//        if (userInput.indexOf(" ")==-1){
//        al.add(userInput.substring(0));
//        cases();
//        }
//        return getWords(userInput);