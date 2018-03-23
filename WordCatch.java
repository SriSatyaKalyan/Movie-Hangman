import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class WordCatch {
    public static void main(String args[]) throws Exception {          //Main Function
        File file = new File("movies.txt");                  //Extracted "movies.txt" file to gain access to the movie names in the file
        Scanner scanner = new Scanner(file);

        ArrayList filearray = new ArrayList();                         //Declared an instance called "filearray" belonging to the ArrayList
        ArrayManager Array = new ArrayManager();                       //Declared an instance called "Array" belonging to the ArrayManager class defined by me
        List<String> guessedname = new ArrayList<String>();                 //Created StringLists named 'guessedname' and 'wrongguess' & IntegerList called 'correctindex'
        List<String> wrongguesses = new ArrayList<String>();                //'guessedname' is used to take in the correct guesses of user and embed them if the characters are present in the movie name
        List<Integer> correctindex = new ArrayList<>();                //'wronguesses' is used to take in the wrong guesses of the user
                                                                       //'correctindex' is used to maintain a record of the indices of the guessed character appearing in the movie name

        while (scanner.hasNextLine()){                                 //A while loop for checking the names of the movies...
            String line = scanner.nextLine();                          //in the text file provided by the user (in this case, 'movies.txt')...
            Array.elementAdd(filearray, line);                         //and adding them in the filearray. This filearray has all the movie names...
        }                                                              //mentioned in the text file.

        String moviename = (String) Array.randomName(filearray);       //Considering a random moviename from the filearray
        //System.out.println("The random name is " + moviename);       //Printing the moviename for my reference
        int lengthofname = moviename.length();                         //Storing the length of moviename in variable named 'lengthofname'
        //System.out.println("The lengthofname is " + lengthofname);

        //Loop for Printing the name of the movie in "_ _ _ _ " format (guessable)
        for (int i = 1; i <= lengthofname; i++){
            guessedname.add("_");
        }

        System.out.println(" ");

        System.out.println("Now guess the movie.");                    //Starting the guessing game
        int itercount = 0;                                             //A variable used for checking if the guessed character doesn't exist in the name
        int numberofguesses = 10;                                      //A variable allowing Maximum number of guesses
        Array.checkSpaces(moviename, guessedname);                     //A method checking if there are spaces in the movie name and removing them when placed before the player
        Array.printArray(guessedname);                                 //Method printing the guessed name so far (which is nothing and hence this prints "_ _" only

        while (numberofguesses > 0){                                   //Starting the loop of 10 guesses
            boolean breakset = false;                                  //A boolean variable used to break the flow of game if the player wins or loses
            correctindex.clear();                                      //Clearing the 'correctindex' every single time to cater for the new character and its appearances in the movie name
            System.out.println(" ");
            System.out.println("You have " + numberofguesses + " wrong guess(es) left.");
            System.out.print("The wrong guesses made by you are: ");
            Array.printArray(wrongguesses);                            //This prints the wrong guesses made so far

            System.out.println(" ");
            System.out.print("Guess the letter: ");
            itercount = 0;                                             //Setting the 'itercount' every single time
            Scanner tuna = new Scanner(System.in);                     //A scanner variable named 'tuna' (bucky tutorials reference)
            String guess = tuna.nextLine();                            //Scanning the guess made by the player

            for (int y=0; y <= lengthofname-1; y++){                   //Here 'y' makes sure that the guess is checked with every character in the movie name

                if (guess.equals(moviename.substring(y,y+1))){         //Loop for checking the guess equalling every character individually
                    correctindex.add(y);                               //If yes, add the respective index to the 'correctindex' list

                }else {                                                //If no,..,
                    itercount += 1;                                    //Increment the 'itercount'
                    //If the 'itercount' is equal to 'lengthofname', it means that the guessed character is not a match to any of the characters in the movie name

                    //Loop to calculate number of wrong guesses
                    if (itercount == lengthofname){
                        numberofguesses = numberofguesses - 1;         //This counts as a loss of a guess

                        //Loop to populate the set of wrong guesses
                        if (wrongguesses.contains(guess)) {            //If the wrong guess has already been made previously, print the following output
                            System.out.println("This character was already guessed. Guess another character");
                        }else{                                         //If the wrong guess is a new one, print the following output and add it to the 'wrongguesses' list
                            System.out.println(guess + " is a wrong guess");
                            wrongguesses.add(guess);
                        }

                        break;                                         //Since a wrong guess was made, we can break this particular "FOR" loop
                    }
                }

            }

            //Adding the correct guess to the 'guessedname' List and displaying it
            for(int index = 0; index < correctindex.size(); index++) {
                guessedname.set(correctindex.get(index), guess);
            }
            Array.printArray(guessedname);

            // Logic for loosing game
            if (numberofguesses == 0){
                System.out.println("You have used all of your 10 guesses. GAME OVER!!");  //Letting the player know he lost the game
                breakset = true;                                       //Setting the 'breakset' to true as the game was lost
            }

            //Logic for game winning
            int blankspaces = 0;                                       //A variable checking the number of 'blankspaces' which still have to be guessed by the user
            String search = "_";                                       //Searching the "_" string to check for blankspaces
            for(String str: guessedname) {                             //Searching in the loop
                if(str.trim().contains(search)) {                      //If the guessed name string has any "_",...
                    blankspaces += 1;                                  //Add 1 to the 'blankspaces' variable
                }
            }

            if (blankspaces == 0){                                     //If there are no 'blankspaces', then there is nothing to be guessed
                System.out.println("YOU WON");                         //Letting the player know he won the game
                breakset = true;                                       //Setting the 'breakset' to true as the game was lost
            }

            if (breakset){                                             //If tha game has been won or lost, 'breakset' will be true.
                break;
            }

        }

    }
}
