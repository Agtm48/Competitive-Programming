/**
 * Created by aksha on 1/14/2018.
 */

import java.util.*;
import java.io.*;

public class Add10943 {
    // Memoization Array to speed up the rest of the DP solution.
    static int[][] memoized = new int[101][101];
    static int N, K;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("Add10943.in"));
        for(int i = 0; i < 101; i++){
            for(int j = 0; j < 101; j++){
                memoized[i][j] = -1;
            }
        }
        while(true){
            N = in.nextInt();
            K = in.nextInt();
            if(N == 0 && K == 0){
                break;
            }
            System.out.println(ways(N, K));
        }
        in.close();


        int result = 0;

        PrintWriter out = new PrintWriter(new File("Add10943.out"));
        System.out.println(result);
        out.println(result);
        out.close();
    }
    static int ways(int N, int K){
        if(K == 1){
            return 1;
        }
        if(memoized[N][K] != -1){
            return memoized[N][K];
        }
        int totalWay = 0;
        for(int x = 0; x <= N; x++){
            totalWay = (totalWay + ways(N-x, K - 1)) % 1000000;
        }
        memoized[N][K] = totalWay;
        return totalWay;
    }
}
/*  ANALYSIS

Given an integer n, how many ways can K non-negative integers <= n add up to n?

Mathematically, the number of ways is just (n+k-1) C (k-1)

Only two parameters for DP solution: n and K, so there are 4 possible combinations.
- if we don't choose any parameter, there is no state
- if we only choose n, then we don't know how many numbers have been used
- if we only choose k, then we don't know the target sum n.
- Choose N and K by a pair (n, K).

Determine the base cases: For K = 1, the problem becomes very easy.
- only one way to add exactly one number less than or equal to n to get n-> use n itself.

Recursive formula: at (n, K) where K > 1, split N into one number X [0, ..., n] and n - X.
- n = X + n - X. By doing this, the subproblem becomes N - X, K - 1.
- given a number N - X, how many ways can K - 1 numbers less than or equal to N - X add up to N - X?
- The problem quickly becomes a recursive DP, starting out with N, K.

1. ways(n, 1) = 1; only 1 number to add up to n (the number N)
2. ways(n, k) = Sum of ways(n - X, K - 1), from X = 0 to N.




*/