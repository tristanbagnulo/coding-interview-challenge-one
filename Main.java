import java.io.*;
import java.math.*;
import java.security.*;
import java.sql.Array;
import java.sql.SQLOutput;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'groupSort' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public void groupSort(List<Integer> arr) {
        // Write your code here

        // Create a 2D array to collect [integer][times integer occurred].
        ArrayList<ArrayList<Integer>> twoDArrayList = new ArrayList();
        ArrayList<Integer> firstArrayList = new ArrayList();
        System.out.println(arr);
        //Create a 1D arrayList for the first integer and a count of 1.
        firstArrayList.add(arr.get(0));
        firstArrayList.add(1);
        //Add that first 1D arraylist for the 2D arrayList.
        twoDArrayList.add(firstArrayList);


        //Count the number of integers within the 1D array.
        int numberOfIntegersInOneDimensionArray = arr.size();

        //Skip the first integer from the raw list because it has already been added above.
        for (int i = 1; i < arr.size(); i++){
            System.out.println("Start 1st for loop");

            int integerToCheckFromUnprocessedList = arr.get(i);
            System.out.println("Integer from 1D list: "+ integerToCheckFromUnprocessedList);
            int numberOfIntegersThatDoNotMatchInOriginal = 0;
            System.out.println(twoDArrayList.size());
            //For each integer received...
            for (int j = 0; j <= twoDArrayList.size() - 1; j++){
                System.out.println("j = "+ j);
                System.out.println("Start 2nd for loop");
                int integerFrom2DArrayList = twoDArrayList.get(j).get(0);
                System.out.println("Integer from 2D Array List: " + integerFrom2DArrayList);
                //...1 - Check if the integer matches with an integer from 2D arrayList.
                if (integerToCheckFromUnprocessedList == integerFrom2DArrayList){
                    System.out.println("Start 1st if statement");
                    //1.1 - If it does, increase the count of that integer within the 2D arrayList
                    //and move on to the next integer (after checking whether there has been any matches
                    //in 1.2 below).
                    int countOfIntegerIn2DArrayList = twoDArrayList.get(j).get(1);
                    twoDArrayList.get(j).set(1,countOfIntegerIn2DArrayList+1);
                    System.out.println("Single array - plus");
                    System.out.println(twoDArrayList.get(j));
                } else {
                    System.out.println("Start 1st if statement - else");
                    //1.2.1 - Count the number of integers that don't match the integer in question
                    numberOfIntegersThatDoNotMatchInOriginal += 1;
                    System.out.println("Number of integers that don't match in 1d array: " + numberOfIntegersThatDoNotMatchInOriginal);
                }
                //1.2 - If the integer does NOT have a single match, add that integer in a new
                //spot within the 2D arrayList.
                if (numberOfIntegersThatDoNotMatchInOriginal >= twoDArrayList.size()){
                    //...This requires you to create a new 1D integerArrayList for that integer
                    ArrayList<Integer> integerArrayList = new ArrayList<>();
                    integerArrayList.add(integerToCheckFromUnprocessedList);
                    integerArrayList.add(0);
                    twoDArrayList.add(integerArrayList);
                    System.out.println(integerArrayList);
                    System.out.println("Single array - start");
                    System.out.println("Start 2nd if statement");
                }
            }
        }
        System.out.println(twoDArrayList);


    }

}

public class Main {
    public static void main(String[] args) {
        List myList = new ArrayList();
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(7);
        myList.add(7);
        myList.add(10);
        myList.add(6);
        myList.add(3);
        myList.add(7);
        myList.add(4);
        myList.add(7);
        myList.add(2);
        myList.add(9);
        myList.add(10);
        myList.add(10);
        myList.add(6);
        myList.add(4);
        myList.add(1);
        myList.add(1);
        myList.add(8);
        myList.add(5);
        myList.add(2);
        myList.add(8);
        myList.add(5);
        myList.add(4);
        myList.add(8);
        myList.add(1);

        Result result = new Result();
        result.groupSort(myList);
    }
}
