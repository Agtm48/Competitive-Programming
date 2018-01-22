/**
 * Created by aksha on 12/31/2017.
 */

import java.util.*;
import java.io.*;

public class Darts00735 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("Darts00735.in"));
        ArrayList<Integer> solns = new ArrayList<>();
        ArrayList<String> finalAns = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 1; i <= 20; i++){
            if(!set.contains(i)){
                solns.add(i);
            }
            if(!set.contains(i * 2)){
                solns.add(i * 2);
            }
            if(!set.contains(i * 3)){
                solns.add(i * 3);
            }
            set.add(i);
            set.add(i * 2);
            set.add(i * 3);
        }
        solns.add(50);
        solns.add(0);
        while(true){
            int n = in.nextInt();
            if(n <= 0) break;
            int perms = 0;
            int combs = 0;
            for(int i : solns){
                for(int j : solns){
                    for(int k : solns){
                        if(i + j + k == n){
                            perms++;
                            // Good way to find out whether it is a combination
                            // Set the base case for combinations as in increasing order (L->R)
                            if(i <= j && j <= k){
                                combs++;
                            }
                            // Now, the number of combinations and permutations have been found.
                        }

                    }
                }
            }
            if(perms == 0){
                finalAns.add("THE SCORE OF " + n + " CANNOT BE MADE WITH THREE DARTS.");
            }
            else{
                finalAns.add("NUMBER OF COMBINATIONS THAT SCORES " + n + " IS " + combs);
                finalAns.add("NUMBER OF PERMUTATIONS THAT SCORES " + n + " IS " + perms);
            }
            String s = "";
            for(int i = 0; i < 70; i++){
                s += "*";
            }
            finalAns.add(s);
        }
        in.close();


        int result = 0;

        PrintWriter out = new PrintWriter(new File("Darts00735.out"));
        System.out.println(result);
        for(String s: finalAns){
            System.out.println(s);
        }
        out.println(result);
        out.close();
    }
}
/*  ANALYSIS
Given a player’s current dart score, write a program to calculate all the possible combinations and
permutations of scores on throwing three darts that would reduce the player’s score to exactly zero
(meaning the player won the game). The output of the program should contain the number of combinations
and permutations found.

Algorithm: Permute all the possible combinations, since the input size is small, and then compare
to the original answer to find the result of how many combinations add up to the player's
original score.


*/