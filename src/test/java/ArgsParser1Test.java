import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArgsParser1Test {
    /*
    项目需求整理
    目标：实现传入main函数参数的分解：-p 8080 -l a.log,b.log -d /usr/logs

    1。 schema解析
        a，输入 schema string
        b，输出 schema object
    2。 入参解析
        a，输入 入参 string[]
        b, 输出 参数解析
    3。 获取参数值
        a，输入 flag string
        b，输出 value string，boolean，int

     */
    @Test
    public void should_parse_agrs_with_schema() {
        ArgsParser1 argsParser = new ArgsParser1("l:boolean p:int d:string");
        String[] args = new String[]{"-l", "-p", "8080", "-d", "/usr/logs"};
        argsParser.parse(args);
        assertThat((Boolean) argsParser.getValue("l")).isTrue();
        assertThat(argsParser.getValue("p")).isEqualTo(8080);
        assertThat(argsParser.getValue("d")).isEqualTo("/usr/logs");
    }

}