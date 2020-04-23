package Query;

import java.util.ArrayList;

public class QueryManager {

    public static Query makeQuery(String string) {
        string = string.toLowerCase();

        String condition = string.substring(string.indexOf("where") + 5);

        Query query = new Query();


        if(condition.contains("randomv != ")) {
            query.setConditionInequal(Integer.parseInt(condition.replace("randomv != ", "").replaceAll("\\s+", "")));
        }	else if(condition.contains("randomv = ")) {
            query.setConditionEqual(Integer.parseInt(condition.replace("randomv = ", "").replaceAll("\\s+", "")));
        } else if(condition.contains("and")) {
            ArrayList<Integer> parameters = new ArrayList<Integer>();
            String parts[] = condition.split(" and ");

            for(String part : parts) {
                part = part.replace("randomv > ", "");
                part = part.replace("randomv < ", "");

                part = part.replaceAll("\\s+", "");

                parameters.add(Integer.parseInt(part));
            }

            query.setConditionRange(parameters.get(0), parameters.get(1));
        }


        return query;
    }
}