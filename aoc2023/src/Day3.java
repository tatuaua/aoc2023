import java.io.File;
import java.io.FileNotFoundException;
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

                //String enginePart = "";
                boolean isEnginePart = false;

                if(Character.isDigit(array[k][x])){

                    if(array[k-1][x-1] != '.' && !Character.isDigit(array[k-1][x-1]) || 
                    array[k][x-1] != '.' && !Character.isDigit(array[k][x-1]) ||
                    array[k+1][x-1] != '.' && !Character.isDigit(array[k+1][x-1]) ||
                    array[k-1][x] != '.' && !Character.isDigit(array[k-1][x]) ||
                    array[k-1][x+1] != '.' && !Character.isDigit(array[k-1][x+1])
                    ){

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
