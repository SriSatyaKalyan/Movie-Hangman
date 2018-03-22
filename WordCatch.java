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

        //System.out.println("The length of the file array is " + filearray.size());

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            Array.elementAdd(filearray, line);
        }

        System.out.println("The filearray is " + filearray);
        System.out.println("The length of the filearray is "+ Array.arrayLength(filearray));
        String moviename = (String) Array.randomName(filearray);
        System.out.println("The random name is " + moviename);
        int lengthofname = moviename.length();
        //System.out.println("The second element is " + moviename.substring(2,3));

        for (int i = 1; i <= lengthofname; i++){
            System.out.print("_ ");
        }

        System.out.println("Now guess the movie.");
        int itercount = 0;
        int i = 10;
        while (i >= 0){
            System.out.println("You have " + i + " wrong guesses left.");
            System.out.println("Guess the letter: ");
            Scanner tuna = new Scanner(System.in);
            String guess = tuna.nextLine();
            System.out.println("The letter guessed is: " + guess);
            for (int y=0; y <= lengthofname-1; y++){
                //System.out.println("The moviename.substring(y,y+1) = " + moviename.substring(y,y+1));
                //System.out.println("The type of guess = " + guess.getClass().getSimpleName());
                if (guess.equals(moviename.substring(y,y+1))){
                    for (int p = 0; p <= lengthofname-1; p++){
                        if (y == p) {
                            System.out.print(guess+" ");
                        }else{
                            System.out.print("_ ");
                        }
                    }

                }else{
                    itercount += 1;
                    if (itercount == lengthofname){
                        i = i-1;
                        itercount = 0;
                        System.out.println(guess + " is a wrong guess");
                        break;
                    }
                }
            }
        }

    }
}
