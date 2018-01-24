// USACO Bronze Contest, March 2013
// Breed Proximity
 import java.util.*;
 import java.io.*;

 public class proximity {
   public static void main(String[] args) throws Exception {
     Scanner in = new Scanner(new File("proximity.in"));
     int n = in.nextInt();  // # cows
     int k = in.nextInt();  // difference within which cows are crowded

     int[] cowsInLine = new int[n];
     for (int i = 0; i < n; i++) cowsInLine[i] = in.nextInt();
     in.close();

     int result = -1;
     boolean[] breedInWindow = new boolean[1000001];
     // index: a breed id
     // value: is this breed id currently in the "crowded window"
     // alternative: a HashSet

     // initial window
     for (int i = 0; i <= k; i++) {
       int b = cowsInLine[i];
       if (breedInWindow[b]) result = Math.max(result, b);
       breedInWindow[b] = true;
     }
     // each time add cow i to window, remove cow i-k-1
     for (int i = k+1; i < n; i++) {
       int bLeaving = cowsInLine[i-k-1];
       int bEntering = cowsInLine[i];

       breedInWindow[bLeaving] = false;
       if (breedInWindow[bEntering]) result = Math.max(result, bEntering);
       breedInWindow[bEntering] = true;
     }

     PrintWriter out = new PrintWriter(new File("proximity.out"));
     System.out.println(result);
     out.println(result);
     out.close();
   }
 }