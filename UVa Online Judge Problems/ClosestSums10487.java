/**
 * Created by aksha on 12/31/2017.
 */

import java.util.*;
import java.io.*;

public class ClosestSums10487 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("ClosestSums10487.in"));
        int n;
        ArrayList<int[]> solns = new ArrayList<>();
        while((n = in.nextInt()) != 0){
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = in.nextInt();
            }
            // Sorting the array for the optimal O(n^2) algorithm.
            Arrays.sort(nums);
            int m = in.nextInt();
            int[] queryAns = new int[m];
            for(int i = 0; i < m; i++){
                int query = in.nextInt();
                queryAns[i] = solve(nums, query);
            }
            solns.add(queryAns);

        }
        in.close();

        for(int[] s : solns){
            int currCase = 1;
            System.out.println("Case " + currCase + ":");
            for(int x : s){
                System.out.println("Closest sum to x is " + x);
            }
            currCase++;
        }
        int result = 0;

        PrintWriter out = new PrintWriter(new File("ClosestSums10487.out"));
        System.out.println(result);
        out.println(result);
        out.close();
    }
    static int solve(int[] array, int query){
        // Assuming that the array is already sorted.
        int minDifference = Integer.MAX_VALUE;
        int optimalSum = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                if(i != j && Math.abs(query - (array[i] + array[j])) < minDifference ){
                    int sum = array[i] + array[j];
                    minDifference = Math.abs(query - sum);
                    optimalSum = query - sum > 0 ? -1 : 1;
                }
            }
        }

        return query + (minDifference * optimalSum);


    }
}
/*  ANALYSIS





*/