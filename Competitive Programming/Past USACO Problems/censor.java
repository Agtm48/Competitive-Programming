// USACO 2015 Silver Contest, February
// Censoring

import java.util.*;
import java.io.*;

public class censor {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("censor.in"));
        //Linear sweep approach
        String s = in.next();   // The text that is read in (S)
        String t = in.next();     // The word that needs to be censored (T)
        String[] letters = s.split("");
        //Setting up the initial window
        String result = "";
        for(int i = 0; i < letters.length; i++){
            result += letters[i];
            if(result.length() >= t.length() && result.substring(result.length() - t.length()).equals(t)){
                result = result.substring(i, result.length() - t.length() + 1);
            }

        }

        in.close();



        PrintWriter out = new PrintWriter(new File("censor.out"));
        System.out.println(result);
        out.println(result);
        out.close();
    }
}
/*  ANALYSIS





*/