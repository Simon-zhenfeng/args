import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArgsParser3Test {
    @Test
    public void should_parse_args_with_schema() {
        ArgsParser3 argsParser = new ArgsParser3("l:boolean,p:int,d:string");
        String[] args = {"-l", "-p", "8080", "-d", "/usr/logs"};
        argsParser.parse(args);
        assertThat((Boolean)argsParser.getValue("l")).isTrue();
        assertThat(argsParser.getValue("p")).isEqualTo(8080);
        assertThat(argsParser.getValue("d")).isEqualTo("/usr/logs");
    }
}
