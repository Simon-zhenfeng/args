import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArgsParser2Test {
    @Test
    public void should_parse_agrs_with_schema() {
        ArgsParser2 argsParser = new ArgsParser2("l:boolean p:int d:string");
        String[] args = new String[]{"-l", "-p", "8080", "-d", "/usr/logs"};
        argsParser.parse(args);
        assertThat((Boolean) argsParser.getValue("l")).isTrue();
        assertThat(argsParser.getValue("p")).isEqualTo(8080);
        assertThat(argsParser.getValue("d")).isEqualTo("/usr/logs");
    }
}
