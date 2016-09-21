/**
 * Created by KJH on 2016-09-08.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class input {

    public void insertionReadNWrite() throws IOException{
        ArrayList arrList = readFile();

        insertionSort(arrList);

        FileOutputStream output = new FileOutputStream("C:/Users/KJH/IdeaProjects/sort/src/hw02_00_201203406_insertion.txt");
        writeFile(arrList, output);
    }

    public void binaryInsertionReadNWrite() throws IOException{
        ArrayList arrList = readFile();

        insertionSortWithBSearch(arrList);

        FileOutputStream output = new FileOutputStream("C:/Users/KJH/IdeaProjects/sort/src/hw02_00_201203406_binary_insertion.txt");
        writeFile(arrList, output);
    }

    public void mergeReadNWrite() throws IOException{
        ArrayList arrList = readFile();

        mergeSort(arrList, 0, arrList.size()-1);

        FileOutputStream output = new FileOutputStream("C:/Users/KJH/IdeaProjects/sort/src/hw02_00_201203406_merge.txt");
        writeFile(arrList, output);
    }

    public void merge3_WayReadNWrite() throws IOException{
        ArrayList arrList = readFile();

        mergeSort3_Way(arrList);

        FileOutputStream output = new FileOutputStream("C:/Users/KJH/IdeaProjects/sort/src/hw02_00_201203406_3-way_merge.txt");
        writeFile(arrList, output);
    }

    private ArrayList readFile() throws IOException {
        FileInputStream input = new FileInputStream("C:/Users/KJH/IdeaProjects/sort/src/data02.txt");
        StringBuffer buffer = new StringBuffer();
        ArrayList arrList = new ArrayList();
        int data;

        while( (data = input.read()) != -1){
            if( data == ',') {
                arrList.add(convertToInt(buffer));
                buffer.setLength(0);
            }
            else
                buffer.append((char)data);
        }
        arrList.add(convertToInt(buffer));
        return arrList;
    }

    private void writeFile(ArrayList arrList, FileOutputStream output) throws IOException {
        String write;
        for(int loop = 0; loop<arrList.size(); loop++) {
            write = arrList.get(loop).toString() + ",";
            output.write(write.getBytes());
        }
        write = arrList.get(arrList.size()-1).toString()+"\r\n";
        output.write(write.getBytes());
        output.close();
    }

    private void insertionSort(ArrayList arrList){
        int temp, pos;
        for(int i=1 ; i<arrList.size() ; i++){
            temp = convertToInt(arrList.get(i));
            pos = i;
            while(pos > 0 && temp < convertToInt(arrList.get(pos-1))){
                arrList.set(pos, convertToInt(arrList.get(pos-1)));
                pos = pos-1;
            }
            arrList.set(pos, temp);
        }
    }

    private void insertionSortWithBSearch(ArrayList arrList){
        int temp, left, right, middle;

        for(int i=1 ; i<arrList.size() ; i++) {
            temp = convertToInt(arrList.get(i));
            left = 0;
            right = i;
            while(left < right){
                middle = (left + right) / 2;
                if(temp >= convertToInt(arrList.get(middle)))
                    left = middle + 1;
                else
                    right = middle;
            }
            for(int j=i ; j>left ; j--) {
                arrList.set(j, convertToInt(arrList.get(j-1)));
                arrList.set(j-1, temp);
            }
        }
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
            if(convertToInt(arrList.get(start)) <= convertToInt(arrList.get(end))){
                tempArray.add(convertToInt(arrList.get(start)));
                start++;
            }
            else{
                tempArray.add(convertToInt(arrList.get(end)));
                end++;
            }
        }

        while(start <= middle){
            tempArray.add(arrList.get(start));
            start++;
        }

        while(end <= right){
            tempArray.add(arrList.get(end));
            end++;
        }

        int i=0;
        int j=left;
        while(i<tempArray.size()){
            arrList.set(j,convertToInt(tempArray.get(i++)));
            j++;
        }
    }

    private void mergeSort3_Way(ArrayList arrList){

    }

    private int convertToInt(Object obj){
        return Integer.parseInt(obj.toString());
    }
}
