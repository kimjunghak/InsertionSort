import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by KJH on 2016-09-22.
 */
public class Merge3_Way {
    input input = new input();
    public void merge3_WayReadNWrite() throws IOException {
        ArrayList arrList = input.readFile();

        mergeSort3_Way(arrList, 0, arrList.size()-1);

        FileOutputStream output = new FileOutputStream("C:/Users/KJH/IdeaProjects/sort/src/hw02_00_201203406_3-way_merge.txt");
        //FileOutputStream output = new FileOutputStream("/home/kjh/Documents/git/InsertionSort/sort/src/hw02_00_201203406_3-way_merge.txt");
        input.writeFile(arrList, output);
    }

    private void mergeSort3_Way(ArrayList arrList, int left, int right){
        if(left + 2 < right){
            int one_third = left + ((right - left) / 3);
            int two_third = left + 2 * ((right - left) / 3);

            mergeSort3_Way(arrList, left, one_third);
            mergeSort3_Way(arrList, one_third+1, two_third);
            mergeSort3_Way(arrList, two_third+1, right);
            merge3_way(arrList, left, one_third, two_third, right);
        }
    }

    private void merge3_way(ArrayList arrList, int left, int one_third, int two_third, int right){
        ArrayList tempArray = new ArrayList();
        int start = left;
        int mid1_3 = one_third;
        int mid2_3 = two_third;
        int end = right;

        while(start <= one_third && mid1_3 <= two_third && mid2_3 <= end){
            if(input.convertToInt(arrList.get(start)) <= input.convertToInt(arrList.get(mid1_3))){
                if(input.convertToInt(arrList.get(start)) <= input.convertToInt(arrList.get(mid2_3)))
                    tempArray.add(input.convertToInt(arrList.get(start++)));
                else
                    tempArray.add(input.convertToInt(arrList.get(mid2_3++)));
            }
            else{
                if(input.convertToInt(arrList.get(mid1_3)) <= input.convertToInt(arrList.get(mid2_3)))
                    tempArray.add(input.convertToInt(arrList.get(mid1_3++)));
                else
                    tempArray.add(input.convertToInt(arrList.get(mid2_3++)));
            }
        }

        while(start <= one_third && mid1_3 <= two_third){
            if(input.convertToInt(arrList.get(start)) <= input.convertToInt(arrList.get(mid1_3)))
                tempArray.add(input.convertToInt(arrList.get(start++)));
            else
                tempArray.add(input.convertToInt(arrList.get(mid1_3)));
        }

        while(start <= one_third && mid2_3 <= right){
            if(input.convertToInt(arrList.get(start)) <= input.convertToInt(arrList.get(mid2_3)))
                tempArray.add(input.convertToInt(arrList.get(start++)));
            else
                tempArray.add(input.convertToInt(arrList.get(mid2_3++)));
        }

        while(mid1_3 <= two_third && mid2_3 <= right){
            if(input.convertToInt(arrList.get(mid1_3)) <= input.convertToInt(arrList.get(mid2_3)))
                tempArray.add(input.convertToInt(arrList.get(mid1_3++)));
            else
                tempArray.add(input.convertToInt(arrList.get(mid2_3++)));
        }

        int index=0;
        int pos=left;

        while(index<tempArray.size())
            arrList.set(pos++,input.convertToInt(tempArray.get(index++)));
    }
}
