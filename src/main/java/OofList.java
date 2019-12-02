import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OofList {

    private LinkedHashMap<String, List<ListItem>> oofList;
    private int errorCount;


    public OofList() {
        errorCount = 0;
        oofList = new LinkedHashMap<>();
    }

    public void add(String name, ListItem listItem) {

        if (oofList.containsKey(name)) {
            oofList.get(name).add(listItem);
        } else {
            List<ListItem> list = new ArrayList<>();
            list.add(listItem);
            oofList.put(name, list);
        }
    }

    public String printPretty() {
        String result = "";
        for (Map.Entry<String, List<ListItem>> e : oofList.entrySet()) {
            result += "name:  " + e.getKey() + " \t\tseen: " + e.getValue().size() + "\ttimes\n";
            result += "===========\t\t\t=============\n";
            result += printPrices(e.getValue());
            result += "\n";
        }

        result += "Errors  \t\t\tseen: " + errorCount + "\ttimes\n";

        return result;
    }

    private String printPrices(List<ListItem> list) {
        Map<Double, Integer> map = new LinkedHashMap<>();
        for (ListItem l : list) {
            if(map.containsKey(l.getPrice())) {
                map.put(l.getPrice(), map.get(l.getPrice()) + 1);
            } else {
                map.put(l.getPrice(), 1);
            }
        }

        String result = "";
        for (Map.Entry<Double, Integer> e : map.entrySet()) {
            result += "price: " + e.getKey() + "\t\t\tseen: " + e.getValue() + "\ttimes\n";
            result += "-----------\t\t\t-------------\n";
        }

        return result;
    }

    public void addError() {
        errorCount++;
    }

    public Set<String> getKeys() {
        return oofList.keySet();
    }

}
