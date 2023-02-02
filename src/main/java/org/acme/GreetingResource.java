package org.acme;

import io.quarkus.logging.Log;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

import static io.quarkus.arc.ComponentsProvider.LOG;

@Path("/hello")
public class GreetingResource {
    public String[] stacks  =
            {"                [B]     [L]     [S]",
"        [Q] [J] [C]     [W]     [F]",
"    [F] [T] [B] [D]     [P]     [P]",
"    [S] [J] [Z] [T]     [B] [C] [H]",
"    [L] [H] [H] [Z] [G] [Z] [G] [R]",
        "[R] [H] [D] [R] [F] [C] [V] [Q] [T]",
"[C] [J] [M] [G] [P] [H] [N] [J] [D]",
"[H] [B] [R] [S] [R] [T] [S] [R] [L]"};

public String intructions = "move 8 from 7 to 1/move 9 from 1 to 9/move 4 from 5 to 4/move 4 from 6 to 1/move 3 from 8 to 5/move 6 from 5 to 9/move 1 from 5 to 1/move 4 from 4 to 9/move 7 from 3 to 7/move 6 from 7 to 3/move 1 from 8 to 7/move 2 from 7 to 6/move 1 from 8 to 9/move 1 from 6 to 3/move 4 from 3 to 5/move 5 from 1 to 3/move 1 from 1 to 8/move 2 from 3 to 4/move 1 from 4 to 1/move 7 from 9 to 2/move 1 from 6 to 3/move 2 from 1 to 9/move 20 from 9 to 7/move 6 from 4 to 9/move 1 from 2 to 9/move 6 from 9 to 4/move 1 from 4 to 6/move 1 from 8 to 6/move 1 from 4 to 7/move 5 from 2 to 3/move 2 from 6 to 4/move 3 from 9 to 5/move 5 from 3 to 5/move 3 from 3 to 8/move 3 from 5 to 6/move 1 from 9 to 8/move 5 from 4 to 5/move 3 from 4 to 9/move 1 from 8 to 2/move 2 from 8 to 2/move 11 from 5 to 6/move 16 from 7 to 1/move 2 from 1 to 7/move 14 from 6 to 1/move 11 from 1 to 6/move 2 from 1 to 4/move 4 from 3 to 4/move 9 from 2 to 4/move 2 from 4 to 8/move 2 from 5 to 3/move 9 from 4 to 7/move 2 from 3 to 2/move 1 from 2 to 7/move 1 from 8 to 4/move 4 from 1 to 4/move 1 from 9 to 1/move 7 from 4 to 7/move 2 from 6 to 5/move 1 from 8 to 6/move 1 from 4 to 2/move 10 from 1 to 6/move 5 from 7 to 3/move 1 from 4 to 7/move 2 from 1 to 2/move 2 from 2 to 4/move 4 from 3 to 4/move 18 from 7 to 6/move 6 from 6 to 4/move 1 from 7 to 4/move 1 from 7 to 6/move 11 from 4 to 5/move 14 from 5 to 9/move 1 from 8 to 7/move 8 from 6 to 2/move 2 from 4 to 5/move 7 from 9 to 1/move 6 from 9 to 7/move 5 from 1 to 8/move 1 from 3 to 6/move 10 from 6 to 3/move 1 from 9 to 6/move 1 from 5 to 4/move 4 from 3 to 8/move 1 from 5 to 9/move 9 from 2 to 3/move 1 from 9 to 5/move 4 from 8 to 4/move 1 from 5 to 3/move 5 from 8 to 7/move 5 from 7 to 2/move 3 from 4 to 1/move 8 from 6 to 5/move 1 from 7 to 9/move 4 from 1 to 3/move 2 from 4 to 6/move 5 from 5 to 2/move 4 from 6 to 9/move 1 from 1 to 2/move 1 from 5 to 6/move 7 from 2 to 8/move 5 from 6 to 8/move 4 from 7 to 9/move 15 from 3 to 9/move 1 from 7 to 3/move 1 from 5 to 3/move 6 from 2 to 6/move 1 from 5 to 2/move 2 from 3 to 9/move 1 from 6 to 8/move 5 from 8 to 9/move 2 from 3 to 8/move 3 from 3 to 6/move 11 from 9 to 4/move 1 from 2 to 1/move 2 from 8 to 4/move 1 from 1 to 4/move 7 from 4 to 7/move 9 from 6 to 3/move 4 from 7 to 8/move 4 from 7 to 6/move 19 from 9 to 4/move 7 from 8 to 5/move 5 from 3 to 6/move 6 from 6 to 9/move 3 from 3 to 5/move 1 from 3 to 9/move 8 from 4 to 5/move 2 from 9 to 6/move 3 from 8 to 2/move 1 from 8 to 4/move 1 from 2 to 5/move 19 from 4 to 1/move 2 from 5 to 7/move 2 from 2 to 4/move 13 from 5 to 2/move 1 from 5 to 1/move 2 from 6 to 9/move 1 from 8 to 7/move 9 from 9 to 3/move 2 from 3 to 8/move 1 from 4 to 2/move 5 from 6 to 7/move 1 from 4 to 6/move 2 from 8 to 7/move 7 from 1 to 5/move 1 from 6 to 7/move 10 from 1 to 8/move 1 from 1 to 3/move 1 from 1 to 2/move 6 from 5 to 3/move 4 from 5 to 3/move 5 from 7 to 1/move 3 from 1 to 2/move 4 from 7 to 5/move 8 from 3 to 6/move 2 from 1 to 7/move 4 from 5 to 8/move 7 from 3 to 5/move 3 from 7 to 2/move 1 from 7 to 3/move 12 from 2 to 8/move 23 from 8 to 2/move 16 from 2 to 6/move 1 from 9 to 6/move 7 from 5 to 7/move 7 from 2 to 4/move 2 from 3 to 8/move 1 from 1 to 9/move 5 from 8 to 1/move 2 from 3 to 9/move 2 from 7 to 1/move 4 from 1 to 3/move 4 from 7 to 2/move 2 from 1 to 4/move 11 from 2 to 9/move 3 from 3 to 4/move 1 from 9 to 1/move 2 from 2 to 7/move 4 from 4 to 8/move 2 from 9 to 5/move 2 from 5 to 7/move 4 from 4 to 6/move 1 from 3 to 8/move 1 from 9 to 8/move 4 from 4 to 2/move 2 from 1 to 3/move 1 from 8 to 4/move 2 from 3 to 5/move 3 from 9 to 7/move 2 from 8 to 9/move 1 from 9 to 6/move 2 from 7 to 3/move 2 from 8 to 1/move 1 from 4 to 9/move 18 from 6 to 2/move 1 from 6 to 5/move 1 from 5 to 9/move 18 from 2 to 3/move 1 from 8 to 7/move 2 from 5 to 9/move 1 from 1 to 4/move 3 from 2 to 1/move 9 from 9 to 4/move 7 from 4 to 6/move 2 from 7 to 3/move 2 from 4 to 9/move 7 from 6 to 7/move 3 from 7 to 2/move 7 from 6 to 3/move 2 from 6 to 9/move 24 from 3 to 9/move 2 from 6 to 8/move 1 from 4 to 2/move 2 from 8 to 5/move 31 from 9 to 3/move 6 from 7 to 4/move 35 from 3 to 7/move 1 from 1 to 8/move 1 from 5 to 7/move 1 from 5 to 4/move 1 from 3 to 9/move 1 from 8 to 2/move 3 from 1 to 7/move 7 from 4 to 5/move 1 from 9 to 8/move 4 from 5 to 6/move 2 from 5 to 2/move 6 from 2 to 5/move 2 from 5 to 7/move 2 from 2 to 1/move 2 from 5 to 4/move 1 from 8 to 4/move 3 from 4 to 6/move 4 from 6 to 7/move 1 from 5 to 2/move 2 from 6 to 9/move 1 from 6 to 4/move 1 from 4 to 8/move 2 from 9 to 6/move 1 from 8 to 9/move 34 from 7 to 9/move 6 from 7 to 3/move 1 from 7 to 2/move 1 from 5 to 8/move 1 from 8 to 6/move 6 from 7 to 4/move 1 from 7 to 3/move 7 from 3 to 5/move 6 from 4 to 6/move 31 from 9 to 1/move 3 from 5 to 7/move 24 from 1 to 3/move 1 from 2 to 4/move 3 from 9 to 1/move 14 from 3 to 5/move 1 from 4 to 3/move 1 from 9 to 7/move 8 from 3 to 7/move 1 from 2 to 9/move 7 from 1 to 5/move 3 from 6 to 8/move 3 from 6 to 1/move 1 from 1 to 3/move 4 from 3 to 2/move 4 from 2 to 3/move 2 from 5 to 1/move 9 from 7 to 4/move 1 from 6 to 5/move 1 from 1 to 7/move 3 from 8 to 9/move 5 from 4 to 2/move 3 from 2 to 3/move 1 from 2 to 3/move 2 from 4 to 1/move 2 from 9 to 4/move 1 from 9 to 3/move 1 from 6 to 1/move 1 from 9 to 6/move 25 from 5 to 4/move 4 from 1 to 9/move 2 from 3 to 7/move 2 from 6 to 9/move 2 from 9 to 5/move 6 from 7 to 1/move 5 from 3 to 6/move 10 from 4 to 3/move 10 from 4 to 8/move 2 from 4 to 2/move 5 from 1 to 9/move 2 from 6 to 4/move 6 from 9 to 6/move 7 from 6 to 4/move 3 from 9 to 4/move 3 from 2 to 4/move 4 from 3 to 8/move 2 from 5 to 3/move 10 from 4 to 9/move 4 from 9 to 7/move 5 from 9 to 5/move 4 from 5 to 1/move 9 from 4 to 6/move 10 from 1 to 3/move 1 from 5 to 4/move 3 from 4 to 5/move 2 from 5 to 7/move 1 from 7 to 3/move 1 from 6 to 9/move 11 from 8 to 6/move 14 from 6 to 5/move 1 from 4 to 7/move 7 from 5 to 3/move 3 from 5 to 4/move 2 from 9 to 5/move 2 from 4 to 3/move 2 from 7 to 4/move 11 from 3 to 9/move 2 from 8 to 2/move 2 from 2 to 3/move 1 from 8 to 2/move 1 from 2 to 9/move 3 from 4 to 5/move 2 from 6 to 9/move 1 from 1 to 8/move 10 from 9 to 7/move 2 from 9 to 3/move 23 from 3 to 9/move 4 from 6 to 4/move 9 from 5 to 6/move 1 from 5 to 3/move 5 from 6 to 7/move 1 from 1 to 7/move 1 from 3 to 9/move 4 from 6 to 7/move 1 from 8 to 7/move 1 from 7 to 5/move 1 from 5 to 1/move 12 from 7 to 6/move 9 from 9 to 3/move 6 from 6 to 4/move 8 from 7 to 3/move 3 from 7 to 4/move 6 from 3 to 1/move 10 from 4 to 8/move 10 from 8 to 7/move 2 from 3 to 7/move 9 from 3 to 8/move 2 from 6 to 3/move 10 from 7 to 1/move 3 from 4 to 6/move 5 from 8 to 5/move 3 from 5 to 7/move 1 from 3 to 2/move 1 from 2 to 6/move 6 from 9 to 1/move 12 from 1 to 3/move 3 from 6 to 9/move 3 from 1 to 7/move 1 from 3 to 2/move 7 from 1 to 7/move 1 from 2 to 7/move 2 from 6 to 4/move 1 from 4 to 5/move 3 from 8 to 7/move 2 from 6 to 3/move 2 from 6 to 1/move 1 from 3 to 8/move 5 from 3 to 4/move 2 from 8 to 5/move 14 from 7 to 4/move 1 from 3 to 2/move 1 from 3 to 7/move 7 from 7 to 4/move 2 from 5 to 3/move 2 from 1 to 4/move 9 from 4 to 6/move 1 from 1 to 2/move 4 from 9 to 4/move 8 from 9 to 3/move 2 from 2 to 7/move 13 from 4 to 8/move 4 from 4 to 1/move 2 from 7 to 6/move 12 from 3 to 2/move 11 from 2 to 9/move 6 from 4 to 9/move 18 from 9 to 4/move 2 from 1 to 6/move 6 from 8 to 1/move 13 from 6 to 5/move 8 from 4 to 5/move 1 from 2 to 9/move 8 from 1 to 4/move 7 from 4 to 8/move 4 from 3 to 5/move 10 from 8 to 5/move 13 from 5 to 8/move 12 from 4 to 5/move 2 from 9 to 8/move 29 from 5 to 9/move 24 from 9 to 2/move 23 from 2 to 4/move 5 from 9 to 2/move 7 from 5 to 7/move 1 from 5 to 1/move 7 from 4 to 8/move 14 from 8 to 1/move 5 from 2 to 6/move 16 from 4 to 7/move 8 from 1 to 6/move 1 from 2 to 8/move 20 from 7 to 6/move 11 from 6 to 4/move 3 from 1 to 5/move 3 from 4 to 3/move 8 from 4 to 9/move 8 from 6 to 1/move 2 from 1 to 4/move 3 from 5 to 2/move 12 from 8 to 2/move 1 from 7 to 1/move 1 from 3 to 5/move 1 from 7 to 8/move 1 from 7 to 3/move 12 from 2 to 8/move 13 from 6 to 4/move 2 from 1 to 9/move 3 from 2 to 6/move 3 from 9 to 7/move 5 from 9 to 1/move 4 from 6 to 4/move 2 from 3 to 6/move 1 from 5 to 9/move 1 from 6 to 7/move 9 from 1 to 5/move 11 from 8 to 3/move 1 from 6 to 8/move 3 from 7 to 1/move 1 from 8 to 7/move 2 from 8 to 9/move 7 from 1 to 2/move 17 from 4 to 7/move 1 from 8 to 6/move 4 from 7 to 2/move 4 from 9 to 7/move 4 from 2 to 3/move 1 from 1 to 4/move 2 from 4 to 3/move 9 from 5 to 4/move 1 from 6 to 8/move 6 from 2 to 1/move 5 from 1 to 9/move 9 from 4 to 3/move 1 from 4 to 6/move 2 from 9 to 7/move 1 from 1 to 5/move 1 from 2 to 7/move 1 from 8 to 9/move 1 from 6 to 8/move 1 from 5 to 4/move 1 from 8 to 7/move 23 from 3 to 7/move 36 from 7 to 6/move 33 from 6 to 1/move 1 from 4 to 8/move 7 from 1 to 5/move 1 from 8 to 1/move 3 from 7 to 2/move 24 from 1 to 3/move 7 from 7 to 3/move 3 from 5 to 1/move 4 from 5 to 3/move 1 from 9 to 8/move 2 from 9 to 6/move 1 from 8 to 5/move 3 from 2 to 5/move 30 from 3 to 5/move 1 from 6 to 7/move 6 from 1 to 8/move 7 from 3 to 2/move 1 from 7 to 5/move 2 from 3 to 2/move 2 from 6 to 8/move 1 from 6 to 1/move 7 from 5 to 8/move 8 from 8 to 7/move 20 from 5 to 8/move 2 from 9 to 7/move 8 from 2 to 1/move 7 from 7 to 3/move 1 from 2 to 1/move 3 from 7 to 9/move 4 from 8 to 3/move 5 from 5 to 6/move 1 from 5 to 9/move 4 from 9 to 4/move 1 from 5 to 9/move 2 from 3 to 6/move 1 from 5 to 8/move 7 from 6 to 3/move 1 from 4 to 1/move 7 from 3 to 2/move 3 from 3 to 5/move 2 from 4 to 7";

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
    String[] intructionsArr = intructions.split("/");

        Integer rowLenght = stacks.length ;
        Integer columLenght = (int) Math.floor(stacks[0].length()/3.88) ;

        String[][] table = new String[columLenght][rowLenght];

            for(int i = 0; i < rowLenght; i++){
        Integer rowIterator = 0;
        for(int j = 0; j < stacks[i].length(); j++){
            Integer moduloForWithJAbtractOne = (j-1) % 4;
          if(moduloForWithJAbtractOne== 0 && stacks[i].charAt(j) != ' ') {
                table[rowIterator][i] = String.valueOf(stacks[i].charAt(j));
                rowIterator++;
                }
          if(rowIterator == rowLenght && j == stacks[i].length()-1){
              rowIterator=0;
          }
        }
    }

            List<List<Integer>> intructionNumbersArr = new ArrayList<List<Integer>>();
            for (int i = 0; i < intructionsArr.length; i++) {
                // parse the string and get the numbers
                String[] numbers = intructionsArr[i].split(" ");
                List<Integer> intructionNumbers = new ArrayList<Integer>();
                for(int j = 0; j < numbers.length; j++){
                    //if char is a number
                    if(numbers[j].matches("[0-9]+")){
                        //if number is bigger than 9
                      Integer number = Integer.parseInt(numbers[j]);
                      intructionNumbers.add(number);
                    }
                }
                intructionNumbersArr.add(intructionNumbers);
            }
        String newTablestDisplay = Arrays.deepToString(table);

        String[][] newtable = new String[columLenght][rowLenght];

        for(int i = 0; i < intructionNumbersArr.size(); i++) {
            Integer numberOfCrates = intructionNumbersArr.get(i).get(0);
            Integer fromStack = intructionNumbersArr.get(i).get(1);
            Integer toStack = intructionNumbersArr.get(i).get(2);
            Integer nonEmptyCratesIteratorFromStack = 0;
            Integer nonEmptyCratesIteratorToStack = 0;
            for (int k = 0; k < table[toStack].length; k++) {
                if (table[fromStack][k] != null) {
                    nonEmptyCratesIteratorToStack++;
                }
            }
                for (int j = 0; j < table[fromStack].length; j++) {
                    newtable[toStack] = table[toStack];
                    // count the number of item that are not null

                    if (table[fromStack][j] != null) {
                 //    newtable[toStack] = table[fromStack][j];
                 //       nonEmptyCratesIterator++;
                    }
            }
        }
        return newTablestDisplay + "\n"+intructionNumbersArr.toString();

    }
}
