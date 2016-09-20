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

        mergeSort(arrList);

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
                arrList.add(Integer.parseInt(buffer.toString()));
                buffer.setLength(0);
            }
            else
                buffer.append((char)data);
        }
        arrList.add(Integer.parseInt(buffer.toString()));
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
            temp = Integer.parseInt(arrList.get(i).toString());
            pos = i;
            while(pos > 0 && temp < Integer.parseInt(arrList.get(pos-1).toString())){
                arrList.set(pos, Integer.parseInt(arrList.get(pos-1).toString()));
                pos = pos-1;
            }
            arrList.set(pos, temp);
        }
    }

    private void insertionSortWithBSearch(ArrayList arrList){
        int temp, left, right, middle;

        for(int i=1 ; i<arrList.size() ; i++) {
            temp = Integer.parseInt(arrList.get(i).toString());
            left = 0;
            right = i;
            while(left < right){
                middle = (left + right) / 2;
                if(temp >= Integer.parseInt(arrList.get(middle).toString()))
                    left = middle + 1;
                else
                    right = middle;
            }
            for(int j=i ; j>left ; j--) {
                arrList.set(j, Integer.parseInt(arrList.get(j-1).toString()));
                arrList.set(j-1, temp);
            }
        }
    }

    private void mergeSort(ArrayList arrList){

    }

    private void mergeSort3_Way(ArrayList arrList){

    }
}
