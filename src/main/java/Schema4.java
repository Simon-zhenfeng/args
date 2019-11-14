public class Schema4 {
    public Schema4(String schemaAsString) {
//        Flag4 flog = new Flag4();
    }

    public Object convert(String valueAsString, String flag) {
        String typeOfFlag = getTypeOfFlag(flag);
        if (typeOfFlag.equals("boolean")) {
            return Boolean.parseBoolean(valueAsString);
        }
        if (typeOfFlag.equals("int")) {
            return Integer.parseInt(valueAsString);
        }
        return true;
    }

    public String getTypeOfFlag(String flag) {

        if (flag.equals("l")) {
            return "boolean";
        }
        if (flag.equals("p")) {
            return "int";
        }
        return "aa";
    }
}
