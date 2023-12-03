import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day3 {
    

    public static void main(String[] args) throws FileNotFoundException{

        long start = System.nanoTime();

        String data = "";
        String[] eachInput;

        File myObj = new File("src/day3input.txt");
        Scanner myReader = new Scanner(myObj);

        while (myReader.hasNextLine()) {
            data = data + myReader.nextLine() + "\n";
        }

        myReader.close();
      
        eachInput = data.split("\n");

        char[][] array = new char[eachInput[0].length()][eachInput.length];

        for(int i = 0; i < array.length; i++){ // Construct 2d array
            for(int j = 0; j < array[i].length; j++){
                array[i][j] = eachInput[i].charAt(j);
            }
        }

        for(int k = 0; k < array.length; k++){ // Loops through all arrays
            
            for(int x = 0; x < array[0].length; x++){ // Loops through current array

                String enginePart = "";
                boolean isEnginePart = false;

                if(Character.isDigit(array[k][x])){

                    for(int y = k-1; y >= 0; y--){ // When we find a number, start looping up the arrays within the same X axis

                        if(Character.isDigit(array[k][x])){
                            break;
                        }

                        if(array[y][x] != '.' && !Character.isDigit(array[y][x])){

                            enginePart += array[y][x];
                            isEnginePart = true;
                            break;
                        }
                    }

                    for(int y = k+1; y < array.length-1; y++){ // Same thing but down

                        if(array[y][x] != '.' && !Character.isDigit(array[y][x]) && !isEnginePart){

                            enginePart += array[k][x];
                            isEnginePart = true;
                            break;
                        }
                    }
                }

                if(isEnginePart){
                    System.out.println(array[k][x] + " is engine part");
                }
            }
        }

        long end = System.nanoTime();

        System.out.println("Time to execute: " + (end-start)/1000000 + " ms");

    }
}
