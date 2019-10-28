/**
 * Created by aksha on 12/26/2017.
 */

import java.util.*;
import java.io.*;

public class SimpleEquations11565 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            int A = in.nextInt();
            int B = in.nextInt();
            int C = in.nextInt();
            boolean solved = false;
            int x, y, z;
            for(x = -100; x <= 100; x++){
                for(y = -100; y <= 100; y++){
                    for(z = -100; z <= 100; z++){
                        //Lightweight check base case to see if the 3 numbers are different, which greatly reduces
                        //  the runtime.
                        if(y != x && z != x && z != y && x + y + z == A && x * y * z == B && x*x + y*y + z*z == C){
                            if(!solved){
                                System.out.println(x + " " + y + " " + z);
                                solved = true;
                            }
                        }
                    }
                }
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





*/