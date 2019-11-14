import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Schema4Test {

    @Test
    public void should_convert_boolean_value() {
        Schema4 schema = new Schema4("l:boolean");
        assertThat((boolean) schema.convert("true", "l")).isTrue();
        assertThat((boolean) schema.convert("false", "l")).isFalse();
    }
    @Test
    public void should_convert_int_value() {
        Schema4 schema = new Schema4("p:int");
        assertThat(schema.convert("8080", "p")).isEqualTo(8080);
        assertThat(schema.convert("90", "p")).isEqualTo(90);
        assertThat(schema.convert("-1", "p")).isEqualTo(-1);
        assertThat(schema.convert("090", "p")).isEqualTo(90);
    }
}