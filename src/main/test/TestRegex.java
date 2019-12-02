import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {

    String jerksonString = "";

    @Before
    public void setup() {
        FileReader reader = new FileReader("RawData.txt");
        try {
            jerksonString = reader.readRawDataToString();
        } catch (Exception e) {
            System.out.println("Oof");
        }
    }

    @Test
    public void myTest() {
        //System.out.println(jerksonString);

        //Pattern p = Pattern.compile("(?i)price:(\\w+[.]\\w+)");
        Pattern p = Pattern.compile("(?i)name:(\\w+)\\Wprice:(\\w+[.]\\w+)");
        Matcher m = p.matcher(jerksonString);

        while (m.find()) {
            System.out.println(m.group(1) + "\t\t" + m.group(2));
        }

    }

}
