/**
 * Created by aksha on 12/22/2017.
 */

import java.util.*;
import java.io.*;

public class CD11849 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        ArrayList<Integer> solutions = new ArrayList<>();
        String str;
        int n;
        int m;
        while(!((n = in.nextInt()) == 0) && !((m = in.nextInt()) == 0)){
            HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i < n; i++){
                set.add(in.nextInt());
            }
            int res = 0;
            for(int i = 0; i < m; i++){
                if(set.contains(in.nextInt())){
                    res++;
                }
            }
            solutions.add(res);
        }
        in.close();


        int result = 0;

        PrintWriter out = new PrintWriter(System.out);
        for(int i : solutions){
            System.out.println(i);
        }

        out.close();
    }
}

/*  ANALYSIS





*/