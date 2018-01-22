/**
 * Created by aksha on 1/14/2018.
 */

import java.util.*;
import java.io.*;

public class CountWay00357 {
    static int[] denoms = {1, 5, 10, 25, 50};
    static int[][] memo;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("CountWay00357.in"));
        ArrayList<String> solns = new ArrayList<>();
        while(in.hasNext()){
            int n = in.nextInt();
            memo = new int[n][n];
            for(int[] i : memo){
                Arrays.fill(i, -1);
            }
            int way = ways(0, n);
            if(way == 1){
                solns.add("There is only 1 way to produce " + n + " cents change.");
            }
            else{
                solns.add("There are " + way + " ways to produce " + n + " cents change.");
            }
        }
        in.close();


        int result = 0;

        PrintWriter out = new PrintWriter(new File("CountWay00357.out"));
        System.out.println(result);
        out.println(result);
        out.close();
    }
    static int ways(int type, int value){
        if(value == 0){
            return 1;
        }
        if(memo[type][value] != -1){
            return memo[type][value];
        }

        return memo[type][value] = ways(type + 1, value) + ways(type, value - denoms[type]);
    }
}
/*  ANALYSIS
Algorithm: Coin Change Dynamic Programming Approach
V = 17, n = ?, coinValue = {1, 5, 10, 25, 50}





*/