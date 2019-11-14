import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Args4Test {

    @Test
    public void should_parse_bool_flag_with_out_value() {
        String[] argsArray=new String[]{"-l"};
        Args4 args = new Args4(argsArray);
        String value = args.getValue("l", "boolean");
        assertThat(value).isEqualTo("true");
    }
    @Test
    public void should_parse_flag_with_value() {
        String[] argsArray=new String[]{"-p", "8080"};
        Args4 args = new Args4(argsArray);
        String value = args.getValue("p", "int");
        assertThat(value).isEqualTo("8080");
    }
    @Test
    public void should_parse_multiple_value() {
        String[] argsArray=new String[]{"-p", "8080", "-l"};
        Args4 args = new Args4(argsArray);
        assertThat(args.getValue("p", "int")).isEqualTo("8080");
        assertThat(args.getValue("l", "boolean")).isEqualTo("true");
    }
}