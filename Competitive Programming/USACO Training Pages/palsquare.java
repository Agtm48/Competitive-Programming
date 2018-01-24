/*
    PROB: palsquare
    LANG: JAVA


 */

import java.util.*;
import java.io.*;

public class palsquare {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("palsquare.in"));
        ArrayList<String> solns = new ArrayList<>();
        // Base that the input must be in.
        int B = in.nextInt();
        for(int i = 1; i < 300; i++){
            String s = Integer.toString(i * i, B).toUpperCase();
            if(isPalindrome(s)){
                solns.add(Integer.toString(i, B).toUpperCase() + " " + s);
            }
        }
        in.close();

        PrintWriter out = new PrintWriter(new File("palsquare.out"));
        for(String c : solns){
            out.println(c);
        }
        out.close();
    }
    static boolean isPalindrome(String s){
        String temp = "";
        String[] tokens = s.split("");
        for(int i = tokens.length - 1; i >= 0; i--){
            temp += tokens[i];
        }
        return temp.equalsIgnoreCase(s);
    }
}
/*  ANALYSIS





*/