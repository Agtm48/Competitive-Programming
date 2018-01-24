// USACO February 2014 Contest, Bronze
// Auto Complete

import java.util.*;
import java.io.*;


public class auto {
    static String[] dictionary;
    static int w, n;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("auto.in"));
        w = in.nextInt();
        n = in.nextInt();
        dictionary = new String[w + 1];
        for(int i = 1; i <= w; i++){
            dictionary[i] = in.next();
        }
        ArrayList<Integer> solns = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int q = in.nextInt();
            String seq = in.next();
            solns.add(solve(q, seq));
        }

        in.close();

        PrintWriter out = new PrintWriter(new File("auto.out"));
        for(int s : solns){
            out.println(s);
        }
        out.close();
    }
    static int solve(int query, String sequence){
        int result = -1;
        ArrayList<String> tempStrings = new ArrayList<>();
        for(int i = 1; i < dictionary.length; i++){
            if(dictionary[i].startsWith(sequence)) {
                tempStrings.add(dictionary[i]);
            }
        }
        tempStrings.sort(String::compareToIgnoreCase);
        if(query > tempStrings.size()){
            return -1;
        }
        String ret = tempStrings.get(query - 1);
        ArrayList<String> strAns = new ArrayList<>(Arrays.asList(dictionary));
        return strAns.indexOf(ret);
    }
}
/*  ANALYSIS

10 3
dab
ba
ab
daa
aa
aaa
aab
abc
ac
dadba
4 a
2 da
4 da



*/