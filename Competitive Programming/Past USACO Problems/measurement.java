// USACO Silver Contest, December 2017
// Milk Measurement

import java.util.*;
import java.io.*;

public class measurement {
    static int n;
    static int g;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("measurement.in"));
        n = in.nextInt();
        g = in.nextInt();
        Measuring[] entries = new Measuring[n];
        for(int i = 0; i < n; i++){
            entries[i] = new Measuring(in);
        }
        Arrays.sort(entries);
        in.close();


        int result = 0;

        PrintWriter out = new PrintWriter(new File("measurement.out"));
        System.out.println(result);
        out.println(result);
        out.close();
    }
    static class Measuring implements Comparable<Measuring>{
        int date, id, change;
        int gallon = g;
        Measuring(Scanner in){
            date = in.nextInt();
            id = in.nextInt();
            String temp = in.next();
            //Positive number
            if(temp.contains("+"))
                change = Integer.parseInt(temp.substring(1));

            else
                change = Integer.parseInt(temp);
        }
        public int compareTo(Measuring other){
            //Want to sort the entries by date, not anything else
            return this.date - other.date;
        }

    }
}
/*  ANALYSIS
4 10
7 3 +3
4 2 -1
9 3 -1
1 1 +2




*/