import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by KJH on 2016-09-22.
 */
public class InsertionSortWithBSearch {
    input input = new input();
    public void binaryInsertionReadNWrite() throws IOException {
        ArrayList arrList = input.readFile();

        insertionSortWithBSearch(arrList);

        FileOutputStream output = new FileOutputStream("C:/Users/KJH/IdeaProjects/sort/src/hw02_00_201203406_binary_insertion.txt");
        //FileOutputStream output = new FileOutputStream("/home/kjh/Documents/git/InsertionSort/sort/src/hw02_00_201203406_binary_insertion.txt");
        input.writeFile(arrList, output);
    }

    private void insertionSortWithBSearch(ArrayList arrList){
        int temp, left, right, middle;

        for(int i=1 ; i<arrList.size() ; i++) {
            temp = input.convertToInt(arrList.get(i));
            left = 0;
            right = i;
            while(left < right){
                middle = (left + right) / 2;
                if(temp >= input.convertToInt(arrList.get(middle)))
                    left = middle + 1;
                else
                    right = middle;
            }
            for(int j=i ; j>left ; j--) {
                arrList.set(j, input.convertToInt(arrList.get(j-1)));
                arrList.set(j-1, temp);
            }
        }
    }


}
