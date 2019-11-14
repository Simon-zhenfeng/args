import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArgsParser4Test {
    @Test
    public void should_parse_args() {
        ArgsParser4 argsParser = new ArgsParser4("l:boolean p:int d:string");
        String[] args = new String[]{"-l", "-p", "8080", "-d", "/usr/logs"};
        argsParser.pars(args);
        assertThat((boolean) argsParser.getValue("-l")).isTrue();
    }
}
