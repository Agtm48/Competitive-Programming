/*
    PROB: beads
    LANG: JAVA

 */

import java.io.*;
import java.util.*;


/**
 * Created by aksha on 9/17/2017.
 */
public class beads {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(new File("beads.in"));
        int n = Integer.parseInt(in.nextLine());
        String content = in.nextLine();
        int maximum = 2;
        int amount = 0;
        for(int i = 0; i < content.length(); i++){
            int left = takeLeft(i, content);
            int right;
            if(i == content.length() - 1){
                right = takeRight(0, content);
            }
            else{
                right = takeRight(i+1, content);
            }
            int totalAmt = Math.min(content.length(), left + right);
            if(totalAmt > maximum){
                maximum = totalAmt;
            }
        }
        System.out.println(maximum);

        in.close();
        PrintWriter out = new PrintWriter(new File("beads.out"));
        out.println(maximum);
        out.close();
    }
    public static int takeLeft(int start, String content){
        int left = start;
        boolean isComplete = false;
        int totalBeads = 1;
        char curr = content.charAt(left);
        left = left == 0 ? content.length() - 1 : left - 1;
        while(!isComplete && totalBeads < content.length()){
            char currBead = content.charAt(left);
            if(currBead != 'w' && currBead != curr && curr != 'w'){
                isComplete = true;
            }
            else{
                if(curr == 'w'){
                    curr = currBead;
                }
                totalBeads++;
                left = left == 0 ? content.length() -1 : left - 1;
            }

        }
        return totalBeads;
    }
    public static int takeRight(int start, String content){
        int right = start;
        boolean isComplete = false;
        int totalBeads = 1;
        char curr = content.charAt(right);
        right = right == content.length() - 1 ? 0 : right + 1;
        while(!isComplete && totalBeads < content.length()){
            char currBead = content.charAt(right);
            if(currBead != 'w' && currBead != curr && curr != 'w'){
                isComplete = true;
            }
            else{
                if(curr == 'w'){
                    curr = currBead;
                }
                totalBeads++;
                right = right == content.length() - 1 ? 0 : right + 1;
            }

        }
        return totalBeads;
    }
}
