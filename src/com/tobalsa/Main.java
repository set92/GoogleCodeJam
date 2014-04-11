package com.tobalsa;

import com.tobalsa.africa2010.ReverseWords;

public class Main {



    public static void main(String[] args) {
        ReverseWords rw = new ReverseWords();
        String userInput = "3\r\n" +
                "this is a test\r\n" +
                "foobar\r\n" +
                "all your base";
        rw.enter(userInput);
    }
}
