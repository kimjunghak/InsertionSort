import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by KJH on 2016-09-22.
 */
public class InsertionSort {
    input input = new input();
    public void insertionReadNWrite() throws IOException {
        ArrayList arrList = input.readFile();

        insertionSort(arrList);

        FileOutputStream output = new FileOutputStream("C:/Users/KJH/IdeaProjects/sort/src/hw02_00_201203406_insertion.txt"); // windows
        //FileOutputStream output = new FileOutputStream("/home/kjh/Documents/git/InsertionSort/sort/src/hw02_00_201203406_insertion.txt");
        input.writeFile(arrList, output);
    }

    private void insertionSort(ArrayList arrList){
        int temp, pos;
        for(int i=1 ; i<arrList.size() ; i++){
            temp = input.convertToInt(arrList.get(i));
            pos = i;
            while(pos > 0 && temp < input.convertToInt(arrList.get(pos-1))){
                arrList.set(pos, input.convertToInt(arrList.get(pos-1)));
                pos--;
            }
            arrList.set(pos, temp);
        }
    }
}
