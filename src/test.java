import java.io.IOException;

/**
 * Created by KJH on 2016-09-20.
 */
public class test {
    public static void main(String args[]) throws IOException{
        InsertionSort insertionSort = new InsertionSort();
        InsertionSortWithBSearch insertionSortWithBSearch = new InsertionSortWithBSearch();
        Merge merge = new Merge();
        Merge3_Way merge3_way = new Merge3_Way();

        //insertionSort.insertionReadNWrite();
        //insertionSortWithBSearch.binaryInsertionReadNWrite();
        //merge.mergeReadNWrite();
        merge3_way.merge3_WayReadNWrite();
    }
}
