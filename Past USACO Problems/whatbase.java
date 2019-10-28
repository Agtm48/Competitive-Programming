// USACO Bronze Contest, January 2015
// It's All About The Base

import java.util.*;
import java.io.*;

public class whatbase {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("whatbase.in"));
        int k = in.nextInt();
        for(int i = 0; i < k; i++){
            int xNum = in.nextInt();
            int yNum = in.nextInt();
            int x = 10;
            int y = 10;
            int maxBase = 15000;
            while(x < maxBase && y < maxBase){
                if(base(x, xNum) < base(y, yNum)){
                    x++;
                }
                else if(base(x, xNum) > base(y, yNum)){
                    y++;
                }
                else{
                    System.out.println(x + " " + y);
                    break;
                }
            }

        }
        in.close();


        int result = 0;

        PrintWriter out = new PrintWriter(new File("whatbase.out"));
        System.out.println(result);
        out.println(result);
        out.close();
    }
    static int base(int b, int n){
        String s = "" + n;
        String[] tokens = s.split("");
        return b * b * Integer.parseInt(tokens[2]) + b * Integer.parseInt(tokens[1]) + Integer.parseInt(tokens[0]);
    }
}
/*  ANALYSIS
Possible bit manipulation
Compute all integers that each input number could evaluate to & find the overlap

1
419 792

*/