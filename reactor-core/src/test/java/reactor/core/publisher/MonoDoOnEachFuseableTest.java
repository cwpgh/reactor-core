package reactor.core.publisher;

import org.junit.Test;
import reactor.core.Scannable;

import static org.assertj.core.api.Assertions.assertThat;

public class MonoDoOnEachFuseableTest {

    @Test
    public void scanOperator(){
        final MonoDoOnEachFuseable<String> test = new MonoDoOnEachFuseable<>(Mono.just("foo"), s -> { });

        assertThat(test.scanUnsafe(Scannable.Attr.RUN_STYLE)).isEqualTo(Scannable.Attr.RunStyle.SYNC);
    }
}