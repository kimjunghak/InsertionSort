/**
 * Created by KJH on 2016-09-08.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class input {
    public static void main(String args[]) throws IOException {
        FileInputStream input = new FileInputStream("C:/Users/KJH/IdeaProjects/sort/src/data02.txt");

        StringBuffer buffer = new StringBuffer();
        int[] arr = new int[1024];
        int data, index = 0, cost = 0;
        String write;

        while( (data = input.read()) != -1){
            if( data == ',') {
                arr[index++] = Integer.parseInt(buffer.toString());
                buffer.setLength(0);
            }
            else
                buffer.append((char)data);
            cost++;
        }
        insertionSort(arr);

        FileOutputStream output = new FileOutputStream("C:/Users/KJH/IdeaProjects/sort/src/hw02_00_201203406_insertion.txt");
        for(int loop=0; loop<arr.length; loop++) {
            write = arr[loop] + ",";
            output.write(write.getBytes());
        }
        write = arr[arr.length-1]+"\r\n";
        output.write(write.getBytes());
        output.close();
    }

    static void insertionSort(int[] data){
        int temp, pos;
        for(int i=1 ; i<data.length ; i++){
            temp = data[i];
            pos = i;
            while(pos > 0 && temp < data[pos-1]){
                data[pos] = data[pos-1];
                pos = pos-1;
            }
            data[pos] = temp;
        }
    }
}
