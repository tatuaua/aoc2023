import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {

    public static void main(String[] args) throws FileNotFoundException{

        long start = System.nanoTime();

        String data = "";
        String[] eachInput;

        File myObj = new File("aoc2023/src/day2input.txt");
        Scanner myReader = new Scanner(myObj);

        while (myReader.hasNextLine()) {
            data = data + myReader.nextLine() + "\n";
        }

        myReader.close();
      
        eachInput = data.split("\n");

        int idTotal = 0;
        int totalPower = 0;

        int maxRed = 12;
        int maxGreen = 13;
        int maxBlue = 14;

        for(int i = 0; i < eachInput.length; i++){

            int biggestGreen = 0;
            int biggestBlue = 0;
            int biggestRed = 0;

            String input = eachInput[i].split(":")[1]; // Remove the Game X:
            boolean inputValid = true;
            System.out.println("Analyzing game " + i + ": " + input);
            String[] sets = input.split(";"); // Split the game into sets

            for(int j = 0; j < sets.length; j++){

                String[] elems = sets[j].split(" "); // ALl numbers have empty space around them so we can extract them from the words this way
                System.out.println("Checking set " + j +  " :" + sets[j]);

                for(int k = 0; k < elems.length; k++){

                    if(elems[k].equals("green,") || elems[k].equals("green")){
                        System.out.println("found green, checking " + elems[k-1]);

                        int elemInt = Integer.parseInt(elems[k-1]);

                        if(elemInt > maxGreen){
                            System.out.println("Green was too big, game " + i + " invalid");
                            inputValid = false;
                        }

                        if(elemInt > biggestGreen){
                            biggestGreen =  elemInt;
                        }
                    }

                    if(elems[k].equals("blue,") || elems[k].equals("blue")){
                        System.out.println("found blue, checking " + elems[k-1]);

                        int elemInt = Integer.parseInt(elems[k-1]);

                        if(elemInt > maxBlue){
                            System.out.println("Blue was too big, game " + i + " invalid");
                            inputValid = false;
                        }

                        if(elemInt > biggestBlue){
                            biggestBlue =  elemInt;
                        }
                    }

                    if(elems[k].equals("red,") || elems[k].equals("red")){
                        System.out.println("found red, checking " + elems[k-1]);

                        int elemInt = Integer.parseInt(elems[k-1]);

                        if(elemInt > maxRed){
                            System.out.println("Red was too big, game " + i + " invalid");
                            inputValid = false;
                        }

                        if(elemInt > biggestRed){
                            biggestRed =  elemInt;
                        }
                    }
                }   
            }

            if(inputValid){
                idTotal += i+1;
            }

            System.out.println("Biggest green for game " + i + ": " + biggestGreen);
            System.out.println("Biggest blue for game " + i + ": " + biggestBlue);
            System.out.println("Biggest red for game " + i + ": " + biggestRed);

            totalPower += (biggestGreen * biggestBlue * biggestRed);
        }

        long end = System.nanoTime();

        System.out.println("Valid games id total: " + idTotal);
        System.out.println("Power total: " + totalPower);
        System.out.println("Time to execute: " + (end-start)/1000000 + " ms");
        
    }
    
}


