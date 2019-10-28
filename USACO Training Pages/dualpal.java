/*
    PROB: dualpal
    LANG: JAVA


 */

import java.util.*;
import java.io.*;

public class dualpal {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("dualpal.in"));
        int n = in.nextInt();
        int s = in.nextInt();
        in.close();
        int number = s + 1;
        ArrayList<Integer> solns = new ArrayList<>();
        while(n > 0){
           if(works(number)){
               n--;
               solns.add(number);
           }
           number++;
        }

        int result = 0;

        PrintWriter out = new PrintWriter(new File("dualpal.out"));
//        System.out.println(result);
        for(Integer i : solns){
            out.println(i);
        }
        out.close();
    }
    static boolean works(int n){
        int result = 0;
        for(int i = 2; i <= 10; i++){
            String baseN = Integer.toString(n, i);
            if(isPalindrome(baseN)){
                result++;
            }
            if(result >= 2){
                return true;
            }
        }
        return result >= 2;
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