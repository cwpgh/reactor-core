package reactor.core.publisher;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static reactor.core.Scannable.*;

public class MonoMapFuseableTest {

    @Test
    public void scanOperator(){
        MonoMapFuseable<String, String> test = new MonoMapFuseable<>(Mono.just("foo"), s -> s.toUpperCase());

        assertThat(test.scanUnsafe(Attr.RUN_STYLE)).isEqualTo(Attr.RunStyle.SYNC);
    }

}