// USACO Bronzes Contest, December 2013
// Record Keeping

import java.util.*;
import java.io.*;

public class records {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("records.in"));
        int n = in.nextInt();
        String[] groups = new String[n];
        for(int i = 0; i < n; i++){
            String[] temp = new String[3];
            temp[0] = in.next();
            temp[1] = in.next();
            temp[2] = in.next();
            Arrays.sort(temp);
            // All of the groups of cows have been sorted.
            groups[i] = temp[0] + " " + temp[1] + " " + temp[2];

        }


        in.close();


        int result = 1;
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(groups[i].equals(groups[j]) && i != j){
                    result++;
                }
            }
            answer = Math.max(result, answer);
            result = 1;
        }


        PrintWriter out = new PrintWriter(new File("records.out"));
        System.out.println(answer);
        out.println(answer);
        out.close();
    }
}
/*  ANALYSIS





*/