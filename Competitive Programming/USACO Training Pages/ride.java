import java.io.*;
/*
PROB: ride
LANG: JAVA

 */
public class ride {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("ride.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        String cometName = br.readLine();
        String groupName = br.readLine();
        char[] tokens = cometName.toCharArray();
        char[]tokens2 = groupName.toCharArray();

        int cometProduct = 1;
        int groupProduct = 1;
        for(char c : tokens)
        {
            int temp = (int)c;
            int temp_integer = 64; //for upper case
            if(temp<=90 & temp>=65) {
                cometProduct = cometProduct *(temp - temp_integer);                }

        }


        for(char c : tokens2)
        {
            int temp = (int)c;
            int temp_integer = 64; //for upper case
            if(temp<=90 & temp>=65) {
                groupProduct = groupProduct *(temp - temp_integer);                }

        }

        int groupMod = Math.floorMod(groupProduct, 47);
        int cometMod = Math.floorMod(cometProduct, 47);
        if(groupMod == cometMod){
            pw.println("GO");
        }
        else{
            pw.println("STAY");
        }
        pw.close();
    }
}
