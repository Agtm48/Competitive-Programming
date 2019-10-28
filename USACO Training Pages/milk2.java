/*
    PROB: milk2
    LANG: JAVA


 */
import java.util.*;
import java.io.*;
public class milk2 {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(new File("milk2.in"));
        int n = in.nextInt();
        int[] counts = new int[1000000];
        int starting = Integer.MAX_VALUE;
        int ending = 0;
        for(int i = 0; i < n; i++){
            int begin = in.nextInt();
            int end = in.nextInt();
            starting = Math.min(starting, begin);
            ending = Math.max(ending, end);
            for(int t = begin; t < end; t++){
                counts[t]++;
            }
        }
        int m1 = 0;
        int m2 = 0;
        int temp1 = 0;
        int temp2 = 0;
        for(int i = starting; i < ending; i++){
            if(counts[i]>0){
                temp1++;
                temp2 = 0;
            }
            else{
                temp2++;
                temp1 = 0;
            }
            m1 = Math.max(m1, temp1);
            m2 = Math.max(m2, temp2);
        }








        int result = 0;
        PrintWriter out = new PrintWriter(new File("milk2.out"));
        System.out.println(result);
        out.println(m1 + " " + m2);
        out.close();

    }
    static class Time implements Comparable<Time>{
        int start, end;
        Time(Scanner in){
            start = in.nextInt();
            end = in.nextInt();
        }
        public int compareTo(Time other){
            return this.start - other.start;
        }
    }
}
