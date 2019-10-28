/**
 * Created by aksha on 1/1/2018.
 */

import java.util.*;
import java.io.*;

public class MonkeyBamboo12032 {
    static int[] heights;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("MonkeyBamboo12032.in"));
        int T = in.nextInt();
        ArrayList<Integer> solns = new ArrayList<>();
        while(T-- > 0){
            int n = in.nextInt();
            heights = new int[n+1];
            heights[0] = 0;
            int sum = 0;
            for(int i = 1; i <= n; i++){
                heights[i] = in.nextInt();
                sum += heights[i];
            }
            int low = 0;
            int high = sum;
            int best = high + 1;
            while(low <= high){
                int mid = (low + high) / 2;
                if(isK(mid)){
                    best = mid;
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            solns.add(best);

        }
        in.close();


        int result = 0;

        PrintWriter out = new PrintWriter(new File("MonkeyBamboo12032.out"));
        System.out.println(result);
        for(int i : solns){
            System.out.println(i);
        }
        out.println(result);
        out.close();
    }
    static boolean isK(int k){
        for(int i = 1; i < heights.length; i++){
            int difference = heights[i] - heights[i-1];
            if(difference > k){
                return false;
            }
            else if(k > difference){
                // Do nothing yet
            }
            else if(k == difference){
                k--;
            }
        }
        return true;
    }
}
/*  ANALYSIS

Initially I am on the ground. In each jump I can
jump from the current rung (or the ground) to the next rung only (can’t skip rungs). Initially I set
my strength factor k. The meaning of k is, in any jump I can’t jump more than k feet. And if I jump
exactly k feet in a jump, k is decremented by 1. But if I jump less than k feet, k remains same.



*/