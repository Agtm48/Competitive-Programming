// USACO Silver Contest, December 2015
// High Card Wins
import java.util.*;
import java.io.*;


public class highcard {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("highcard.in"));
        int n = in.nextInt();
        // size 7
        boolean[] elsieWins = new boolean[2*n + 1];
        ArrayList<Integer> bessie = new ArrayList<>();
        ArrayList<Integer> elsie = new ArrayList<>();
        // O(N)
        for(int i = 0; i < n; i++){
            elsieWins[in.nextInt()] = true;
        }
        Collections.sort(elsie);

        for(int i = 1; i <= 2*n; i++){
            if(elsieWins[i]){
                elsie.add(i);
            }
            else{
                bessie.add(i);
            }

        }
        Collections.sort(bessie);
        int result = 0;

        for(int i = 0; i < elsie.size(); i++){
            for(int j = 0; j < bessie.size(); j++){
                if(bessie.get(j) > elsie.get(i)){
                    result++;
                    bessie.remove(j);
                    break;
                }
            }
        }




        in.close();



        PrintWriter out = new PrintWriter(new File("highcard.out"));
//        System.out.println(result);
        out.println(result);
        out.close();
    }


}
/*  ANALYSIS



1   6   4


Remaining:  2   3   5




































*/