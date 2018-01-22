/**
 * Created by aksha on 12/26/2017.
 */

import java.util.*;
import java.io.*;

public class Bars12455 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int n = in.nextInt();
        int i;
        int sum;
        for(i = 0; i < (i << n); i++){
            sum = 0;
            for(int j = 0; j < n; j++){
//                if (i & (1 << j)){
//                    sum += l[j];
//                }
//                if(sum == X){
//                    break;
//                }
            }
        }
        in.close();


        int result = 0;

        PrintWriter out = new PrintWriter(System.out);
        System.out.println(result);
        out.println(result);
        out.close();
    }
}
/*  ANALYSIS

The first line of the input contains an integer,t, 0 ≤ t ≤ 50, indicating the number of test cases. For
each test case, three lines appear, the first one contains a number n, 0 ≤ n ≤ 1000, representing the
length of the bar we want to obtain. The second line contains a number p, 1 ≤ p ≤ 20, representing the
number of bars we have. The third line of each test case contains p numbers, representing the length
of the p bars.

Algorithm: Try all possible 2^n subsets
    Use binary representation of integeres fromm 0 to 2^n - 1 to describe all of the possible subsets.
    Using bit manipulation --> The operations are very fast, so this will not be a time limit problem.



*/