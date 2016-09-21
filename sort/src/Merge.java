import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by KJH on 2016-09-22.
 */
public class Merge {
    input input = new input();

    public void mergeReadNWrite() throws IOException {
        ArrayList arrList = input.readFile();

        mergeSort(arrList, 0, arrList.size()-1);

        FileOutputStream output = new FileOutputStream("C:/Users/KJH/IdeaProjects/sort/src/hw02_00_201203406_merge.txt");
        //FileOutputStream output = new FileOutputStream("/home/kjh/Documents/git/InsertionSort/sort/src/hw02_00_201203406_merge.txt");
        input.writeFile(arrList, output);
    }

    private void mergeSort(ArrayList arrList, int left, int right){
        if(left < right){
            int middle =  (left + right) / 2;
            mergeSort(arrList, left, middle);
            mergeSort(arrList, middle+1, right);
            merge(arrList, left, middle, right);
        }
    }

    private void merge(ArrayList arrList, int left, int middle, int right){
        ArrayList tempArray = new ArrayList();

        int start = left;
        int end = middle + 1;

        while(start <= middle && end <= right){
            if(input.convertToInt(arrList.get(start)) <= input.convertToInt(arrList.get(end)))
                tempArray.add(input.convertToInt(arrList.get(start++)));
            else
                tempArray.add(input.convertToInt(arrList.get(end++)));
        }

        while(start <= middle)
            tempArray.add(arrList.get(start++));

        while(end <= right)
            tempArray.add(arrList.get(end++));

        int index=0;
        int pos=left;

        while(index<tempArray.size())
            arrList.set(pos++,input.convertToInt(tempArray.get(index++)));
    }
}
