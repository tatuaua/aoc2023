import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day5 {
    

    public static void main(String[] args) throws FileNotFoundException{

        long start = System.nanoTime();

        String data = "";
        String[] eachMap;

        File myObj = new File("src/day5input.txt");
        Scanner myReader = new Scanner(myObj);

        while (myReader.hasNextLine()) {
            data = data + myReader.nextLine() + "\n";
        }

        myReader.close();
      
        eachMap = data.split("\n\n");

        ArrayList<Long> seeds = new ArrayList<Long>();

        int i = 0;
        while(i < eachMap[0].split(":")[1].split(" ").length){
            
            if(eachMap[0].split(":")[1].split(" ")[i].length() != 0){
                seeds.add(Long.parseLong(eachMap[0].split(":")[1].split(" ")[i]));
            }
            i++;
        }

        for(int j = 0; j < seeds.size(); j++){

            long seed = seeds.get(j);

            for(int currMap = 1; i < eachMap.length; currMap++){

                
            }
        }
        long end = System.nanoTime();

        System.out.println(seeds.toString());

        System.out.println("Time to execute: " + (end-start)/1000000 + " ms");

    }
}