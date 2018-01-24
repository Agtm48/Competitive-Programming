// USACO Bronze Contest, February 2012
// Moo
import java.io.*;
import java.util.*;

//RECURSION
public class moo {
    static int n;

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(new File("moo.in"));
        n = in.nextInt();
        in.close();

        System.out.println(nthChar(n));


        PrintWriter out = new PrintWriter(new File("moo.out"));
        out.close();
    }

    static int findLength(int k){
        //Finding length of S(k)
        int n;
        if (k == -1){
            return 0;
        }
        n = findLength(k-1);
        return n + n + k + 3;
    }
    static char nthChar(int k){
        if(n > findLength(k)){
            return nthChar(k+1);
        }
        if(n <= findLength(k-1)){
            return nthChar(k-1);
        }
        n -= findLength(k-1);
        if(n <= k + 3){
            if(n == 1){
                return 'm';
            }
            else{
                return 'o';
            }
        }
        n -= k+3;
        return nthChar(k-1);
    }
}

/*  ANALYSIS

Recursion: writing a recursive function to compute length of S(k) --> twice the length of S(k-1) + k + 3 --> middle section
Figure out nth character in S(k) by checking if n lies in left copy of S(k-1), middle, or right copy





 */
