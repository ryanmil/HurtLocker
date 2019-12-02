import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JerksonParser {

    private String jerksonStr;

    public JerksonParser(String jerksonStr) {
        this.jerksonStr = jerksonStr;
    }

    public String parse() {
        OofList list = new OofList();

        Pattern p = Pattern.compile(
                "(?i)name:(\\w+)" +
                "\\Wprice:(\\w[.]\\w+)" +
                "\\Wtype:(\\w+)" +
                "\\Wexpiration:(\\w[/]\\w+[/]\\w+)");
        Matcher m = p.matcher(jerksonStr);

        while (m.find()) {
            String name = m.group(1).replace("0", "o").toLowerCase();
            Double price = Double.parseDouble(m.group(2));
            String type = m.group(3);
            String expiration = m.group(4);
            list.add(name, new ListItem(type, price, expiration));
        }

        countErrors(list);

        return list.printPretty();
    }

    private void countErrors(OofList list) {
        Pattern p = Pattern.compile(":\\W");
        Matcher m = p.matcher(jerksonStr);

        while (m.find()) {
            list.addError();
        }
    }
}
