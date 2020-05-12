package reactor.core.publisher;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static reactor.core.Scannable.*;

public class FluxSourceMonoTest {

    @Test
    public void testOperator(){
        FluxSourceMono<String> test = new FluxSourceMono<>(Mono.just("Foo"));

        assertThat(test.scanUnsafe(Attr.RUN_STYLE)).isEqualTo(Attr.RunStyle.SYNC);
    }
}