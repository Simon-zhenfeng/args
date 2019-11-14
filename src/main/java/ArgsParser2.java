import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;

public class ArgsParser2 {

    private HashMap<String, Object> values;
    private HashMap<String, String> flagDefinitionsMap;

    public ArgsParser2(String schema) {
        //l:boolean p:int d:string
        flagDefinitionsMap = new HashMap<>();
        for (String pair : schema.split(" ")) {
            String[] flagDefinitions = pair.split(":");
            flagDefinitionsMap.put(flagDefinitions[0], flagDefinitions[1]);
        }
    }

    public void parse(String[] args) {
        values = new HashMap<>();
        for (Map.Entry<String, String> flagDefinition : flagDefinitionsMap.entrySet()) {
            String flagType = flagDefinition.getValue();
            String flagKey = flagDefinition.getKey();
            if (flagType.equals("boolean")) {
                values.put(flagKey, asList(args).contains("-" + flagKey));
            } else if (flagType.equals("int")) {
                values.put(flagKey, parseInt(args[asList(args).indexOf("-" + flagKey) + 1]));
            } else {
                values.put(flagKey, args[asList(args).indexOf("-" + flagKey) + 1]);
            }
        }
    }

    public Object getValue(String flag) {
        return values.get(flag);
    }
}
