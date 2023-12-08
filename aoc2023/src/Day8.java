import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Day8 {
    

    public static void main(String[] args) throws FileNotFoundException{

        long start = System.nanoTime();

        String data = "";
        String[] eachInput;

        Scanner myReader = new Scanner(new File("src/day8input.txt"));

        while (myReader.hasNextLine()) {
            data = data + myReader.nextLine() + "\n";
        }

        myReader.close();
      
        eachInput = data.split("\n");

        String instructions = eachInput[0];

        MyNode[] nodes = new MyNode[eachInput.length-2];

        for(int i = 2; i < eachInput.length; i++){

            MyNode node = new MyNode(eachInput[i].split(" ")[0]);
            node.left = eachInput[i].split(" ")[2].substring(1, 4);
            node.right = eachInput[i].split(" ")[3].substring(0, 3);

            nodes[i-2] = node;

            //System.out.println(node.key + " - " + node.left.key + " - " + node.right.key);
        }


        MyNode curr = null;
        for(int k = 0; k < nodes.length; k++){
            if(nodes[k].key.equals("AAA")){
                System.out.println("found starting node");
                curr = nodes[k];
                break;
            }
        }

        boolean finished = false;
        int result = 0;
        while(!finished){

            for(int j = 0; j < instructions.length(); j++){

                result++;
                
                if(curr.key.equals("ZZZ")){
                    finished = true;
                    break;
                }

                if(instructions.charAt(j) == 'L'){

                    System.out.println("going left from " + curr.key + " to " + curr.left);

                    for(int i = 0; i < nodes.length; i++){
                        if(nodes[i].key.equals(curr.left)){
                            curr = nodes[i];
                            continue;
                        }
                    }

                } else {

                    System.out.println("going right from " + curr.key + " to " + curr.right);

                    for(int i = 0; i < nodes.length; i++){
                        if(nodes[i].key.equals(curr.right)){
                            curr = nodes[i];
                            continue;
                        }
                    }
                }
            }
        }

        System.out.println(result);

        long end = System.nanoTime();

        System.out.println("Time to execute: " + (end-start)/1000000 + " ms");

    }
}

class MyNode {

    String key;
    String left;
    String right;

    MyNode(String key){
        this.key = key;
    }

}