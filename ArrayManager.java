import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayManager {

    void printArray(String[] anArray) {
        for (int i = 0; i < anArray.length; i++){
            System.out.println(anArray[i] + " ");
        }
    }

    void elementAdd(ArrayList anArray, String element){
        //System.out.println("The element is " + element);
        //System.out.println("The length of the filearray is "+ anArray.size());
        anArray.add(element);
    }

    int arrayLength(ArrayList anArray){
        //System.out.println("The length of the filearray is "+ filearray.size());
        return anArray.size();
    }

    Object randomName(ArrayList anArray){
        //anArray.size();
        Random rand = new Random();
        int n = rand.nextInt(anArray.size())+1;
        return anArray.get(n);
    }

    public void printArray(List<String> anArray) {
        for (int i = 0; i < anArray.size(); i++){
            System.out.print(anArray.get(i)+" ");
        }
        System.out.println(" ");
   }

    public int checkSpaces(String moviename, List<String> guessedname) {
        List<Integer> correctindex = new ArrayList<>();
        int lengthofname = moviename.length();
        int spacecount = 0;
        for (int y = 0; y <= lengthofname - 1; y++) {

            if (" ".equals(moviename.substring(y, y + 1))) {
                correctindex.add(y);
            }

        }
        spacecount = correctindex.size();
        for (int index = 0; index < correctindex.size(); index++) {
            guessedname.set(correctindex.get(index), " ");
        }

        return spacecount;
        //Array.printArray(guessedname);
        //System.out.println(guessedname);
    }
}































