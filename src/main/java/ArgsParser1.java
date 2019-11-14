import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.*;

public class ArgsParser1 {

    private HashMap<String, Object> values;
    private final HashMap<String, String> schemaMap;

    public ArgsParser1(String schema) {
        schemaMap = parseSchema(schema);
    }

    public void parse(String[] args) {
        values = new HashMap();
        for (Map.Entry<String, String> entry : schemaMap.entrySet()) {
            String flagName = entry.getKey();
            String flagType = entry.getValue();
            if (flagType.equals("boolean")) {
                values.put(flagName, asList(args).contains("-" + flagName));
            } else {
                String value = args[asList(args).indexOf("-" + flagName) + 1];
                if (flagType.equals("int")) {
                    values.put(flagName, parseInt(value));
                } else {
                    values.put(flagName, value);
                }
            }
        }
    }

    private HashMap<String, String> parseSchema(String schema) {
        //l:boolean p:int d:string
        HashMap<String, String> schemaMap = new HashMap<>();
        String[] array = schema.split(" ");
        for (String pair : array) {
            String[] flagDefinition = pair.split(":");
            schemaMap.put(flagDefinition[0], flagDefinition[1]);
        }
        schemaMap.put(array[0].split(":")[0], array[0].split(":")[1]);
        schemaMap.put(array[1].split(":")[0], array[1].split(":")[1]);
        schemaMap.put(array[2].split(":")[0], array[2].split(":")[1]);
        return schemaMap;
    }

    public Object getValue(String flag) {
        return values.get(flag);
    }
}
