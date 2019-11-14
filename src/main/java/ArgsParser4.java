public class ArgsParser4 {
    private Args4 args;
    private Schema4 schema;

    public ArgsParser4(String schemaAsString) {
        schema = new Schema4(schemaAsString);
    }

    public void pars(String[] args) {
        this.args = new Args4(args);
    }

    public Object getValue(String flag) {
        //边想边说边写
        // 第一步，得到flag的类型
        String type = schema.getTypeOfFlag(flag);
        //第二步，得到值
        String valueAsString = args.getValue(flag, type);
        //第三步，转换值
        return schema.convert(valueAsString, flag);
    }
}
