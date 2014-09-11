package com.tobalsa;

import com.tobalsa.QualificationRound2014.CookieClickerAlpha;
import com.tobalsa.QualificationRound2014.MagicTrick;
import com.tobalsa.QualificationRound2014.MinesweeperMaster;
import com.tobalsa.africa2010.ReverseWords;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
//        ReverseWords rw = new ReverseWords();
//        String userInput = "3\r\n" +
//                "this is a test\r\n" +
//                "foobar\r\n" +
//                "all your base";
//        rw.enter(userInput);
        MinesweeperMaster mt = new MinesweeperMaster();
        try {
            mt.enter(readFile(System.getProperty("user.dir")+
                    "/src/com/tobalsa/QualificationRound2014/MinesweeperMaster.in", StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }


}
