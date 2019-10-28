/*
    PROB: namenum
    LANG: JAVA


 */

import java.util.*;
import java.io.*;

public class namenum {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("namenum.in"));
        double result = in.nextDouble();
        in.close();
        Scanner dictionary = new Scanner(new File("dict.txt"));

        ArrayList<String> answer = new ArrayList<>();
        while(dictionary.hasNext()){
            String s = dictionary.next();
            double d = getCode(s);
            if(d == result){
                answer.add(s);
            }
        }
        dictionary.close();
        Collections.sort(answer);

        PrintWriter out = new PrintWriter(new File("namenum.out"));
        if(answer.size() != 0){
            for(String re : answer){
                out.println(re);
            }
        }
        else{
            out.println("NONE");
        }

        out.close();
    }
    static double getCode(String code){
        String[] lets = code.split("");
        String st = "";
        for(String s : lets){
            st += convert(s);
        }
        return Double.parseDouble(st);
    }
    static int convert(String letter){
        if(letter.equals("A") || letter.equals("B") || letter.equals("C")){
            return 2;
        }
        if(letter.equals("D") || letter.equals("E") || letter.equals("F")){
            return 3;
        }
        if(letter.equals("G") || letter.equals("H") || letter.equals("I")){
            return 4;
        }
        if(letter.equals("J") || letter.equals("K") || letter.equals("L")){
            return 5;
        }
        if(letter.equals("M") || letter.equals("N") || letter.equals("O")){
            return 6;
        }
        if(letter.equals("P") || letter.equals("R") || letter.equals("S")){
            return 7;
        }
        if(letter.equals("T") || letter.equals("U") || letter.equals("V")){
            return 8;
        }
        else{
            return 9;
        }
    }
}
/*  ANALYSIS





*/