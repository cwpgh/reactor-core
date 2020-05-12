package reactor.core.publisher;

import org.junit.Test;
import reactor.core.Scannable;

import static org.assertj.core.api.Assertions.assertThat;

public class FluxSourceMonoFuseableTest {

    @Test
    public void testOperator(){
        FluxSourceMonoFuseable<String> test = new FluxSourceMonoFuseable<>(Mono.just("Foo"));

        assertThat(test.scanUnsafe(Scannable.Attr.RUN_STYLE)).isEqualTo(Scannable.Attr.RunStyle.SYNC);
    }

}