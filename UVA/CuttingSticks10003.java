/**
 * Created by aksha on 1/14/2018.
 */

import java.util.*;
import java.io.*;

public class CuttingSticks10003 {
    static int l, n;
    static int[] A = new int[55];
    static int[][] memo = new int[55][55];
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("CuttingSticks10003.in"));
        while(true){
            l = in.nextInt();
            n = in.nextInt();
            if(l == 0){
                break;
            }
            for(int i = 0; i < 55; i++){
                for(int j = 0; j < 55; j++){
                    memo[i][j] = -1;
                }
            }
            for(int i = 0; i < n; i++){
                A[i] = in.nextInt();
            }
            System.out.println("The minimum cutting is " + cut(0, n + 1));

        }
        in.close();


        int result = 0;

        PrintWriter out = new PrintWriter(new File("CuttingSticks10003.out"));
        System.out.println(result);
        out.println(result);
        out.close();
    }
    static int cut(int left, int right){
        if(left + 1 == right){
            return 0;
        }
        if(memo[left][right] != -1){
            return memo[left][right];
        }
        int cuts = Integer.MAX_VALUE;
        // Iterating through each of the endpoint indices from left to right.
        for(int i = left + 1; i < right; i++){
            cuts = Math.min(cut(left, i) + cut(i, right), A[right] - A[left]);
        }
        return cuts;
    }
}
/*  ANALYSIS
Given stick of length l (1, 1000) and n (1, 50) cuts to be made of the stick, find a cutting sequence in which
    the overall cost is minimized.

The cost of a cut is the total length of the stick that will be cut.


Case: l = 100, n = 3, cut coordinates = A = {25, 50, 75}.

- Cutting left to right: cost = 225
    - first cut is at coord 25, total cost = 100
    - second cut at 50, total cost

Approaches to the Problem:
- Complete Search: Try all possible cutting points
    - In this case, the appropriate state for the DP problem would be the stick, with a left and right value.
    - However, these values can become quite large, which makes memoization of an array very hard.
- Dynamic Programming (Memoization): THERE ARE ONLY N + 1 SMALLER STICKS AFTER CUTTING THE ORIGINAL STICK N TIMES.
    --> The endpoints of each smaller stick can be described by 0, the cutting point coords., and l.
    - Add two more coordinates so that A = {0, the original A, and l} so a stick can be denoted by the endpoints of its
        indices in the A array.

Final Approach: Use these recurrences for cut(left, right), where left/right are the left and right indices of the
    current stick with respect to A. Originally, the stick is described by left = 0, right = n + 1 in A[0]..., A[n-1].

1. cut(i-1, i) = 0 --> if left + 1 = right where left and right are the indices in A, then the stick segment cannot be
    divided any further.
2. cut(left, right) = min(cut(left, i) + cut(i, right) + (A[right] - A[left]))

The recursive base case to start off the program will just be cut(0, n + 1);


*/