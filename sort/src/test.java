import java.io.IOException;

/**
 * Created by KJH on 2016-09-20.
 */
public class test {
    public static void main(String args[]) throws IOException{
        input input = new input();
        input.insertionReadNWrite();
        input.binaryInsertionReadNWrite();
        input.mergeReadNWrite();
        input.merge3_WayReadNWrite();
    }
}
