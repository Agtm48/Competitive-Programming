import java.util.*;
import java.io.*;
/*
PROB: gift1
LANG: JAVA

 */
class gift1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("gift1.in"));
        // Number of people
        int n = in.nextInt();
        String[] peopleArr = new String[n];
        // Stores a person's name + their amount
        HashMap<String, Integer> people = new HashMap<>();
        for(int i = 0; i < n; i++){
            String person = in.next();
            people.put(person, 0);
            peopleArr[i] = person;
        }
        for(int i = 0; i < n; i++){
            String currPerson = in.next();
            int moneyGive = in.nextInt();
            int numOfGifts = in.nextInt();
            int eachGift = 0;
            if(numOfGifts > 0){
                eachGift = moneyGive / numOfGifts;

            }
            people.put(currPerson, Integer.parseInt(people.get(currPerson).toString()) - (eachGift * numOfGifts));
            for(int j = 0; j < numOfGifts; j++){
                String currRecipient = in.next();
                people.put(currRecipient, Integer.parseInt(people.get(currRecipient).toString()) + eachGift);
            }
        }
        in.close();
        PrintWriter out = new PrintWriter(new File("gift1.out"));

        for(int i = 0; i < people.size(); i++){
            System.out.println(peopleArr[i] + " " + people.get(peopleArr[i]));
            out.println(peopleArr[i] + " " + people.get(peopleArr[i]));

        }


        out.close();
    }
}

/* ANALYSIS



*/