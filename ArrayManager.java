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
    }
}