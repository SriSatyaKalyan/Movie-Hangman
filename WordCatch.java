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
        //System.out.println("The second element is " + moviename.substring(2,3));

        for (int i = 1; i <= lengthofname; i++){
            guessedname.add("_ ");
        }
        //System.out.println(guessedname);
        Array.printArray(guessedname);
        System.out.println(" ");

        System.out.println("Now guess the movie.");
        int itercount = 0;
        int correctcount = 0;
        int numberofguesses = 10;
        while (numberofguesses >= 0){
            correctindex.clear();
            System.out.println(" ");
            System.out.println("You have " + numberofguesses + " wrong guesses left.");

            System.out.println(" ");
            System.out.print("Guess the letter: ");
            Scanner tuna = new Scanner(System.in);
            String guess = tuna.nextLine();
            //System.out.println("The letter guessed is: " + guess);
            for (int y=0; y <= lengthofname-1; y++){
                //System.out.println("The moviename.substring(y,y+1) = " + moviename.substring(y,y+1));
                //System.out.println("The type of guess = " + guess.getClass().getSimpleName());
                if (guess.equals(moviename.substring(y,y+1))){
                    correctindex.add(y);

                }else {
                    itercount += 1;
                }

                if (itercount == lengthofname){                   //Loop to calcuate number of wrong guesses
                    numberofguesses = numberofguesses - 1;
                    itercount = 0;
                    System.out.println(guess + " is a wrong guess");
                    break;
                }
            }
            for(int index = 0; index < correctindex.size(); index++) {
                guessedname.set(correctindex.get(index), guess);
            }
            Array.printArray(guessedname);

        }

    }
}
