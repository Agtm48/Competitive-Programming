/**
 * Created by aksha on 12/22/2017.
 */

import java.util.*;
import java.io.*;

public class GroupReverse11192 {
    static int n;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();
        while((n = in.nextInt()) != 0 && in.hasNextLine()){
            String curr = in.next();
            words.add(curr);
        }
        for(String s : words){
            String[] w = split(s);
            for(String st : w){
                System.out.print(reverse(st));
            }
            System.out.println();
        }
        in.close();


        int result = 0;

        PrintWriter out = new PrintWriter(System.out);
        System.out.println(result);
        out.println(result);
        out.close();
    }
    static String[] split(String s){
        String[] groups;
        String test = "";
        for(int i = 0; i < n; i++){
            test += ".";
        }
        groups = (s.split("(?<=\\G" + test + ")"));
        return groups;

    }
    static String reverse(String str){
        String result = "";
        for(int i = str.length() - 1; i >= 0; i--){
            result += str.charAt(i);
        }
        return result;
    }
}
/*  ANALYSIS





*/