import java.util.HashMap;
import java.util.Map;

public class ListItem {

    private Double price;
    private String type;
    private String expiration;

    public ListItem(String type, Double price, String expiration) {
        this.type = type;
        this.price = price;
        this.expiration = expiration;
    }

    public Double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getExpiration() {
        return expiration;
    }
}
