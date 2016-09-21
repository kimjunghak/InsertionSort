import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by KJH on 2016-09-22.
 */
public class Merge {
    input input = new input();

    public void mergeReadNWrite() throws IOException {
        ArrayList arrList = input.readFile();

        mergeSort(arrList);

        FileOutputStream output = new FileOutputStream("C:/Users/KJH/IdeaProjects/sort/src/merge.txt");
        //FileOutputStream output = new FileOutputStream("/home/kjh/Documents/git/InsertionSort/sort/src/merge.txt");
        input.writeFile(arrList, output);
    }

    private void mergeSort(ArrayList arrList){
        int length = arrList.size();

        if(length < 2)
            return;

        int middle = length / 2;

        ArrayList leftList = new ArrayList();
        ArrayList rightList = new ArrayList();

        for(int i=0 ; i<middle ; i++)
            leftList.add(input.convertToInt(arrList.get(i)));

        for(int j=middle ; j<length ; j++)
            rightList.add(input.convertToInt(arrList.get(j)));

        mergeSort(leftList);
        mergeSort(rightList);

        merge(arrList, leftList, rightList);
    }

    private void merge(ArrayList arrList, ArrayList leftList, ArrayList rightList) {
        int l_length = leftList.size();
        int r_length = rightList.size();

        int pos = 0;
        int l_idx = 0;
        int r_idx = 0;

        while(l_idx < l_length && r_idx < r_length){
            if(input.convertToInt(leftList.get(l_idx)) < input.convertToInt(rightList.get(r_idx)))
                arrList.set(pos++, input.convertToInt(leftList.get(l_idx++)));
            else
                arrList.set(pos++, input.convertToInt(rightList.get(r_idx++)));
        }

        while(l_idx < l_length)
            arrList.set(pos++, input.convertToInt(leftList.get(l_idx++)));

        while(r_idx < r_length)
            arrList.set(pos++, input.convertToInt(rightList.get(r_idx++)));
    }
}
