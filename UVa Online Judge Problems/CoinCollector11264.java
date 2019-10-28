/**
 * Created by aksha on 1/2/2018.
 */

import java.util.*;
import java.io.*;

public class CoinCollector11264 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("CoinCollector11264.in"));
        int T = in.nextInt();
        ArrayList<Integer> solns = new ArrayList<>();
        while(T-- > 0){
            int n = in.nextInt();
            int[] values = new int[n];
            for(int i = 0; i < n; i++){
                values[i] = in.nextInt();
            }
            int sum = values[0];
            int answer = 1;
            for(int i = 1; i < n-1; i++){
                if(values[i + 1] > sum + values[i]){
                    sum += values[i];
                    answer++;
                }
            }
            solns.add(answer + 1);

        }
        in.close();


        int result = 0;

        PrintWriter out = new PrintWriter(new File("CoinCollector11264.out"));
        System.out.println(result);
        for(int i : solns){
            System.out.println(i);
        }
        out.println(result);
        out.close();
    }
}
/*  ANALYSIS
2
6
1 2 4 8 16 32
6
1 3 6 8 15 20

Problem (Shortened): Given a series of coin values, find the maximum number of coins that can be received in a single
withdrawal from the Bank, which tries to maximize the number of different coins per withdrawal.

withdraw(X){
    if(X == 0) return;
    Let Y be the highest value coin not exceeding X.
    Give the customer the Y valued coin.
    withdraw(X - Y);

}


*/