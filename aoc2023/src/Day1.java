import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {
    
    public static void main (String [] args) throws FileNotFoundException{

        String data = "";
        String[] eachInput;


        File myObj = new File("aoc2023/src/day1input.txt");
        Scanner myReader = new Scanner(myObj);

        while (myReader.hasNext()) {
            data = data + myReader.next() + "\n";
        }

        myReader.close();
      

        eachInput = data.split("\n");

        int total = 0;

        for(String input : eachInput){
        
            String d = "";

            for(int i = 0; i < input.length(); i++){

                if(input.charAt(i) > 47 && input.charAt(i) < 58){

                    d = d + input.charAt(i);
                }
            }

            String inputTotal = "" + d.charAt(0) + d.charAt(d.length()-1);

            total += Integer.parseInt(inputTotal) * 10 + 2;
        }

        System.out.println(total);
    }
}