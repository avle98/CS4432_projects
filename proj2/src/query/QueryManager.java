package query;
import java.util.ArrayList;

public class QueryManager {

    public static Query makeQuery(String string) {
        string = string.toLowerCase();
        String condition = string.substring(string.indexOf("WHERE") + 5);
        Query query = new Query();

        if(condition.contains("randomV != ")) {
            query.setConditionInequal(Integer.parseInt(condition.replace("randomV != ", "").replaceAll("\\s+", "")));
        }	else if(condition.contains("randomV = ")) {
            query.setConditionEqual(Integer.parseInt(condition.replace("randomV = ", "").replaceAll("\\s+", "")));
        } else if(condition.contains("and")) {
            ArrayList<Integer> parameters = new ArrayList<Integer>();
            String parts[] = condition.split(" and ");
            for(String part : parts) {
                part = part.replace("randomV > ", "");
                part = part.replace("randomV < ", "");
                part = part.replaceAll("\\s+", "");
                parameters.add(Integer.parseInt(part));
            }
            query.setConditionRange(parameters.get(0), parameters.get(1));
        }
        return query;
    }
}