import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {

    public static void main(String[] args) throws FileNotFoundException{

        String data = "";
        String[] eachInput;

        File myObj = new File("day2input.txt");
        Scanner myReader = new Scanner(myObj);

        while (myReader.hasNextLine()) {
            data = data + myReader.nextLine() + "\n";
        }

        myReader.close();
      
        eachInput = data.split("\n");

        int idTotal = 0;

        int maxRed = 12;
        int maxGreen = 13;
        int maxBlue = 14;

        for(int i = 0; i < eachInput.length; i++){

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

                        if(Integer.parseInt(elems[k-1]) > maxGreen){
                            System.out.println("Green was too big, game " + i + " invalid");
                            inputValid = false;
                            break;
                        }
                    }

                    if(elems[k].equals("blue,") || elems[k].equals("blue")){
                        System.out.println("found blue, checking " + elems[k-1]);

                        if(Integer.parseInt(elems[k-1]) > maxBlue){
                            System.out.println("Blue was too big, game " + i + " invalid");
                            inputValid = false;
                            break;
                        }
                    }

                    if(elems[k].equals("red,") || elems[k].equals("red")){
                        System.out.println("found red, checking " + elems[k-1]);

                        if(Integer.parseInt(elems[k-1]) > maxRed){
                            System.out.println("Red was too big, game " + i + " invalid");
                            inputValid = false;
                            break;
                        }
                    }
                }

                if(!inputValid){
                    break;
                }   
            }

            if(inputValid){
                idTotal += i+1;
            }
        }

        System.out.println(idTotal);
        
    }
    
}

