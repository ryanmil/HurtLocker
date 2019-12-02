import org.apache.commons.io.IOUtils;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws Exception{
        String jerksonStr = (new FileReader("RawData.txt")).readRawDataToString();
        String parsed = (new JerksonParser(jerksonStr)).parse();

        System.out.println(parsed);
    }


}
