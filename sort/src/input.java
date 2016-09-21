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

        //FileOutputStream output = new FileOutputStream("C:/Users/KJH/IdeaProjects/sort/src/hw02_00_201203406_insertion.txt"); // windows
        FileOutputStream output = new FileOutputStream("/home/kjh/Documents/git/InsertionSort/sort/src/hw02_00_201203406_insertion.txt");
        writeFile(arrList, output);
    }

    public void binaryInsertionReadNWrite() throws IOException{
        ArrayList arrList = readFile();

        insertionSortWithBSearch(arrList);

        //FileOutputStream output = new FileOutputStream("C:/Users/KJH/IdeaProjects/sort/src/hw02_00_201203406_binary_insertion.txt");
        FileOutputStream output = new FileOutputStream("/home/kjh/Documents/git/InsertionSort/sort/src/hw02_00_201203406_binary_insertion.txt");
        writeFile(arrList, output);
    }

    public void mergeReadNWrite() throws IOException{
        ArrayList arrList = readFile();

        mergeSort(arrList, 0, arrList.size()-1);

        //FileOutputStream output = new FileOutputStream("C:/Users/KJH/IdeaProjects/sort/src/hw02_00_201203406_merge.txt");
        FileOutputStream output = new FileOutputStream("/home/kjh/Documents/git/InsertionSort/sort/src/hw02_00_201203406_merge.txt");
        writeFile(arrList, output);
    }

    public void merge3_WayReadNWrite() throws IOException{
        ArrayList arrList = readFile();

        mergeSort3_Way(arrList, 0, arrList.size()-1);

        //FileOutputStream output = new FileOutputStream("C:/Users/KJH/IdeaProjects/sort/src/hw02_00_201203406_3-way_merge.txt");
        FileOutputStream output = new FileOutputStream("/home/kjh/Documents/git/InsertionSort/sort/src/hw02_00_201203406_3-way_merge.txt");
        writeFile(arrList, output);
    }

    private ArrayList readFile() throws IOException {
        //FileInputStream input = new FileInputStream("C:/Users/KJH/IdeaProjects/sort/src/data02.txt");
        FileInputStream input = new FileInputStream("/home/kjh/Documents/git/InsertionSort/sort/src/data02.txt");
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
        for(int loop = 0; loop<arrList.size()-1; loop++) {
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
                pos--;
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
            if(convertToInt(arrList.get(start)) <= convertToInt(arrList.get(end)))
                tempArray.add(convertToInt(arrList.get(start++)));
            else
                tempArray.add(convertToInt(arrList.get(end++)));
        }

        while(start <= middle)
            tempArray.add(arrList.get(start++));

        while(end <= right)
            tempArray.add(arrList.get(end++));

        int index=0;
        int pos=left;

        while(index<tempArray.size())
            arrList.set(pos++,convertToInt(tempArray.get(index++)));
    }

    private void mergeSort3_Way(ArrayList arrList, int left, int right){
        if(left + 2 < right){
            int one_third = left + ((right - left) / 3);
            int two_third = left + 2 * ((right - left) / 3)+1;

            mergeSort3_Way(arrList, left, one_third);
            mergeSort3_Way(arrList, one_third+1, two_third);
            mergeSort3_Way(arrList, two_third, right);
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
            if(convertToInt(arrList.get(start)) <= convertToInt(arrList.get(mid1_3))){
                if(convertToInt(arrList.get(start)) <= convertToInt(arrList.get(mid2_3)))
                    tempArray.add(convertToInt(arrList.get(start++)));
                else
                    tempArray.add(convertToInt(arrList.get(mid2_3++)));
            }
            else{
                if(convertToInt(arrList.get(mid1_3)) <= convertToInt(arrList.get(mid2_3)))
                    tempArray.add(convertToInt(arrList.get(mid1_3++)));
                else
                    tempArray.add(convertToInt(arrList.get(mid2_3++)));
            }
        }

        while(start <= one_third && mid1_3 <= two_third){
            if(convertToInt(arrList.get(start)) <= convertToInt(arrList.get(mid1_3)))
                tempArray.add(convertToInt(arrList.get(start++)));
            else
                tempArray.add(convertToInt(arrList.get(mid1_3)));
        }

        while(start <= one_third && mid2_3 <= right){
            if(convertToInt(arrList.get(start)) <= convertToInt(arrList.get(mid2_3)))
                tempArray.add(convertToInt(arrList.get(start++)));
            else
                tempArray.add(convertToInt(arrList.get(mid2_3++)));
        }

        while(mid1_3 <= two_third && mid2_3 <= right){
            if(convertToInt(arrList.get(mid1_3)) <= convertToInt(arrList.get(mid2_3)))
                tempArray.add(convertToInt(arrList.get(mid1_3++)));
            else
                tempArray.add(convertToInt(arrList.get(mid2_3++)));
        }

        int index=0;
        int pos=left;

        while(index<tempArray.size())
            arrList.set(pos++,convertToInt(tempArray.get(index++)));
    }

    private int convertToInt(Object obj){
        return Integer.parseInt(obj.toString());
    }
}
