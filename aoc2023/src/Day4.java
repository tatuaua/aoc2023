import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day4 {
    

    public static void main(String[] args) throws FileNotFoundException{

        long start = System.nanoTime();

        String data = "";
        String[] eachInput;

        File myObj = new File("aoc2023/src/day4input.txt");
        Scanner myReader = new Scanner(myObj);

        while (myReader.hasNextLine()) {
            data = data + myReader.nextLine() + "\n";
        }

        myReader.close();
      
        eachInput = data.split("\n");

        int total = 0;
        int points = 0;

        for(String input : eachInput){

            points = 0;
            input = input.split(":")[1];
            String[] winningNums = input.split("\\|");
            String[] myNums = winningNums[1].split(" ");
            winningNums = winningNums[0].split(" ");

            System.out.println("w: " + Arrays.toString(winningNums) + "my: " + Arrays.toString(myNums));

            for(String num : myNums){

                for(String wnum: winningNums){

                    if(num.equals(wnum) && wnum.length() != 0){

                        System.out.println("Found matching: " + num + ", " + wnum);
                        if(points == 0){
                            points = 1;
                        } else {
                            points *= 2;
                        }
                    }
                }
            }
            
            if(points == 0){
                System.out.println("card had no points");
            }

            total += points;
        }



        System.out.println(total);

        long end = System.nanoTime();

        System.out.println("Time to execute: " + (end-start)/1000000 + " ms");

    }
}