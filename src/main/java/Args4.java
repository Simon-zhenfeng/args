import java.util.Arrays;
import java.util.List;

public class Args4 {

    private final List<String> argList;

    public Args4(String[] args) {
        argList = Arrays.asList(args);
    }

    public String getValue(String flag, String type) {
        if (type.equals("boolean") && argList.contains("-" + flag)) {
            return "true";
        }
        int index = argList.indexOf("-" + flag);
        return argList.get(index + 1);
    }
}
