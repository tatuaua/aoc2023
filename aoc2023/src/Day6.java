import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Day6 {
    

    public static void main(String[] args) throws FileNotFoundException{

        long start = System.nanoTime();

        String data = "";
        String[] eachInput;
        String[] times;
        String[] distances;

        File myObj = new File("src/day6input.txt");
        Scanner myReader = new Scanner(myObj);

        while (myReader.hasNextLine()) {
            data = data + myReader.nextLine() + "\n";
        }

        myReader.close();
      
        eachInput = data.split("\n");

        System.out.println(Arrays.toString(eachInput));
        
        times = eachInput[0].split(" ");
        System.out.println(Arrays.toString(times));

        distances = eachInput[1].split(" ");
        System.out.println(Arrays.toString(distances));;

        ArrayList<Integer> timeslist = new ArrayList<Integer>();
        ArrayList<Integer> distlist = new ArrayList<Integer>();

        for(int i = 0; i < times.length; i++){

            if (times[i].matches("[0-9]+")){
                timeslist.add(Integer.parseInt(times[i]));
            }
        }

        for(int i = 0; i < distances.length; i++){

            if(distances[i].matches("[0-9]+")){
                distlist.add(Integer.parseInt(distances[i]));
            }
        }

        int[] waysToWins = new int[1000000];
        int index = 0;
        
        for(int j = 0; j < 4; j++){

            int waysToWin = 0;

            for(int heldDownFor = 0; heldDownFor < timeslist.get(j); heldDownFor++){

                if(heldDownFor * (timeslist.get(j) - heldDownFor) >= distlist.get(j)){
                    waysToWin++;
                }
            }


            if(waysToWin != 0){
                waysToWins[index] = waysToWin;
                index++;
            }
        }

        int total = 0;

        for(int f = 0; f < waysToWins.length; f++){
            
            while(waysToWins[f] != 0){
                total *= waysToWins[f];
            }
        }

        System.out.println(total);

        long end = System.nanoTime();

        System.out.println("Time to execute: " + (end-start)/1000000 + " ms");

    }
}