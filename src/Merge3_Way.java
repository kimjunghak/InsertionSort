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

        mergeSort3_Way(arrList);

        FileOutputStream output = new FileOutputStream("C:/Users/KJH/IdeaProjects/sort/src/3-way_merge.txt");
        //FileOutputStream output = new FileOutputStream("/home/kjh/Documents/git/InsertionSort/sort/src/3-way_merge.txt");
        input.writeFile(arrList, output);
    }

    private void mergeSort3_Way(ArrayList arrList){
        int length = arrList.size();

        ArrayList leftList = new ArrayList();
        ArrayList middleList = new ArrayList();
        ArrayList rightList = new ArrayList();

        if(length < 2)
            return;

        int mid = length / 3;

        for(int i=0 ; i<mid ; i++)
            leftList.add(input.convertToInt(arrList.get(i)));

        for(int j=mid ; j<mid*2+1 ; j++)
            middleList.add(input.convertToInt(arrList.get(j)));

        for(int k=mid*2+1 ; k<length ; k++)
            rightList.add(input.convertToInt(arrList.get(k)));

        mergeSort3_Way(leftList);
        mergeSort3_Way(middleList);
        mergeSort3_Way(rightList);

        merge3_way(arrList, leftList, middleList, rightList);
    }

    private void merge3_way(ArrayList arrList, ArrayList leftList, ArrayList middleList, ArrayList rightList) {
        int l_length = leftList.size();
        int m_length = middleList.size();
        int r_length = rightList.size();

        int pos = 0;
        int l_idx = 0;
        int m_idx = 0;
        int r_idx = 0;


        while(l_idx < l_length && m_idx < m_length && r_idx < r_length){
            int leftN = input.convertToInt(leftList.get(l_idx));
            int middleN = input.convertToInt(middleList.get(m_idx));
            int rightN = input.convertToInt(rightList.get(r_idx));

            if(checkRealtion3(leftN, middleN, rightN))
                    arrList.set(pos++, input.convertToInt(leftList.get(l_idx++)));

            else if(checkRealtion3(rightN, leftN, middleN))
                    arrList.set(pos++, input.convertToInt(rightList.get(r_idx++)));

            else if(checkRealtion3(middleN, leftN, rightN))
                    arrList.set(pos++, input.convertToInt(middleList.get(m_idx++)));

            else if(checkRealtion3(leftN, middleN, rightN))
                    arrList.set(pos++, input.convertToInt(middleList.get(l_idx++)));

            else if(checkRealtion3(middleN, rightN, leftN))
                    arrList.set(pos++, input.convertToInt(middleList.get(m_idx++)));

            else if(checkRealtion3(rightN, middleN, leftN))
                    arrList.set(pos++, input.convertToInt(middleList.get(r_idx++)));
        }

        while(l_idx < l_length && m_idx < m_length){
            if(input.convertToInt(leftList.get(l_idx)) <= input.convertToInt(middleList.get(m_idx)))
                arrList.set(pos++, input.convertToInt(leftList.get(l_idx++)));
            else
                arrList.set(pos++, input.convertToInt(middleList.get(m_idx++)));
        }

        while(l_idx < l_length && r_idx < r_length){
            if(input.convertToInt(leftList.get(l_idx)) <= input.convertToInt(rightList.get(r_idx)))
                arrList.set(pos++, input.convertToInt(leftList.get(l_idx++)));
            else
                arrList.set(pos++, input.convertToInt(rightList.get(r_idx++)));
        }

        while(m_idx < m_length && r_idx < r_length){
            if(input.convertToInt(middleList.get(m_idx)) <= input.convertToInt(rightList.get(r_idx)))
                arrList.set(pos++, input.convertToInt(middleList.get(m_idx++)));
            else
                arrList.set(pos++, input.convertToInt(rightList.get(r_idx++)));
        }

        while(l_idx < l_length)
            arrList.set(pos++, input.convertToInt(leftList.get(l_idx++)));

        while(m_idx < m_length)
            arrList.set(pos++, input.convertToInt(middleList.get(m_idx++)));

        while(r_idx < r_length)
            arrList.set(pos++, input.convertToInt(rightList.get(r_idx++)));
    }

    private boolean checkRealtion3(int left, int middle, int right){
        if(left <= middle){
            if(left < right)
                return true;
            else if(left == right)
                return true;
            else
                return false;
        }

        else
            return false;
    }

}
