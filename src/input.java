/**
 * Created by KJH on 2016-09-08.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class input {

    public ArrayList readFile() throws IOException {
        FileInputStream input = new FileInputStream("C:/Users/KJH/IdeaProjects/sort/src/data02.txt");
        //FileInputStream input = new FileInputStream("/home/kjh/Documents/git/InsertionSort/sort/src/data02.txt");
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

    public void writeFile(ArrayList arrList, FileOutputStream output) throws IOException {
        String write;
        for(int loop = 0; loop<arrList.size()-1; loop++) {
            write = arrList.get(loop).toString() + ",";
            output.write(write.getBytes());
        }
        write = arrList.get(arrList.size()-1).toString()+"\r\n";
        output.write(write.getBytes());
        output.close();
    }

    public int convertToInt(Object obj){
        return Integer.parseInt(obj.toString());
    }
}
