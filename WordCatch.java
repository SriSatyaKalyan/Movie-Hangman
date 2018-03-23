import com.sun.org.apache.xpath.internal.operations.Equals;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class WordCatch {
    public static void main(String args[]) throws Exception {
        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);

        ArrayList filearray = new ArrayList();
        ArrayManager Array = new ArrayManager();

        List<String> guessedname = new ArrayList<String>();
        List<String> wrongguesses = new ArrayList<String>();
        List<Integer> correctindex = new ArrayList<>();

        //System.out.println("The length of the file array is " + filearray.size());

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            Array.elementAdd(filearray, line);
        }

        //System.out.println("The filearray is " + filearray);
        //System.out.println("The length of the filearray is "+ Array.arrayLength(filearray));
        String moviename = (String) Array.randomName(filearray);
        System.out.println("The random name is " + moviename);
        int lengthofname = moviename.length();
        System.out.println("The lengthofname is " + lengthofname);
        //System.out.println("The second element is " + moviename.substring(2,3));

        for (int i = 1; i <= lengthofname; i++){
            guessedname.add("_");
            //System.out.println(guessedname);
        }


        //System.out.println(moviename.charAt(3));
        //System.out.println(guessedname);
        //Array.printArray(guessedname);
        System.out.println(" ");

        System.out.println("Now guess the movie.");
        int itercount = 0;
        int correctcount = 0;
        int numberofguesses = 10;
        int spacecount  = Array.checkSpaces(moviename, guessedname);
        Array.printArray(guessedname);
        while (numberofguesses > 0){
            boolean breakset = false;
            correctindex.clear();
            System.out.println(" ");
            System.out.println("You have " + numberofguesses + " wrong guess(es) left.");
            System.out.print("The wrong guesses made by you are: ");
            Array.printArray(wrongguesses);

            System.out.println(" ");
            System.out.print("Guess the letter: ");
            itercount = 0;
            Scanner tuna = new Scanner(System.in);
            String guess = tuna.nextLine();
            //System.out.println("The letter guessed is: " + guess);
            for (int y=0; y <= lengthofname-1; y++){

                if (guess.equals(moviename.substring(y,y+1))){
                    correctindex.add(y);

                }else {
                    itercount += 1;
                    if (itercount == lengthofname){                   //Loop to calculate number of wrong guesses
                        numberofguesses = numberofguesses - 1;
                        itercount = 0;
                        System.out.println(guess + " is a wrong guess");
                        wrongguesses.add(guess);
                        break;
                    }
                }

            }
            for(int index = 0; index < correctindex.size(); index++) {
                guessedname.set(correctindex.get(index), guess);
            }
            Array.printArray(guessedname);
            //System.out.println(guessedname);

            if (numberofguesses == 0){       // Logic for game loosing
                System.out.println("You have used all of your 10 guesses. GAME OVER!!");
                breakset = true;
            }

            //System.out.println("The spacecount is " + spacecount);
            //int noblankspaces = 0;       //Logic for game winning
            int blankspaces = 0;
            String search = "_";
            for(String str: guessedname) {
                if(str.trim().contains(search)) {
                    blankspaces += 1;
                }
            }

            System.out.println("The blankspaces is " + blankspaces);

            if (blankspaces == 0){
                System.out.println("YOU WON");
                breakset = true;
                break;
            }

            if (breakset){
                break;
            }

        }

    }
}
